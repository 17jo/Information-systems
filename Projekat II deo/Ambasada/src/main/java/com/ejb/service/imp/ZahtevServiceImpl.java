package com.ejb.service.imp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.ZahtevService;
import com.jpa.entities.Zahtev;

import java.util.List;

@Stateless
public class ZahtevServiceImpl implements ZahtevService{
	@PersistenceContext(name = "WebAmbasada")
	private EntityManager entityManager;
	

	@Override
	public void addZahtev(Zahtev zahtev) {
		this.entityManager.persist(zahtev);
	}

	@Override
	public void deleteZahtev(int id) {
		Zahtev zahtev = entityManager.find(Zahtev.class, id);
		entityManager.remove(zahtev);
	}

	@Override
	public void updateZahtev(int aid, int abrojpasosa, String anamena,int atrajanje, String astatus) {
		
		Zahtev zahtev = entityManager.find(Zahtev.class, aid);
		zahtev.setBrojpasosa(abrojpasosa);
		zahtev.setNamena(anamena);
		zahtev.setTrajanje(atrajanje);
		zahtev.setStatus(astatus);	
	}

	@Override
	public List<Zahtev> listazahteva() {
		List<Zahtev> svizahtevi = entityManager.createQuery("SELECT d FROM Zahtev d", Zahtev.class).getResultList();
		return svizahtevi;
	}
	
}
