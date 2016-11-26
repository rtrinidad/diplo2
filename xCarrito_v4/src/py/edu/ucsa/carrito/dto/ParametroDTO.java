package py.edu.ucsa.carrito.dto;


public abstract class ParametroDTO extends BaseDTO {
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
