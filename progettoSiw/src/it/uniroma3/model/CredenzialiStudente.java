package it.uniroma3.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CredenzialiStudente")
@NamedQuery(name = "findAllCredenzialiStudente", query = "SELECT p FROM CredenzialiStudente p")
public class CredenzialiStudente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false,name="userName")
	private String userName;

	@Column(nullable = false,name="password")
	private String password;

	@OneToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
	private Studente studente;

	public CredenzialiStudente(String userName,String password) {
		this.password=password;
		this.userName=userName;
		// TODO Auto-generated constructor stub
	}

	public CredenzialiStudente() {
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Studente getStudente() {
		return studente;
	}
	public String getUserName() {
		return userName;
	}

	@Override
	public boolean equals(Object obj) {
	
		CredenzialiStudente credenzialiStudente=(CredenzialiStudente) obj;
		
		return this.getUserName().equals(credenzialiStudente.getUserName())&&
				this.getPassword().equals(credenzialiStudente.getPassword());
	}

}
