package com.project.stuckyi.domain;


public class JoinDTO {
	private String id;
	private String pw;
	private String ph;
	private String email;
	private String name;
	private String gender;
	
	
	public JoinDTO() {
		super();
	}

	public JoinDTO(String id, String pw, String ph, String email, String name, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.ph = ph;
		this.email = email;
		this.name = name;
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
