package py.edu.ucsa.lomitus.dto;

public class ItemDTO {

	private ProductoDTO producto;
	private double cantidad;
	
	public ItemDTO(){}
	
	public ItemDTO(ProductoDTO producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
}
