package py.edu.ucsa.webapplication01.recurso;

import java.util.Date;

public class RecursosDTO {
	private Long id;
	private String codigo;
	private String descripcion;
	private boolean habilitado;
	private Date fechainsercion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Date getFechainsercion() {
		return fechainsercion;
	}
	public void setFechainsercion(Date fechainsercion) {
		this.fechainsercion = fechainsercion;
	}
}
