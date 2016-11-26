package py.edu.ucsa.jdbc.resultsets.scrollable;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;
import py.edu.ucsa.jdbc.util.Consola;


public class ScrollableResultSets {

	static void testResultSetType(final int RESULT_SET_TYPE) {
		if (RESULT_SET_TYPE == ResultSet.TYPE_FORWARD_ONLY)
			System.out.println("TYPE_FORWARD_ONLY ");
		if (RESULT_SET_TYPE == ResultSet.TYPE_SCROLL_INSENSITIVE) 
			System.out.println("TYPE_SCROLL_INSENSITIVE ");		
		if (RESULT_SET_TYPE == ResultSet.TYPE_SCROLL_SENSITIVE)
			System.out.println("TYPE_SCROLL_SENSITIVE ");
	}

	static void testResultSetUpdate(int RESULT_SET_TYPE) {
		if  (RESULT_SET_TYPE == ResultSet.CONCUR_READ_ONLY)
			System.out.println("CONCUR_READ_ONLY ");
		if (RESULT_SET_TYPE == ResultSet.CONCUR_UPDATABLE)
			System.out.println("CONCUR_UPDATABLE");		
	}

	
	
	public static void queryAlumnos(Connection c) throws SQLException{
		Statement s;
		
		String selectStmt = "select " +  
		"nombre, direccion, cedula, celular,  email " +
		" from alumnos order by nombre";
		
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		//s = c.createStatement();		
		int rst = s.getResultSetType();
		testResultSetType(rst);
		int rsc = s.getResultSetConcurrency();
		testResultSetUpdate(rsc);
		ResultSet rs = s.executeQuery(selectStmt);
		rs.beforeFirst();
		
		System.out.println("*** Primero recorremos hacia adelante ***");
		int ultima = 0;
		while (rs.next()) {
			int fila = rs.getRow();
			System.out.print("Fila # " + fila + "Nombre: " + rs.getString("nombre"));
			System.out.print(" Dirección: " + rs.getString("direccion"));
			System.out.println(" Cedula: " + rs.getInt("cedula"));
			ultima = rs.getRow();			
		}
		System.out.println("*** Después recorremos hacia atrás ***");		
		rs.afterLast();

		while(rs.previous()){
			int fila = rs.getRow();
			System.out.print("Fila # " + fila + "Nombre: " + rs.getString("nombre"));
			System.out.print(" Dirección: " + rs.getString("direccion"));
			System.out.println(" Cedula: " + rs.getInt("cedula"));
		}

		int medio  = ultima / 2;		
		System.out.println("*** Posicion destino " + medio + " ***");
		if (medio > 0) {
			rs.absolute(medio);
			int fila = rs.getRow();
			System.out.print("Fila # " + fila + "Nombre: " + rs.getString("nombre"));
			System.out.print(" Dirección: " + rs.getString("direccion"));
			System.out.println(" Cedula: " + rs.getInt("cedula"));
		}
		
		rs.close();
		s.close();
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		
			Connection c = ManejadorConexiones.obtenerConexionPG();
			
			//queryAlumnos(c);
			//updateAlumnos(c);
			//queryAlumnos(c);	
			//insertAlumnos(c);
			//deleteAlumnos(c);
			batchUpdateAlumnos(c);
/*			queryAlumnos(c);
			deleteAlumnos(c);
			queryAlumnos(c);		
			batchUpdateAlumnos(c);
			queryAlumnos(c);				
*/     		c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}


	public static void batchUpdateAlumnos(Connection c)  {
		Statement s;
		
		try {
			// especificamos que los resultsets van a ser updateables.
			s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			c.setAutoCommit(false);
			System.out.println("BATCH, INGRESAR DATOS");
			for (int i = 0; i < 2; i++) {
				String nombre = Consola.leerDatos("nombre");
				String email = Consola.leerDatos("email");		
				String direccion = Consola.leerDatos("direccion");		
				String celular = Consola.leerDatos("celular");		
				String ci = Consola.leerDatos("cedula");		
	
				s.addBatch("insert into alumnos " +  
						"( nombre, direccion, cedula, celular,  email )" +
						" values " + 
						" ( '" + nombre +"', '" + direccion + "'," + ci +", '" + celular+"', '"+ email+"')");
				
			}
	
			int [] updateCounts = s.executeBatch();
			c.commit();
			
			for (int i = 0; i < updateCounts.length; i++) {
				System.out.println("<<<Updated Rows" + i + updateCounts[i] + ">>>>>>>");
			}		
			
			s.close();		
		}catch(BatchUpdateException b) {
			System.err.println("SQLException: " + b.getMessage());
			System.err.println("SQLState:  " + b.getSQLState());
			System.err.println("Message:  " + b.getMessage());
			System.err.println("Vendor:  " + b.getErrorCode());
			System.err.print("Update counts:  ");
			int [] updateCounts = b.getUpdateCounts();
			for (int i = 0; i < updateCounts.length; i++) {
				System.err.print(updateCounts[i] + "   ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void deleteAlumnos(Connection c) throws SQLException {
		Statement s;
		
		String selectStmt = "select " +  
		"nombre, direccion, cedula, celular,  email " +
		" from alumnos";
		
		//especificamos que los resultsets van a ser updateables.
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		int rst = s.getResultSetType();
		testResultSetType(rst);
		int rsc = s.getResultSetConcurrency();
		//TODO: comprobar que el rs es modifiable.
		ResultSet rs = s.executeQuery(selectStmt);
		
		String fila = Consola.leerDatos("fila a borrar");
		rs.absolute(Integer.parseInt(fila));
		rs.deleteRow();
		
		rs.close(); //cerramos result set.
		s.close();  //cerramos el statement.	
	}


	public static void insertAlumnos(Connection c) throws SQLException {
		Statement s;
		
		String selectStmt = "select " +  
		"nombre, direccion, cedula, celular,  email " +
		" from alumnos order by nombre";
		
		//especificamos que los resultsets van a ser updateables.
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		testResultSetType(s.getResultSetType());
		testResultSetUpdate(s.getResultSetConcurrency());
	
		ResultSet rs = s.executeQuery(selectStmt);
		
		System.out.println("PASO 1: " + rs.absolute(2));
		System.out.println("PASO 1.1: " + rs.getRow());
	
		// IMPORTANTE, MOVERSE AL INSERT ROW.
		rs.moveToInsertRow();
		
		System.out.println("INSERT, INGRESAR DATOS");		
		String nombre = Consola.leerDatos("nombre");
		String email = Consola.leerDatos("email");		
		String direccion = Consola.leerDatos("direccion");		
		String celular = Consola.leerDatos("celular");	
		String cedula = Consola.leerDatos("cedula");	
		
		rs.updateString("nombre", nombre);
		rs.updateString("email", email);
		rs.updateString("direccion", direccion);
		rs.updateString("celular", celular);	
//		rs.updateInt("cedula", Integer.parseInt(cedula));
		rs.updateString("cedula", cedula);
		
		rs.insertRow();	
		
		System.out.println("PASO 2: " + rs.getRow());
		
		//volvemos a la fila actual.
		rs.moveToCurrentRow();
		
		System.out.println("PASO 3: " + rs.getRow());
		
		rs.beforeFirst();
		
		System.out.println("PASO 4: " + rs.getRow());
		while (rs.next()) {
			int fila = rs.getRow();
			System.out.print("Fila # " + fila + "Nombre: " + rs.getString("nombre"));
			System.out.print(" Dirección: " + rs.getString("direccion"));
			System.out.println(" Cedula: " + rs.getInt("cedula"));			
		}
	
		rs.close(); //cerramos result set.
		s.close();  //cerramos el statement.
	}



	public static void updateAlumnos(Connection c) throws SQLException {
		Statement s;
		
		String selectStmt = "select " +  
		"nombre, direccion, cedula, celular,  email " +
		" from alumnos";
		
		//especificamos que los resultsets van a ser updateables.
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		int rst = s.getResultSetType();
		testResultSetType(rst);
		
		ResultSet rs = s.executeQuery(selectStmt);
		
		//obtener cedula a modificar.
		int cedula =  Integer.parseInt(Consola.leerDatos("Cedula a modificar:"));
		String nombre = Consola.leerDatos("Nuevo nombre: ");
		String email = Consola.leerDatos("Nuevo email: ");		

		if(rs.last()) {
			rs.updateString("nombre", nombre);
			rs.updateString("email", email);
			rs.updateRow();
		}
		
		rs.close(); //cerramos result set.
		s.close();  //cerramos el statement.
	}

}
