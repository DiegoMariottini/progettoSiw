package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Prenotazioni")
@NamedQuery(name = "findAllPrenotazioni", query = "SELECT p FROM Prenotazioni p")
public class Prenotazioni {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//solo la segreteria dalle prenotazioni vuole risalire agli studenti
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Studente_id")
	private Studente studente;

	//sia la segreteria che gli studenti quando accedono alle prenotazioni caricano gli esami anche solo per vedere il nome
	@ManyToOne
	@JoinColumn(name = "Esame_id")
	private Esame esame;


	public Prenotazioni() {
	}

	public Prenotazioni(Studente studente,Esame esame) {
		this.esame=esame;
		this.studente=studente;
	}

	public Long getId() {
		return id;
	}

	public Esame getEsame() {
		return esame;
	}
	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		Prenotazioni esamiStudente= (Prenotazioni) obj;
		return 
				this.getEsame().equals(esamiStudente.getEsame())&&
				this.getStudente().equals(esamiStudente.getStudente());
	}

}
