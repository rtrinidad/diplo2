package py.edu.ucsa.webapp01.dto;

import java.util.Date;

public class ProductoDTO extends ParametroDTO {
	
	private CategoriaDTO categoria;
	private ProveedorDTO proveedor;
	private MarcaDTO marca;
	private double existenciaActual;
	private double existenciaMinima;

	private Date fechaUltMod;
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public ProveedorDTO getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	public MarcaDTO getMarca() {
		return marca;
	}
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	public double getExistenciaActual() {
		return existenciaActual;
	}
	public void setExistenciaActual(double existenciaActual) {
		this.existenciaActual = existenciaActual;
	}
	public double getExistenciaMinima() {
		return existenciaMinima;
	}
	public void setExistenciaMinima(double existenciaMinima) {
		this.existenciaMinima = existenciaMinima;
	}
	
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}
	
	
}
