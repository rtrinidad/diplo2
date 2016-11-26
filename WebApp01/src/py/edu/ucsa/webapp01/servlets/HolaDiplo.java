package py.edu.ucsa.webapp01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaDiplo
 */
@WebServlet("/HolaDiplo")
public class HolaDiplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaDiplo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	System.out.println("Destruyendo el Servlet de Bienvenida");
    }
    
  @Override
public void init() throws ServletException {
	super.init();
	System.out.println("Inicializando el Servlet de Bienvenida");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html><html lang=\"es\"><head><title>Servlet de Bienvenida!!</title></head><body>");
		out.print("<h1>Bienvenidos al DIPLOMADO</h1>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
