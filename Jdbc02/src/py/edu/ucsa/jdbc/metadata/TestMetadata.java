package py.edu.ucsa.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;

public class TestMetadata {

	public static void main(String[] args) throws SQLException {
		
		Connection c = ManejadorConexiones.obtenerConexionPG();
		
		String selectStmt = "select * from alumnos";
		
		  Statement s = c.createStatement() ;
		  
		ResultSet rs = s.executeQuery(selectStmt);
		
		
		DatabaseMetaData dbmd=c.getMetaData();

		ResultSetMetaData rsMeta = rs.getMetaData();

		//DATOS DE LA BASE DE DATOS
		
		String   catalog          = null;
		String   schemaPattern    = "public";
		String   tableNamePattern = null;
		String[] types            = {"TABLE"};

		ResultSet result = dbmd.getTables(
		    catalog, schemaPattern, tableNamePattern, types );

		while(result.next()) {
		    String tableName = result.getString("TABLE_NAME");
		    String tableType = result.getString("TABLE_TYPE");
		    System.out.println(tableType);
		    System.out.println(tableName);
		    
		}
		
		
		//Retorna la cantidad de columnas

		int iColumnCount = rsMeta.getColumnCount();

		for (int i =1 ; i <= iColumnCount ; i++){

		System.out.println("Column Name: " + rsMeta.getColumnName(i));

		System.out.println("Column Type: " + rsMeta.getColumnType(i));

		System.out.println("Display Size: " + rsMeta.getColumnDisplaySize(i));

		System.out.println("Precision: " + rsMeta.getPrecision(i));

		}

	}

}
