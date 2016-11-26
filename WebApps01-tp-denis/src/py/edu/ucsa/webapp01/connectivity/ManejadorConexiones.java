package py.edu.ucsa.webapp01.connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

public class ManejadorConexiones {
	static{
		try {
			Class.forName("or.postgressql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection obtenerConexionPG() throws SQLException{
		return obtenerConexion("postgres");
	}
	public static Connection obtenerConexionORCL() throws SQLException{
		return obtenerConexion("oracle");
	}
	
	public static Connection obtenerConexion(String archivo) throws SQLException{
		PropertyResourceBundle prop = 
				(PropertyResourceBundle) PropertyResourceBundle.getBundle(archivo);
		
		String url = prop.getString("url");
		String usuario = prop.getString("usuario");
		String clave = prop.getString("clave");
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Estamos conectados al: "
				+ con.getMetaData().getDatabaseProductName()
        		+ " "
        		+ con.getMetaData().getDatabaseProductVersion());
			//return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(url);
		//return null;
		return con;
	}
}