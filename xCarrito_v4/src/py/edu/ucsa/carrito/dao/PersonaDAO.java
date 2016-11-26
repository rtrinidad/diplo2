package py.edu.ucsa.carrito.dao;

import py.edu.ucsa.carrito.dto.PersonaDTO;

public interface PersonaDAO extends CrudDAO<PersonaDTO>{
	//M�todos para obtener persona(s)
	PersonaDTO getByRuc(String ruc);
}
