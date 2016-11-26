package py.edu.ucsa.jdbc.connectivity.dto;

import java.util.Date;

public class FuncionarioDTO {

	
	private Integer id;
	private Integer codigo;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private Double salario;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaIngreso=" + fechaIngreso
				+ ", salario=" + salario + "]";
	}
	
	
	
}
