package py.edu.ucsa.jdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;



public class TableAlumnos {

//	List list = new ArrayList();

	static Statement s;
	
	
	public static void createTableAlumnos(Connection c) {
		try {
			// para postgres es varchar, para oracle varchar2
			String createStmt = "create table alumnos " +  
			"( nombre    varchar(50), " +
			"  direccion varchar(200) , " +
			"  cedula integer , " +
			"  celular varchar(50) , " +
			"  email    varchar(50) " +
			" ) ";
			
			s = c.createStatement();
			s.executeUpdate(createStmt);
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void cargarAlumnos(Connection c) throws SQLException, ParseException {
		
		
		
		String insertStmt = "insert into alumnos " +  
		"( nombre, direccion, cedula, celular, email)" +
		" values " + 
		" ( 'Roshi Kamisama', 'Kioto 833', 13241, '981987654', 'roshi@gmail.com')" ;	
		
		
		 
		
		   
		s = c.createStatement();
	int cantidad = s.executeUpdate(insertStmt);
		
		System.out.println("cantidad de modificaciones" + cantidad);
		s.close();		
	}
	
	public static void queryAlumnos(Connection c) throws SQLException{
		String selectStmt = "select " +  
		"nombre, direccion, cedula, celular,  email " +
		" from alumnos order by nombre ";
		
		s = c.createStatement();
		ResultSet rs = s.executeQuery(selectStmt);
		while (rs.next()) {
			System.out.println("Nombre: " + rs.getString("nombre"));
			System.out.println("Dirección: " + rs.getString("direccion"));
			System.out.println("Cedula: " + rs.getInt("cedula"));
		}
		rs.close();
		s.close();		
		
	}
	public static void preparedStatementsAlumnos(Connection c) throws SQLException {
		String updateStmt = "update alumnos set celular = ?  where cedula = ? ";
		
		PreparedStatement ps = c.prepareStatement(updateStmt);
		
		ps.setString(1, "0981123");
		ps.setInt(2, 864939);
		
		ps.executeUpdate();
		
		ps.close();		
		
	}

	public static void main(String[] args) throws ParseException {

		try {
			//Drivers.cargarDrivers();
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.postgresql.Driver");

			Connection c = ManejadorConexiones.obtenerConexionPG();
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			//Connection c = DriverManager.getConnection("jdbc:odbc:alumnos");
			
			//createTableAlumnos(c);
			cargarAlumnos(c);
			//queryAlumnos(c);
			//preparedStatementsAlumnos(c);
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} ///:~

 