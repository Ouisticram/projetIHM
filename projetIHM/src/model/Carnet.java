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
	public void ajout(Personne pers) {
		boolean exists = false;
		boolean isParticulier = pers instanceof Particulier;
		boolean isProfessionnel = pers instanceof Professionnel;

		/*if (isParticulier) 
			Personne other = (Particulier) pers;
		else
			Personne other2 = (Professionnel) pers;

		if (this.contacts.size() != 0)
		{
			for (int i=0; i<contacts.size();i++) 
			{
			
				if (contacts.get(i) instanceof Particulier)
				{
					if (isParticulier)
					{
						if ((other.getNom() == contacts.get(i).getNom()) && (other.getPrenom() == contacts.get(i).getPrenom()) && (other.getCivilite() == contacts.get(i).getCivilite()) && 
							(other.getAdresse() == contacts.get(i).getAdresse()) && (other.getTelD() == contacts.get(i).getTelD()) && (other.getTelP() == contacts.get(i).getTelP()) && 
							(other.getEmail() == contacts.get(i).getEmail()))
			    		{
			    			exists = true;
			    		}
					}
				}

				if (contacts.get(i) instanceof Professionnel)
				{
					if (isProfessionnel)
					{
						if ((other2.getNom() == contacts.get(i).getNom()) && (other.getPrenom() == contacts.get(i).getPrenom()) && (othe2r.getCivilite() == contacts.get(i).getCivilite()) && 
							(other2.getAdresse() == contacts.get(i).getAdresse()) && (other2.getTelB() == contacts.get(i).getTelB()) && (other2.getTelP() == contacts.get(i).getTelP()) && 
							(other2.persgetEmail() == contacts.get(i).getEmail()) && (other2.getEntreprise() == contacts.get(i).getEntreprise()))
			    		{
			    			exists = true;
			    		}
					}
				}
			}
		}*/

        
        if (!exists)
        {
        	this.contacts.add(pers);
        	Collections.sort(this.contacts);
        	this.dernier++;
        }        
	}

	public void setCourant(Personne pers){
		int index = this.contacts.indexOf(pers);
		if (index != -1)
			this.courant = index;
	}

	public int getCourant(){
		return this.courant;
	}



    /** supprime la personne du carnet de contacts
	 * @param pers - personne à supprimer du carnet
	 */
    public void supprimer(Personne pers){
        this.contacts.remove(pers);
    }


     /** recherche une personne dans le carnet à partir de son nom et son prénom
	 * @param s - String entrée par l'utilisateur
	 * @return - return une linkedList qui contient les personnes correspondant à la recherche
	 */
    public List<Personne> recherche(String s){

    	List<Personne> finden = new LinkedList<Personne>();
    	int index = 0;
    	boolean ajoute = false;
    	String[] mots = new String[2];

    	if (s.indexOf(" ") != -1 && s.charAt(1) != ' ')
    	{
    		index = s.indexOf(" ");
    		mots[0] = s.substring(0,index-1);
    		mots[1] = s.substring(index);
    	}
    	else 
    	{
    		mots[0] = s;
    	}

    	for (int i=0;i<contacts.size();i++)
    	{
    		ajoute = false;
    		for (int j=0;j<mots.length;j++)
    		{
    			if ((contacts.get(i).getNom().contains(mots[j]) || (contacts.get(i).getPrenom().contains(mots[j]))) && !ajoute && mots[j] != null)
	    		{
	    			finden.add(contacts.get(i));
	    			ajoute = true;
	    		}
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

	public void setCourant(Personne pers){
		int index = contacts.indexOf(pers);
		if (index != -1)
			this.courant = index;
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

	    Professionnel p4 = new Professionnel("AD","Quentin","M.","Nantes","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Facebook");
	    Professionnel p5 = new Professionnel("Briand","Kévin","M.","Remouille RPZ","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","Google");
	    Professionnel p6 = new Professionnel("Someone","Else","M.","Somewhere","01-02-03-04-05","01-02-03-04-05","dizisanemail@email.fr","SNCf");
	    
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

		
		// affiche les contacts de base dans le terminal
		for (int i=0; i<this.contacts.size();i++)
		{
		    System.out.println(i+" "+contacts.get(i).toString());
		}
		
	}

}
