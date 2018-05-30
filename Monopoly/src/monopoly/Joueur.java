/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fourrieq
 */
public class Joueur {
    private String nom;
    private String symbole;
    private int fortune;
    private int position;
    private Cellule cellule;
    private HashMap<String,Proprieter> possedé;
    

    public Joueur(String nom, String symbole, int fortune, int position) {
        this.nom = nom;
        this.symbole = symbole;
        this.fortune = fortune;
        this.position = position;
        this.possedé = new HashMap<>();
    }
    
    public void acheter(Proprieter p){
        // A FAIRE
    }
    public void addProprieter(Proprieter p){
        this.possedé.put(this.nom, p);
    }
    public void payerLoyer(int montantLoyer){
        this.setFortune(this.getFortune() - montantLoyer);
    }
    public int getFortune(){
        return this.fortune;
    }
    public int getPosition(){
        return this.position;
    }
    public HashMap getPropriétésJoueur(){
        return this.possedé;
    }
    public void perdu(Joueur j){
        // A FAIRE
    }
    public int getNbGarePossédées(){
        // A FAIRE
    }
    public int getNbCompagnies(){
        // A FAIRE
    }
    public void setFortune(int montant){
        this.fortune = montant;
    }
    public void setPositionJoueur(int position){
        this.position = position;
    }
    public Cellule getCellule(){
        return this.cellule;
    }
    public String getNom() {
        return this.nom;
    }
    
}
