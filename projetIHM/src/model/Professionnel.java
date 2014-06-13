package model;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

public class Professionnel extends Personne {

    private String telB;    // téléphone  bureau
    private String telP;    // téléphone portable travail   
    private String email;   // email professionnel
    
    public Professionnel (String nom, String prenom, String civilite, String adresse, String telB, String telP, String email) {
		super(nom,prenom,civilite,adresse);
		this.telB = telB;
		this.telP = telP;
		this.email = email;
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
	
	
	/** redéfinition de la méthode toString()
     @return les caractéristiques d'une personne + celle d'un particulier
	*/
	public String toString() {
		return super.toString() + "Particulier [telB=" + telB + ", telP=" + telP + ", email="
				+ email + "]";
	}    
}
