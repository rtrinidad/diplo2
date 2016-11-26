package py.edu.ucsa.webapp01.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaDiplom
 */
@WebServlet("/HolaDiplom")
public class HolaDiplom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaDiplom() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void destroy(){
		System.out.println("Destruyendo el Servlet de Bienvenida");
	}
    public void init() throws ServletException {
		System.out.println("Iniciando el servlet de bienvenida");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Servlet de Bienvenida!!!</title></head>");
		out.print("<body><h1>Bienvenidos al diplomado Java<h1><br></html>");
		if (request.getParameter("param") != null) {
			out.print("<h3>Modulo:" + request.getParameter("param") + "<h3>");
			out.print("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
