package com.gonzalo;

import java.sql.*;

public class ejemploJDBc {
	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/jdbcprueba";
		String USER = "root";
		String PASS = "1234";
		
		String SQL_SELECT = "SELECT * FROM clientes";
		
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);
		
		while(rs.next()) {
			System.out.printf("%s;%s;%s;%s;%s;%s\n",
			//System.out.printf("%2s %s %3s %-3s %-20s %s\n",
				rs.getString("id"), 
				rs.getString("dni"),
				rs.getString("dni_diferencial"),
				rs.getString("nombre"),
				rs.getString("apellidos"),
				rs.getString("fecha_nacimiento")
			);
		}
	}
}