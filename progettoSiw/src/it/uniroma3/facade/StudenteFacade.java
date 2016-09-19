package it.uniroma3.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Studente;

public class StudenteFacade {
	
    private EntityManager entityManager;
    private EntityManagerFactory emf;

	public StudenteFacade()  {
		emf = Persistence.createEntityManagerFactory("products-unit");
		entityManager = emf.createEntityManager();
	}

	public Studente createStudente(String name, String cognome, int matricola) {
		Studente studente = new Studente(name, cognome, matricola);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(studente);
		tx.commit();
		entityManager.close();
		emf.close();
		return studente;
	}
	
	public Studente getStudente(Long id) {
	    Studente studente = entityManager.find(Studente.class, id);
		entityManager.close();
		emf.close();
		return studente;
	}
	
	public List<Studente> getAllStudenti() {
        CriteriaQuery<Studente> cq = entityManager.getCriteriaBuilder().createQuery(Studente.class);
        cq.select(cq.from(Studente.class));
        List<Studente> studenti = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		emf.close();
		return studenti;
	}

	public void updateStudente(Studente studente) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(studente);
		tx.commit();
		entityManager.close();
		emf.close();
		}
	
    private void deleteStudente(Studente studente) {
        entityManager.remove(studente);
    }

	public void deleteStudente(Long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
        Studente studente = entityManager.find(Studente.class, id);
        deleteStudente(studente);
		tx.commit();
		entityManager.close();
		emf.close();	}
}