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
    
    private int numero;
    private ArrayList<Joueur> pions;
    private Propriete propriete = null;
    

    public Cellule(String nom, int numero) {
        this.numero = numero;
    }

    public Cellule(int numero) {
        this.numero = numero;
    }

    

    public ArrayList<Joueur> getPions() {
        return pions;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        this.pions = new ArrayList<>();
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }
    
    public Propriete getPropriete() {
        return this.propriete;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public String getNomCellule(){
        return this.getPropriete().getNom();
    }
    
    public void removePion(Joueur pion){
        if (this.pions.contains(pion))
        {
        this.pions.remove(pion);
        }
    }
    public void addPions(Joueur j){
        this.pions.add(j);
    }
    
    public void getPion(Cellule c){
        for (int  i = 0; i<pions.size() ; i++) {
            System.out.println(pions.get(i));
        }
    }
}
