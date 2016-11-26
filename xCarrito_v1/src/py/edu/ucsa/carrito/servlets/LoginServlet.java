package py.edu.ucsa.carrito.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.carrito.dao.impl.UsuarioDAOImpl;
import py.edu.ucsa.carrito.dto.CarritoDTO;
import py.edu.ucsa.carrito.dto.UsuarioDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2965856253161907123L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (validarDatosIngresados(request)){
			UsuarioDTO usu = new UsuarioDAOImpl().autenticar(request.getParameter("usuario"), request.getParameter("clave"));
			if (usu != null){ //NOS LOGUEAMOS EXITOSAMENTE
				HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
				session.setAttribute(AtributosDeSesion.USUARIO_ACTUAL, usu); //SETEAMOS AL USUARIO EN LA SESSION, COMO ATRIBUTO
				//ACA PODRIAMOS IR A TRAER DE LA BD, UN CARRITO QUE NO HAYA SIDO PAGADO AUN PARA EL USUARIO LOGUEADO
				session.setAttribute(AtributosDeSesion.CARRITO_ACTUAL, new CarritoDTO()); //CREAMOS UN CARRITO VACIO EN LA SESSION
				request.getRequestDispatcher("MostrarCarrito.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICIÓN AL RECURSO MostrarCarrito.jsp
			}else{//SI EL USUARIO NO SE AUTENTICO
				request.getRequestDispatcher("Login.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICIÓN AL RECURSO Login.jsp
			}
		}else{//SI NO SE PUDIERON OBTENER LOS DATOS PARA LA AUTENTICACIÓN: usuario y clave
			request.getRequestDispatcher("Login.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICIÓN AL RECURSO Login.jsp
		}
	}

	private boolean validarDatosIngresados(HttpServletRequest request) {
		return request.getParameter("usuario") != null
				&& request.getParameter("clave") != null
				&& !"".equals(request.getParameter("usuario").trim())
				&& !"".equals(request.getParameter("clave").trim());
	}

}
