package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/criauser")

public class CriaUser extends HttpServlet {


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
			
			PrintWriter out = response.getWriter();
			DAO dao = new DAO();
			
			Users user = new Users();
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setUsername(request.getParameter("username"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			if(dao.adicionaUser(user)) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario já existente. Por favor defina um Nome de Usuario diferente.');");
				out.println("location='index.jsp';");
				out.println("</script>");
				}
		
			dao.close();

	}	
}
