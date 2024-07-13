package ovs;

public class candidate extends User{
	private int id;
	private election e; 

	public candidate(int id,String name, String lastname, String email, String password, int cin) {
		super(name, lastname, email, password, cin);
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
