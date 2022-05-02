package student.com.pjo;

public class Student {
   private long id;
   private String name;
   private String gender;
   private String emailId;
   private long barchId;
   
   public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public long getBarchId() {
	return barchId;
}
public void setBarchId(long barchId) {
	this.barchId = barchId;
}
   

}
