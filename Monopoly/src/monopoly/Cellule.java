/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

/**
 *
 * @author fourrieq
 */
public class Cellule {
    private String nom;
    private int numero;
    private ArrayList<Joueur> pions = new ArrayList<>();
    private Propriete propriete;
    

    public Cellule(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
    }

    public Propriete getPropriete() {
        return this.propriete;
    }

    public int getNumero() {
        return this.numero;
    }
    
    public String getNomCellule(){
        return this.nom;
    }
    
    public void removePion(Joueur pion){
        if (this.pions.contains(pion))
        {
        this.pions.remove(pion);
        }
    }
    public void addPions(Joueur pion){
        this.pions.add(pion);
    }
}
