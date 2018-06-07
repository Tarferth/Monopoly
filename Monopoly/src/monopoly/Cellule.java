/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fourrieq
 */
public class Cellule {
    
    private int numero;
    private ArrayList<Joueur> pions = new ArrayList<>();

    public Cellule(String nom, int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Joueur> getPions() {
        return pions;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void removePion(Cellule c){
        if(pions.contains(c))
        {
        pions.remove(c);
        }
    }
    
    public void addPions(Joueur pion){
        pions.add(pion);
    } 
}
