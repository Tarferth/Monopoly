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
public class Gare extends Propriete{

    public Gare(int prixAchat, String nom, Cellule cellule) {
        super(prixAchat, nom, cellule);
    }
    
    public int getLoyer()
    {
        return this.getProprietaire().getNbGarePossédées()*25;
    }
    
    
}
