import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import javax.ejb.EJB;

public class TestClass {
	
	@Test
	public void TestAssertions()
	{
		VizaService ser = new VizaServiceImpl();
		List<Viza> svevize = ser.listaviza();
		assertNotNull(svevize);
		
		ZahtevService serB = new ZahtevServiceImpl();
		Zahtev b = serB.findZahtev(1);
		System.out.println(b.getStatus());
		assertEquals(b.getStatus(), "odobrena");
		/*serB.updateZahtev(7, 000001, "radna", 60, "odbijeno");
		Zahtev b1 = serB.findZahtev(7);
		System.out.println(b1.getBrojpasosa());
		assertEquals(b1.getBrojpasosa(), 000001);*/
		
	}
}
