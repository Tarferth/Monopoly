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
    private HashMap<String, Propriete> possedé;
    private int De;
    private HashMap<String, Terrain> terrains;

    public Joueur(String nom, String symbole, int fortune, int position) {
        this.nom = nom;
        this.symbole = symbole;
        this.fortune = fortune;
        this.position = position;
        this.possedé = new HashMap<>();
        this.terrains = new HashMap<>();
        for (Propriete i : possedé.values()) {
            if (i.getClass().getName() == "Terrain") {
                terrains.put(i.getNom(), (Terrain) i);
            }
        }

    }

    

    public void addProprieter(Propriete p) {
        this.possedé.put(this.nom, p);
    }

    public void payerLoyer(int montantLoyer) {
        this.setFortune(this.getFortune() - montantLoyer);
    }

    public int getFortune() {
        return this.fortune;
    }

    public int getPosition() {
        return this.position;
    }

    public HashMap getPropriétésJoueur() {
        return this.possedé;
    }

    public int getNbGarePossédées() {
        int g = 0;
        for (Propriete i : possedé.values()) {
            if (i.getClass().getName() == "Gare")// test sur sortie d'un getname
            {
                g++;
            }
        }
        return g;
    }

    public int getNbCompagnies() {
        int g = 0;
        for (Propriete i : possedé.values()) {
            if (i.getClass().getName() == "Compagnie")// test sur sortie d'un getname
            {
                g++;
            }
        }
        return g;

    }

    public void setDe(int De) {
        this.De = De;
    }

    public int getDe() {
        return De;
    }

    public void setFortune(int montant) {
        this.fortune = montant;
    }

    public void setPositionJoueur(Joueur j, int position) {
        this.position = position;
    }

    public Cellule getCellule() {
        return this.cellule;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean couleurComplete(String couleur) {
        int compteur = 0;
        boolean c = false;

        switch (couleur) {

            case "rouge":

                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }

            case "jaune":

                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
            case "vert":

                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }

            case "orange":
                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }

            case "bleu_clair":
                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
            case "violet":
                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
            case "bleu_fonce":
                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 2) {
                    c = true;
                }

            case "rose":
                for (Terrain i : terrains.values()) {
                    if (i.getCouleur() == couleur) {
                        compteur++;
                    }
                }
                if (compteur == 2) {
                    c = true;
                }

            default:

                c = false;
        }
        return c;
    }
}
