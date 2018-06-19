/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class Message {
    private TypesMessage message;
    private int nbJoueurs;
    private ArrayList<Joueur> listeJoueurs;
    
    public Message(TypesMessage message, int nbJoueurs){
        this.message = message;
        this.nbJoueurs = nbJoueurs;
    }
    public Message(TypesMessage message){
        this.message = message;
    }
    public Message(TypesMessage message, ArrayList<Joueur> listeJoueurs){
        this.message = message;
        this.listeJoueurs = listeJoueurs;
    }

    public TypesMessage getMessage() {
        return message;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }
    
    
}
