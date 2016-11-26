package py.edu.ucsa.carrito.dto;

import java.util.List;

public class UsuarioDTO {
	
	private int id;
	private String usuario;
	private String nombres;
	private String apellidos;
	private List<RolDTO> roles;

	public UsuarioDTO(){}
	
	public UsuarioDTO(int id, String usuario, String nombres, String apellidos,
			List<RolDTO> roles) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.roles = roles;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public List<RolDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}

}
