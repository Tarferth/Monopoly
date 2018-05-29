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
public class Proprieter {
    private int prixAchat;
    private Joueur proprio;
    
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
