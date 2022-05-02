package student.com.pjo;

public class Login {
 private long Id;
 private String name;
 private String loginId;
 private String loginPassword;
 private String role;
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getLoginPassword() {
	return loginPassword;
}
public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
 
}
