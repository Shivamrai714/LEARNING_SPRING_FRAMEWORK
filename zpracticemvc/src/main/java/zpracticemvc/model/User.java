package zpracticemvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity                 //this will create table of User in database
public class User {

	@Id                      //to take auto incremetn filed id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String email;
	private String userName;

	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
