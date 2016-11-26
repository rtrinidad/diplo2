package py.edu.ucsa.jdbc.connectivity.test;

import java.sql.Connection;
import java.sql.SQLException;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
		Connection c = ManejadorConexiones.obtenerConexion("postgres");
		
			 System.out.println("*****************************************");
		
			 System.out.println( "Estamos conectados al: " 
     				+ c.getMetaData().getDatabaseProductName()
     				+ " "
     				+ c.getMetaData().getDatabaseProductVersion());
			 System.out.println("*****************************************");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
