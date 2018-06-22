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
public class Terrain extends Propriete {

    private String couleur;
    private int loyer, prixMaison, loyer1, loyer2, loyer3, loyer4, loyerH ;
    private int maisons, hotel;

    public Terrain(String couleur, int loyer, int prixAchat, int prixMaison, String nom, Cellule cellule, int loyer1, int loyer2, int loyer3, int loyer4, int loyerH) {
        super(prixAchat, nom, cellule);
        this.couleur = couleur;
        this.loyer = loyer;
        this.prixMaison = prixMaison;
        this.loyer1 = loyer1;
        this.loyer2 = loyer2;
        this.loyer3 = loyer3;
        this.loyer4 = loyer4;
        this.loyerH = loyerH;
        this.maisons = 0;
        this.hotel =0;
    }

    @Override
    public int getLoyer() {
        int l = 0;
        if (this.getProprietaire().couleurComplete(couleur) == false) {
            l = this.loyer;
        } else {
            switch (this.getNbMaison()) {
                case 0:
                    if (this.hotel == 0) {
                        l = this.loyer * 2;
                    } else {
                        l = this.loyerH;
                        
                    }
                    break;
                case 1:
                    l = this.loyer1;
                    break;

                case 2:
                    l = this.loyer2;
                    break;

                case 3:
                    l = this.loyer3;
                    break;

                case 4:
                    l = this.loyer4;
                    break;

            }

        }
        return l;
    }

    @Override
    public String getCouleur() {
        return this.couleur;
    }

    @Override
    public int getNbMaison() {
        return maisons;
    }

    @Override
    public void addMaison() {
        if (this.getProprietaire().couleurComplete(couleur) && this.getProprietaire().peutConstruire(couleur)== true && this.hotel==0){
        this.getProprietaire().setFortune(this.getProprietaire().getFortune()-this.prixMaison);
        this.maisons++;
        }
        else
        {
            System.out.println("Vous ne pouvez pas construire de maison sur ce terrain.");
        }
    }

    @Override
    public void addHotel() {
        if (this.getProprietaire().couleurComplete(couleur) && this.getProprietaire().peutConstruire(couleur) && this.hotel==0){
        this.getProprietaire().setFortune(this.getProprietaire().getFortune()-this.prixMaison);
        this.maisons = 0;
        this.hotel = 1;
        }
        else
        {
            System.out.println("Vous ne pouvez pas construire d'hotel sur ce terrain.");
        }
    }

    @Override
    public int getPrixMaison() {
        return this.prixMaison;
    }

    @Override
    public void resetMaisons() {
        maisons = 0;
        hotel = 0;
    }

    @Override
    public int getHotel() {
        return hotel;
    }

}
