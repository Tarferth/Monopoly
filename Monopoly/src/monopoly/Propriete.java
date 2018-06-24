/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author fourrieq
 */
public abstract class Propriete {
    private int prixAchat;
    private Joueur proprio;
    private String nom;
    private Cellule cellule;
   

    public Propriete(int prixAchat, String nom, Cellule cellule) {
        this.prixAchat = prixAchat;
        this.nom = nom;
        this.cellule = cellule;
    }

    public Propriete(String nom) {
        this.nom = nom;
    }
   

    
    public String getNom() {
        return this.nom;
    }
    
    public int getPrixAchat(){
        return this.prixAchat;
    }
    
    public void setProprietaire(Joueur joueur){
        this.proprio = joueur;
    }
    
    public Joueur getProprietaire() {
        return this.proprio;
    }
    
    public Cellule getCellule() {
        return this.cellule;
    }
    
   public abstract int getLoyer();
   
   public abstract String getCouleur();
   
   public abstract int getNbMaison();
   
   public abstract void addMaison();
   
   public abstract void addHotel();
   
   public abstract int getPrixMaison();
   
   public abstract void resetMaisons();
   
   public abstract int getHotel();
       
   
}
