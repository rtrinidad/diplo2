package py.edu.ucsa.carrito.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.carrito.dto.CarritoDTO;
import py.edu.ucsa.carrito.dto.ItemDTO;
import py.edu.ucsa.carrito.dto.ProductoDTO;

/**
 * Servlet implementation class AgregarProductoServlet
 */
@WebServlet("/AgregarProducto")
public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("codigoSeleccionado") != null
				&& !"".equals(request.getParameter("codigoSeleccionado").trim())){
			Long id = Long.parseLong(request.getParameter("codigoSeleccionado"));
			Double cantidad = Double.parseDouble(request.getParameter("cantidadAgregada"));
			CarritoDTO carrito = (CarritoDTO) request.getSession().getAttribute(AtributosDeSesion.CARRITO_ACTUAL);
			ItemDTO item = this.obtenerProductoExistenteEnCarrito(id, carrito);
			if (item != null){
				item.setCantidad(item.getCantidad()+ cantidad);
			}else{
				item = new ItemDTO();
				item.setCantidad(cantidad);
				item.setProducto(this.getProducto(id, request.getSession()));
				carrito.getItems().add(item);
			}
			request.getRequestDispatcher("MostrarCarrito.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("MostrarProductosDisponibles.jsp").forward(request, response);
		}

	}

	private ProductoDTO getProducto(long id, HttpSession session) {
		List<ProductoDTO> productos = (List<ProductoDTO>) session.getAttribute(AtributosDeSesion.PRODUCTOS);
		for (ProductoDTO p : productos) {
			if (p.getId().longValue() == id){
				return p;
			}
		}

		return null;
	}

	private ItemDTO obtenerProductoExistenteEnCarrito(Long id,
			CarritoDTO carrito) {
		for(ItemDTO i : carrito.getItems()){
			if (i.getProducto().getId().longValue() == id){
				return i;
			}
		}
		return null;
	}

}
