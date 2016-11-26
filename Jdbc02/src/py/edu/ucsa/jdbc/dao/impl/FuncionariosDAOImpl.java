package py.edu.ucsa.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;
import py.edu.ucsa.jdbc.dao.FuncionariosDAO;

public class FuncionariosDAOImpl implements FuncionariosDAO {

	@Override
	public void copiarFuncionariosPostgresAOracle() {
		try {
			Connection postgres = ManejadorConexiones.obtenerConexionPG();
			Connection oracle = ManejadorConexiones.obtenerConexionORCL();
			Statement leer = postgres.createStatement();
			ResultSet datosPostgres = leer.executeQuery("SELECT * FROM funcionarios");
			PreparedStatement escribir = oracle.prepareStatement("INSERT INTO funcionarios (id, codigo, "
					+ "nombres, apellidos, fecha_ingreso, fecha_nacimiento, salario) VALUES (?, ?, ?, ?, ?, ?, ?)");

			while(datosPostgres.next()){
				escribir.setInt(1, datosPostgres.getInt("id"));
				escribir.setLong(2, datosPostgres.getLong("codigo"));
				escribir.setString(3, datosPostgres.getString("nombres"));
				escribir.setString(4, datosPostgres.getString("apellidos"));
				escribir.setDate(5, datosPostgres.getDate("fecha_ingreso"));
				escribir.setDate(6, datosPostgres.getDate("fecha_nacimiento"));
				escribir.setDouble(7, datosPostgres.getDouble("salario"));
				escribir.executeUpdate();
				//				escribir.addBatch();
			}

			//			escribir.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FuncionariosDAO dao = new FuncionariosDAOImpl();
		dao.recorrerFuncionariosHaciaAdelante();
	}

	@Override
	public void recorrerFuncionariosHaciaAdelante() {
		Connection c;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			String selectStmt = "select " +  
					"id, codigo, nombres, apellidos, fecha_ingreso, "
					+ "fecha_nacimiento,  salario " +
					"from funcionarios";

			Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = s.executeQuery(selectStmt);

			while (rs.next()) {
				int fila = rs.getRow(); //obtenemos el numero de fila
				System.out.print("Fila # " + fila);
				System.out.print(" Nombres: " + rs.getString("nombres"));
				System.out.print(" Apellidos: " + rs.getString("apellidos"));
				System.out.println(" Codigo: " + rs.getInt("codigo"));
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
