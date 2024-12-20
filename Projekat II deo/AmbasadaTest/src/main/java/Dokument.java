

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="dokument")
public class Dokument {
	
	@Id
	@Column(name="id_dokumenta", nullable = false, updatable = false)
	@TableGenerator(name="gen_dokument", table="generator_id", pkColumnName="gen_name", valueColumnName="gen_val", allocationSize = 1, pkColumnValue="gen_dokument")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_dokument")
	private int iddokumenta;
	
	@Column(name="broj_pasosa")
	private int brojpasosa;
	
	@Column(name="opis")
	private String opis;
	
	
	public Dokument() {
		
	}
	
	public Dokument(int brojpas, String opis) {
		this.setBrojpasosa(brojpas);
		this.setOpis(opis);
	}
	
	public int getIddokumenta() { return this.iddokumenta; }
	public int getBrojpasosa() { return this.brojpasosa; }
	public String getOpis() { return this.opis; }
	
	public void setBrojpasosa(int brojpasosa) { this.brojpasosa=brojpasosa; }
	public void setOpis(String opis) { this.opis = opis; }
}