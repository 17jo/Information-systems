

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="zahtev")
public class Zahtev{
	
	@Id
	@Column(name="id_zahteva", nullable = false, updatable = false)
	@TableGenerator(name="gen_zahtev", table="generator_id", pkColumnName="gen_name", valueColumnName="gen_val", allocationSize = 1, pkColumnValue="gen_zahtev")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_zahtev")
	private int idzahteva;
	
	@Column(name="broj_pasosa")
	private int brojpasosa;
	
	@Column(name="namena")
	private String namena;
	
	@Column(name="trajanje")
	private int trajanje;
	
	@Column(name="status")
	private String status;
	
	
	public Zahtev() {
		
	}
	
	public Zahtev(int brojpasosa, String namena,int trajanje) {
		this.setBrojpasosa(brojpasosa);
		this.setNamena(namena);
		this.setTrajanje(trajanje);
		this.status="na cekanju";
	}
	
	public int getIdzahteva() { return this.idzahteva; }
	public int getBrojpasosa() { return this.brojpasosa; }
	public String getNamena() { return this.namena; }
	public int getTrajanje() { return this.trajanje; }
	public String getStatus() { return this.status; }
	
	public void setBrojpasosa(int brojpasosa) { this.brojpasosa=brojpasosa; }
	public void setNamena(String namena) { this.namena=namena; }
	public void setTrajanje(int trajanje) { this.trajanje=trajanje ;}
	public void setStatus(String status) { this.status = status; }
}