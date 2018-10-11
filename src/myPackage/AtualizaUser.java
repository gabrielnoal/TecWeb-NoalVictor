package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atualizauser")

public class AtualizaUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='user_id'><br>");
		out.println("Nome: <input type='text' name='name'><br>");
		out.println("Sobrenome: <input type='text' name='surname'><br>");
		out.println("Usuario: <input type='text' name='username'><br>");
		out.println("Idade: <input type='number' name='age' step='1'><br>");
		out.println("E-mail: <input type='text' name='email'><br>");
		out.println("Senha: <input type='password' name='password'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
		}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			DAO dao = new DAO();
			
			Users user = new Users();
			user.setId(Integer.valueOf(request.getParameter("user_id")));
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setUsername(request.getParameter("username"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			dao.alteraUser(user);
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Cadastro atualizado com sucesso! :D");
			out.println("</body></html>");
			
			dao.close();
			}
			
}
