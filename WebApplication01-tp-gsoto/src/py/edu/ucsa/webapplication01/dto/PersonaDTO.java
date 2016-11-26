package py.edu.ucsa.webapplication01.dto;


public class PersonaDTO {
	private String ruc;
	private String razonSocial;
	private String pass;
	private String comentarios;
	public String getRuc() {
		return ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public String getPass() {
		return pass;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	

}
