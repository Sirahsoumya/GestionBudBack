package ma.mic.sic.budgetaire.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mandat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numMandat;
	private double montantMandat;
	private String objectif;
	
	@OneToOne(mappedBy = "mandat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Depense  depense;
	public Mandat() {
		super();
	}
	public int getNumMandat() {
		return numMandat;
	}
	public void setNumMandat(int numMandat) {
		this.numMandat = numMandat;
	}
	public double getMontantMandat() {
		return montantMandat;
	}
	public void setMontantMandat(double montantMandat) {
		this.montantMandat =montantMandat;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public Depense getDepense() {
		return depense;
	}
	public void setDepense(Depense depense) {
		this.depense = depense;
	}
	
	
	

}
