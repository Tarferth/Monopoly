/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fourrieq
 */
public class Controlleur {
    private ArrayList<Joueur> joueurs;
    private boolean faitUnDouble;
    
    public int lancerDes(){
        int lancer1 = (int) Math.round(Math.random()*5+1);
        int lancer2 = (int) Math.round(Math.random()*5+1);
        if (lancer1 == lancer2){
            faitUnDouble = true;
        }
        else
            faitUnDouble = false;
        
       return lancer1+lancer2;
    }
    public Joueur getJoueurCourant(){
       
    }
    public int getPrixLot(int l){
        // A FAIRE
    }
    
    public Joueur nouveauJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez votre nom : ");
        String nom = sc.nextLine();
        System.out.println("Choisissez votre symbole : ");
        String symbole = sc.nextLine();
        return new Joueur(nom,symbole);
    }
   
}
