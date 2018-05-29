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
public class Joueur {
    private String nom;
    private String symbole;
    private int fortune;
    private int position;
    private Cellule cellule;
    private ArrayList<Proprieter> possedé;
    

    public Joueur(String nom, String symbole, int fortune, int position) {
        this.nom = nom;
        this.symbole = symbole;
        this.fortune = fortune;
        this.position = position;
        this.possedé = new ArrayList<>();
    }
    
    public void deplacer(int tot){
        // A FAIRE
    }
    public void acheter(Proprieter p){
        // A FAIRE
    }
    public void addProprieter(){
        // A FAIRE
    }
    public void payerLoyer(){
        // A FAIRE
    }
    public int getFortune(){
        return this.fortune;
    }
    public int getPosition(){
        return this.position;
    }
    public ArrayList getPropriétésJoueur(Joueur j){
        return j.possedé;
    }
    public void perdu(Joueur j){
        // A FAIRE
    }
    public int getNbGarePossédées(Joueur proprietaire){
        // A FAIRE
    }
    public int getNbCompagnies(Joueur proprietaire){
        // A FAIRE
    }
    public void setFortune(int montant){
        this.fortune = this.getFortune() + montant;
    }
    public void setPositionJoueur(int position){
        this.position = position;
    }
    public Cellule getCellule(int numero){
        return this.cellule.getNumero(numero);
    }
}
