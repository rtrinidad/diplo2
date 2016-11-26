package py.edu.ucsa.lomitus.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.lomitus.dao.imp.PedidoDAOImpl;
import py.edu.ucsa.lomitus.dto.PedidoDTO;






/**
 * Servlet implementation class ObtenerProductosServlet
 */
@WebServlet("/GestionarPedido")
public class GestionarPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionarPedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<ProductoDTO> productosFromDB = null;//new ProductoDAOImpl().listar();
		List<PedidoDTO> productosFromDB = new PedidoDAOImpl().listar();
		request.getSession().setAttribute(AtributosDeSesion.PRODUCTOS, productosFromDB);
		request.getRequestDispatcher("MostrarProductosDisponibles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("ELIMINAR".equals(request.getParameter("accion"))){
			if (validarId(request)){
				long id = Long.parseLong(request.getParameter("idSeleccionado"));
				this.eliminarProductoDelCarrito(id, request.getSession());
			}
		}else if ("EDITAR".equals(request.getParameter("accion"))){
			if (validarId(request)
					&& request.getParameter("cantidad") != null 
					&& !"".equals(request.getParameter("cantidad"))){
				long id = Long.parseLong(request.getParameter("idSeleccionado"));
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));
				this.editarCantProdDelCarrito(id, cantidad, request.getSession());
			}
		}
		
		request.getRequestDispatcher("MostrarCarrito.jsp").forward(request, response);
	}

	private boolean validarId(HttpServletRequest request) {
		return request.getParameter("idSeleccionado") != null 
				&& !"".equals(request.getParameter("idSeleccionado"));
	}

	private void editarCantProdDelCarrito(long id, int cantidad,
			HttpSession session) {
		CarritoDTO carritoActual = (CarritoDTO) session.
				getAttribute(AtributosDeSesion.CARRITO_ACTUAL);
		for (ItemDTO item : carritoActual.getItems()) {
			if (item.getProducto().getId().longValue() == id){
				item.setCantidad(cantidad);
			}
		}
	}

	private void eliminarProductoDelCarrito(long id, HttpSession session) {
		CarritoDTO carritoActual = (CarritoDTO) session.
				getAttribute(AtributosDeSesion.CARRITO_ACTUAL);
		Iterator<ItemDTO> it = carritoActual.getItems().iterator();
		while(it.hasNext()){
			ItemDTO item = it.next();
			if (item.getProducto().getId().longValue() == id){
				it.remove();
			}
		}
	}

}
