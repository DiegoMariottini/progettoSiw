package it.uniroma3.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.CredenzialiStudente;

	public class CredenzialiStudenteFacade {
		
	    private EntityManager entityManager;
	    private EntityManagerFactory emf;

		public CredenzialiStudenteFacade()  {
			emf = Persistence.createEntityManagerFactory("products-unit");
			entityManager = emf.createEntityManager();
		}

		public CredenzialiStudente createCredenzialiStudente(String userName, String password) {
			CredenzialiStudente credenzialiStudente = new CredenzialiStudente(userName, password);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(credenzialiStudente);
			tx.commit();
			entityManager.close();
			emf.close();
			return credenzialiStudente;
		}

		
		public CredenzialiStudente getCredenzialiStudente(Long id) {
		    CredenzialiStudente credenzialiStudente = entityManager.find(CredenzialiStudente.class, id);
			entityManager.close();
			emf.close();
			return credenzialiStudente;
		}
		
		public List<CredenzialiStudente> getAllCredenzialiStudente() {
	        CriteriaQuery<CredenzialiStudente> cq = entityManager.getCriteriaBuilder().createQuery(CredenzialiStudente.class);
	        cq.select(cq.from(CredenzialiStudente.class));
	        List<CredenzialiStudente> listaCredenzialiStudente = entityManager.createQuery(cq).getResultList();
			entityManager.close();
			emf.close();
			return listaCredenzialiStudente;
		}

		public void updateCredenzialiStudente(CredenzialiStudente credenzialiStudente) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(credenzialiStudente);
			tx.commit();
			entityManager.close();
			emf.close();
			}
		
	    private void deleteCredenzialiStudente(CredenzialiStudente credenzialiStudente) {
	        entityManager.remove(credenzialiStudente);
	    }

		public void deleteCredenzialiStudente(Long id) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
	        CredenzialiStudente credenzialiStudente = entityManager.find(CredenzialiStudente.class, id);
	        deleteCredenzialiStudente(credenzialiStudente);
			tx.commit();
			entityManager.close();
			emf.close();	}
	}
