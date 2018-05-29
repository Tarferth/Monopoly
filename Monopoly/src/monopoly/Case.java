/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author fourrieq
 */
public class Case {
    private String nom;
    private int numero;
    private Plateau plateau;

    public Case(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
    }
    
    public String getNomCase(int numero){
        // A FAIRE
    }
    public Joueur getProprietaire(){
        // A FAIRE
    }
    public void removePion(Case cAvant){
        
    }
    public void addPions(Joueur pion){
        
    }
}
