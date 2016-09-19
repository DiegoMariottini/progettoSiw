package it.uniroma3.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;
import it.uniroma3.model.Prenotazioni;
import it.uniroma3.model.Studente;

public class PrenotazioniFacade {

	private static EntityManager entityManager;
	private static EntityManagerFactory emf;

	public PrenotazioniFacade()  {
		emf = Persistence.createEntityManagerFactory("products-unit");
		entityManager = emf.createEntityManager();
	}


	public static Prenotazioni createPrenotazione(Studente studente,Esame esame) {

		Prenotazioni prenotazione = new Prenotazioni(studente,esame);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(prenotazione);
		tx.commit();
		entityManager.close();
		emf.close();
		return prenotazione;
	}

	public static Prenotazioni getPrenotazione(Long id) {
		Prenotazioni prenotazione = entityManager.find(Prenotazioni.class, id);
		entityManager.close();
		emf.close();
		return prenotazione;
	}


	public static void updatePrenotazione(Prenotazioni prenotazione) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(prenotazione);
		tx.commit();
		entityManager.close();
		emf.close();
	}

	public void deletePrenotazione(Long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Prenotazioni prenotazione = entityManager.find(Prenotazioni.class, id);
		deletePrenotazione(prenotazione);
		tx.commit();
		entityManager.close();
		emf.close();	
	}
	private void deletePrenotazione(Prenotazioni prenotazione) {
		entityManager.remove(prenotazione);
	}

	public List<Prenotazioni> getAllPrenotazioni() {
        CriteriaQuery<Prenotazioni> cq = entityManager.getCriteriaBuilder().createQuery(Prenotazioni.class);
        cq.select(cq.from(Prenotazioni.class));
        List<Prenotazioni> prenotazioni = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		emf.close();
		return prenotazioni;
	}
}