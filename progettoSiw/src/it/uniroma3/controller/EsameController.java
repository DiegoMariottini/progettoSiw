package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.Date;

import it.uniroma3.facade.EsameFacade;

@ManagedBean
public class EsameController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String codiceEsame;
	private Date date;
	private String aula;
	
	
	@EJB
	private EsameFacade esameFacade;
	
	public String creareEsame() {
		esameFacade.createEsame(this.codiceEsame, this.date, this.aula);
		return "Esame";
	}
	
	public String getAula() {
		return aula;
	}
	public String getCodiceEsame() {
		return codiceEsame;
	}
	public Date getDate() {
		return date;
	}
	public Long getId() {
		return id;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
