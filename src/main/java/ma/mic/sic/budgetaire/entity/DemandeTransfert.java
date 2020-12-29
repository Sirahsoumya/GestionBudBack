package ma.mic.sic.budgetaire.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DemandeTransfert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numDemande;
	@Temporal(TemporalType.DATE)
	private Date dateDemande;
	private String typeDemande;
	private Double montantTransfert;
	private int ligneBudgetaire;
	
	
	
	@OneToOne
	@JoinColumn(name = "division_id")
	private  Devision  division;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private StatutDemande statutDemande;
	

	
	
	public DemandeTransfert() {
		super();
	}





	public StatutDemande getStatutDemande() {
		return statutDemande;
	}





	public void setStatutDemande(StatutDemande statutDemande) {
		this.statutDemande = statutDemande;
	}





	public int getNumDemande() {
		return numDemande;
	}


	public void setNumDemande(int numDemande) {
		this.numDemande = numDemande;
	}


	public Date getDateDemande() {
		return dateDemande;
	}


	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}


	public String getTypeDemande() {
		return typeDemande;
	}


	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}


	public Double getMontantTransfert() {
		return montantTransfert;
	}


	public void setMontantTransfert(Double montantTransfert) {
		this.montantTransfert = montantTransfert;
	}


	public int getLigneBudgetaire() {
		return ligneBudgetaire;
	}


	public void setLigneBudgetaire(int ligneBudgetaire) {
		this.ligneBudgetaire = ligneBudgetaire;
	}



	public Devision getDivision() {
		return division;
	}



	public void setDivision(Devision division) {
		this.division = division;
	}





	@Override
	public String toString() {
		return "DemandeTransfert [numDemande=" + numDemande + ", dateDemande=" + dateDemande + ", typeDemande="
				+ typeDemande + ", montantTransfert=" + montantTransfert + ", ligneBudgetaire=" + ligneBudgetaire
				+ ", division=" + division + ", statutDemande=" + statutDemande + "]";
	}


	
	

}
