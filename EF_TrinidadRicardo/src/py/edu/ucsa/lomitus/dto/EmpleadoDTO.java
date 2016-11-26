package py.edu.ucsa.lomitus.dto;

public class EmpleadoDTO {

	private int id;
	private String nombre_apellido;
	private String usuario;
	private String clave;
	private String tipo;
	
	
	public EmpleadoDTO(){
		
	}
	
	public EmpleadoDTO (int id, String nombre_apellido, String usuario, String clave, String tipo){
		
		super();
		this.id = id;
		this.nombre_apellido = nombre_apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.tipo = tipo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_apellido() {
		return nombre_apellido;
	}
	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
