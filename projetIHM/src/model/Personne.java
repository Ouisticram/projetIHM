package model;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

public class Personne implements Humain{

    private String nom;
    private String prenom;
    private String civilite;
    private String adresse;
    
	public Personne(String nom, String prenom, String civilite, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	/** méthode qui permet d'obtenir le nom d'une personne
	 @return le nom de la personne
	*/
	public String getNom() {
		return nom;
	}

	
	/** méthode qui permet de définir le nom d'une personne
     @param nom - String qui définit le nouveau nom de la personne
	*/
	public void setNom(String nom) {
		this.nom = nom;
	}


	/** méthode qui permet d'obtenir le prénom d'une personne
     @return prenom - le prenom de la personne
	*/
	public String getPrenom() {
		return prenom;
	}
	
	
	/** méthode qui permet de définir le prénom d'une personne
     @param prenom - String qui définit le nouveau prenom de la personne
	*/
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	/** méthode qui permet d'obtenir la civilité d'une personne
     @return civilite - la civilité de la personne
	*/
	public String getCivilite() {
		return civilite;
	}
	
	
	/** méthode qui permet de définir la civilité d'une personne
     @param civilite - String qui définit la nouvelle civilité de la personne
	*/
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	/** méthode qui permet d'obtenir l'adresse d'une personne
     @return adresse - l'adresse de la personne
	*/
	public String getAdresse() {
		return adresse;
	}


    /** méthode qui permet de définir l'adresse d'une personne
     @param adresse - String qui définit la nouvelle adresse de la personne
	*/
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	
	
	/** redéfinition de la méthode toString()
     @return les caractéristiques d'une personne
	*/
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", civilite="
				+ civilite + ", adresse=" + adresse + "]";
    }
}
