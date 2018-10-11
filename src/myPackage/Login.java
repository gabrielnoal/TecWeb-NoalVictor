package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			DAO dao = new DAO();
		
			Tentativas tentativa = new Tentativas();
			tentativa.setUsername(request.getParameter("username"));
			tentativa.setPassword(request.getParameter("password"));
		
			if(dao.autenticaUsuario(tentativa)!=null){ 
				Users autenticatedUser = dao.setUser(tentativa.getUsername());

				request.setAttribute("userId", dao.autenticaUsuario(tentativa).getId());
				request.setAttribute("Username", autenticatedUser.getName());
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario ou senha incorretos');");
				out.println("location='index.jsp';");
				out.println("</script>");
			}
			
			dao.close();
		}	
}	
