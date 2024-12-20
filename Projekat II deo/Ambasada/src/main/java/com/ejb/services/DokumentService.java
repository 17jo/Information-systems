package com.ejb.services;

import java.util.List;
import com.jpa.entities.Dokument;

public interface DokumentService  {

	public void addDokument(Dokument dokument);
	public void deleteDokument(int id);
	public void updateDokument(int aid, int abrojpasosa, String aopis);
	
	public List<Dokument> listadokumenata();
}
