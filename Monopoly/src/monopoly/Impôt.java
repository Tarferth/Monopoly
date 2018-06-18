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
public class Impôt {
    
    private int montant;
    private String nom;
    
    public Impôt(String nom, int montant )
    {
        this.nom = nom;
        this.montant = montant;
    }

    public int getMontant() {
        return montant;
    }

    public String getNom() {
        return nom;
    }
    
    
    
}
