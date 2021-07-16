package br.com.api.bancoDeSangue.repositories;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.bancoDeSangue.connection.ConnectionPostgreSql;
import br.com.api.bancoDeSangue.dtos.ImcMedioPorFaixaDeIdade;
import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Data;
import br.com.api.bancoDeSangue.responses.Response;

public class ImcMedioPorFaixaDeIdadeRepository {
	private ConnectionPostgreSql connPostgre;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public ImcMedioPorFaixaDeIdadeRepository() throws Exception{
		this.connPostgre = new ConnectionPostgreSql();
		this.connPostgre.connect();
	}
	
	
	public Response getImcMedioPorFaixaDeIdade(Integer faixaInicial, Integer faixaFinal) {
		Response response = new Response();
		Data responseData = new Data();
		List<ImcMedioPorFaixaDeIdade> imcMedioPorFaixaDeIdadeList = new ArrayList<ImcMedioPorFaixaDeIdade>();
		
		try {
			String sql =  "select round((sum(imc_medio)/count(*))::decimal,2) as imc_medio_faixa from "
					+ "("
					+ "	select "
					+ "	extract(day from ((now() - p.data_nasc)/365)) as idade, "
					+ "	count(*) as quantidade, "
					+ "	("
					+ "		(sum(dc.peso/(dc.altura*dc.altura))/count(*)) "
					+ "	) as imc_medio "
					+ "	from public.pessoa p "
					+ "	join public.dados_clinicos dc on dc.pessoa_id = p.id "
					+ "	group by extract(day from ((now() - p.data_nasc)/365)) "
					+ "	having extract(day from ((now() - p.data_nasc)/365)) between "+faixaInicial+" and " +faixaFinal
					+ ") as sub";
			
			rs = connPostgre.getConn().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				ImcMedioPorFaixaDeIdade imcMedioPorFaixaDeIdade = new ImcMedioPorFaixaDeIdade();
				
				imcMedioPorFaixaDeIdade.setImcMedioFaixa(rs.getLong("imc_medio_faixa"));
				imcMedioPorFaixaDeIdadeList.add(imcMedioPorFaixaDeIdade);
			}
			
			responseData.setImcMedioPorFaixaDeIdade(imcMedioPorFaixaDeIdadeList);
	
			response.setData(responseData);
			response.setCode(RespostaCodigo.CODE_SUCCESS.getValue());
			response.setMensage("Dados retornados com sucesso");
			rs.close();
		}
		catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String msgError = "";
			response.setCode(RespostaCodigo.CODE_ERROR.getValue());
			
			if(e.getMessage() != null) {
				msgError = e.getMessage();
				response.setMensage(e.getMessage().split(":")[0]);
			}
			if(e.getCause() != null) {
				msgError = msgError + e.getCause();
			}
			
			e.printStackTrace();
		}
		finally {
			try {
				connPostgre.desconecte();
				connPostgre = null;
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
}
