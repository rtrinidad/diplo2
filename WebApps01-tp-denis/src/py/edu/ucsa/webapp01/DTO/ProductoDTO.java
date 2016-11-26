package py.edu.ucsa.webapp01.DTO;

import java.util.Date;

public class ProductoDTO extends ParametroDTO{
	private CategoriaDTO categoria;
	private ProveedorDTO proveedor;
	private MarcaDTO marca;
	private Double existenciaActual;
	private Double existenciaMinima;
	private Date fechaUltimaModificacion;
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public ProveedorDTO getProveedor() {
		return proveedor;
	}
	public MarcaDTO getMarca() {
		return marca;
	}
	public Double getExistenciaActual() {
		return existenciaActual;
	}
	public Double getExistenciaMinima() {
		return existenciaMinima;
	}
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	public void setExistenciaActual(Double existenciaActual) {
		this.existenciaActual = existenciaActual;
	}
	public void setExistenciaMinima(Double existenciaMinima) {
		this.existenciaMinima = existenciaMinima;
	}
	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}
	
}
