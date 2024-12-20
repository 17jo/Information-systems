

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Remote(VizaService.class)
@Stateless
public class VizaServiceImpl implements VizaService{
private EntityManager em;
	
	public VizaServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AmbasadaTest");
		em = emf.createEntityManager();
	}
	

	public void addViza(Viza viza) {
		this.em.persist(viza);
		
	}

	public void deleteViza(int id) {
		Viza viza = em.find(Viza.class, id);
		em.remove(viza);
		
	}

	public void updateViza(int aid, int abrojpasosa, int atrajanje, String atip, int aidzahteva) {
		
		Viza viza = em.find(Viza.class, aid);
		viza.setBrojpasosa(abrojpasosa);
		viza.setTrajanje(atrajanje);
		viza.setTip(atip);
		viza.setIdzahteva(aidzahteva);
	}

	public List<Viza> listaviza() {
		List<Viza> svevize = em.createQuery("SELECT d FROM Viza d", Viza.class).getResultList();
		return svevize;
	}
}
