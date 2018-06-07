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
    
    @Override
    public int getLoyer(){
        if (this.getProprietaire().getNbCompagnies() == 1)
        {
            return (this.getProprietaire().getDe())*4;
        }
        else if (this.getProprietaire().getNbCompagnies()==2)
        {
            return (this.getProprietaire().getDe())*10;
        }
        else 
                {
                    System.out.println("La valeur des dés multipliée par 4 si le propriétaire a 1 compagnie par 10 s'il en a 2");
                    return 0;
                }
        
    }
}
