package py.edu.ucsa.jdbc.procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;


public class Procedimientos {

	
	public static void createProcedure(Connection c) {
		Statement s;
		
		try {
			// para postgres es varchar, para oracle varchar2
			s = c.createStatement();
			
			String createStmt = "CREATE OR REPLACE FUNCTION sp_crea_alumno(nombre_alumno \"varchar\", ci int4) " +
					" RETURNS int4 AS $BODY$begin " + 
					" INSERT INTO ALUMNOS (NOMBRE, cedula) " + //Cambiar por los campos de la tabla
					" VALUES (nombre_alumno, ci); " + //agregar parametros de acuerdo al campo de la tabla
					" return 1; " +
					" end$BODY$ " +
					" LANGUAGE 'plpgsql' VOLATILE; ";
			
			s.executeUpdate(createStmt);
			
			s.executeUpdate("ALTER FUNCTION sp_crea_alumno(nombre_alumno \"varchar\", ci int4) OWNER TO postgres;");
			
			createStmt = "CREATE OR REPLACE FUNCTION refalumnoscursor() " +
						" RETURNS refcursor AS 	" +
						" $BODY$ DECLARE  ref refcursor; " +
						" BEGIN " +
						" OPEN ref FOR SELECT nombre  FROM alumnos; " +
						"  RETURN ref; "+
						" END; $BODY$  LANGUAGE 'plpgsql' VOLATILE;";
			
			s.executeUpdate(createStmt);
			
			 createStmt = "CREATE OR REPLACE FUNCTION alumnos_upper(nombre_alumno \"varchar\") " +
					" RETURNS varchar AS $BODY$begin " + 		
					" return UPPER(nombre) FROM alumnos WHERE nombre LIKE nombre_alumno LIMIT 1; " +
					" end$BODY$ " +
					" LANGUAGE 'plpgsql' VOLATILE; ";
			
			s.executeUpdate(createStmt);
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
	
	
	    public static void llamarProcedimiento(Connection c) {
	    	try {
	    		c.setAutoCommit(false);
	    		CallableStatement proc = c.prepareCall("{ ? =  call alumnos_upper (?) }");
	    		proc.registerOutParameter(1, Types.VARCHAR);
	    		proc.setString(2, "%Ricardo%");
	    		proc.execute();
	    		
	    		String resultado = proc.getString(1);	    		
	    		proc.close();
	    		
	    		System.out.println("El valor de retorno del proc es: " + resultado);	    		
	    		c.commit();
	    		c.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

	    public static void callingDatabaseSize(Connection c) {
	    	try {
	    		c.setAutoCommit(false);
	    		CallableStatement proc = c.prepareCall("{ ? =  call pg_database_size (?) }");
	    		proc.registerOutParameter(1, Types.BIGINT);
	    		proc.setString(2, "modulo2-martes");
	    		proc.execute();
	    		
	    		long resultado = proc.getLong(1);
	    		
	    		System.out.println("El valor de retorno del proc es: " + resultado);
	    		
	    		proc.close();
	    		
	    		c.commit();
	    		c.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	    }
	    
	    
	    
	    public static void llamarProcedimientoRS(Connection c) {
	    	try {
	    		c.setAutoCommit(false);
	    		CallableStatement proc = c.prepareCall("{ ? =  call refalumnoscursor () }");
	    		proc.registerOutParameter(1, Types.OTHER);
	    		proc.execute();
	    		ResultSet rs = (ResultSet) proc.getObject(1);
	    		
	    		while (rs.next()) {
	    			System.out.println("Nombre: " + rs.getString(1));
	    		}
	    		rs.close();
	    		
	    		proc.close();
	    		c.commit();
	    		c.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    	    
	    
		public static void main(String[] args) {
			try {
				Connection c = ManejadorConexiones.obtenerConexionPG();
				
				//createProcedure(c);
				//llamarProcedimiento(c);
				//callingDatabaseSize(c);
				
				llamarProcedimientoRS(c);
				c.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}


}
