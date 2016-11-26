package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.MarcaDTO;

public interface MarcaDAO {
	void insertMarca(MarcaDTO m);
	
	void actualizarMarca(MarcaDTO m);
	
	void borrarMarca(String codigo);
	
	ArrayList<MarcaDTO> listarMarca();
	
	MarcaDTO obtenerMarcaXCodigo(String cod);
}
