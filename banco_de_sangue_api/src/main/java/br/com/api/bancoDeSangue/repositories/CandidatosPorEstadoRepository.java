package br.com.api.bancoDeSangue.repositories;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.bancoDeSangue.connection.ConnectionPostgreSql;
import br.com.api.bancoDeSangue.dtos.CandidatosPorEstado;
import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Data;
import br.com.api.bancoDeSangue.responses.Response;


public class CandidatosPorEstadoRepository {
	private ConnectionPostgreSql connPostgre;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public CandidatosPorEstadoRepository() throws Exception{
		this.connPostgre = new ConnectionPostgreSql();
		this.connPostgre.connect();
	}
	
	
	public Response getCandidatosPorEstado() {
		Response response = new Response();
		Data responseData = new Data();
		List<CandidatosPorEstado> candidatosPorEstadoList = new ArrayList<CandidatosPorEstado>();
		
		try {
			String sql =  "select e.estado, count(*) as candidatos "
						+ "from public.endereco e "
						+ "group by e.estado";
			
			rs = connPostgre.getConn().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				CandidatosPorEstado candidatosPorEstado = new CandidatosPorEstado();
				
				candidatosPorEstado.setCandidatos(rs.getInt("candidatos"));
				candidatosPorEstado.setEstado(rs.getString("estado"));
				candidatosPorEstadoList.add(candidatosPorEstado);
			}
			
			responseData.setCandidatosPorEstado(candidatosPorEstadoList);
	
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
