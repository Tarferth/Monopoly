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
    private Case case;
    private ArrayList<Proprieter> possedé;
    

    public Joueur(String nom, String symbole, int fortune, Case position) {
        this.nom = nom;
        this.symbole = symbole;
        this.fortune = fortune;
        this.case = case;
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
    public Case getPosition(){
        return this.position;
    }
    public void getPropriétésJoueur(Joueur j){
        // A FAIRE
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
        // A FAIRE
    }
    public Case getCase(int case){
        
    }
}
