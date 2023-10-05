package com.miguelcode.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalHostDB {

	private LocalHostDB() {
	}
	
	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "gmarket";
		String pass = "ORCL1234";
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
			Connection cn = LocalHostDB.getConnection();
			System.out.println("Conexion ok - LocalHost.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
