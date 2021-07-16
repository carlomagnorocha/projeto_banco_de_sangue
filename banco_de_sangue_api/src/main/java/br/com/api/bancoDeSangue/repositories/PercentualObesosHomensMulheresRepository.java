package br.com.api.bancoDeSangue.repositories;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.bancoDeSangue.connection.ConnectionPostgreSql;
import br.com.api.bancoDeSangue.dtos.PercentualObesosHomensMulheres;
import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Data;
import br.com.api.bancoDeSangue.responses.Response;

public class PercentualObesosHomensMulheresRepository {
	private ConnectionPostgreSql connPostgre;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public PercentualObesosHomensMulheresRepository() throws Exception{
		this.connPostgre = new ConnectionPostgreSql();
		this.connPostgre.connect();
	}
	
	
	public Response getPercentualObesosHomensMulheres() {
		Response response = new Response();
		Data responseData = new Data();
		List<PercentualObesosHomensMulheres> percentualObesosHomensMulheresList = new ArrayList<PercentualObesosHomensMulheres>();
		
		try {
			String sql =  "select "
					+ "p.sexo, "
					+ "round("
					+ "	("
					+ "		("
					+ "			count(*)::decimal "
					+ "			/ "
					+ "			("
					+ "				case "
					+ "					when p.sexo = 'Masculino' "
					+ "					then "
					+ "						("
					+ "							select count(*) from public.pessoa p1 "
					+ "							where p1.sexo = 'Masculino' "
					+ "						) "
					+ "					else "
					+ "						("
					+ "							select count(*) from public.pessoa p1 "
					+ "							where p1.sexo = 'Feminino' "
					+ "						) "
					+ "				end "
					+ "			)::decimal "
					+ "		) "
					+ "		* 100 "
					+ "	) "
					+ ",2) as percentual_obesidade "
					+ "from public.pessoa p "
					+ "join public.dados_clinicos dc on dc.pessoa_id = p.id "
					+ "where (dc.peso/(dc.altura*dc.altura)) > 30 "
					+ "group by p.sexo";
			
			rs = connPostgre.getConn().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				PercentualObesosHomensMulheres percentualObesosHomensMulheres = new PercentualObesosHomensMulheres();
				
				percentualObesosHomensMulheres.setPercentualObesidade(rs.getLong("percentual_obesidade"));
				percentualObesosHomensMulheres.setSexo(rs.getString("sexo"));
				percentualObesosHomensMulheresList.add(percentualObesosHomensMulheres);
			}
			
			responseData.setPercentualObesosHomensMulheres(percentualObesosHomensMulheresList);
	
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
