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
    private ArrayList<Propriete> possedé;
    private int De;
    private ArrayList<Propriete> terrains;
    private boolean prisonnier = false;
    private ArrayList<Carte> inventaire;

    public Joueur(String nom, String symbole, int fortune, int position) {
        this.nom = nom;
        this.symbole = symbole;
        this.fortune = fortune;
        this.position = position;
        this.possedé = new ArrayList<>();
        this.terrains = new ArrayList<>();
        for (int i =0;i<possedé.size();i++) {
            if (possedé.get(i).getClass().getName()== "Terrain") {
                terrains.add(possedé.get(i));
            }
        }
       this.inventaire = new ArrayList<>();

    }

    public ArrayList<Carte> getInventaire() {
        return inventaire;
    }

    public String getSymbole() {
        return symbole;
    }
    
    public void setCellule(Cellule cellule) {
        this.cellule = cellule;
    }

    public void addProprieter2(Propriete p) {
        this.possedé.add(p);
        if(p.getNom().contains("Gare")== false ||p.getNom().contains("Compagnie")== false )
        {
            terrains.add(p);
        }
        p.setProprietaire(this);
    }
    
    
    public void addProprieter(Propriete p) {
        this.possedé.add(p);
        if(p.getNom().contains("Gare")== false ||p.getNom().contains("Compagnie")== false )
        {
            terrains.add(p);
        }
    }

    public void payerLoyer(int montantLoyer) {
        this.setFortune(this.getFortune() - montantLoyer);
    }

    public int getFortune() {
        return this.fortune;
    }

    public int getPosition() {
        return this.getCellule().getNumero();
    }

    public ArrayList getPropriétésJoueur() {
        return this.possedé;
    }

    public int getNbGarePossédées() {
        int g = 0;
        for (int i=0;i<possedé.size();i++)
        {
            if (possedé.get(i).getNom().contains("Gare"))
            {
                g++;
            }
        }
        return g;
    }

    public int getNbCompagnies() {
        int g = 0;
        for(int i=0;i<possedé.size();i++)
        {
            if(possedé.get(i).getNom().contains("Compagnie"))
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

    public boolean isPrisonnier() {
        return prisonnier;
    }

    public void setPrisonnier(boolean prisonnier) {
        this.prisonnier = prisonnier;
    }

    public ArrayList<Propriete> getTerrains() {
        return terrains;
    }

    
    public boolean couleurComplete(String couleur) {
        int compteur = 0;
        boolean c = false;

        switch (couleur) {

            case "rouge":

                for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="rouge") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                    
                }
                break;
                
            case "jaune":

                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="jaune") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
                break;
                
            case "vert":

                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="vert") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
                break;
                
            case "orange":
                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="orange") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
                break;
                
            case "bleu_clair":
                for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="bleu_clair") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
                break;
                
            case "violet":
                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="violet") {
                        compteur++;
                    }
                }
                if (compteur == 3) {
                    c = true;
                }
                break;
                
            case "bleu_fonce":
                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="bleu_fonce") {
                        compteur++;
                    }
                }
                if (compteur == 2) {
                    c = true;
                }
                break;
                
            case "rose":
                 for (int i=0;i<terrains.size();i++) {
                    if (terrains.get(i).getCouleur()=="rose") {
                        compteur++;
                    }
                }
                if (compteur == 2) {
                    c = true;
                }
                break;

            default:

                c = false;
                break;
        }
        return c;
    }
    
    public boolean peutConstruire(String couleur)
    {
        Terrain min;
        int difference =0;
        ArrayList<Terrain> t = new ArrayList<>();
        for (int i=0;i<terrains.size();i++)
        {
            if(terrains.get(i).getCouleur()== couleur)
            {
                t.add((Terrain) terrains.get(i));
            }
        }
        min = t.get(0);
        for (int i =0 ; i<t.size();i++)
        {
            if(t.get(i).getNbMaison() < min.getNbMaison())
            {
                difference = min.getNbMaison()-t.get(i).getNbMaison();
                min = t.get(i);      
            }
            else
            {
                difference = t.get(i).getNbMaison()-min.getNbMaison();
            }
        }
        if (difference ==2 && this.getCellule().getPropriete() != min)
        {
            System.out.println("Construisez d'abord sur les autres terrains");
            return false;
        }
        else
        {
            return true;
        }
    }
}
