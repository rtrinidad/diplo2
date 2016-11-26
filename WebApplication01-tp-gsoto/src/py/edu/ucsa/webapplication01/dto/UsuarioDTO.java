package py.edu.ucsa.webapplication01.dto;

import java.util.List;

public class UsuarioDTO {
	
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	
	private List<RolDTO> roles;
	
	public UsuarioDTO(String usuario, String nombre, String apellido) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public List<RolDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	
}
