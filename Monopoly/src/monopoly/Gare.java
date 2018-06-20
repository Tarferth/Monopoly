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
    
    @Override
    public int getLoyer()
    {
        if(this.getProprietaire().getNom() == "banque")
        {
            System.out.println("Nombre de gares du propriétaire multiplié par 25");
            return 1;
        }
        else
        { 
            int nb = this.getProprietaire().getNbGarePossédées();
            return nb*25;
                    
            
        }
    }

    @Override
    public String getCouleur() {
        return "Gare";
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
