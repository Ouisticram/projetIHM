package model;

import java.util.*;

// - liste : LinkedList<Personne>

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
	
	private List<Personne> getContacts(){return this.contacts;}

	private void remplir() {
	    Personne p1 = new Personne("Alves","Claire","M.","Paris");
	    Personne p2 = new Personne("Besson","Marc","M.","Paris");
	    Personne p3 = new Personne("Crusson","Carmen","M.","Paris");
		ajout(p3);
		ajout(p2);
		ajout(p1);
		for (int i=0; i<this.contacts.size();i++)
		{
		    System.out.println(i+" "+contacts.get(i).toString());
		}
		
	}

}
