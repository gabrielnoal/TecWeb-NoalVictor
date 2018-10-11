package myPackage;


public class Users {

	private	Integer	id;
	private	String	name;
	private String surname;
	private String username;
	private Integer age;
	private String email;
	private String password;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName(){ return this.name;}
	public void setName(String name){ this.name = name;}
	
	public	String getSurname(){ return this.surname;}	
	public void setSurname(String surname){	this.surname = surname;}

	public	String getUsername(){ return this.username;}	
	public void setUsername(String username){	this.username = username;}

	public	Integer getAge(){ return this.age;}	
	public void setAge(Integer age){	this.age = age;}

	public	String getEmail(){ return this.email;}	
	public void setEmail(String email){	this.email = email;}

	public	String getPassword(){ return this.password;}	
	public void setPassword(String password){	this.password = password;}
}
