package it.uniroma3.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;
import it.uniroma3.model.Prenotazioni;
import it.uniroma3.model.Studente;
@Stateless
@LocalBean
public class PrenotazioniFacade {
	@PersistenceContext(unitName = "products-unit")
	private static EntityManager entityManager;

		public PrenotazioniFacade()  {
	}


	public static Prenotazioni createPrenotazione(Studente studente,Esame esame) {

		Prenotazioni prenotazione = new Prenotazioni(studente,esame);
		entityManager.persist(prenotazione);
		return prenotazione;
	}

	public static Prenotazioni getPrenotazione(Long id) {
		Prenotazioni prenotazione = entityManager.find(Prenotazioni.class, id);
		return prenotazione;
	}


	public static void updatePrenotazione(Prenotazioni prenotazione) {
		entityManager.merge(prenotazione);
	
	}

	public void deletePrenotazione(Long id) {
		Prenotazioni prenotazione = entityManager.find(Prenotazioni.class, id);
		deletePrenotazione(prenotazione);
	}
	private void deletePrenotazione(Prenotazioni prenotazione) {
		entityManager.remove(prenotazione);
	}

	public List<Prenotazioni> getAllPrenotazioni() {
        CriteriaQuery<Prenotazioni> cq = entityManager.getCriteriaBuilder().createQuery(Prenotazioni.class);
        cq.select(cq.from(Prenotazioni.class));
        List<Prenotazioni> prenotazioni = entityManager.createQuery(cq).getResultList();
		return prenotazioni;
	}
}