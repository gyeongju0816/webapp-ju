package kr.ac.kku.cs.wp.ju;

import java.util.List;

public class Account {

	private String id;
	private String role;
	private List <String> roles;
	private String name;
	private String email;

	
	// username getter와 setter
    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    // email getter와 setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // id getter와 setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // roles getter와 setter
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
