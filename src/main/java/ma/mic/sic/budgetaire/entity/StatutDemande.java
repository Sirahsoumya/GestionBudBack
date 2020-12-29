package ma.mic.sic.budgetaire.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class StatutDemande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStatut;
	private String libelle;
	/*@JsonIgnore
	 
	@OneToMany (mappedBy = "statutDemande",fetch = FetchType.EAGER)
    private List<DemandeBudget> demandeBudget;*/
	@JsonIgnore
	@OneToMany (mappedBy = "statutDemande",cascade = CascadeType.ALL)
    private List<DemandeBudget> demandeBudget;
	
	@JsonIgnore
	@OneToMany (mappedBy = "statutDemande",cascade = CascadeType.ALL)
    private List<DemandeTransfert> demandeTransfert;
	
	public StatutDemande() {
		super();
	}

	

	public List<DemandeTransfert> getDemandeTransfert() {
		return demandeTransfert;
	}



	public void setDemandeTransfert(List<DemandeTransfert> demandeTransfert) {
		this.demandeTransfert = demandeTransfert;
	}



	public int getIdStatut() {
		return idStatut;
	}

	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public List<DemandeBudget> getDemandeBudget() {
		return demandeBudget;
	}



	public void setDemandeBudget(List<DemandeBudget> demandeBudget) {
		this.demandeBudget = demandeBudget;
	}




	
	
}

