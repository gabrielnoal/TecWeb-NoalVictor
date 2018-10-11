package myPackage;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/listanotas")

public class ListaNotas extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
							HttpServletResponse response)

		throws ServletException, IOException {
		
		DAO dao = new DAO();
		dao.close();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
}
