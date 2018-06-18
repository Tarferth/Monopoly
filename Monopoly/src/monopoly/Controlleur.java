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
    private Joueur joueurCourrant, banque;
    private int cagnotte = 0;
    

    int compteurP = 0;
    boolean phase2 = false;

    public int lancerDes() {
        int lancer1 = (int) Math.round(Math.random() * 5 + 1);
        int lancer2 = (int) Math.round(Math.random() * 5 + 1);
        if (lancer1 == lancer2) {
            faitUnDouble = true;
        } else {
            faitUnDouble = false;
        }
        System.out.println("dé 1 : " + lancer1);
        System.out.println("dé 2 : " + lancer2);
        return lancer1 + lancer2;

    }

    public int lancerDesTruqué() {
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
        System.out.println("dé truqué 1 : " + lancerTruqué1);
        System.out.println("dé truqué 2 : " + lancerTruqué2);
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
        System.out.println("Position initiale : " + j1.getPosition());
        System.out.println("Fortune du joueur : " + j1.getFortune());
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
        for (int i = 0; i < plateau.getCellules().size(); i++) {
            banque.getPropriétésJoueur().add((plateau.getCellules().get(i).getPropriete()));
            if (plateau.getCellules().get(i).getPropriete() != null) {
                plateau.getCellules().get(i).getPropriete().setProprietaire(banque);
            }
        }
    }

    public void tourDeJeu() {
        joueurCourrant = joueurs.get(0);//innitialisation du joueur courrant
        System.out.println("\n\n\n--------------------------------------------");
        System.out.println("C'est au tour de: " + joueurCourrant.getNom() + " qui est sur la case: " + joueurCourrant.getPosition());
        Joueur proprio;

        if (joueurCourrant.isPrisonnier() == false) {
            int de = lancerDesTruqué(); // Jeu avec lancé de dés aléatoire
            //int de = lancerDesTruqué(); // Jeu avec choix du résultat des dés
            joueurCourrant.setDe(de);
            deplacer(joueurCourrant, de);//déplacement du pion du joueur courrant
            System.out.println("Le joueur : " + joueurCourrant.getNom() + " est sur la case : " + joueurCourrant.getPosition());
            Cellule cel = joueurCourrant.getCellule();
            if(cel.getNumero()==20 && phase2 == false)
            {
                parcGratuit1();
                System.out.println(phase2);
            }
            else if (phase2 == true && cel.getNumero()==20)
            {   
                parcGratuit2();
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
            if (cel.getPropriete() == null) {
                proprio = banque;
            } else {
                proprio = cel.getPropriete().getProprietaire();
            }

            if (faitUnDouble) { //rejoue si le joueur fait un double
                if (cel.getPropriete() != null) {
                    if (joueurCourrant.getFortune() >= cel.getPropriete().getPrixAchat() && proprio == banque) {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options

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
                                        System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " + joueurCourrant.getFortune());
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

                                        break;
                                }
                        }

                    } else if (proprio != banque) { // si le joueur tombe sur une propriété achetée

                        if (proprio == joueurCourrant) { //Si la propriété lui appartient
                            System.out.println("Fin de tour");
                            tourDeJeu();
                        } else if (proprio != joueurCourrant) {// si il doit payer un loyer
                            if (joueurCourrant.getFortune() >= cel.getPropriete().getLoyer()) {
                                proprio.setFortune(proprio.getFortune() + cel.getPropriete().getLoyer());
                                joueurCourrant.setFortune((joueurCourrant.getFortune()) - (cel.getPropriete().getLoyer()));
                                System.out.println(cel.getPropriete().getNom());
                                System.out.println(cel.getPropriete().getProprietaire().getNom());
                                System.out.println(cel.getPropriete().getLoyer());
                                System.out.println("! La transaction a été effectuée !");
                                System.out.println("Vous avez payé : " + cel.getPropriete().getLoyer() + " au joueur : " + cel.getPropriete().getProprietaire().getNom());
                                System.out.println("Fortune du joueur " + joueurCourrant.getNom() + " : " + joueurCourrant.getFortune());
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println("Fin de tour");
                                tourDeJeu();
                            } else if (joueurCourrant.getFortune() < cel.getPropriete().getLoyer()) {
                                System.out.println("! Vous n'avez pas assez d'argent pour payer le loyer !");
                                System.out.println("! Vous avez perdu !");
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                perdu(joueurCourrant);
                                if (finDeLaPartie()) {
                                    System.out.println("La partie est finie le joueur " + joueurs.get(0).getNom() + " a gagné !");
                                    System.exit(0);
                                }

                            }
                        }
                    } else {
                        System.out.println("! Vous n'avez rien à faire !");
                        tourDeJeu();
                    }
                } else if (cel.getImpot() != null) {
                    joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getImpot().getMontant());
                    cagnotte = cagnotte + cel.getImpot().getMontant();
                    System.out.println("Vous êtes sur la case " + cel.getImpot().getNom() + ", vous payez " + cel.getImpot().getMontant());
                    System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                    tourDeJeu();
                } else if (cel.getNumero() == 30 || joueurCourrant.isPrisonnier()) {
                    prison(joueurCourrant);
                    tourDeJeu();
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
                if (joueurCourrant.getFortune() >= cel.getPropriete().getPrixAchat() && proprio == banque) {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options

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
                                    System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " + joueurCourrant.getFortune());
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

                } else if (proprio != banque) { // si le joueur tombe sur une propriété achetée

                    if (proprio == joueurCourrant) { //Si la propriété lui appartient
                        System.out.println("Fin de tour");
                        tourDeJeu();
                    } else {// si il doit payer un loyer
                        if (joueurCourrant.getFortune() > cel.getPropriete().getLoyer()) {
                            proprio.setFortune(proprio.getFortune() + cel.getPropriete().getLoyer());
                            joueurCourrant.setFortune((joueurCourrant.getFortune()) - (cel.getPropriete().getLoyer()));
                            System.out.println(cel.getPropriete().getLoyer());
                            System.out.println(cel.getPropriete().getNom());
                            System.out.println(cel.getPropriete().getProprietaire().getNom());
                            System.out.println("! La transaction a été effectuée !");
                            System.out.println("Vous avez payé : " + cel.getPropriete().getLoyer() + " au joueur : " + cel.getPropriete().getProprietaire().getNom());
                            System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " + joueurCourrant.getFortune());
                            System.out.println("Fin de tour");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tourDeJeu();
                        } else if (joueurCourrant.getFortune() < cel.getPropriete().getLoyer()) {
                            System.out.println("! Vous n'avez pas assez d'argent pour payer le loyer !");
                            System.out.println("! Vous avez perdu !");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            perdu(joueurCourrant);
                            if (finDeLaPartie()) {
                                System.out.println("La partie est finie le joueur " + joueurs.get(0).getNom() + " a gagné !");
                                System.exit(0);
                            }

                        }
                    }
                } else {
                    System.out.println("! Vous n'avez rien à faire !");
                    tourDeJeu();
                }
            } else if (cel.getImpot() != null) {
                joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getImpot().getMontant());
                cagnotte = cagnotte + cel.getImpot().getMontant();
                System.out.println("Vous êtes sur la case " + cel.getImpot().getNom() + ", vous payez " + cel.getImpot().getMontant());
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                tourDeJeu();
            } else if (cel.getNumero() == 30 || joueurCourrant.isPrisonnier()) {
                prison(joueurCourrant);
                tourDeJeu();
            } else {
                System.out.println("Fin de tour");
                tourDeJeu();
            }

        } else {
            prison(joueurCourrant);
            joueurs.remove(0);
            joueurs.add(joueurCourrant);
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

    public void afficherJoueurTuile(Cellule p) {
        p.getPion(p);
    }

    public void voirOffre() {
        System.out.println("Ma fortune: " + joueurCourrant.getFortune());
        System.out.println("Nom de la propriété: " + joueurCourrant.getCellule().getNomCellule());
        System.out.println("Prix d'achat: " + joueurCourrant.getCellule().getPropriete().getPrixAchat());
        System.out.println("Prix du loyer: " + joueurCourrant.getCellule().getPropriete().getLoyer());

    }

    public void prison(Joueur j) {
        Scanner sc = new Scanner(System.in);

        j.setPrisonnier(true);
        j.getCellule().removePion(j);
        j.setCellule(plateau.getCellule(10));
        plateau.getCellule(10).addPions(j);

        System.out.println(compteurP);
        if (compteurP == 2) {
            j.setPrisonnier(false);
            System.out.println("Vous avez purgé votre peine.");
        } else {
            System.out.println("|**                     Vous êtes en prison                **|");
            System.out.println("|**                     1- Lancer les dés                  **|");
            System.out.println("|**                     0- Payer l'amende (50)             **|");
            int nb = sc.nextInt();
            switch (nb) {

                case 1:
                    lancerDes();
                    if (faitUnDouble) {
                        j.setPrisonnier(false);
                        System.out.println("Vous vous êtes échappé de prison.");
                        tourDeJeu();
                    } else {
                        compteurP++;
                    }
                    break;

                case 0:
                    j.setFortune(j.getFortune() - 50);
                    j.setPrisonnier(false);
                    System.out.println("Vous avez payé l'amende.");
                    System.out.println("Fortune actuelle : " + j.getFortune());
                    break;

            }
        }

    }
    
    public void parcGratuit1()
    {
        
        joueurCourrant.setFortune(joueurCourrant.getFortune()+ cagnotte);
        cagnotte = 0;
        phase2 = true;
        System.out.println("Vous êtes dans le parc gratuit vous remportez la cagnotte !");
        System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
        System.out.println("Vous pourrez aussi choisir de ne pas jouer au prochain tour.");
        
    }
    
    public void parcGratuit2()
    {
        
            Scanner sc = new Scanner(System.in);
            System.out.println("|**               Vous êtes dans le parc Gratuit           **|");
            System.out.println("|**                     1- Lancer les dés                  **|");
            System.out.println("|**                     0- Attendre                        **|");
            int nb = sc.nextInt();
            switch (nb) {
                
                case 1  :
                        phase2 = false;
                        break;
                case 0  :
                        phase2 = false;
                        joueurs.remove(0);
                        joueurs.add(joueurCourrant);
                        break;  
                
            }
        
    }

}
