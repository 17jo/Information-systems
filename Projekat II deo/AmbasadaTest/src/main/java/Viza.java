

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="viza")
public class Viza{
	
	@Id
	@Column(name="id_vize", nullable = false, updatable = false)
	@TableGenerator(name="gen_viza", table="generator_id", pkColumnName="gen_name", valueColumnName="gen_val", allocationSize = 1, pkColumnValue="gen_viza")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_viza")
	private int idvize;
	
	@Column(name="broj_pasosa")
	private int brojpasosa;
	
	@Column(name="trajanje")
	private int trajanje;
	
	@Column(name="tip")
	private String tip;
	
	@Column(name="id_zahteva")
	private int idzahteva;
	
	public Viza() {
		
	}
	
	public Viza(int brojpasosa, int trajanje ,String tip,int idzahteva) {
		this.setBrojpasosa(brojpasosa);
		this.setTrajanje(trajanje);
		this.setTip(tip);
		this.setIdzahteva(idzahteva);
	}
	
	public int getIdvize() { return this.idvize; }
	public int getBrojpasosa() { return this.brojpasosa; }
	public int getTrajanje() { return this.trajanje; }
	public String getTip() { return this.tip; }
	public int getIdzahteva() { return this.idzahteva;}
	
	public void setBrojpasosa(int brojpasosa) { this.brojpasosa=brojpasosa; }
	public void setTrajanje(int trajanje) { this.trajanje=trajanje ;}
	public void setTip(String tip) { this.tip = tip; }
	public void setIdzahteva(int idzahteva) { this.idzahteva=idzahteva ;}
}