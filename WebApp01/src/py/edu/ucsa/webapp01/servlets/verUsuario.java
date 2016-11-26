package py.edu.ucsa.webapp01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class verUsuario
 */
@WebServlet("/verUsuario")
public class verUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession(false);
		  PrintWriter out = response.getWriter();
		  out.print("<html><head><title>USUARIO</title></head><body>");
		  if(session.getAttribute("usuario")!=null){
			  String usuario = (String) session.getAttribute("usuario");
			  out.print("<br><h2>"+usuario+"</h2>");
		  }
		  else{
			  out.print("<h1>La aplicacion no obtuvo la sesion</h1>");
		  }
		  
		  out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
	}

}
