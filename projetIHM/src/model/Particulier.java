package model;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

public class Particulier extends Personne {

    private String adresse;
    private String telD;
    private String telP;
    private String email;
    
    public Particulier (String nom, String prenom, String civilite, String adresse, String telD, String telP, String email) {
		super(nom,prenom,civilite);
		this.adresse = adresse;
		this.telD = telD;
		this.telP = telP;
		this.email = email;
	}
    
    /** redéfinition de equals pour comparer 2 particuliers
     @return true si égaux, false sinon
	*/
    public boolean equals (Particulier part)
    {  
        boolean exists = false;
        if ((this.getNom() == part.getNom()) && (this.getPrenom() == part.getPrenom()) && (this.getCivilite() == part.getCivilite()) && (this.getAdresse() == part.getAdresse()) && (this.getTelD() == part.getTelD()) && (this.getTelP() == part.getTelP()) && (this.getEmail() == part.getEmail()))
        {
		    exists = true;
	    }
	    return exists;
    }
    
    /** modifie une personne en copiant les caractéristiques du particulier passé en en paramètre
	* @param part le particulier qui contient les nouvelles informations du particulier à modifier
	*/
	public void modifier(Particulier part){
		this.setNom(part.getNom());
		this.setPrenom(part.getPrenom());
		this.setCivilite(part.getCivilite());
		this.setAdresse(part.getAdresse());
		this.setTelD(part.getTelD());
		this.setTelP(part.getTelP());
		this.setEmail(part.getEmail());
	}
    
	/** méthode qui permet d'obtenir l'adresse d'un particulier
     @return adresse l'adresse du particulier
	*/
	public String getAdresse() {
		return adresse;
	}


    /** méthode qui permet de définir l'adresse d'un particulier
     @param adresse String qui définit la nouvelle adresse du particulier
	*/
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   


    /** méthode qui donne le téléphone (domicile)
	 @return une string correspondant au numéro
	*/
	public String getTelD() {
		return telD;
	}


    /** méthode qui définit le téléphone (domicile)
	 @param telD une string correspondant au numéro
	*/
	public void setTelD(String telD) {
		this.telD = telD;
	}


    /** méthode qui donne le téléphone (portable)
	 @return une string correspondant au numéro
	*/
	public String getTelP() {
		return telP;
	}


    /** méthode qui définit le téléphone (portable)
	 @param telP une string correspondant au numéro
	*/
	public void setTelP(String telP) {
		this.telP = telP;
	}


    /** méthode qui donne l'email
	 @return une string correspondant à l'email
	*/
	public String getEmail() {
		return email;
	}


    /** méthode qui définit l'email
	 @param email une string correspondant à l'email
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/** redéfinition de la méthode toString()
     @return les caractéristiques d'une personne
	*/
	public String toString() {
		return super.toString();
	}    
}
