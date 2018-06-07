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
public class Terrain extends Propriete{
    private String couleur;
    private int loyer;

    public Terrain(String couleur, int loyer, int prixAchat, String nom) {
        super(prixAchat, nom);
        this.couleur = couleur;
        this.loyer = loyer;
    }

    

    public String getCouleur() {
        return couleur;
    }

    public int getPrix(String couleur)
    {
        if (aToutesLesPropriete)
        {
            return loyer*2;
        }
        else
        {
            return loyer;
        }
    }
    
    
}
