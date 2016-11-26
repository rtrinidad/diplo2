package py.edu.ucsa.lomitus.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.lomitus.dao.imp.EmpleadoDAOImpl;
import py.edu.ucsa.lomitus.dao.imp.PedidoDAOImpl;
import py.edu.ucsa.lomitus.dto.EmpleadoDTO;
import py.edu.ucsa.lomitus.dto.PedidoDTO;



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
			EmpleadoDTO emple = new EmpleadoDAOImpl().autenticar(request.getParameter("usuario"), request.getParameter("clave"));
			if (emple != null){ //NOS LOGUEAMOS EXITOSAMENTE
				HttpSession session = request.getSession(true);//CREAMOS UNA SESSION
				session.setAttribute(AtributosDeSesion.EMPLEADO_ACTUAL, emple); //SETEAMOS AL USUARIO EN LA SESSION, COMO ATRIBUTO
				System.out.println("Empleado");
				System.out.println(emple.getUsuario());
				System.out.println(emple.getClave());
				
				
				//ACA PODRIAMOS IR A TRAER DE LA BD, UN CARRITO QUE NO HAYA SIDO PAGADO AUN PARA EL USUARIO LOGUEADO
				//----ACA SETEAMOS LA LISTA DE PEDIDOS DE LA BASE DE DATOS
				//PedidoDAOImpl pedidos = new PedidoDAOImpl();
				List<PedidoDTO> pedidosFromDB = new PedidoDAOImpl().listar();
				for (PedidoDTO pedidoDTO : pedidosFromDB) {
					System.out.println("Listado de pedidos");
					System.out.println("Id de cada pedido listado: " + pedidoDTO.getId());
				}
				session.setAttribute(AtributosDeSesion.PEDIDOS_ACTUAL, pedidosFromDB); //agregamos la lista de pedidos a la session
				request.getRequestDispatcher("Exito.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICIÓN AL RECURSO MostrarPedidos.jsp
			}else{//SI EL USUARIO NO SE AUTENTICO
				request.getRequestDispatcher("Login.jsp").forward(request, response);//PASAMOS EL CONTROL DE LA PETICIÓN AL RECURSO Login.jsp
			}
		}else{//SI NO SE PUDIERON OBTENER LOS DATOS PARA LA AUTENTICACIÓN: usuario y clave y tipo del tipo 'OPER'
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
