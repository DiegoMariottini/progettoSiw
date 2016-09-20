package it.uniroma3.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Segreteria;
@Stateless
@LocalBean
public class SegreteriaFacade {
	@PersistenceContext(unitName = "products-unit")
	private static EntityManager entityManager;

	public SegreteriaFacade()  {
	}

	public Segreteria createSegreteria(String userName, String password) {
		Segreteria segreteria = new Segreteria(userName, password);
		entityManager.persist(segreteria);
		return segreteria;
	}


	public Segreteria getSegreteria(Long id) {
		Segreteria segreteria = entityManager.find(Segreteria.class, id);
		return segreteria;
	}

	public List<Segreteria> getAllSegreteria() {
		CriteriaQuery<Segreteria> cq = entityManager.getCriteriaBuilder().createQuery(Segreteria.class);
		cq.select(cq.from(Segreteria.class));
		List<Segreteria> listaSegreteria = entityManager.createQuery(cq).getResultList();
		return listaSegreteria;
	}

	public void updateSegreteria(Segreteria segreteria) {
		entityManager.merge(segreteria);
	}

	private void deleteSegreteria(Segreteria segreteria) {
		entityManager.remove(segreteria);
	}

	public void deleteSegreteria(Long id) {
		Segreteria segreteria = entityManager.find(Segreteria.class, id);
		deleteSegreteria(segreteria);
	}
}