package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;
@Stateless
@LocalBean
public class EsameFacade {
	@PersistenceContext(unitName = "products-unit")
	private EntityManager entityManager;

	public Esame createEsame(String codiceEsame,Date data,String aula) {
//
		Esame esame = new Esame(codiceEsame, data, aula);
		entityManager.persist(esame);
		return esame;
	}

	public Esame getEsame(Long id) {
		Esame esame = entityManager.find(Esame.class, id);
		return esame;
	}


	public void updateEsame(Esame esame) {
		entityManager.merge(esame);
			}

	public void deleteEsame(Long id) {
		Esame esame = entityManager.find(Esame.class, id);
		deleteEsame(esame);
	}
	private void deleteEsame(Esame esame) {
		entityManager.remove(esame);
	}

	public List<Esame> getAllEsami() {
        CriteriaQuery<Esame> cq = entityManager.getCriteriaBuilder().createQuery(Esame.class);
        cq.select(cq.from(Esame.class));
        List<Esame> esami = entityManager.createQuery(cq).getResultList();
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
