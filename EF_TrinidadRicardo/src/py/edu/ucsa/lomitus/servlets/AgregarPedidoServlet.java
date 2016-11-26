package py.edu.ucsa.lomitus.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.lomitus.dto.ItemDTO;
import py.edu.ucsa.lomitus.dto.PedidoDTO;


/**
 * Servlet implementation class AgregarProductoServlet
 */
@WebServlet("/AgregarPedido")
public class AgregarPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarPedidoServlet() {
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
			PedidoDTO pedido = (PedidoDTO) request.getSession().getAttribute(AtributosDeSesion.PEDIDOS_ACTUAL);
			ItemDTO item = this.obtenerProductoExistenteEnCarrito(id, carrito);
			if (item != null){
				item.setCantidad(item.getCantidad()+ cantidad);
			}else{
				item = new ItemDTO();
				item.setCantidad(cantidad);
				item.setProducto(this.getProducto(id, request.getSession()));
				carrito.getItems().add(item);
			}
			request.getRequestDispatcher("MostrarPedidos.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("MostrarProductosDisponibles.jsp").forward(request, response);
		}

	}

	private PedidoDTO getProducto(long id, HttpSession session) {
		List<PedidoDTO> pedidos = (List<PedidoDTO>) session.getAttribute(AtributosDeSesion.PRODUCTOS);
		for (PedidoDTO p : pedidos) {
			if (p.getId().longValue() == id){
				return p;
			}
		}

		return null;
	}

	private PedidoDTO obtenerPedidosExistentes(Long id,
			PedidoDTO pedido) {
		for(PedidoDTO i : pedidos.getItems()){
			if (i.getProducto().getId().longValue() == id){
				return i;
			}
		}
		return null;
	}

}
