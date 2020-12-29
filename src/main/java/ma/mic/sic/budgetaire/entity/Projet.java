package ma.mic.sic.budgetaire.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProjet;
	private String libelle;
	private String finalite;
	@Temporal(TemporalType.DATE)
	private Date demaragePrevue; 
	@Temporal(TemporalType.DATE)
	private Date demarageReelle;
	@Temporal(TemporalType.DATE)
	private Date RealisationPrevue;
	@Temporal(TemporalType.DATE)
	private Date RealisationReelle;
	private double budgetRealisation;
	private double contributionBudgetFinanc;
	private double budgetConsomme;
	private double etatAvancementTheorique;
	private double etatAvancementReelle;
	private String description;
	private String source;
	/*@OneToMany(mappedBy = "projetd", cascade = CascadeType.ALL)
    private List<DemandeBudget> demandeBudgets;*/
	
	@JsonIgnore
	@OneToMany (mappedBy = "projet",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<DemandeBudget> demandeBudget;
	
	@JsonIgnore
	@OneToMany (mappedBy = "projet",cascade = CascadeType.ALL)
    private List<Indicateur> indicateur;
	@NotFound(action = NotFoundAction.IGNORE) 
	@ManyToOne
	private Programme programme;

	@JsonIgnore
	@OneToMany(mappedBy="projets",cascade = CascadeType.ALL)
	private List<Sponsor> spnosors;
	@JsonIgnore
	@ManyToOne
	private SourcheBudget sourceBudget;
	
	@JsonIgnore
	@OneToMany(mappedBy="projetp",cascade = CascadeType.ALL)
	private List<Partenaire> partenaires;
	@ManyToOne
	private Perimetre perimetre;
	@ManyToOne
	private StatutProjet statutProjet;
	@JsonIgnore
	@ManyToOne
	private Devision devision;
	@JsonIgnore
	@OneToMany (mappedBy = "projet1",cascade = CascadeType.ALL)
    private List<Fonctionnaire> fonctionnaire;


	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "marche_id")
	private Marche  marche;
	
	public Projet() {
		super();
	}

	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getFinalite() {
		return finalite;
	}
	public void setFinalite(String finalite) {
		this.finalite = finalite;
	}
	public Date getDemaragePrevue() {
		return demaragePrevue;
	}
	public void setDemaragePrevue(Date demaragePrevue) {
		this.demaragePrevue = demaragePrevue;
	}
	public Date getDemarageReelle() {
		return demarageReelle;
	}
	public void setDemarageReelle(Date demarageReelle) {
		this.demarageReelle = demarageReelle;
	}
	public Date getRealisationPrevue() {
		return RealisationPrevue;
	}
	public void setRealisationPrevue(Date realisationPrevue) {
		RealisationPrevue = realisationPrevue;
	}
	public Date getRealisationReelle() {
		return RealisationReelle;
	}
	public void setRealisationReelle(Date realisationReelle) {
		RealisationReelle = realisationReelle;
	}
	public double getBudgetRealisation() {
		return budgetRealisation;
	}
	public void setBudgetRealisation(double budgetRealisation) {
		this.budgetRealisation = budgetRealisation;
	}
	public double getContributionBudgetFinanc() {
		return contributionBudgetFinanc;
	}
	public void setContributionBudgetFinanc(double contributionBudgetFinanc) {
		this.contributionBudgetFinanc = contributionBudgetFinanc;
	}
	public double getBudgetConsomme() {
		return budgetConsomme;
	}
	public void setBudgetConsomme(double budgetConsomme) {
		this.budgetConsomme = budgetConsomme;
	}
	public double getEtatAvancementTheorique() {
		return etatAvancementTheorique;
	}
	public void setEtatAvancementTheorique(double etatAvancementTheorique) {
		this.etatAvancementTheorique = etatAvancementTheorique;
	}
	public double getEtatAvancementReelle() {
		return etatAvancementReelle;
	}
	public void setEtatAvancementReelle(double etatAvancementReelle) {
		this.etatAvancementReelle = etatAvancementReelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public Marche getMarche() {
		return marche;
	}
	public void setMarche(Marche marche) {
		this.marche = marche;
	}
	public List<Sponsor> getSpnosors() {
		return spnosors;
	}
	public void setSpnosors(List<Sponsor> spnosors) {
		this.spnosors = spnosors;
	}
	public List<Indicateur> getIndicateur() {
		return indicateur;
	}
	public void setIndicateur(List<Indicateur> indicateur) {
		this.indicateur = indicateur;
	}
	public SourcheBudget getSourceBudget() {
		return sourceBudget;
	}
	public void setSourceBudget(SourcheBudget sourceBudget) {
		this.sourceBudget = sourceBudget;
	}
	
	public Perimetre getPerimetre() {
		return perimetre;
	}
	public void setPerimetre(Perimetre perimetre) {
		this.perimetre = perimetre;
	}
	public StatutProjet getStatutProjet() {
		return statutProjet;
	}
	public void setStatutProjet(StatutProjet statutProjet) {
		this.statutProjet = statutProjet;
	}
	
	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
	}

	public List<Fonctionnaire> getFonctionnaire() {
		return fonctionnaire;
	}
	public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
		this.fonctionnaire = fonctionnaire;
	}

	public List<Partenaire> getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(List<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}

	public List<DemandeBudget> getDemandeBudget() {
		return demandeBudget;
	}

	public void setDemandeBudget(List<DemandeBudget> demandeBudget) {
		this.demandeBudget = demandeBudget;
	}

	
	

	

	
	
	
}
	
	
	
	
	
	
	
	
	



