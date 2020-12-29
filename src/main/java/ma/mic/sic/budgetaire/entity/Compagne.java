package ma.mic.sic.budgetaire.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Compagne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompagne;
	private int annee;
	@Temporal(TemporalType.DATE)
	private Date debutComp;
	@Temporal(TemporalType.DATE)
	private Date finComp;
	private String statut;
	private String remarque;
	private String pieceJointe;
	@JsonIgnore
	@OneToMany(mappedBy="compagne")
	private List<DemandeBudget> demandesBudget;
	public Compagne() {
		super();
	}
	public int getIdCompagne() {
		return idCompagne;
	}
	public void setIdCompagne(int idCompagne) {
		this.idCompagne = idCompagne;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Date getDebutComp() {
		return debutComp;
	}
	public void setDebutComp(Date debutComp) {
		this.debutComp = debutComp;
	}
	public Date getFinComp() {
		return finComp;
	}
	public void setFinComp(Date finComp) {
		this.finComp = finComp;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getPieceJointe() {
		return pieceJointe;
	}
	public void setPieceJointe(String pieceJointe) {
		this.pieceJointe = pieceJointe;
	}
	public List<DemandeBudget> getDemandesBudget() {
		return demandesBudget;
	}
	public void setDemandesBudget(List<DemandeBudget> demandesBudget) {
		this.demandesBudget = demandesBudget;
	}
	
	
	

}
