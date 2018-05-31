/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author crosv
 */
public class Compagnie extends Propriete{

    public Compagnie(int prixAchat, String nom, Cellule cellule) {
        super(prixAchat, nom, cellule);
    }
    
    public int getLoyer(){
        if (this.getProprietaire().getNbCompagnies() == 1)
        {
            return 
        }
    }
    
}
