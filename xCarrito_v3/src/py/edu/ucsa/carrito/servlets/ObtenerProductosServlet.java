package py.edu.ucsa.carrito.servlets;

import java.io.IOException;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.edu.ucsa.carrito.dao.impl.ProductoDAOImpl;
import py.edu.ucsa.carrito.dto.ProductoDTO;




/**
 * Servlet implementation class ObtenerProductosServlet
 */
@WebServlet("/ObtenerProductosServlet")
public class ObtenerProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<ProductoDTO> productosFromDB = null;//new ProductoDAOImpl().listar();
		List<ProductoDTO> productosFromDB = new ProductoDAOImpl().listar();
		request.getSession().setAttribute("productos", productosFromDB);
		request.getRequestDispatcher("MostrarProductosDisponibles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
