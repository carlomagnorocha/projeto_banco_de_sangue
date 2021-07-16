package br.com.api.bancoDeSangue.connection;


import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGConnectionPoolDataSource;


public class ConnectionPostgreSql {
	private String jdbcDriver;
	private String dbURL;
	
	private Connection conn = null;
	
	private String host;
    private int port;
    private String user;
    private String pass;
    private String dataBase;
    private String schema;
	

	public ConnectionPostgreSql() {
		this.host = "localhost";
		this.port = 5432;
		this.user = "postgres";
		this.pass = "029696";
		this.dataBase = "banco_de_sangue";
		this.schema = "public";
	}
	
	
	public void connect() throws Exception {
		this.jdbcDriver = "org.postgresql.Driver";
		this.dbURL = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.dataBase + "?currentSchema=" + this.schema;
		
		System.out.println("conectando na database por meio da URL: " + this.dbURL);
		
    	Class.forName(this.jdbcDriver);
    	
    	/////////////////////////////////////////////////////////////////////// // com pool de conexoes
		PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
		ds.setUrl(this.dbURL);
		ds.setUser(this.user);
		ds.setPassword(this.pass);
		conn = ds.getConnection(); 
		///////////////////////////////////////////////////////////////////
    	
//		conn = DriverManager.getConnection(this.dbURL, this.user, this.pass); // sem pool de conexoes
		
		System.out.println("conectado a database...");
		
		/////////////////////////////////////////////////////////////////////////////
		
		// teste de consulta
//		System.out.println("testando consulta...");
//		stmt = connPostgre.getConn().createStatement();
//		String sql = "SELECT * FROM tb_status_extracao";
//	    ResultSet rs = stmt.executeQuery(sql);
//	    
//	    System.out.println("co_status_extracao | no_status_extracao | ds_status_extracao");
//	    while(rs.next()){
//	         //Retrieve by column name
//	         int co  = rs.getInt("co_status_extracao");
//	         String no = rs.getString("no_status_extracao");
//	         String ds = rs.getString("ds_status_extracao");
//
//	         //Display values
//	         System.out.println(co +" | "+ no +" | "+ ds);
//	    }
//	    
//	    rs.close();
//	    stmt.close();
//	    connPostgre.desconecte();
	    ///////////////////////////
	}
	
	
	public void desconecte() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}
