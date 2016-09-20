package it.uniroma3.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Studente;

@Stateless
@LocalBean
public class StudenteFacade {
	@PersistenceContext(unitName = "products-unit")
	private static EntityManager entityManager;
	public StudenteFacade()  {
	}

	public Studente createStudente(String name, String cognome, int matricola) {
		Studente studente = new Studente(name, cognome, matricola);
		entityManager.persist(studente);
		return studente;
	}

	public Studente getStudente(Long id) {
		Studente studente = entityManager.find(Studente.class, id);
		return studente;
	}

	public List<Studente> getAllStudenti() {
		CriteriaQuery<Studente> cq = entityManager.getCriteriaBuilder().createQuery(Studente.class);
		cq.select(cq.from(Studente.class));
		List<Studente> studenti = entityManager.createQuery(cq).getResultList();
		return studenti;
	}

	public void updateStudente(Studente studente) {
		entityManager.merge(studente);
	}

	private void deleteStudente(Studente studente) {
		entityManager.remove(studente);
	}

	public void deleteStudente(Long id) {
		Studente studente = entityManager.find(Studente.class, id);
		deleteStudente(studente);
	}
}