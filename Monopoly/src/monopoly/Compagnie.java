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
    

    public Compagnie(int loyer, int prixAchat, String nom) {
        super(prixAchat, nom);
    }
    
    public int getPrix(){
        return (this.getProprietaire().getNbGarePossédées())*25;
    }
    
}
