package py.edu.ucsa.webapplication01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.webapplication01.dto.UsuarioDTO;


/**
 * Servlet implementation class VerUsuario
 */
@WebServlet("/VerUsuario")
public class VerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>USUARIO</title></head><body>");
		if (session != null){
			out.print("<h1>Nombre del Usuario:</h1><br/>");
			if (session.getAttribute("usuario") != null){
				UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuario");
				out.print("<br><h2>"+usuario.getNombre() + " " + usuario.getApellido() +"</h2>");
			}
		}else{
			out.print("<h1>La aplicación no obtuvo la session</h1>");
		}
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
