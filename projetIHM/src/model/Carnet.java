package model;

import java.util.*;

/**
 * @author Auger-Dubois Quentin et Briand Kévin
 * @version 1
 **/

/*
Attention, je dois vous dire quelque chose sur les listes chaînées : vu que tous les éléments contiennent une référence à l'élément suivant, de telles listes risquent de devenir particulièrement lourdes en grandissant ! Cependant, elles sont adaptées lorsqu'il faut beaucoup manipuler une collection en supprimant ou en ajoutant des objets en milieu de liste. Elles sont donc à utiliser avec précaution.
*/

public class Carnet{
    
    private List<Personne> contacts;
    private int courant;
    private int dernier;
    
    public Carnet() {
        this.contacts = new LinkedList<Personne>();
        this.dernier = -1;
        this.courant = 0;
        remplir();
    }
    
	/** ajoute la personne au carnet de contacts
	 * @param pers : personne à ajouter au carnet
	 */
	public boolean ajout(Personne pers) {
		boolean exists = false;
		
		if (this.contacts.size() > 0)
		{
			int i = 0;
			while (i<contacts.size() && !exists)
			{
			    if (contacts.get(i) instanceof Particulier && pers instanceof Particulier)
				{
                    Particulier part = (Particulier) pers;
                    Particulier part1 = (Particulier) contacts.get(i);
                    exists = part1.equals(part);
				}

				if (contacts.get(i) instanceof Professionnel && pers instanceof Professionnel)
				{
                    Professionnel pro = (Professionnel) pers;
                    Professionnel pro1 = (Professionnel) contacts.get(i);
                    exists = pro1.equals(pro);
				}
				i++;
			}
		}
   
        if (!exists)
        {
        	this.contacts.add(pers);
        	Collections.sort(this.contacts);
        	this.dernier++;
        }
        return !exists;       
	}
	
    /** Change l'index "courant" de la linkedlist
	 * @param pers la personne actuellement consultée
	 */
	public void setCourant(Personne pers){
		int index = this.contacts.indexOf(pers);
		if (index != -1)
			this.courant = index;
	}


    /** Retourne l'index "courant" de la linkedlist
	 * @return l'index de la personne consultée dans la LinkedList
	 */
	public int getCourant(){
		return this.courant;
	}

	/** Modifie la personne, en la supprimant et en la recréant
	 * @param del Personne qui sert de base à la modification et qui est supprimée
	 * @param add Nouvelle Personne modifiée
	 */
	public void modifier(Personne del,Personne add) {      
        supprimer(del);
        ajout(add);
	}

    /** supprime la personne du carnet de contacts
	 * @param pers - personne à supprimer du carnet
	 */
    public void supprimer(Personne pers){
        this.contacts.remove(pers); 
        this.courant--;
    }


     /** recherche une personne dans le carnet à partir de son nom et son prénom
	 * @param s - String entrée par l'utilisateur
	 * @return - return une linkedList qui contient les personnes correspondant à la recherche
	 */
    public List<Personne> recherche(String s){

    	// définition des variables
    	List<Personne> finden = new LinkedList<Personne>();
    	List<String> mots = new LinkedList<String>();   
    	int index = 0;
    	int motCourant = 0;
    	boolean ajoute = false;
    	boolean enJeu = true;
    	String nom = "";
    	String prenom = "";
    	
        // on conditionne l'entrée de l'utilisateur
        s = s.toLowerCase();
        while (s.endsWith(" ")) {s = s.substring(0,s.length()-1);}
        while (s.startsWith(" ")) {s = s.substring(1,s.length());}
        
        // on split le mot conditionné en sous-chaînes si besoin (selon les espaces)
        if (s.indexOf(" ") != -1)
        {
            while (s.indexOf(" ") != -1)
            {
                index = s.indexOf(" ");
                mots.add(s.substring(0,index-1));
        		s = s.substring(index);
        		while (s.startsWith(" ")) {s = s.substring(1,s.length());} // cas avec au moins 2 espaces
            }
        }
        mots.add(s);
     
        // on compare les mots entrés par l'utilisateur avec les noms et prénoms des contacts
    	for (int i=0;i<contacts.size();i++)
    	{
    		ajoute = false;
    		enJeu = true;
    		motCourant = 0;
    		nom = contacts.get(i).getNom();
    		nom = nom.toLowerCase();
    		prenom = contacts.get(i).getPrenom();
    		prenom = prenom.toLowerCase();
    		
    		while (motCourant < mots.size() && enJeu == true)
    		{
    		    if ((nom.contains(mots.get(motCourant)) || (prenom.contains(mots.get(motCourant)))))
    		    {
    		        motCourant++;
    		    }
    		    else 
    		    {
    		        enJeu = false;
    		    }
    		}  

    	    if (enJeu)
	        {
	            finden.add(contacts.get(i));
	            ajoute = true;
	        }
    	}
    	return finden;
    }

	/**
	 * @return la personne actuellement consultée
	 */
	public Personne getPersonne() {
		return contacts.get(courant);
	}

	/**
	 * @return vrai s'il y a encore une personne après la personne courante dans le carnet
	 */
	public boolean suivantPossible() {
		return (courant < dernier);
	}

	/** change la personne courante par son sucesseur 
	 * @throws Exception si la personne courante n'a pas de sucesseur
	 */
	public void personneSuivante() throws Exception {
		if (suivantPossible())
			courant++;
		else
			throw new Exception();
	}

	/** 
	 * @return vrai s'il y a une personne avant la personne courante dans le carnet
	 */
	public boolean precedentPossible() {
		return courant > 0;
	}

	/** change la personne courante par son prédécésseur
	 * @throws Exception : si la personne courante n'a pas de prédécesseur
	 */
	public void personnePrecedent() throws Exception {
		if (precedentPossible())
			courant--;
		else
			throw new Exception();
	}
	
	/** Donne la liste acuelle des personnes du carnet
	 * @return : une linkedlist de personnes
	 */
	public List<Personne> getContacts(){return this.contacts;}
	
	
	
	/** Remplit le carnet avec des personnes (sert aux tests de controleurs)
	 *
	 */
	private void remplir() {


		Particulier p1 = new Particulier("Alves","Claire","Mme","Paris","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p2 = new Particulier("Besson","Marc","M.","Marseille","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p3 = new Particulier("Crusson","Carmen","Mme","Lyon","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p7 = new Particulier("Alves","Claire","Mme","Paris","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p8 = new Particulier("Besson","Marc","M.","Marseille","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p9 = new Particulier("Crusson","Carmen","Mme","Lyon","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p10 = new Particulier("Alves","Claire","Mme","Paris","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p11 = new Particulier("Besson","Marc","M.","Marseille","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p12 = new Particulier("Crusson","Carmen","Mme","Lyon","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Particulier p13 = new Particulier("Crusson","Carmen","Mme","Lyon","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr");
		Professionnel p14 = new Professionnel("Someone","Else","M.","Somewhere","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","SNCf");

	    Professionnel p4 = new Professionnel("AD","Quentin","M.","Nantes","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Facebook");
	    Professionnel p5 = new Professionnel("Briand","Kévin","M.","Remouille RPZ","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Google");
	    Professionnel p6 = new Professionnel("Someone","Else","M.","Somewhere","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","SNCf");
	     Professionnel p15 = new Professionnel("AD","Quentin","M.","Nantes","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Facebook");
	    Professionnel p16 = new Professionnel("Briand","Kévin","M.","Remouille RPZ","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Google");
	    Professionnel p17 = new Professionnel("Someone","Else","M.","Somewhere","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","SNCf");
	    
		ajout(p1);
		ajout(p2);
		ajout(p3);
		ajout(p4);
		ajout(p5);
		ajout(p6);
		ajout(p7);
		ajout(p8);
		ajout(p9);
		ajout(p10);
		ajout(p11);
		ajout(p12);
		ajout(p13);
		ajout(p14);
		ajout(p15);
		ajout(p16);
		ajout(p17);
		
		

		
		// affiche les contacts de base dans le terminal
		for (int i=0; i<this.contacts.size();i++)
		{
		    System.out.println(i+" "+contacts.get(i).toString());
		}
		
		List<Personne> result = new LinkedList<Personne>();
		result = recherche("QUENTIN");
		System.out.println("\n");
		
		// affiche résulats recherche
		for (int i=0; i<result.size();i++)
		{
		    System.out.println(i+" "+result.get(i).toString());
		}
		
	}

}
