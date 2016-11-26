package py.edu.ucsa.carrito.dto;

import java.util.Date;

public class ProductoDTO extends ParametroDTO{
	
	private CategoriaDTO categoria;
	private MarcaDTO marca;
	private ProveedorDTO proveedor;
	private Double cantidadEnStock;
	private Double existenciaMinima;
	private Date fechaUltimaModificacion;
	private Double precio;
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public MarcaDTO getMarca() {
		return marca;
	}
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	public ProveedorDTO getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	
	public Double getCantidadEnStock() {
		return cantidadEnStock;
	}
	public void setCantidadEnStock(Double cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getExistenciaMinima() {
		return existenciaMinima;
	}
	public void setExistenciaMinima(Double existenciaMinima) {
		this.existenciaMinima = existenciaMinima;
	}
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

}
