

import java.util.List;

public interface ZahtevService {

	public void addZahtev(Zahtev zahtev);
	public void deleteZahtev(int id);
	public void updateZahtev(int aid, int abrojpasosa, String anamena,int atrajanje, String astatus);
	public Zahtev findZahtev(int id);
	
	public List<Zahtev> listazahteva();
}
