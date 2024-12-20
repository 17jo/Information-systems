package com.ejb.service.imp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.VizaService;
import com.jpa.entities.Viza;

import java.util.List;

@Stateless
public class VizaServiceImpl implements VizaService{
	@PersistenceContext(name = "WebAmbasada")
	private EntityManager entityManager;
	

	@Override
	public void addViza(Viza viza) {
		this.entityManager.persist(viza);
		
	}

	@Override
	public void deleteViza(int id) {
		Viza viza = entityManager.find(Viza.class, id);
		entityManager.remove(viza);
		
	}

	@Override
	public void updateViza(int aid, int abrojpasosa, int atrajanje, String atip, int aidzahteva) {
		
		Viza viza = entityManager.find(Viza.class, aid);
		viza.setBrojpasosa(abrojpasosa);
		viza.setTrajanje(atrajanje);
		viza.setTip(atip);
		viza.setIdzahteva(aidzahteva);
	}

	@Override
	public List<Viza> listaviza() {
		List<Viza> svevize = entityManager.createQuery("SELECT d FROM Viza d", Viza.class).getResultList();
		return svevize;
	}
}
