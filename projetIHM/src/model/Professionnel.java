package model;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

public class Professionnel extends Personne {

    private String adresse; 	// adresse de l'entreprise
    private String telB;    // téléphone  bureau
    private String telP;    // téléphone portable travail   
    private String email;   // email professionnel
    private String entreprise; // entreprise
    
    public Professionnel (String nom, String prenom, String civilite, String adresse, String telB, String telP, String email, String entreprise) {
		super(nom,prenom,civilite);
		this.adresse = adresse;
		this.telB = telB;
		this.telP = telP;
		this.email = email;
		this.entreprise = entreprise;
	}
	
    /** redéfinition de equals pour comparer 2 professionnels
     @return true si égaux, false sinon
	*/
    public boolean equals (Professionnel pro)
    {  
        boolean exists = false;
        if ((this.getNom() == pro.getNom()) && (this.getPrenom() == pro.getPrenom()) && (this.getCivilite() == pro.getCivilite()) && (this.getAdresse() == pro.getAdresse()) && (this.getTelB() == pro.getTelB()) && (this.getTelP() == pro.getTelP()) && (this.getEmail() == pro.getEmail()) && (this.getEntreprise() == pro.getEntreprise()))
        {
		    exists = true;
	    }
	    return exists;
    }

    /** modifie une personne en copiant les caractéristiques du professionnel passé en en paramètre
	* @param pro le professionnel qui contient les nouvelles informations du professionnel à modifier
	*/
	public void modifier(Professionnel pro){
		this.setNom(pro.getNom());
		this.setPrenom(pro.getPrenom());
		this.setCivilite(pro.getCivilite());
		this.setAdresse(pro.getAdresse());
		this.setEmail(pro.getEmail());
		this.setEntreprise(pro.getEntreprise());
		this.setTelB(pro.getTelB());
		this.setTelP(pro.getTelP());
	}

	/** méthode qui donne l'adresse de l'entreprise
     @return adresse - l'adresse de l'entreprise
	*/
	public String getAdresse() {
		return adresse;
	}


    /** méthode qui permet de définir l'adresse de l'entreprise
     @param adresse - String qui définit la nouvelle adresse de l'entreprise
	*/
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   


    /** méthode qui donne le téléphone (bureau)
	 @return une string correspondant au numéro
	*/
	public String getTelB() {
		return telB;
	}


    /** méthode qui définit le téléphone (bureau)
	 @param telB - une string correspondant au numéro
	*/
	public void setTelB(String telB) {
		this.telB = telB;
	}


    /** méthode qui donne le téléphone (portable)
	 @return une string correspondant au numéro
	*/
	public String getTelP() {
		return telP;
	}


    /** méthode qui définit le téléphone (portable)
	 @param telP - une string correspondant au numéro
	*/
	public void setTelP(String telP) {
		this.telP = telP;
	}


    /** méthode qui donne l'email
	 @return une string correspondant à l'email professionnel
	*/
	public String getEmail() {
		return email;
	}


    /** méthode qui définit l'email
	 @param email - une string correspondant à l'email professionnel
	*/
	public void setEmail(String email) {
		this.email = email;
	}


	/** méthode qui donne l'entreprise
	 @return une string correspondant à l'entreprise
	*/
	public String getEntreprise() {
		return entreprise;
	}


    /** méthode qui définit l'entreprise
	 @param entreprise - une string correspondant à l'entreprise
	*/
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	/** redéfinition de la méthode toString()
     @return les caractéristiques d'une personne
	*/
	public String toString() {
		return super.toString();
	}    
}
