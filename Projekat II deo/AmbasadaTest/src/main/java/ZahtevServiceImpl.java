

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Remote(ZahtevService.class)
@Stateless
public class ZahtevServiceImpl implements ZahtevService{
private EntityManager em;
	
	public ZahtevServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AmbasadaTest");
		em = emf.createEntityManager();
	}

	public void addZahtev(Zahtev zahtev) {
		this.em.persist(zahtev);
		
	}

	public void deleteZahtev(int id) {
		Zahtev zahtev = em.find(Zahtev.class, id);
		em.remove(zahtev);
	}

	public void updateZahtev(int aid, int abrojpasosa, String anamena,int atrajanje, String astatus) {
		
		Zahtev zahtev = em.find(Zahtev.class, aid);
		zahtev.setBrojpasosa(abrojpasosa);
		zahtev.setNamena(anamena);
		zahtev.setTrajanje(atrajanje);
		zahtev.setStatus(astatus);	
	}
	
	public Zahtev findZahtev(int id) {
		
		Zahtev z = em.find(Zahtev.class, id);
		return z;
		
	}

	public List<Zahtev> listazahteva() {
		List<Zahtev> svizahtevi = em.createQuery("SELECT d FROM Zahtev d", Zahtev.class).getResultList();
		return svizahtevi;
	}
}
