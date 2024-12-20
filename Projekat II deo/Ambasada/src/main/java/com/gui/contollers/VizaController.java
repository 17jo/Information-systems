package com.gui.contollers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.VizaService;
import com.jpa.entities.Viza;

import java.util.List;

@ManagedBean(name = "VizaController")
public class VizaController {
	private int idvize=0;
	private int brojpasosa = 0;
	private int trajanje = 0;
	private String tip="";
	private int idzahteva = 0;
	
	private int bid = 0;
	private int aid = 0;
	private int abrojpasosa = 0;
	private int atrajanje = 0;
	private String atip="";
	private int aidzahteva = 0;
	
	@EJB
	private VizaService service;
	
	public void saveViza(int brojpasosa,int trajanje, String tip, int idzahteva) {
		service.addViza(new Viza(brojpasosa, trajanje, tip, idzahteva));
	}
	
	public void removeViza(int bid) {
		service.deleteViza(bid);
	}
	
	public void updateViza(int aid, int abrojpasosa, int atrajanje, String atip, int aidzahteva) {
		service.updateViza(aid, abrojpasosa, atrajanje, atip, aidzahteva);
	}
	
	public List<Viza> listaviza() {
		List<Viza> svevize = service.listaviza();
		return svevize;
	}
	
	public int getIdvize() {
		return this.idvize;
	}

	public void setIdvize(int id) {
		this.idvize=id;
	}
	
	public int getBrojpasosa() {
		return this.brojpasosa;
	}

	public void setBrojpasosa(int brojpas) {
		this.brojpasosa=brojpas;
	}
	
	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje=trajanje;
	}
	
	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getIdzahteva() {
		return this.idzahteva;
	}

	public void setIdzahteva(int idz) {
		this.idzahteva=idz;
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
	
	public int getAtrajanje() {
		return this.atrajanje;
	}

	public void setAtrajanje(int atrajanje) {
		this.atrajanje=atrajanje;
	}
	
	public String getAtip() {
		return this.atip;
	}

	public void setAtip(String atip) {
		this.atip = atip;
	}
	public int getAidzahteva() {
		return this.aidzahteva;
	}

	public void setAidzahteva(int aidz) {
		this.aidzahteva=aidz;
	}
}