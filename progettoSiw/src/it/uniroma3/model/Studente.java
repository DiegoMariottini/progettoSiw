package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Studente")
@NamedQuery(name = "findAllStudente", query = "SELECT s FROM Studente s")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nomeStudente")
	private String nomeStudente;
	@Column(name="cognomeStudente")
	private String cognomeStudente;
	@Column(name="matricola")
	private int matricola;
	
	@OneToOne(cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
	private CredenzialiStudente credenzialiStudente;
	
	@OneToMany
    private List<Prenotazioni> prenotazioni;
		
	public Studente(String nomeStudente, String cognomeStudente,int matricola) {
		this.nomeStudente=nomeStudente;
		this.cognomeStudente=cognomeStudente;
		this.matricola=matricola;
		
	}
	public Studente() {
	}
	
	public List<Prenotazioni> getPrenotazioni() {
		return prenotazioni;
	}
	
	public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	public void setCredenzialiStudente(CredenzialiStudente credenzialiStudente) {
		this.credenzialiStudente = credenzialiStudente;
	}
	public CredenzialiStudente getCredenzialiStudente() {
		return credenzialiStudente;
	}
	
	
	public int getMatricola() {
		return matricola;
	}
	public String getCognomeStudente() {
		return cognomeStudente;
	}
	public String getNomeStudente() {
		return nomeStudente;
	}
	public void setCognomeStudente(String cognomeStudente) {
		this.cognomeStudente = cognomeStudente;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
				return this.nomeStudente+" "+this.cognomeStudente+" matr. "+this.getMatricola();
		}
	
	@Override
	public boolean equals(Object obj) {
		Studente studente = (Studente) obj;
		return (this.getMatricola()==studente.getMatricola());
	}
	
	
}
