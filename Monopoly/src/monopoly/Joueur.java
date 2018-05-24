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
    private int montantJoueur;
    private Case position;
    private ArrayList<Proprieter> possedé;

    public Joueur(String nom, String symbole, int montantJoueur, Case position) {
        this.nom = nom;
        this.symbole = symbole;
        this.montantJoueur = montantJoueur;
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
        // A FAIRE
    }
    public int getPosition(){
        // A FAIRE
    }
    public void getPropriétésJoueur(Joueur j){
        // A FAIRE
    }
    public int getMontantJoueur(Joueur j){
        // A FAIRE
    }
    public void enleverArgent(int prixLoyer, Joueur j){
        // A FAIRE
    }
    public void ajouterArgent(int prixLoyer, Joueur proprietaire){
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
    public void setFortune(int fortune){
        // A FAIRE
    }
    public void acheter(){
        // A FAIRE
    }
    public void setPositionJoueur(int position){
        // A FAIRE
    }
    public Case getCase(int position){
        // A FAIRE
    }
    public void setPositionTourComplet(int position){
        
    }
}
