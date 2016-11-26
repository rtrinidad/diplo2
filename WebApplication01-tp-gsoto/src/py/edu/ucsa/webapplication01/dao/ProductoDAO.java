package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.ProductoDTO;

public interface ProductoDAO {
	void insertProducto(ProductoDTO p);
	
	void actualizarProducto(ProductoDTO p);
	
	void borrarProducto(String codigo);
	
	ArrayList<ProductoDTO> listarProducto();
}
