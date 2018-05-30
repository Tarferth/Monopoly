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
public abstract class Proprieter {
    private int prixAchat;
    private Joueur proprio;
    private String nom;
    private String type;

    public String getNom() {
        return nom;
    }
    public int getPrixAchat(){
        return this.prixAchat;
    }
    public void setProprietaire(Joueur joueur){
        this.proprio = joueur;
    }
    public Joueur getProprio() {
        return this.proprio;
    }
    public String getType() {
        return this.type;
    }
    
}
