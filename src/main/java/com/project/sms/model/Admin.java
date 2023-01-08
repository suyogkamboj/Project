package com.project.sms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private int adminID;
	
	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	public int getUserID() {
		return adminID;
	}

	public void setadminID(int adminID) {
		this.adminID = adminID;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminID, String email, String name, String password) {
		super();
		this.adminID = adminID;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", email=" + email + ", name=" + name + ", password=" + password
				+ "]";
	}
	
	

//	@Column(name = "desig")
//	private String desig;

//	@OneToOne(mappedBy = "users")
//	private Students students;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "c_id")
//	   private Students students;
	
//	@OneToOne(mappedBy = "users")
//	private Faculty faculty;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "f_id")
//	   private Faculty faculty;

	

	
}
	
	



	
	