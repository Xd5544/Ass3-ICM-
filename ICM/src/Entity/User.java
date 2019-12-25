package Entity;


/**
 * The <code>Member</code> entity, represents a Member in the database.
 */
public class User {


    private String email;  
    private String password;
    private String username;
    
    public User() {
    	
    }
    
	
public User(String email, String password,String username) {
	this.email = email;
	this.password = password;
	this.username = username;
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

public String getUsername() {
		return username;
}

public void setUsername(String username) {
	this.username = username;
}

public enum Role {
	Studint, Secturer, Employee;
}
}