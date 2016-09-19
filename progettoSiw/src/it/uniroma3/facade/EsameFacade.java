package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;

public class EsameFacade {

	private EntityManager entityManager;
	private EntityManagerFactory emf;

	public EsameFacade()  {
		emf = Persistence.createEntityManagerFactory("products-unit");
		entityManager = emf.createEntityManager();
	}


	public Esame createEsame(String codiceEsame,Date data,String aula) {

		Esame esame = new Esame(codiceEsame, data, aula);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(esame);
		tx.commit();
		entityManager.close();
		emf.close();
		return esame;
	}

	public Esame getEsame(Long id) {
		Esame esame = entityManager.find(Esame.class, id);
		entityManager.close();
		emf.close();
		return esame;
	}


	public void updateEsame(Esame esame) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(esame);
		tx.commit();
		entityManager.close();
		emf.close();
	}

	public void deleteEsame(Long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Esame esame = entityManager.find(Esame.class, id);
		deleteEsame(esame);
		tx.commit();
		entityManager.close();
		emf.close();	
	}
	private void deleteEsame(Esame esame) {
		entityManager.remove(esame);
	}

	public List<Esame> getAllEsami() {
        CriteriaQuery<Esame> cq = entityManager.getCriteriaBuilder().createQuery(Esame.class);
        cq.select(cq.from(Esame.class));
        List<Esame> esami = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		emf.close();
		return esami;
	}
	
//	public List<Esame> getEsamiPrenotabili(Date data) {
//		Query q = entityManager.createQuery("SELECT e FROM Esame e WHERE e.data = {d'2012-01-03'}");
//		System.out.println("*********PRENDOES**********");
//		List<Esame> esami = q.getResultList();
//		System.out.println("DIMENSIONE LISTA *****" + esami.size());
//		return esami;
//	}


}
