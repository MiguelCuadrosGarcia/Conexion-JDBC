package com.miguelcode.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CloudDB {

	private CloudDB() {
	}
	
	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.sa-saopaulo-1.oraclecloud.com))(connect_data=(service_name=gca6fa2289c5a12_atpsistemavg_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))";
		String user = "atp_bibliotech";
		String pass = "BiblioTechWeb2023";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			cn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new SQLException("No se encontró el driver de la base de datos.");
		} catch (Exception e) {
			throw new SQLException("No se puede establecer la conexión con la BD.");
		}
		return cn;
	}
	
	public static void main(String[] args) {
		try {
			Connection cn = CloudDB.getConnection();
			System.out.println("Conexion ok - Cloud.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
