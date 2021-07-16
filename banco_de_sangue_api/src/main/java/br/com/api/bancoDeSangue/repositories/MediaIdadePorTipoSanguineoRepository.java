package br.com.api.bancoDeSangue.repositories;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.bancoDeSangue.connection.ConnectionPostgreSql;
import br.com.api.bancoDeSangue.dtos.MediaIdadePorTipoSanguineo;
import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Data;
import br.com.api.bancoDeSangue.responses.Response;

public class MediaIdadePorTipoSanguineoRepository {
	private ConnectionPostgreSql connPostgre;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MediaIdadePorTipoSanguineoRepository() throws Exception{
		this.connPostgre = new ConnectionPostgreSql();
		this.connPostgre.connect();
	}
	
	
	public Response getMediaIdadePorTipoSanguineo() {
		Response response = new Response();
		Data responseData = new Data();
		List<MediaIdadePorTipoSanguineo> mediaIdadePorTipoSanguineoList = new ArrayList<MediaIdadePorTipoSanguineo>();
		
		try {
			String sql =  "select "
					+ "dc.tipo_sanguineo, "
					+ "round(sum(extract(day from ((now() - p.data_nasc)/365)))::decimal / count(*)::decimal) as media_idade "
					+ "from public.pessoa p "
					+ "join public.dados_clinicos dc on dc.pessoa_id = p.id "
					+ "group by dc.tipo_sanguineo";
			
			rs = connPostgre.getConn().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				MediaIdadePorTipoSanguineo mediaIdadePorTipoSanguineo = new MediaIdadePorTipoSanguineo();
				
				mediaIdadePorTipoSanguineo.setMediaIdade(rs.getLong("media_idade"));
				mediaIdadePorTipoSanguineo.setTipoSanguineo(rs.getString("tipo_sanguineo"));
				mediaIdadePorTipoSanguineoList.add(mediaIdadePorTipoSanguineo);
			}
			
			responseData.setMediaIdadePorTipoSanguineo(mediaIdadePorTipoSanguineoList);
	
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
