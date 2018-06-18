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
    private int loyer;

    public Terrain(String couleur, int loyer, int prixAchat, String nom, Cellule cellule) {
        super(prixAchat, nom, cellule);
        this.couleur = couleur;
        this.loyer = loyer;
    }
    
    @Override
    public int getLoyer(){
        if(this.getProprietaire().couleurComplete(couleur) == false)
        {
            return this.loyer;
        }
        else
        {
            return this.loyer*2;
        }
    }
    
    @Override
    public String getCouleur()
    {
        return this.couleur;
    }   
    
    
    
    
}
