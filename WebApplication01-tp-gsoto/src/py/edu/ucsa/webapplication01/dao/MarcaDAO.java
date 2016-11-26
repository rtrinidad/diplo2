package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.MarcaDTO;

public interface MarcaDAO {
	void insertMarca(MarcaDTO m);
	
	void actualizarMarca(MarcaDTO m);
	
	void borrarMarca(String codigo);
	
	ArrayList<MarcaDTO> listarMarca();
}
