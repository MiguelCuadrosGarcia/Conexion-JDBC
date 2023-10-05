package com.miguelcode.app.AccesoDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class LocalHostDB {

	private LocalHostDB() {
	}
	
	public static Connection getConnection() {
		Connection cn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=dbPrueba;encrypt=true;TrustServerCertificate=True;";
		String user = "sa";
		String pass = "1234";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			cn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
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
