package com.ejb.services;

import com.jpa.entities.Zahtev;
import java.util.List;

public interface ZahtevService {

	public void addZahtev(Zahtev zahtev);
	public void deleteZahtev(int id);
	public void updateZahtev(int aid, int abrojpasosa, String anamena,int atrajanje, String astatus);
	
	public List<Zahtev> listazahteva();
}
