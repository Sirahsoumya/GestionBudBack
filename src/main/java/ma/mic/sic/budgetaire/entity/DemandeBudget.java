package ma.mic.sic.budgetaire.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
@Entity

public class DemandeBudget{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDemande;
	private double montantDemande;
	private double montantProposeBureau;
	private double montantValideConseil;
	private double montantAlloue;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProjet")*/
	
	@ManyToOne
	private Projet projet;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idStatut", nullable=false)
    private StatutDemande statutDemande;
	@ManyToOne
	@JoinColumn(name="idType", nullable=false)
	private Type type;
    
	@ManyToOne
	@JoinColumn(name="idCompagne", nullable=false)
	private Compagne compagne;

    
	public DemandeBudget() {
		super();
	}
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public double getMontantDemande() {
		return montantDemande;
	}
	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}
	public double getMontantProposeBureau() {
		return montantProposeBureau;
	}
	public void setMontantProposeBureau(double montantProposeBureau) {
		this.montantProposeBureau = montantProposeBureau;
	}
	public double getMontantValideConseil() {
		return montantValideConseil;
	}
	public void setMontantValideConseil(double montantValideConseil) {
		this.montantValideConseil = montantValideConseil;
	}
	public double getMontantAlloue() {
		return montantAlloue;
	}
	public void setMontantAlloue(double montantAlloue) {
		this.montantAlloue = montantAlloue;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Compagne getCompagne() {
		return compagne;
	}
	public void setCompagne(Compagne compagne) {
		this.compagne = compagne;
	}
	public StatutDemande getStatutDemande() {
		return statutDemande;
	}
	public void setStatutDemande(StatutDemande statutDemande) {
		this.statutDemande = statutDemande;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
	
	
	
	

}
