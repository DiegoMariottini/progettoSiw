package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Segreteria")
@NamedQuery(name = "Segreteria", query = "SELECT p FROM Segreteria p")
public class Segreteria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false,name="userName")
	private String userName;

	@Column(nullable = false,name="password")
	private String password;
	
	public Segreteria(String userName,String password) {
		this.password=password;
		this.userName=userName;
	}
	public Segreteria() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
