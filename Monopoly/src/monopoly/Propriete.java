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

    public Propriete(int prixAchat, String nom) {
        this.prixAchat = prixAchat;
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }
    
    
    
    public int getPrixAchat(){
        return this.prixAchat;
    }
    public Joueur getProprietaire(){
        return this.proprio;
    }
    public void setProprietaire(Joueur joueur){
        this.proprio = joueur;
    }
}
