package it.uniroma3.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.CredenzialiStudente;
@Stateless
@LocalBean
public class CredenzialiStudenteFacade {
	@PersistenceContext(unitName = "products-unit")
	private EntityManager entityManager;

	
		public CredenzialiStudente createCredenzialiStudente(String userName, String password) {
			CredenzialiStudente credenzialiStudente = new CredenzialiStudente(userName, password);
			entityManager.persist(credenzialiStudente);
			return credenzialiStudente;
		}

		
		public CredenzialiStudente getCredenzialiStudente(Long id) {
		    CredenzialiStudente credenzialiStudente = entityManager.find(CredenzialiStudente.class, id);
			return credenzialiStudente;
		}
		
		public List<CredenzialiStudente> getAllCredenzialiStudente() {
	        CriteriaQuery<CredenzialiStudente> cq = entityManager.getCriteriaBuilder().createQuery(CredenzialiStudente.class);
	        cq.select(cq.from(CredenzialiStudente.class));
	        List<CredenzialiStudente> listaCredenzialiStudente = entityManager.createQuery(cq).getResultList();
			return listaCredenzialiStudente;
		}

		public void updateCredenzialiStudente(CredenzialiStudente credenzialiStudente) {
			entityManager.merge(credenzialiStudente);
			}
		
	    private void deleteCredenzialiStudente(CredenzialiStudente credenzialiStudente) {
	        entityManager.remove(credenzialiStudente);
	    }

		public void deleteCredenzialiStudente(Long id) {
	        CredenzialiStudente credenzialiStudente = entityManager.find(CredenzialiStudente.class, id);
	        deleteCredenzialiStudente(credenzialiStudente);
	}
}