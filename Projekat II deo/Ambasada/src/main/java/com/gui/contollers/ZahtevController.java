package com.gui.contollers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.ZahtevService;
import com.ejb.service.imp.VizaServiceImpl;
import com.ejb.services.VizaService;
import com.jpa.entities.Zahtev;
import com.jpa.entities.Viza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@ManagedBean
public class ZahtevController {
	private int idzahteva=0;
	private int brojpasosa = 0;
	private String namena="";
	private int trajanje = 0;
	private String status="";
	
	private int bid = 0;
	private int aid = 0;
	private int abrojpasosa = 0;
	private String anamena="";
	private int atrajanje = 0;
	private String astatus="";
	
	@EJB
	private ZahtevService service;
	
	@EJB
	private VizaService vizaservice;
	
	
	public void saveZahtev(int brojpasosa, String namena, int trajanje) throws IOException {
		this.status=this.sendGET(Integer.toString(brojpasosa));
		Zahtev zahtev=new Zahtev(brojpasosa,namena, trajanje,this.status);
		service.addZahtev(zahtev);
		if(this.status.equals("prihvaceno")) {
			Viza viza=new Viza(brojpasosa,trajanje,namena,zahtev.getIdzahteva());
			this.vizaservice.addViza(viza);
		}
	}
	
   private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36 Edg/81.0.416.72";
	
	public String sendGET(String ckid) throws IOException {
		String res = "";
		URL obj = new URL("http://192.168.99.100/?ckid="+ckid);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			res="true";
			System.out.println("GET request not worked");
			return res;
		}

	}
	
	public void removeZahtev(int bid) {
		service.deleteZahtev(bid);
	}
	
	public void updateZahtev(int aid, int abrojpasosa, String anamena, int atrajanje, String astatus) {
		service.updateZahtev(aid, abrojpasosa, anamena, atrajanje, astatus);
	}
	
	public List<Zahtev> listazahteva() {
		List<Zahtev> svizahtevi = service.listazahteva();
		return svizahtevi;
	}
	//--------------------------------------------
	
	public int getIdzahteva() {
		return this.idzahteva;
	}

	public void setIdzahteva(int idzahteva) {
		this.idzahteva=idzahteva;
	}
	public int getBrojpasosa() {
		return this.brojpasosa;
	}

	public void setBrojpasosa(int brojpas) {
		this.brojpasosa=brojpas;
	}
	
	public String getNamena() {
		return this.namena;
	}

	public void setNamena(String namena) {
		this.namena = namena;
	}
	
	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje=trajanje;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status=status;
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
	
	public String getAnamena() {
		return this.anamena;
	}

	public void setAnamena(String anamena) {
		this.anamena = anamena;
	}
	
	public int getAtrajanje() {
		return this.atrajanje;
	}

	public void setAtrajanje(int atrajanje) {
		this.atrajanje=atrajanje;
	}
	
	public String getAstatus() {
		return this.astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus=astatus;
	}

}