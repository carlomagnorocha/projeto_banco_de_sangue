package br.com.api.bancoDeSangue.repositories;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.bancoDeSangue.connection.ConnectionPostgreSql;
import br.com.api.bancoDeSangue.dtos.DoadoresParaCadaTipoSanguineo;
import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Data;
import br.com.api.bancoDeSangue.responses.Response;

public class DoadoresParaCadaTipoSanguineoRepository {
	private ConnectionPostgreSql connPostgre;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public DoadoresParaCadaTipoSanguineoRepository() throws Exception{
		this.connPostgre = new ConnectionPostgreSql();
		this.connPostgre.connect();
	}
	
	
	public Response getDoadoresParaCadaTipoSanguineo() {
		Response response = new Response();
		Data responseData = new Data();
		List<DoadoresParaCadaTipoSanguineo> doadoresParaCadaTipoSanguineoList = new ArrayList<DoadoresParaCadaTipoSanguineo>();
		
		try {
			String sql =  "select "
					+ "dc.tipo_sanguineo, "
					+ "("
					+ "	case "
					+ "		when dc.tipo_sanguineo = 'A+' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('A+','A-','O+','O-')) "
					+ "		when dc.tipo_sanguineo = 'A-' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('A-','O-')) "
					+ "		when dc.tipo_sanguineo = 'B+' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('B+','B-','O+','O-')) "
					+ "		when dc.tipo_sanguineo = 'B-' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('B-','O-')) "
					+ "		when dc.tipo_sanguineo = 'AB+' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('A+','B+','O+','AB+','A-','B-','O-','AB-')) "
					+ "		when dc.tipo_sanguineo = 'AB-' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('A-','B-','O-','AB-')) "
					+ "		when dc.tipo_sanguineo = 'O+' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('O+','O-')) "
					+ "		when dc.tipo_sanguineo = 'O-' then (select count(*) from public.dados_clinicos dc1 where dc1.tipo_sanguineo in ('O-')) "
					+ "	end "
					+ ") as doadores "
					+ "from public.dados_clinicos dc "
					+ "group by dc.tipo_sanguineo";
			
			rs = connPostgre.getConn().prepareStatement(sql).executeQuery();
			
			while (rs.next()) {
				DoadoresParaCadaTipoSanguineo doadoresParaCadaTipoSanguineo = new DoadoresParaCadaTipoSanguineo();
				
				doadoresParaCadaTipoSanguineo.setDoadores(rs.getLong("doadores"));
				doadoresParaCadaTipoSanguineo.setTipoSanguineo(rs.getString("tipo_sanguineo"));
				doadoresParaCadaTipoSanguineoList.add(doadoresParaCadaTipoSanguineo);
			}
			
			responseData.setDoadoresParaCadaTipoSanguineo(doadoresParaCadaTipoSanguineoList);
	
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
