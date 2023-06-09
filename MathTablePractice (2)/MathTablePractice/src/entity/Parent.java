package entity;

public class Parent {
	
	String username;
	String password;
	public Parent(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Parent() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
