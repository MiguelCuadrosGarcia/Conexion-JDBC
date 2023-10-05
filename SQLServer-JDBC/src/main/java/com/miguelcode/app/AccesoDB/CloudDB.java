package com.miguelcode.app.AccesoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CloudDB {

	private CloudDB() {
	}
	
	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://miguelcg.database.windows.net:1433;databaseName=dbBiblioTech;encrypt=true;TrustServerCertificate=True;";
		String user = "miguelcg";
		String pass = "Miguel159angel";
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
