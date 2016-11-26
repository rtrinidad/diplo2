package py.edu.ucsa.webapp01.servlets;

 import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import py.edu.ucsa.webapp01.personaDAO.PersonaDAO;
import py.edu.ucsa.webapp01.personaDAO.PersonaDTO;

/**
 * Servlet implementation class ProcesarPersonaServlet
 */
@WebServlet("/ProcesarPersonaServlet") //ESTO ES ANOTATIONS
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
		// TODO Auto-generated method stub
		/*
		String ruc = request.getParameter("ruc");
		String rs = request.getParameter("razonSocial");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>ABM Persona</title></head>");
		out.print("<body>");
		out.print("<br><span>RUC:</span>"+ ruc);
		out.print("<br><span>Razon Social:</span>"+ rs);
		out.print("<br><span>Password:</span>"+ request.getParameter("pass"));
		out.print("<br><span>Comentario:</span>"+ request.getParameter("Comentarios"));
		out.print("<br><span>Sexo:</span>"+ request.getParameter("sexo"));
		out.print("<br><span>Actividad Economica:</span>"+ request.getParameterValues("activEconomica"));
		out.print("<br><span>Persona Juridica:</span>"+ request.getParameter("personaJuridica"));
		out.print("<br><span>Es Gran Contribuyente?:</span>"+ request.getParameter("granContribuyente"));
		*/
		
		PersonaDTO dto = new PersonaDTO();
		dto.setRuc(request.getParameter("ruc"));
		dto.setRazonSocial(request.getParameter("razonSocial"));
		dto.setComentarios(request.getParameter("Comentarios"));
		dto.setPass(request.getParameter("pass"));
		
		PersonaDAO dao = new PersonaImpl();
		dao.insertar(dto);
		
	}	
}
