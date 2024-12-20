

import java.util.List;

public interface DokumentService  {

	public void addDokument(Dokument dokument);
	public void deleteDokument(int id);
	public void updateDokument(int aid, int abrojpasosa, String aopis);
	
	public List<Dokument> listadokumenata();
}
