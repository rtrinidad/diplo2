package py.edu.ucsa.carrito.dto;

import java.util.Date;
import java.util.List;

public class CarritoDTO {
	// Atributos
	private int id;
	private UsuarioDTO usuario;

	private List<ItemDTO> items;
	
	private boolean confirmado;
	private boolean pagado;
	
	private Date fechaConfirmacion;
	private Date fechaPago;
	
	// Constructores
	public CarritoDTO(){}
	
	public CarritoDTO(UsuarioDTO usuario) {
		super();
		this.usuario = usuario;
	}
	
	// Métodos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public boolean isConfirmado() {
		return confirmado;
	}
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public Date getFechaConfirmacion() {
		return fechaConfirmacion;
	}
	public void setFechaConfirmacion(Date fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}
