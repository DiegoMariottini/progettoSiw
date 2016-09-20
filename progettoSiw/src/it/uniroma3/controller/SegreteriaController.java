package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.SegreteriaFacade;

@ManagedBean
public class SegreteriaController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String password;
	private String username;

	
	@EJB
	private SegreteriaFacade segreteriaFacade;

public String createSegreteria() {
	segreteriaFacade.createSegreteria(this.username, this.password);
	return "credenziali";
	
}

public Long getId() {
	return id;
}
public String getPassword() {
	return password;
}
public String getUsername() {
	return username;
}
public void setId(Long id) {
	this.id = id;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}



}