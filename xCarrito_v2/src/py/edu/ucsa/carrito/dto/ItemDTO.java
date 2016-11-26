package py.edu.ucsa.carrito.dto;

public class ItemDTO {

	private ProductoDTO producto;
	private int cantidad;
	
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
