package myPackage;


public class Notas {

	private	Integer	id;
	private	String	title;
	private String content;
	private	Integer	user_id;
	private String user_Username;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getTitle(){ return this.title;}
	public void setTitle(String title){ this.title = title;}
	
	public	String getContent(){ return this.content;}	
	public void setContent(String content){	this.content = content;}

	public	Integer getUserID(){ return this.user_id;}	
	public void setUserID(Integer user_id){	this.user_id = user_id;}
	
	public	String getUsername(){ return this.user_Username;}	
	public void setUsername(String user_Username){	this.user_Username = user_Username;}
}
