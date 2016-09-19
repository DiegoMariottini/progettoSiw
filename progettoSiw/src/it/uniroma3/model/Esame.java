package it.uniroma3.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Esame")
@NamedQuery(name = "findAllEsame", query = "SELECT p FROM Esame p")
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false,name="codiceEsame")
	private String codiceEsame;
	
	@Column(nullable = false,name="data")
    @Temporal (TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false,name="aulaEsame")
	private String aulaEsame;


	@OneToMany
    private List<Prenotazioni> prenotazioni;

	
	
	public Esame(String codiceEsame,Date data, String aulaEsame) {
		this.data=data;
		this.codiceEsame=codiceEsame;
		this.aulaEsame=aulaEsame;
		this.prenotazioni=null;
	}
	
	public Esame() {
	}
	
	
	public List<Prenotazioni> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	public String getAulaEsame() {
		return aulaEsame;
	}
	public String getCodiceEsame() {
		return codiceEsame;
	}
	public Date getData() {
		return data;
	}
	
	public void setAulaEsame(String aulaEsame) {
		this.aulaEsame = aulaEsame;
	}
	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return ""+this.getCodiceEsame()+","+this.getData()+","+this.getAulaEsame();
	}
	@Override
	public boolean equals(Object obj) {
		Esame esame=(Esame) obj;
		return this.getCodiceEsame().equals(esame.getCodiceEsame())&&
				this.getData().equals(esame.getData()) &&
				this.getAulaEsame().equals(esame.getAulaEsame());
	}
	
	
	
	
}
