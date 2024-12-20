package com.ejb.services;

import com.jpa.entities.Viza;
import java.util.List;

public interface VizaService {

	public void addViza(Viza viza);
	public void deleteViza(int id);
	public void updateViza(int aid, int abrojpasosa, int atrajanje, String atip, int aidzahteva);
	
	public List<Viza> listaviza();
}
