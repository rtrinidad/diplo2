package py.edu.ucsa.carrito.dto;

public class ProductoDTO {

	private int id;
	private String descripcion;
	private double precio;
	private int cantidadEnStock;

	public ProductoDTO(){}
	
	public ProductoDTO(int id, String descripcion, double precio,
			int cantidadEnStock) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidadEnStock() {
		return cantidadEnStock;
	}
	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	
}
