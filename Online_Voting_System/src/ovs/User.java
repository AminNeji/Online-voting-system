package ovs;

public class User {
	protected String name,lastname,email,password;
	protected int cin;
	protected boolean hasvoted;
	public User(String name, String lastname, String email, String password, int cin) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.cin = cin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public void setvote(boolean vote) {
		this.hasvoted=vote;
	}
	public boolean getvote() {
		return this.hasvoted;
	}
	
}
