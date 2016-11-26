package py.edu.ucsa.carrito.dto;

public class PersonaDTO {
	
	private String ruc;
	private String razonSocial;
	private String password;
	private String comentarios;
	private boolean personaJuridica;
	private boolean contribuyente;
	private String sexo;
	private String actividadEconomica;

	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public boolean isPersonaJuridica() {
		return personaJuridica;
	}
	public void setPersonaJuridica(boolean personaJuridica) {
		this.personaJuridica = personaJuridica;
	}
	public boolean isContribuyente() {
		return contribuyente;
	}
	public void setContribuyente(boolean contribuyente) {
		this.contribuyente = contribuyente;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getActividadEconomica() {
		return actividadEconomica;
	}
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

}
