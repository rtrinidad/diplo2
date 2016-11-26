package py.edu.ucsa.carrito.dao.impl;

import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.dto.ProductoDTO;

public class ProductoDAOImpl {

	public List<ProductoDTO> listar() {
		List<ProductoDTO> prods = new ArrayList<ProductoDTO>();
		ProductoDTO prod = new ProductoDTO(10, "AUTITO", 20000, 15);
		prods.add(prod);
		prod = new ProductoDTO(19, "MUÑECA", 80000, 3);
		prods.add(prod);
		return prods;
	}

}
