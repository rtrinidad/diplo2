package py.edu.ucsa.webapp01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapp01.dto.CategoriaDTO;



public class CategoriaDAO  {

	
	public List<CategoriaDTO> listar() {
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		Connection con;
		try {
			con = ManejadorConexiones.obtenerConexionPG();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM funcionarios ORDER BY id ASC");
			
			CategoriaDTO cat = null;
			
			while (rs.next()){
				
				cat = new CategoriaDTO();
				
				cat.setId(rs.getInt("id"));
				cat.setCodigo(rs.getString("codigo"));
				cat.setFechaInsercion(rs.getDate("fecha_insercion"));
				cat.setDescripcion(rs.getString("descripcion"));
											
				
				categorias.add(cat);
			}
			
						
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return categorias;
	}

	
	public CategoriaDTO obtenerCategoriaPorCodigo(Integer codigo) {
		
		CategoriaDTO categoria = new CategoriaDTO();
		
		try {
									
			Connection con = ManejadorConexiones.obtenerConexionPG();
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM funcionarios WHERE id="+codigo);
			
		
				
				categoria.setId(rs.getInt("id"));
				categoria.setCodigo(rs.getString("codigo"));
				categoria.setFechaInsercion(rs.getDate("fecha_insercion"));
				categoria.setDescripcion(rs.getString("descripcion"));
											
				
						
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return categoria;
	}

	
	

}
