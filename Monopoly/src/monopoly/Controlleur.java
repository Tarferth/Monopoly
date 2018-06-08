/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fourrieq
 */
public class Controlleur {

    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private boolean faitUnDouble;
    private Plateau plateau;
    private Joueur joueurCourrant , banque;

    public int lancerDes() {
        int lancer1 = (int) Math.round(Math.random() * 5 + 1);
        int lancer2 = (int) Math.round(Math.random() * 5 + 1);
        if (lancer1 == lancer2) {
            faitUnDouble = true;
        } else {
            faitUnDouble = false;
        }
        System.out.println("dé 1 : "+ lancer1);
        System.out.println("dé 2 : "+ lancer2);
        return lancer1 + lancer2;

    }
    
    public int lancerDesTruqué(){
        Scanner sc = new Scanner(System.in);
        System.out.println("|**               Choisissez la valeur du 1er dé :                 **|");
        int lancerTruqué1 = sc.nextInt();
        System.out.println("|**               Choisissez la valeur du 2eme dé :                **|");
        int lancerTruqué2 = sc.nextInt();
        if (lancerTruqué1 == lancerTruqué2) {
            faitUnDouble = true;
        } else {
            faitUnDouble = false;
        }
        System.out.println("dé truqué 1 : "+ lancerTruqué1);
        System.out.println("dé truqué 2 : "+ lancerTruqué2);
        return lancerTruqué1 + lancerTruqué2;
    }

    public void nouveauJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|**               Choisissez votre nom :                 **|");
        String nom = sc.nextLine();
        System.out.println("|**               Choisissez votre symbole :             **|");
        String symbole = sc.nextLine();
        System.out.println("! Inscription validée !");
        Joueur j1 = new Joueur(nom, symbole, 1500, 0);
        j1.setCellule(plateau.getCellule(0));
        joueurs.add(j1);
        System.out.println("Nom du joueur : " + j1.getNom());
        System.out.println("Symbole du joueur : " + j1.getSymbole());
        System.out.println("Position initiale : "+j1.getPosition());
        System.out.println("Fortune du joueur : "+j1.getFortune());
// création d'un nouveau joueur (nom, symboel,argent et position)
    }

    public void inscriptionJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|**                A combien voulez vous jouer ? :       **|");
        int nb = sc.nextInt();
        switch (nb) {
            case 2:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;
            case 3:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;
            case 4:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;
            case 5:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;
            case 6:
                for (int i = 0; i < nb; i++) {
                    nouveauJoueur();
                }
                break;

            default:
                System.out.println("! Il faut un minimum de 2 joueurs ou un maximum de 6 joueurs !");
                inscriptionJoueur();
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
                Menu();
        }
    }

    public void initialisationTourJeu() {
        this.plateau = new Plateau();
        this.banque = new Joueur("banque", "$", 0, 0);
        for(int i =0;i<plateau.getCellules().size();i++)
        {
         banque.addProprieter(plateau.getCellules().get(i).getPropriete());
         if (plateau.getCellules().get(i).getPropriete() != null){
             plateau.getCellules().get(i).getPropriete().setProprietaire(banque);
         }
        }
    }

    public void tourDeJeu() {
        joueurCourrant = joueurs.get(0);//innitialisation du joueur courrant
        System.out.println("\n\n\n--------------------------------------------");
        System.out.println("C'est au tour de: " + joueurCourrant.getNom() + " qui est sur la case: " + joueurCourrant.getPosition());
        String proprio;
        
        
        
        int de = lancerDesTruqué(); // Jeu avec lancé de dés aléatoire
        //int de = lancerDesTruqué(); // Jeu avec choix du résultat des dés
        joueurCourrant.setDe(de);
        deplacer(joueurCourrant, de);//déplacement du pion du joueur courrant
        System.out.println("Le joueur : " + joueurCourrant.getNom() + " est sur la case : " + joueurCourrant.getPosition());
        Cellule cel = joueurCourrant.getCellule();
        if(cel.getPropriete() == null)
        {
            proprio = "banque";
        }else{
            proprio = cel.getPropriete().getProprietaire().getNom();
        }
        

        if (faitUnDouble) { //rejoue si le joueur fait un double
            if (cel.getPropriete() != null) {
            if (joueurCourrant.getFortune() >= cel.getPropriete().getPrixAchat() && proprio == "banque") {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options

                Scanner sc = new Scanner(System.in);
                System.out.println("|**                     1- Voir l'offre                    **|");
                System.out.println("|**                     0- Passer son Tour                 **|");
                int nb = sc.nextInt();
                switch (nb) {
                    case 1:
                        voirOffre();
                        System.out.println("|**                     1- Acheter                            **|");
                        System.out.println("|**                     0- Passer son Tour                    **|");
                        int nb2 = sc.nextInt();
                        switch (nb2) {
                                case 1:
                                    joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getPropriete().getPrixAchat());
                                    joueurCourrant.addProprieter(cel.getPropriete());
                                    banque.getPropriétésJoueur().remove(cel.getPropriete());
                                    cel.getPropriete().setProprietaire(joueurCourrant);
                                    System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " +joueurCourrant.getFortune());
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
                } else if (proprietaire != joueurCourrant) {// si il doit payer un loyer
                    if (joueurCourrant.getFortune() > cel.getPropriete().getLoyer()) {
                        proprietaire.setFortune(proprietaire.getFortune() + cel.getPropriete().getLoyer());
                        joueurCourrant.setFortune((joueurCourrant.getFortune()) - (cel.getPropriete().getLoyer()));
                        System.out.println(cel.getPropriete().getNom());
                        System.out.println(cel.getPropriete().getProprietaire().getNom());
                        System.out.println(cel.getPropriete().getLoyer());
                        System.out.println("! La transaction a été effectuée !");
                        System.out.println("Vous avez payé : " + cel.getPropriete().getLoyer() + " au joueur : "+ cel.getPropriete().getProprietaire().getNom());
                        System.out.println("Fortune du joueur "+joueurCourrant.getNom()+ " : "+joueurCourrant.getFortune());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Fin de tour");
                        tourDeJeu();
                    } else if(joueurCourrant.getFortune()<cel.getPropriete().getLoyer() ){
                        System.out.println("! Vous n'avez pas assez d'argent pour payer le loyer !");
                        System.out.println("! Vous avez perdu !");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        perdu(joueurCourrant);
                         if (finDeLaPartie())
                        {
                            System.out.println("La partie est finie le joueur "+joueurs.get(0).getNom()+" a gagné !");
                            System.exit(0);
                        }
                         
                         
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
        //////////////////////////////////////////////FIN DU CAS DOUBLE    
            
        } else {// On enlève le joueur de la liste puis on le réinsère ce qui permet une rotation des joueurs
            joueurs.remove(0); 
            joueurs.add(joueurCourrant);
        }
        if (cel.getPropriete() != null) {
            if (joueurCourrant.getFortune() >= cel.getPropriete().getPrixAchat() && proprio == "banque") {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options

                Scanner sc = new Scanner(System.in);
                System.out.println("|**                     1- Voir l'offre                    **|");
                System.out.println("|**                     0- Passer son Tour                 **|");
                int nb = sc.nextInt();
                switch (nb) {
                    case 1:
                        voirOffre();
                        System.out.println("|**                     1- Acheter                            **|");
                        System.out.println("|**                     0- Passer son Tour                    **|");
                        int nb2 = sc.nextInt();
                        switch (nb2) {
                                case 1:
                                    joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getPropriete().getPrixAchat());
                                    joueurCourrant.addProprieter(cel.getPropriete());
                                    banque.getPropriétésJoueur().remove(cel.getPropriete());
                                    cel.getPropriete().setProprietaire(joueurCourrant);
                                    System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " +joueurCourrant.getFortune());
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
                        break;
                    case 0:
                        System.out.println("Fin de tour");
                        tourDeJeu();
                        break;
                    default:
                        System.out.println("! Entrée non valide !");
                }

            } 
            else if (proprio != "banque") { // si le joueur tombe sur une propriété achetée
                Joueur proprietaire = cel.getPropriete().getProprietaire();
                if (proprietaire == joueurCourrant) { //Si la propriété lui appartient
                    System.out.println("Fin de tour");
                    tourDeJeu();
                } else {// si il doit payer un loyer
                    if (joueurCourrant.getFortune() > cel.getPropriete().getLoyer()) {
                        proprietaire.setFortune(proprietaire.getFortune() + cel.getPropriete().getLoyer());
                        joueurCourrant.setFortune((joueurCourrant.getFortune()) - (cel.getPropriete().getLoyer()));
                        System.out.println(cel.getPropriete().getLoyer());
                        System.out.println(cel.getPropriete().getNom());
                        System.out.println(cel.getPropriete().getProprietaire().getNom());
                        System.out.println("! La transaction a été effectuée !");
                        System.out.println("Vous avez payé : " + cel.getPropriete().getLoyer() + " au joueur : "+ cel.getPropriete().getProprietaire().getNom());
                        System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " +joueurCourrant.getFortune());
                        System.out.println("Fin de tour");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tourDeJeu();
                    } else if (joueurCourrant.getFortune()< cel.getPropriete().getLoyer()) {
                        System.out.println("! Vous n'avez pas assez d'argent pour payer le loyer !");
                        System.out.println("! Vous avez perdu !");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        perdu(joueurCourrant);
                        if (finDeLaPartie())
                        {
                            System.out.println("La partie est finie le joueur "+joueurs.get(0).getNom()+" a gagné !");
                            System.exit(0);
                        }
                       
                    }
                }
            } 
            else {
                System.out.println("! Vous n'avez rien à faire !");
                tourDeJeu();
            }
        } else {
            System.out.println("Fin de tour");
            tourDeJeu();
        }

    }

    public void perdu(Joueur j) {
        this.joueurs.remove(j);
        
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
        } else {
            pos = pos % 40;
        }
        j.setPositionJoueur(j, pos);
        j.setCellule(this.plateau.getCellule(pos));
        this.plateau.getCellule(pos).addPions(j);
    }
    public void afficherJoueurTuile(Cellule p){
      p.getPion(p);
    }
    public void voirOffre(){
        System.out.println("Ma fortune: " + joueurCourrant.getFortune());
        System.out.println("Nom de la propriété: " + joueurCourrant.getCellule().getNomCellule());
        System.out.println("Prix d'achat: " + joueurCourrant.getCellule().getPropriete().getPrixAchat());
        System.out.println("Prix du loyer: " + joueurCourrant.getCellule().getPropriete().getLoyer());
 
    }
    
    
}
