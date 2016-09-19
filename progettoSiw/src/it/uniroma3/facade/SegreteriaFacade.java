package it.uniroma3.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Segreteria;

	public class SegreteriaFacade {
		
	    private EntityManager entityManager;
	    private EntityManagerFactory emf;

		public SegreteriaFacade()  {
			emf = Persistence.createEntityManagerFactory("products-unit");
			entityManager = emf.createEntityManager();
		}

		public Segreteria createSegreteria(String userName, String password) {
			Segreteria segreteria = new Segreteria(userName, password);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(segreteria);
			tx.commit();
			entityManager.close();
			emf.close();
			return segreteria;
		}

		
		public Segreteria getSegreteria(Long id) {
		    Segreteria segreteria = entityManager.find(Segreteria.class, id);
			entityManager.close();
			emf.close();
			return segreteria;
		}
		
		public List<Segreteria> getAllSegreteria() {
	        CriteriaQuery<Segreteria> cq = entityManager.getCriteriaBuilder().createQuery(Segreteria.class);
	        cq.select(cq.from(Segreteria.class));
	        List<Segreteria> listaSegreteria = entityManager.createQuery(cq).getResultList();
			entityManager.close();
			emf.close();
			return listaSegreteria;
		}

		public void updateSegreteria(Segreteria segreteria) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(segreteria);
			tx.commit();
			entityManager.close();
			emf.close();
			}
		
	    private void deleteSegreteria(Segreteria segreteria) {
	        entityManager.remove(segreteria);
	    }

		public void deleteSegreteria(Long id) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
	        Segreteria segreteria = entityManager.find(Segreteria.class, id);
	        deleteSegreteria(segreteria);
			tx.commit();
			entityManager.close();
			emf.close();	}
	}