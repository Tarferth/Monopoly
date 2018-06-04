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
    
    public int getLoyer(){
        if(this.getProprietaire().couleurComplete())
        {
            return this.loyer*2;
        }
        else
        {
            return this.loyer;
        }
    }
    
    public String getCouleur()
    {
        return this.couleur;
    }   
    
    
    
    
}
