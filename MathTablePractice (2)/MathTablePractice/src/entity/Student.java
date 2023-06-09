package entity;

public class Student {
	
	private int id;
	private String name;
	private String lname;
	private String username;
	private String password;
	
	public Student() {
		super();
		
	}
	
	public Student(int id, String name, String lname, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
