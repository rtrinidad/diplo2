package py.edu.ucsa.jdbc.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 	Este es el primer ejemplo de conectividad a una base de datos.
 * 	El alumno debe completar las indicaciones marcadas con "TODO", solucionando
 * los inconvenientes que vayan surgiendo.
 * 
 * @author Pablo
 * 
 */
public class Conexion2 {
	
	
	public static void main(String[] args){

            //TODO: Cargar el Driver, por ejemplo:
			// String driverName = "PONER AQUI EL NOMBRE DE LA CLASE DEL DRIVER"; //Carga Solo no hace falta
            // Class.forName(driverName);
            
            String url = "jdbc:postgresql://localhost:5432/modulo2-martes";
            String uname = "postgres";
            String passwd = "postgres";
            
            //TODO: Conectarse a la base de datos.
            Connection con = null;
            try {
            	            
            con = DriverManager.getConnection(url, uname, passwd);
            
            
            System.out.println( "Estamos conectados al: " 
                    				+ con.getMetaData().getDatabaseProductName()
                    				+ " "
                    				+ con.getMetaData().getDatabaseProductVersion());
           
            //TODO: Cerrar la conexion si todo anda bien.   
            }catch(SQLException e) {
            	
            	e.printStackTrace();
            	
            }finally{
            	try {
					if (con != null && !con.isClosed()){
						
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
            
            
	
	}

}
