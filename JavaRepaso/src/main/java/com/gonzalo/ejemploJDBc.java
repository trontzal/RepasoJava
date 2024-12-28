package com.gonzalo;

import java.sql.*;
import java.time.LocalDate;

public class ejemploJDBc {

	private static final String URL = "jdbc:mysql://localhost:3306/jdbcprueba";
	private static final String USER = "root";
	private static final String PASS = "1234";

	private static final String SQL_SELECT = "SELECT id, dni, dni_diferencial, nombre, apellidos, fecha_nacimiento FROM clientes";
	private static final String SQL_SELECT_ID = "SELECT id, dni, dni_diferencial, nombre, apellidos, fecha_nacimiento FROM clientes WHERE id = ?";

	private static final String SQL_INSERT = "INSERT INTO clientes ('dni, dni_diferencial, nombre, apellidos, fecha_nacimiento') VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE clientes SET dni=?, dni_diferencial=?, nombre=?, apellidos=?, fecha_nacimiento=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id=?";

	private static Connection con;

	public static void main(String[] args) throws SQLException {
		con = DriverManager.getConnection(URL, USER, PASS);

		insertar("19600000A", "1", "Nuevo", "Nvicus", LocalDate.of(2000, 2, 12));

		borrar(3);

		listado();
	}

	private static void listado() throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);

		while (rs.next()) {
			// System.out.printf("%s;%s;%s;%s;%s;%s\n",
			System.out.printf("%2s %s %3s %-10s %-20s %s\n", rs.getString("id"), rs.getString("dni"),
					rs.getString("dni_diferencial"), rs.getString("nombre"), rs.getString("apellidos"),
					rs.getString("fecha_nacimiento"));
		}

	}

	private static void borrar(int i) {
		// TODO Auto-generated method stub

	}

	private static void insertar(String string, String string2, String string3, String string4, LocalDate of) {
		// TODO Auto-generated method stub

	}
}