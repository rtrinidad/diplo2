package py.edu.ucsa.webapp01.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapp01.dto.CategoriaDTO;
import py.edu.ucsa.webapp01.dto.ProductoDTO;



public class ProductoDAO  {

	
	public List<ProductoDTO> listar() {
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		Connection c;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM funcionarios ORDER BY id ASC");
			
			ProductoDTO prod = null;
			
			while (rs.next()){
				
				CategoriaDAO categoria = new CategoriaDAO();
				prod = new ProductoDTO();
				//prod.setId(rs.getInt("id"));
				
				prod.setCategoria(categoria.obtenerCategoriaPorCodigo(rs.getInt("id_categoria"))); // Traer objeto del CategoriaDAO
				

				/**prod.setCodigo(rs.getInt("codigo"));
				prod.setNombres(rs.getString("nombres"));
				prod.setApellidos(rs.getString("apellidos"));
				prod.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				prod.setFechaIngreso(rs.getDate("fechaIngreso"));
				prod.setSalario(rs.getDouble("salario"));
									
				**/
				productos.add(prod);
			}
			
						
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return productos;
	}

	
	public ProductoDTO obtenerProductoPorCodigo(Integer codigo) {
		
		ProductoDTO producto = new ProductoDTO();
		
		try {
			
						
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = con.prepareStatement("SELECT ...... funcionarios SET salario = ? WHERE id = ?");
			pstmt.setDouble(1, producto.getSalario());
			pstmt.setInt(2, producto.getId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return producto;
	}

	
	public void insertar(ProductoDTO prod) {
	/*
	int v_id = f.getId();
	int v_codigo = f.getCodigo();
	String v_nombres = f.getNombres();
	String v_apellidos = f.getApellidos();
	Date v_Nacimiento = f.getFechaNacimiento();
	Date v_Ingreso = f.getFechaIngreso();
	Double v_salario = f.getSalario();
	*/	
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO funcionarios(id, codigo, nombres, apellidos, fechanacimiento, fechaingreso, salario) VALUES (?, ?, ?, ?, ?, ?, ?);");
			
			pstmt.setInt(1, prod.getId());
			pstmt.setString(2, prod.getCodigo());
			pstmt.setString(3, prod.getNombres());
			pstmt.setString(4, prod.getApellidos());
			pstmt.setDate(5, new Date(prod.getFechaNacimiento().getTime()));
			pstmt.setDate(6, new Date(prod.getFechaIngreso().getTime()));
			pstmt.setDouble(7, prod.getSalario());
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	
	public void actualizar(ProductoDTO prod) {
		
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = con.prepareStatement("UPDATE funcionarios SET salario = ? WHERE id = ?");
			pstmt.setDouble(1, prod.getSalario());
			pstmt.setInt(2, prod.getId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	
	public void eliminar(Integer id) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}


	public void crearTabla() {
		
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			int iReturnValue = s.executeUpdate("CREATE TABLE  IF NOT EXISTS funcionarios ("
 + " id integer NOT NULL,"
 + " codigo integer,"
 + " nombres character varying,"
 + " apellidos character varying,"
 + " fechaNacimiento date,"
  + "fechaIngreso date,"
 + " salario double precision);");
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

}
