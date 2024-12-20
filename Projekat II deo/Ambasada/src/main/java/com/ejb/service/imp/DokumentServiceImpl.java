package com.ejb.service.imp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.DokumentService;
import com.jpa.entities.Dokument;

import java.util.List;

@Stateless
public class DokumentServiceImpl implements DokumentService{
	@PersistenceContext(name = "WebAmbasada")
	private EntityManager entityManager;
	

	@Override
	public void addDokument(Dokument dokument) {
		entityManager.persist(dokument);	
	}

	@Override
	public void deleteDokument(int id) {
		
		Dokument dok = entityManager.find(Dokument.class, id);
		entityManager.remove(dok);	
	}

	@Override
	public void updateDokument(int aid, int abrojpasosa, String aopis) {
		
		Dokument dok =entityManager.find(Dokument.class, aid);
		dok.setBrojpasosa(abrojpasosa);
		dok.setOpis(aopis);
	}

	@Override
	public List<Dokument> listadokumenata() {
		List<Dokument> svadokumenta = entityManager.createQuery("SELECT d FROM Dokument d", Dokument.class).getResultList();
		return svadokumenta;
	}
}
