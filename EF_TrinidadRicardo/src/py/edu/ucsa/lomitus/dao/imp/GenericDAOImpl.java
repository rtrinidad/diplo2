package py.edu.ucsa.lomitus.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDAOImpl {
	protected void cerrarConexion(Connection c) {
		try {
			if (c != null && !c.isClosed()){
				c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
