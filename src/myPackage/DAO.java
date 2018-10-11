package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myPackage.Users;

public class DAO {
	
//	CONECTANDO COM  BASE DE DADOS
	
	private Connection connection = null;
	public DAO() {	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

 				connection = DriverManager.getConnection("jdbc:mysql://localhost/crudproject","root","Warlen1998");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
//	CONEXÃO JÁ ESTABELECIDA
	
// -------------------------

//	TRATANDO USUÁRIOS
	
	public List<Users> getListaUser(){
		
		List<Users> users = new ArrayList<Users>();
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);				

			}
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return users;
	}
	
	public Users setUser(String Username){
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM user WHERE username=?");
			stmt.setString(1, Username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {	
			
			Users user = new Users();
			while (rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		
			rs.close();
			stmt.close();
			
			return user;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}	
	
	public boolean adicionaUser(Users user) {
		List<Users> users = getListaUser();
		for (Users alreadyIn : users) {
			if(user.getUsername().equals(alreadyIn.getUsername())) {
			return false; 
				}			
			}
						
		String sql = "INSERT INTO user" + "(name, surname, username, age, email, password) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setInt(4,user.getAge());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getPassword());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void alteraUser(Users user) {
		String sql = "UPDATE user SET " + "name=?, surname=?, username=?, age=?, email=?, password =? WHERE user_id=?";	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setInt(4,user.getAge());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getPassword());
			stmt.setInt(6, user.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeUser(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM user WHERE user_id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}


// FIM DO TRATAMENTO DE USUÁRIOS

// ------------------------------

// TRATANDO NOTAS

	public List<Notas> getListaNotas(Integer UserID){
		
		List<Notas> notas = new ArrayList<Notas>();
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM note WHERE user_id=?");
			stmt.setInt(1, UserID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setId(rs.getInt("note_id"));
				nota.setTitle(rs.getString("title"));
				nota.setContent(rs.getString("content"));
				notas.add(nota);				
			}
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Collections.reverse(notas); 
        
	return notas;
	}
	
	
	public void adicionaNota(Notas nota, Integer UserID) {
	String sql = "INSERT INTO note" + "(title, content, user_id) values(?,?,?)";
	try {
		PreparedStatement stmt = null;
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, nota.getTitle());
		stmt.setString(2, nota.getContent());
		stmt.setInt(3, UserID);
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void alteraNota(Notas nota) {
		String sql = "UPDATE note SET " + "title=?, content=? WHERE note_id=?";	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTitle());
			stmt.setString(2, nota.getContent());
			stmt.setLong(3, nota.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeNota(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM note WHERE note_id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

//	--------------------------------
	
//	AUTENTICAÇÃO/LOGIN
	
	public Users autenticaUsuario(Tentativas tentativa) {
		PreparedStatement stmt;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM user WHERE username=?");
			stmt.setString(1, tentativa.getUsername());
			rs = stmt.executeQuery();
			if(rs.next()) {
				if(tentativa.getPassword().equals(rs.getString("password"))) {
					Users user = new Users();
					
					user.setId(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setSurname(rs.getString("surname"));
					user.setUsername(rs.getString("username"));
					user.setAge(rs.getInt("age"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));		
					
					stmt.close();
					
					return user;
					
				} else {
					stmt.close();
					return null;
				}
			} else {
				stmt.close();
				return null;
			}	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return null;
	}
	
	
}
