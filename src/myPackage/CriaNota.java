package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crianota")

public class CriaNota extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			DAO dao = new DAO();		
			Notas nota = new Notas();

			nota.setTitle(request.getParameter("title"));
			nota.setContent(request.getParameter("content"));
			nota.setUserID(Integer.valueOf(request.getParameter("user_id")));
			nota.setUsername(request.getParameter("username"));
			
			dao.adicionaNota(nota, nota.getUserID());
			
			request.setAttribute("userId", nota.getUserID());
			request.setAttribute("Username", nota.getUsername());
			
			dao.close();
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
}
