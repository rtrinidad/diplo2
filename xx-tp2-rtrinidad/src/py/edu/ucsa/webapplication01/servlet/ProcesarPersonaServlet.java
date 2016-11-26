package py.edu.ucsa.webapplication01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesarPersonaServlet
 */
@WebServlet("/ProcesarPersonaServlet")
public class ProcesarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>ABM PERSONAS</title>");
		out.print("</head><body>");
		out.print("<br><span>Codigo:</span>" + request.getParameter("ruc"));
		out.print("<br><span>Nombre:</span>" + request.getParameter("razonsocial"));
		out.print("<br><span>Password:</span>" + request.getParameter("pass"));
		out.print("<br><span>PersonaJuridica:</span>" + request.getParameter("personajuridica"));
		out.print("<br><span>Sexo:</span>" + request.getParameter("sexo"));
		out.print("<br><span>Comentarios:</span>" + request.getParameter("comentarios"));
		out.print("<br><span>activEconomica:</span>" + request.getParameter("activEconomica"));
		
	}

}
