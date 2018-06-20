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
        int r =1 ;
       if(this.getProprietaire().getNom() == "banque")
                {
                    System.out.println("La valeur des dés multipliée par 4 si le propriétaire a 1 compagnie par 10 s'il en a 2");
                    r = 0;
                }
       else if (this.getProprietaire().getNbCompagnies()==1)
       {
           return this.getCellule().getPions().get(this.getCellule().getPions().size()-1).getDe()*4;
       }
       else if (this.getProprietaire().getNbCompagnies()==2)
       {
           return this.getCellule().getPions().get(this.getCellule().getPions().size()-1).getDe()*10;
       }
      
            return r;
            
          
    }

    @Override
    public String getCouleur() {
        return "Compagnie";
    }

    @Override
    public int getNbMaison() {
        return 0;
    }

    @Override
    public void addMaison() {
    }

    @Override
    public void addHotel() {
        
    }

    @Override
    public int getPrixMaison() {
        return 0;
    }

    @Override
    public void setMaisons() {
    }

    @Override
    public int getHotel() {
        return 0;
    }
}
