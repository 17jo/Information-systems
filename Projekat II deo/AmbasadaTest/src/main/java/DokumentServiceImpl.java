

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Remote(DokumentService.class)
@Stateless
public class DokumentServiceImpl implements DokumentService{
private EntityManager em;
	
	public DokumentServiceImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AmbasadaTest");
		em = emf.createEntityManager();
	}
	

	public void addDokument(Dokument dokument) {
		em.persist(dokument);	
	}

	public void deleteDokument(int id) {
		
		Dokument dok = em.find(Dokument.class, id);
		em.remove(dok);	
	}

	public void updateDokument(int aid, int abrojpasosa, String aopis) {
		
		Dokument dok = em.find(Dokument.class, aid);
		dok.setBrojpasosa(abrojpasosa);
		dok.setOpis(aopis);
	}

	public List<Dokument> listadokumenata() {
		List<Dokument> svadokumenta = em.createQuery("SELECT d FROM Dokument d", Dokument.class).getResultList();
		return svadokumenta;
	}
}
