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
public class Depense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepense;
	@Temporal(TemporalType.DATE)
	private Date dateDengagement;
	private String objet;
	private Double mantantDengagement;
	private Double montantCredit;
	private Double creditDispo;
	@Temporal(TemporalType.DATE)
	private Date dateVisa;
	private String observation;
	private String imputationBudgetaires;
	private String nomPartiesPrenantes;
	private int totalArticle;
	
	@ManyToOne
	private Devision devision;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "mandat_id")
	private Mandat  mandat;
	
	public Depense() {
		super();
	}

	public int getIdDepense() {
		return idDepense;
	}

	public void setIdDepense(int idDepense) {
		this.idDepense = idDepense;
	}

	public Date getDateDengagement() {
		return dateDengagement;
	}

	public void setDateDengagement(Date dateDengagement) {
		this.dateDengagement = dateDengagement;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Double getMantantDengagement() {
		return mantantDengagement;
	}

	public void setMantantDengagement(Double mantantDengagement) {
		this.mantantDengagement = mantantDengagement;
	}

	public Double getMontantCredit() {
		return montantCredit;
	}

	public void setMontantCredit(Double montantCredit) {
		this.montantCredit = montantCredit;
	}

	public Double getCreditDispo() {
		return creditDispo;
	}

	public void setCreditDispo(Double creditDispo) {
		this.creditDispo = creditDispo;
	}

	public Date getDateVisa() {
		return dateVisa;
	}

	public void setDateVisa(Date dateVisa) {
		this.dateVisa = dateVisa;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getImputationBudgetaires() {
		return imputationBudgetaires;
	}

	public void setImputationBudgetaires(String imputationBudgetaires) {
		this.imputationBudgetaires = imputationBudgetaires;
	}

	public String getNomPartiesPrenantes() {
		return nomPartiesPrenantes;
	}

	public void setNomPartiesPrenantes(String nomPartiesPrenantes) {
		this.nomPartiesPrenantes = nomPartiesPrenantes;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
	}

	public Mandat getMandat() {
		return mandat;
	}

	public void setMandat(Mandat mandat) {
		this.mandat = mandat;
	}

	



}
