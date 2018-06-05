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
    private Plateau plateau;
    private Joueur joueurCourrant;

    public int lancerDes() {
        int lancer1 = (int) Math.round(Math.random() * 5 + 1);
        int lancer2 = (int) Math.round(Math.random() * 5 + 1);
        if (lancer1 == lancer2) {
            faitUnDouble = true;
        } else {
            faitUnDouble = false;
        }

        return lancer1 + lancer2;

    }

    public Joueur nouveauJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|**               Choisissez votre nom :                 **|");
        String nom = sc.nextLine();
        System.out.println("|**               Choisissez votre symbole :             **|");
        String symbole = sc.nextLine();
        System.out.println("! Inscription validée !");
        Joueur j1 = new Joueur(nom, symbole, 1500, 0);
        joueurs.add(j1);
        return j1; // création d'un nouveau joueur (nom, symboel,argent et position)
    }

    public void inscriptionJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|**                A combien voulez vous jouer ? :       **|");
        int nb = sc.nextInt();
        switch (nb) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;

            default:
                System.out.println("! Il faut un minimum de 2 joueurs ou un maximum de 6 joueurs !");
        }

        tourDeJeu();
    }

    public void Menu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------");
        System.out.println("|**********************************************************|");
        System.out.println("|**                   -- Monopoly --                     **|");
        System.out.println("|**********************************************************|");
        System.out.println("|**                                                      **|");
        System.out.println("|**                     1- Jouer                         **|");
        System.out.println("|**                                                      **|");
        System.out.println("|**                     0- Quitter                       **|");
        System.out.println("|**                                                      **|");
        System.out.println("|**********************************************************|");
        System.out.println("------------------------------------------------------------");
        int nb = sc.nextInt();

        switch (nb) {
            case 1:
                inscriptionJoueur();
            case 0:
                return;
            default:
                System.out.println("! Entrée non valide !");
        }
    }

    public void initialisationTourJeu() {
        Plateau plateau = new Plateau();
        Joueur banque = new Joueur("banque", "$", 0, 0);
    }

    public void tourDeJeu() {
        joueurCourrant = joueurs.get(0);//innitialisation du joueur courrant

        int de = lancerDes();
        de = de + joueurCourrant.getPosition();
        deplacer(joueurCourrant, de);//déplacement du pion du joueur courrant
        System.out.println("Le joueur : " + joueurCourrant + "est sur la case : " + joueurCourrant.getCellule().getNomCellule());
        Cellule cel = joueurCourrant.getCellule();
        String proprio = cel.getPropriete().getProprietaire().getNom();

        if (faitUnDouble) { //rejoue si le joueur fait un double
            tourDeJeu();
        } else {// On enlève le joueur de la liste puis on le réinsère ce qui permet une rotation des joueurs
            joueurs.remove(0);
            joueurs.add(joueurCourrant);
        }
        if (cel.getPropriete().getClass().getName() == "Terrain" || cel.getPropriete().getClass().getName() == "Compagnie" || cel.getPropriete().getClass().getName() == "Gare") {
            if (joueurCourrant.getFortune() > cel.getPropriete().getPrixAchat() && proprio == "banque") {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options

                Scanner sc = new Scanner(System.in);
                System.out.println("|**                     1- Acheter                         **|");
                System.out.println("|**                     0- Passer son Tour                 **|");
                int nb = sc.nextInt();
                switch (nb) {
                    case 1:
                        joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getPropriete().getPrixAchat());
                        joueurCourrant.addProprieter(cel.getPropriete());
                        System.out.println("! Achat confirmé !");
                        System.out.println("Fin de tour");
                        tourDeJeu();
                        break;
                    case 0:
                        System.out.println("Fin de tour");
                        tourDeJeu();
                        break;
                    default:
                        System.out.println("! Entrée non valide !");
                }

            } else if (proprio != "banque") { // si le joueur tombe sur une propriété achetée
                Joueur proprietaire = cel.getPropriete().getProprietaire();
                if (proprietaire == joueurCourrant) { //Si la propriété lui appartient
                    System.out.println("Fin de tour");
                    tourDeJeu();
                } else {// si il doit payer un loyer
                    if (joueurCourrant.getFortune() < cel.getPropriete().getPrixLoyer()) {
                        proprietaire.setFortune(proprietaire.getFortune() + cel.getPropriete().getPrixLoyer());
                        joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getPropriete().getPrixLoyer());
                        System.out.println("! La transaction a été effectuée !");
                        System.out.println("Fin de tour");
                        tourDeJeu();
                    } else {
                        System.out.println("! Vous n'avez pas assez d'argent pour payer le loyer !");
                        System.out.println("! Vous avez perdu !");
                        perdu(joueurCourrant);
                    }
                }
            } else {
                System.out.println("! Vous n'avez rien à faire !");
                tourDeJeu();
            }
        } else {
            System.out.println("Fin de tour");
            tourDeJeu();
        }

    }

    public void perdu(Joueur j) {
        joueurs.remove(0);
    }

    public boolean finDeLaPartie() {
        if (joueurs.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void deplacer(Joueur j, int de) {
        int pos = j.getPosition() + de;

        if (pos < 40) {
            j.setPositionJoueur(j, pos);
            Cellule c = j.getCellule();
            c.addPions(j);
        } else {
            pos = pos % 40;
        }
        j.setPositionJoueur(j, pos);
        Cellule c = j.getCellule();
        c.addPions(j);
        j.setFortune(j.getFortune() + 200);
    }
}
