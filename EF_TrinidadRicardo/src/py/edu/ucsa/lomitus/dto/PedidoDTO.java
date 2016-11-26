package py.edu.ucsa.lomitus.dto;

import java.util.Date;


public class PedidoDTO {
	
	private Long id;
	private ProductoDTO producto;
	private ClienteDTO cliente;
	private int cantidad;
	private Date fecha_pedido;
	private String estado;
	
	
	//Constructores
	public PedidoDTO(){}
	
	
	public PedidoDTO(ClienteDTO cliente){
		super();
		this.cliente = cliente;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
