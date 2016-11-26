package py.edu.ucsa.carrito.dto;

public class RolDTO {

	private int id;
	private String nombreRol;
	
	public RolDTO() {
		super();
	}
	
	public RolDTO(int id, String nombreRol) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
}
