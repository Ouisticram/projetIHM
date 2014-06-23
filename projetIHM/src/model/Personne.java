package model;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

public abstract class Personne implements Humain,Comparable<Personne>{

    private String nom;
    private String prenom;
    private String civilite;
    
	public Personne(String nom, String prenom, String civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

	/** méthode qui permet de comparer 2 personnes par ordre alphabétique de nom, puis prénom
	 @return un nombre négatif, postif ou nul
	*/
	public int compareTo(Personne p){
        
        int ret = 0;
        boolean fini = false;
        int taille = 0;
        int i = 0;
        String p1 = "";
        String p2 = "";
        
<<<<<<< HEAD
        if (!(this.getNom().equals(p.getNom())))
=======
        if (!this.getNom().equals(p.getNom()))
>>>>>>> 2668f7a4bf0561abc428fcb623795d64f73753ab
        {
            p1 = this.getNom();
            p2 = p.getNom();  
        }
        else 
        {
<<<<<<< HEAD
            if (!(this.getPrenom().equals(p.getPrenom())))
=======
            if (!this.getPrenom().equals(p.getPrenom()))
>>>>>>> 2668f7a4bf0561abc428fcb623795d64f73753ab
            {
                p1 = this.getPrenom();
                p2 = p.getPrenom();
            }
            else 
            {
                fini = true;
            }
        }
       
        if (p1.length() > p2.length()) {taille = p2.length();}
<<<<<<< HEAD
        else {taille = p1.length();};
=======
        else {taille = p1.length();}
>>>>>>> 2668f7a4bf0561abc428fcb623795d64f73753ab

	    while (!fini && i<taille)
	    {
	    	System.out.println("i = "+i);
	        ret = ((Character)p1.charAt(i)).compareTo((Character)p2.charAt(i));
<<<<<<< HEAD
	        if (ret ==0) {i++;}
	        else{fini = true;}
=======
	        if (ret == 0) i++;
	        else fini = true;
>>>>>>> 2668f7a4bf0561abc428fcb623795d64f73753ab
	    }
	    System.out.println(i+"");
	    return ret;
	}
	
	/** méthode qui permet d'obtenir le nom d'une personne
	 @return le nom de la personne
	*/
	public String getNom() {
		return nom;
	}

	
	/** méthode qui permet de définir le nom d'une personne
     @param nom String qui définit le nouveau nom de la personne
	*/
	public void setNom(String nom) {
		this.nom = nom;
	}


	/** méthode qui permet d'obtenir le prénom d'une personne
     @return prenom le prenom de la personne
	*/
	public String getPrenom() {
		return prenom;
	}
	
	
	/** méthode qui permet de définir le prénom d'une personne
     @param prenom String qui définit le nouveau prenom de la personne
	*/
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	/** méthode qui permet d'obtenir la civilité d'une personne
     @return civilite la civilité de la personne
	*/
	public String getCivilite() {
		return civilite;
	}
	
	
	/** méthode qui permet de définir la civilité d'une personne
     @param civilite String qui définit la nouvelle civilité de la personne
	*/
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	
	/** redéfinition de la méthode toString()
     @return les caractéristiques d'une personne
	*/
	public String toString() {
		return this.nom + " " + this.prenom;
    }
    

}
