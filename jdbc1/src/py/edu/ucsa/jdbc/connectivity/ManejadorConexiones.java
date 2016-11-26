package py.edu.ucsa.jdbc.connectivity;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class ManejadorConexiones {

	public static Connection obtenerConexionPG() throws SQLException{
		
		return obtenerConexion("postgres");
		
	}
	
	public static Connection obtenerConexionORCL() throws SQLException{
		
		return obtenerConexion("oracle");
	}
	
	@SuppressWarnings("finally")
	public static Connection obtenerConexion(String archivo) throws SQLException{
		
//		InputStream props = ManejadorConexiones.class.getResourceAsStream(archivo);
		
		PropertyResourceBundle prop = 
				(PropertyResourceBundle) PropertyResourceBundle.getBundle(archivo);
		
		String url = prop.getString("url");
		String usuario = prop.getString("usuario");
		String clave = prop.getString("clave");
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, usuario, clave);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(url);		
		return null;
	}

 }


