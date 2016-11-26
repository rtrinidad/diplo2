package py.edu.ucsa.webapp01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ABMPersonaServlet
 */
// A partir de la especificacion 3.0 del Servlet se crea un Annotations @webservlet 
// que permite registrar mi servlet
@WebServlet(
		name = "ABMPersonaServletLogico", 
		description = "Servlet que procesara las peticiones relacionadas a la gestion de personas", 
		urlPatterns = { 
				"/ABMPersona", 
				"/ProcesarPersona", 
				"/GestionarPersona"
		})
public class ABMPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMPersonaServlet() {
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
		
		String ruc = request.getParameter("ruc");
		String razon = request.getParameter("razon");
		String password = request.getParameter("password");
		String textarea1 = request.getParameter("textarea1");
		//String check1 = request.getParameter("check1");
		String[] ckeck1 = request.getParameterValues("check1[]");
		String opt1 = request.getParameter("opt1");
		//String mult1 = request.getParameter("mult1");
		String[] mult1 = request.getParameterValues("mult1[]");
	
		
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html><html lang=\"es\"><head><title>ABM Personas</title></head><body>");
		out.print("<br><span>RUC: </span>" + ruc);
		out.print("<br><span>RAZON SOCIAL: </span>" + razon);
		out.print("<br><span>PASSWORD: </span>" + password);
		out.print("<br><span>OBSERVACIONES: </span>" + textarea1);
		//out.print("<br><span>TIPOS: </span>" + check1);
		for(int i = 0; i < ckeck1.length; i++){ 
			out.print("<br><span>TIPOS: </span>" + ckeck1[i]);
		}	
		out.print("<br><span>SEXO: </span>" + opt1);
		//out.print("<br><span>ACTIVIDADES: </span>" + mult1);	
		for(int loopIndex = 0; loopIndex < mult1.length; loopIndex++){ 
			out.print("<br><span>ACTIVIDADES: </span>" + mult1[loopIndex]);
		}		
		out.print("</body></html>");
		
	}

}
