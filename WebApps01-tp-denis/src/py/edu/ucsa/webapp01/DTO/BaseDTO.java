package py.edu.ucsa.webapp01.DTO;

import java.util.Date;

public class BaseDTO {
	private Long id;
	private String codigo;
	private Date fechaInsercion;
	
	public Long getId() {
		return id;
	}
	public String getCodigo() {
		return codigo;
	}
	public Date getFechaInsercion() {
		return fechaInsercion;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}
	
	
}
