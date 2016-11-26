package py.edu.ucsa.jdbc.connectivity.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;
import py.edu.ucsa.jdbc.connectivity.dao.FuncionariosDAO;
import py.edu.ucsa.jdbc.connectivity.dto.FuncionarioDTO;

public class FuncionariosDAOImpl implements FuncionariosDAO {

	@Override
	public List<FuncionarioDTO> listar() {
		List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
		Connection c;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM funcionarios ORDER BY id ASC");
			
			FuncionarioDTO f = null;
			
			while (rs.next()){
				
				f = new FuncionarioDTO();
				f.setId(rs.getInt("id"));
				f.setCodigo(rs.getInt("codigo"));
				f.setNombres(rs.getString("nombres"));
				f.setApellidos(rs.getString("apellidos"));
				f.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				f.setFechaIngreso(rs.getDate("fechaIngreso"));
				f.setSalario(rs.getDouble("salario"));
									
				
				funcionarios.add(f);
			}
			
						
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return funcionarios;
	}

	@Override
	public FuncionarioDTO obtenerFuncionarioPorCodigo(Integer codigo) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = con.prepareStatement("SELECT ...... funcionarios SET salario = ? WHERE id = ?");
			pstmt.setDouble(1, f.getSalario());
			pstmt.setInt(2, f.getId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return funcionario;
	}

	@Override
	public void insertar(FuncionarioDTO f) {
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
			
			pstmt.setInt(1, f.getId());
			pstmt.setInt(2, f.getCodigo());
			pstmt.setString(3, f.getNombres());
			pstmt.setString(4, f.getApellidos());
			pstmt.setDate(5, new Date(f.getFechaNacimiento().getTime()));
			pstmt.setDate(6, new Date(f.getFechaIngreso().getTime()));
			pstmt.setDouble(7, f.getSalario());
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(FuncionarioDTO f) {
		
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement pstmt = con.prepareStatement("UPDATE funcionarios SET salario = ? WHERE id = ?");
			pstmt.setDouble(1, f.getSalario());
			pstmt.setInt(2, f.getId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	@Override
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

	@Override
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
