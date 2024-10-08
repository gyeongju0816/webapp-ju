package kr.ac.kku.cs.wp.ju;

import java.util.Arrays;
import java.util.Collections;
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
    
    // 단일 String 역할을 설정할 때 사용
    public void setRole(String role) {
        this.roles = Collections.singletonList(role);
    }

    // 콤마로 구분된 여러 역할을 설정할 때 사용
    public void setRolesFromString(String rolesString) {
        this.roles = Arrays.asList(rolesString.split(","));
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
