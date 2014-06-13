package model;

import java.util.*;

// - liste : LinkedList<Personne>


/*
Attention, je dois vous dire quelque chose sur les listes chaînées : vu que tous les éléments contiennent une référence à l'élément suivant, de telles listes risquent de devenir particulièrement lourdes en grandissant ! Cependant, elles sont adaptées lorsqu'il faut beaucoup manipuler une collection en supprimant ou en ajoutant des objets en milieu de liste. Elles sont donc à utiliser avec précaution.
*/

public class Carnet{
    
    private List<Personne> contacts;
    private int courant;
    private int dernier;
    
    public Carnet() {
        this.contacts = new LinkedList<Personne>();
        this.dernier = 0;
        this.courant = 0;
        remplir();
    }
    
	/** ajoute la personne au carnet de contacts
	 * @param pers : personne à ajouter au carnet
	 */
	public void ajout(Personne pers) {	
        this.contacts.add(pers);
        Collections.sort(this.contacts);
	}

    /** supprime la personne du carnet de contacts
	 * @param pers - personne à supprimer du carnet
	 */
    public void supprimer(Personne pers){
        this.contacts.remove(pers); 
    }
    
    

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
	
	
	/** Donne la liste acuelle des personnes du carnet
	 * @return : une linkedlist de personnes
	 */
	public List<Personne> getContacts(){return this.contacts;}
	
	
	
	/** Remplit le carnet avec des personnes (sert aux tests de controleurs)
	 *
	 */
	private void remplir() {
	    Personne p1 = new Personne("Alves","Claire","Mme","Paris");
	    Personne p2 = new Personne("Besson","Marc","M.","Marseille");
	    Personne p3 = new Personne("Crusson","Carmen","Mme","Lyon");
	    Personne p4 = new Personne("AD","Quentin","M.","Nantes");
	    Personne p5 = new Personne("Briand","Kévin","M.","Remouille RPZ");
	    Personne p6 = new Personne("Someone","Else","M.","Somewhere");
	    
		ajout(p1);
		ajout(p2);
		ajout(p3);
		ajout(p4);
		ajout(p5);
		ajout(p6);
		
		// affiche les contacts de base dans le terminal
		for (int i=0; i<this.contacts.size();i++)
		{
		    System.out.println(i+" "+contacts.get(i).toString());
		}
		
	}

}
