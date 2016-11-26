package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.ProductoDTO;

public interface ProductoDAO {
	void insertProducto(ProductoDTO p);
	
	void actualizarProducto(ProductoDTO p);
	
	void borrarProducto(String codigo);
	
	ArrayList<ProductoDTO> listarProducto();
	
	ProductoDTO obtenerProductoXCodigo(String cod);
}
