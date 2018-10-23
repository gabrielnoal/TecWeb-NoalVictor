package mvc.model;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;

public class UsuarioDAO {
	private Connection connection = null;
	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "vlm1998");
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
	
	public void adiciona(Usuario usuario) throws IOException {
		MultipartFile filePart = usuario.getFoto();
		/* Rotina para salvar o arquivo no servidor */
 		if (!filePart.isEmpty()) {
 			String fileName = filePart.getOriginalFilename();
 			File uploads = new File("/tmp");
 				File file = new File(uploads, fileName);
 				try (InputStream input = filePart.getInputStream()) {
 					Files.copy(input, file.toPath());
 				}
 		}
 		
		try {
			String sql = "INSERT INTO usuario (login, senha, foto) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			stmt.setBinaryStream(3, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		try {
			String sql = "SELECT * FROM usuario WHERE login=? and senha=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			
			ResultSet resultSet = stmt.executeQuery();
			
			if (!resultSet.next() ) {
			    System.out.println("resultset does not data");
			    return existe;
			} else {
				existe = true;
				
				stmt.close();
				resultSet.close();
				return existe;
			}
		}catch (SQLException e) {e.printStackTrace();}
		return existe;
	}

	public byte[] buscaFoto(String login) {

		return null;
	}
}