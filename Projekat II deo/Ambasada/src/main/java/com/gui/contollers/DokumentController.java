package com.gui.contollers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.DokumentService;
import com.jpa.entities.Dokument;

import java.util.List;

@ManagedBean(name = "DokumentController")
public class DokumentController {
	private int iddokumenta=0;
	private int brojpasosa = 0;
	private String opis="";
	
	private int bid = 0;
	private int aid = 0;
	private int abrojpasosa = 0;
	private String aopis="";
	
	@EJB
	private DokumentService service;
	
	public void saveDokument(int brojpasosa, String opis) {
		service.addDokument(new Dokument(brojpasosa,opis));
	}
	
	public void removeDokument(int bid) {
		service.deleteDokument(bid);
	}
	
	public void updateDokument(int aid, int abrojpasosa, String aopis) {
		service.updateDokument(aid, abrojpasosa, aopis);
	}
	
	public List<Dokument> listadokumenata() {
		List<Dokument> svidokumenti = service.listadokumenata();
		return svidokumenti;
	}

	public int getIddokumenta() {
		return this.iddokumenta;
	}

	public void setIddokumenta(int iddok) {
		this.iddokumenta=iddok;
	}
	
	public int getBrojpasosa() {
		return this.brojpasosa;
	}

	public void setBrojpasosa(int brojpas) {
		this.brojpasosa=brojpas;
	}
	
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public int getBid() {
		return this.bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getAid() {
		return this.aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public int getAbrojpasosa() {
		return this.abrojpasosa;
	}

	public void setAbrojpasosa(int abrojpas) {
		this.abrojpasosa=abrojpas;
	}
	
	public String getAopis() {
		return this.aopis;
	}

	public void setAopis(String aopis) {
		this.aopis = aopis;
	}
	
}