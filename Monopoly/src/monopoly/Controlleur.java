/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import monopoly.Vues.Vue_Accueil;
import monopoly.Vues.Vue_Inscription;
import monopoly.Vues.Vue_Inscription2;
import monopoly.Vues.Vue_Jeu;
import monopoly.Vues.Vue_Plateau;

/**
 *
 * @author fourrieq
 */
public class Controlleur implements Observateur {

    private Timer timer;
    private ArrayList<Joueur> joueurs;
    private boolean faitUnDouble;
    private Plateau plateau;
    private Joueur joueurCourrant, banque;
    private int cagnotte = 0, compteurDouble = 0, maisonsDispo = 32, hotelsDispo = 12;
    private Communaute caisse;
    private Chance chance;
    private Vue_Inscription ihmInscription1;
    private Vue_Inscription2 ihmInscription2;
    private Vue_Accueil ihmAccueil;
    private Vue_Plateau Vplateau;
    private Vue_Jeu Vjeu;
    private int de1, de2;

    int compteurP = 0;
    boolean phase2 = false;
    String jX;

    public Controlleur() {
        this.ihmAccueil = new Vue_Accueil();
        this.ihmAccueil.addObservateur(this);

    }

    @Override
    public void traiterMessage(Message m) {
        switch (m.getMessage()) {
            case AFFICHER_INSCRIPTION_2:
                this.ihmInscription2 = new Vue_Inscription2(m.getNbJoueurs());
                this.ihmInscription2.addObservateur(this);
                this.afficherIhmInscription2();
                this.cacherIhmInscription1();
                break;
            case RETOUR_INSCRIPTION_1:
                this.afficherIhmInscription1();
                this.cacherIhmInscription2();
                break;
            case RETOUR_ACCUEIL:
                this.afficherIhmAccueil();
                this.cacherIhmInscription1();
                break;
            case AFFICHER_INSCRIPTION_1:
                this.ihmInscription1 = new Vue_Inscription();
                this.ihmInscription1.addObservateur(this);
                this.afficherIhmInscription1();
                this.cacherIhmAccueil();
                break;
            case LANCEMENT_PARTIE:
                // Afficher l'ihm du jeu
                this.joueurs = m.getListeJoueurs();         // ArrayList listeJoueurs qui contient les joueurs
                this.joueurCourrant = joueurs.get(0);
                this.initialisationTourJeu();
                this.cacherIhmInscription2();               // On cache la fenetre d'inscription2
                this.Vjeu.addObservateur(this);
                this.Vjeu.getSouthPanel().getNomJCourrant().setText(this.joueurCourrant.getNom());
                this.Vjeu.getSouthPanel().getNomCaseCourrante().setText(this.plateau.getCellule(0).getNom());
                this.Vjeu.getSouthPanel().getPrixCaseCourrante().setText("");
                this.Vjeu.getSouthPanel().getFortuneJCourrant().setText("Fortune actuelle : "+this.joueurCourrant.getFortune());
                
                this.Vjeu.afficher();
                break;
            case QUITTER:
                this.cacherIhmAccueil();
                System.exit(0);
                break;

            case LANCER_DES:

                this.tourDeJeu();
                this.Vjeu.getWestPanel().getDe1().setText(String.valueOf(de1));
                this.Vjeu.getWestPanel().getDe2().setText(String.valueOf(de2));
                this.Vjeu.getSouthPanel().getNomJCourrant().setText(this.joueurCourrant.getNom());
                
                
                if (joueurCourrant.getCellule().getNom() != null )
                {
                    this.Vjeu.getSouthPanel().getPrixCaseCourrante().setText("Pas à vendre (" + this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getNomCellule());
                    this.Vjeu.getSouthPanel().getNomCaseCourrante().setText("Vous êtes sur la case : "+this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getNom());
                }
                        else if (joueurCourrant.getCellule().getPropriete().getProprietaire() == banque)
                {
                    this.Vjeu.getSouthPanel().getPrixCaseCourrante().setText("Prix de la propriété : "+ this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getPropriete().getPrixAchat());
                    this.Vjeu.getSouthPanel().getNomCaseCourrante().setText("Vous êtes sur la case : "+this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getNomCellule());
                }
                
                else
                {
                    this.Vjeu.getSouthPanel().getPrixCaseCourrante().setText( "Loyer a payer : "+ this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getPropriete().getLoyer());
                    this.Vjeu.getSouthPanel().getNomCaseCourrante().setText("Vous êtes sur la case : "+this.plateau.getCellule(joueurCourrant.getCellule().getNumero()).getNomCellule());
                }
                this.Vjeu.getSouthPanel().getFortuneJCourrant().setText("Fortune actuelle : " + this.joueurCourrant.getFortune());

                break;

        }
    }

    public void cacherIhmAccueil() {
        this.ihmAccueil.cacher();
    }

    public void afficherIhmAccueil() {
        this.ihmAccueil.afficher();
    }

    public void afficherIhmInscription1() {
        this.ihmInscription1.afficher();
    }

    public void afficherIhmInscription2() {
        this.ihmInscription2.afficher();
    }

    public void cacherIhmInscription1() {
        this.ihmInscription1.cacher();
    }

    public void cacherIhmInscription2() {
        this.ihmInscription2.cacher();
    }

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
        this.de1 = lancer1;
        this.de2 = lancer2;
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
        // System.out.println("|**                A combien voulez vous jouer ? :       **|");
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
                plateau.getCellules().get(i).getPropriete().resetMaisons();
            }
        }
        this.caisse = new Communaute();
        this.chance = new Chance();
        this.Vplateau = new Vue_Plateau();
        this.Vplateau.setCellules(plateau);
        this.Vjeu = new Vue_Jeu();
        
        this.Vjeu.getWestPanel().setListeAchetables(this.banque.getPropriétésJoueur());
        
        this.Vjeu.getNorthPanel().setNomJ1(this.joueurs.get(0).getNom());
        this.Vjeu.getNorthPanel().setNomJ2(this.joueurs.get(1).getNom());
        if (this.joueurs.size() > 2) {
            this.Vjeu.getNorthPanel().setNomJ3(this.joueurs.get(2).getNom());
        }
        if (this.joueurs.size() > 3) {
            this.Vjeu.getNorthPanel().setNomJ4(this.joueurs.get(3).getNom());
        }
        if (this.joueurs.size() > 4) {
            this.Vjeu.getNorthPanel().setNomJ5(this.joueurs.get(4).getNom());        
        }
        if (this.joueurs.size() > 5) {
            this.Vjeu.getNorthPanel().setNomJ6(this.joueurs.get(5).getNom());
        }
    }

    public void tourDeJeu() {
        joueurCourrant = joueurs.get(0);//innitialisation du joueur courrant
        
        System.out.println("\n\n\n--------------------------------------------");
        System.out.println("C'est au tour de: " + joueurCourrant.getNom() + " qui est sur la case: " + joueurCourrant.getPosition());
        Joueur proprio;
        if (joueurCourrant.getNom() == jX && phase2 == true) {
            parcGratuit2();
        }

        if (joueurCourrant.isPrisonnier() == false) {
            int de = lancerDes(); // Jeu avec lancé de dés aléatoire
            //int de = lancerDesTruqué(); // Jeu avec choix du résultat des dés
            joueurCourrant.setDe(de);
            deplacer(joueurCourrant, de);//déplacement du pion du joueur courrant
            System.out.println("Le joueur : " + joueurCourrant.getNom() + " est sur la case : " + joueurCourrant.getPosition());
            Cellule cel = joueurCourrant.getCellule();

            if (cel.getNumero() == 20 && phase2 == false) {
                parcGratuit1();
                System.out.println(phase2);
            }

            if (cel.getPropriete() == null) {
                proprio = banque;
            } else {
                proprio = cel.getPropriete().getProprietaire();
            }

            if (faitUnDouble) { //rejoue si le joueur fait un double
                compteurDouble++;
            }


                //////////////////////////////////////////////FIN DU CAS DOUBLE    
            if (compteurDouble == 3) {
                System.out.println("Vous avez fait 3 doubles à la suite vous allez en prison.");
                compteurDouble = 0;
                prison(joueurCourrant);
                
                tourSuivant();
                compteurDouble=0;

            } else {// On enlève le joueur de la liste puis on le réinsère ce qui permet une rotation des joueurs

                compteurDouble = 0;

                if (cel.getPropriete() != null) {
                    if (joueurCourrant.getFortune() >= cel.getPropriete().getPrixAchat() && proprio == banque) {// on vérifie que le joueur possède assez d'argent avant de lui proposer les options    
                        timer();

                    } else if (proprio != banque) { // si le joueur tombe sur une propriété achetée

                        if (proprio == joueurCourrant && joueurCourrant.couleurComplete(cel.getPropriete().getCouleur()) && (maisonsDispo != 0 || hotelsDispo != 0) && joueurCourrant.peutConstruire(cel.getPropriete().getCouleur())) {
                            construire();
                            return;
                        } else if (proprio == joueurCourrant) { //Si la propriété lui appartient
                            System.out.println("Fin de tour");
                            System.out.println("351");
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
                                System.out.println("363");
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
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
                        
                    }
                } else if (cel.getImpot() != null) {
                    joueurCourrant.setFortune(joueurCourrant.getFortune() - cel.getImpot().getMontant());
                    cagnotte = cagnotte + cel.getImpot().getMontant();
                    this.Vplateau.setCagnotte(cagnotte);
                    System.out.println("Vous êtes sur la case " + cel.getImpot().getNom() + ", vous payez " + cel.getImpot().getMontant());
                    System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                    
                } else if (cel.getNumero() == 2 || cel.getNumero() == 17 || cel.getNumero() == 33) {
                    piocherUneCarteCommunaute();
                    
                } else if (cel.getNumero() == 7 || cel.getNumero() == 22 || cel.getNumero() == 36) {
                    piocherUneCarteChance();
                    
                } else if (cel.getNumero() == 30 || joueurCourrant.isPrisonnier()) {
                    prison(joueurCourrant);
                    
                } else {
                    System.out.println("Fin de tour");
                    System.out.println("408");
                    
                }
            }

        } else { //A revoir

            
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
        if (compteurP == 3) {
            j.setPrisonnier(false);
            System.out.println("Vous devez payer l'amende");
            j.setFortune(j.getFortune() - 50);
        } else if (j.getInventaire().isEmpty() != true) // si le joueur a une carte "libérer de prison"
        {
            j.setPrisonnier(false);
            if (j.getInventaire().get(0).getDescription() == "Liberer prison Co") {
                this.caisse.getCartes().add(j.getInventaire().get(0));
            } else if (j.getInventaire().get(0).getDescription() == "Liberer prison Ch") {
                this.chance.getCartes().add(j.getInventaire().get(0));
            }
            j.getInventaire().remove(0);

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
                        tourSuivant();
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

    public void parcGratuit1() {

        joueurCourrant.setFortune(joueurCourrant.getFortune() + cagnotte);
        cagnotte = 0;
        this.Vplateau.setCagnotte(cagnotte);
        phase2 = true;
        jX = joueurCourrant.getNom();
        System.out.println("Vous êtes dans le parc gratuit vous remportez la cagnotte !");
        System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
        System.out.println("Vous pouvez aussi choisir de ne pas jouer au prochain tour.");
        if (faitUnDouble == true) {
            parcGratuit2();
        }
    }

    public void parcGratuit2() {

        Scanner sc = new Scanner(System.in);
        System.out.println("|**               Vous êtes dans le parc Gratuit           **|");
        System.out.println("|**                     1- Lancer les dés                  **|");
        System.out.println("|**                     0- Attendre                        **|");
        int nb = sc.nextInt();
        switch (nb) {

            case 1:
                phase2 = false;
                break;
            case 0:
                phase2 = false;
                
                tourSuivant();
                break;

        }

    }

    public void piocherUneCarteCommunaute() {
        Carte carte = caisse.getCartes().get(0);
        ArrayList<Carte> cartes = caisse.getCartes();

        switch (carte.getDescription()) {
            case "Liberer prison Co":
                joueurCourrant.getInventaire().add(carte);
                cartes.remove(carte);
                break;

            case "Payer 10":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 10);
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Tout le monde vous donne 10":
                int somme = 0;
                for (int i = 1; i < joueurs.size(); i++) {
                    joueurs.get(i).setFortune(joueurs.get(i).getFortune() - 10);
                    somme = somme + 10;
                }
                joueurCourrant.setFortune(joueurCourrant.getFortune() + somme);
                System.out.println("Tout le monde vous donne 10 pour votre anniversaire");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 200":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 200);
                System.out.println("Vous gagnez 200");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller a Belleville":
                joueurCourrant.setCellule(plateau.getCellules().get(1));
                System.out.println("Vous retournez au Boulevard de Belleville");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Payer 50":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 50);
                System.out.println("Vous Payez 50");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 20":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 20);
                System.out.println("Vous gagner 20");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Payer 100":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 100);
                System.out.println("Vous payer 100");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 100":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 100);
                System.out.println("Vous gagner 100");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller en prison":
                prison(joueurCourrant);
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 50":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 50);
                System.out.println("Vous gagner 50");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller au depart":
                joueurCourrant.setCellule(plateau.getCellules().get(0));
                System.out.println("Vous retournez au Depart");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 25":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 25);
                System.out.println("Vous gagner 25");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 10":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 10);
                System.out.println("Vous gagner 10");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;
        }

    }

    public void piocherUneCarteChance() {
        Carte carte = chance.getCartes().get(0);
        ArrayList<Carte> cartes = chance.getCartes();
        int deplacement;
        int sommeTot, sommeM = 0, sommeH = 0;

        switch (carte.getDescription()) {
            case "Liberer prison Ch":
                joueurCourrant.getInventaire().add(carte);
                cartes.remove(carte);
                break;

            case "Reculez de 3 cases":
                joueurCourrant.setCellule(plateau.getCellule(joueurCourrant.getCellule().getNumero() - 3));
                System.out.println("Vous reculez de 3 cases.");
                System.out.println("Position actuelle : " + joueurCourrant.getCellule().getNumero());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Payer 15":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 15);
                System.out.println("Vous Payez 15");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Reparations":

                for (int i = 0; i < joueurCourrant.getTerrains().size(); i++) {
                    sommeM = sommeM + joueurCourrant.getTerrains().get(i).getNbMaison();
                    sommeH = sommeH + joueurCourrant.getTerrains().get(i).getHotel();
                }
                sommeTot = 25 * sommeM + 100 * sommeH;

                joueurCourrant.setFortune(joueurCourrant.getFortune() - sommeTot);
                System.out.println("Vous payez 25 par maison et 100 par hotel soit : " + sommeTot);
                System.out.println("Fortune Actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Payer 20":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 20);
                System.out.println("Vous Payez 20");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller au depart":
                joueurCourrant.setCellule(plateau.getCellules().get(0));
                System.out.println("Vous retournez au Depart");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Deplacer Henri-Martin":

                if (joueurCourrant.getCellule().getNumero() > 24) {
                    deplacement = (24 - joueurCourrant.getCellule().getNumero()) + 40;
                } else {
                    deplacement = 24 - joueurCourrant.getCellule().getNumero();
                }
                deplacer(joueurCourrant, deplacement);
                System.out.println("Vous vous déplacez jusqu'à Henri-Martin (cellule 24).");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Deplacer gare de lyon":

                if (joueurCourrant.getCellule().getNumero() > 15) {
                    deplacement = (15 - joueurCourrant.getCellule().getNumero()) + 40;
                } else {
                    deplacement = 15 - joueurCourrant.getCellule().getNumero();
                }
                deplacer(joueurCourrant, deplacement);
                System.out.println("Vous vous déplacez jusqu'à la gare de Lyon (cellule 15).");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Payer 150":
                joueurCourrant.setFortune(joueurCourrant.getFortune() - 150);
                System.out.println("Vous payer 150");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller en prison":
                prison(joueurCourrant);
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 50":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 50);
                System.out.println("Vous gagner 50");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 100":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 100);
                System.out.println("Vous gagner 100");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Gagner 150":
                joueurCourrant.setFortune(joueurCourrant.getFortune() + 150);
                System.out.println("Vous gagner 150");
                System.out.println("Fortune actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Aller rue de la paix":
                joueurCourrant.setCellule(plateau.getCellules().get(39));
                System.out.println("Vous aller à rue de la paix (cellule 39).");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Deplacer Villette":

                if (joueurCourrant.getCellule().getNumero() > 11) {
                    deplacement = (11 - joueurCourrant.getCellule().getNumero()) + 40;
                } else {
                    deplacement = 11 - joueurCourrant.getCellule().getNumero();
                }
                deplacer(joueurCourrant, deplacement);
                System.out.println("Vous vous déplacez jusqu'au boulevard de la Villette (cellule 11).");
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

            case "Impots voirie":

                for (int i = 0; i < joueurCourrant.getTerrains().size(); i++) {
                    sommeM = sommeM + joueurCourrant.getTerrains().get(i).getNbMaison();
                    sommeH = sommeH + joueurCourrant.getTerrains().get(i).getHotel();
                }
                sommeTot = 40 * sommeM + 115 * sommeH;

                joueurCourrant.setFortune(joueurCourrant.getFortune() - sommeTot);
                System.out.println("Vous payez 40 par maison et 115 par hotel soit : " + sommeTot);
                System.out.println("Fortune Actuelle : " + joueurCourrant.getFortune());
                cartes.remove(cartes.get(0));
                cartes.add(carte);
                break;

        }

    }

    public void construire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|**                     1- Acheter une maison (" + joueurCourrant.getCellule().getPropriete().getPrixMaison() + ")                    **|");
        System.out.println("|**                     0- Passer son Tour                 **|");
        int nb = sc.nextInt();
        switch (nb) {

            case 1:
                if (joueurCourrant.getCellule().getPropriete().getNbMaison() != 4) {
                    joueurCourrant.getCellule().getPropriete().addMaison();
                    maisonsDispo--;
                    System.out.println("Une maison a été ajouté au terrain " + joueurCourrant.getCellule().getPropriete().getNom() + " Il y a " + joueurCourrant.getCellule().getPropriete().getNbMaison() + " maisons sur ce terrain.");
                    System.out.println("Nouveau Loyer : " + joueurCourrant.getCellule().getPropriete().getLoyer());
                    tourSuivant();
                } else if (joueurCourrant.getCellule().getPropriete().getNbMaison() == 4) {
                    joueurCourrant.getCellule().getPropriete().addHotel();
                    hotelsDispo--;
                    System.out.println("Un hotel a été ajouté au terrain " + joueurCourrant.getCellule().getPropriete().getNom());
                    System.out.println("Nouveau Loyer : " + joueurCourrant.getCellule().getPropriete().getLoyer());
                    tourSuivant();
                } else if (joueurCourrant.getCellule().getPropriete().getHotel() == 1) {
                    System.out.println("Vous ne pouvez plus rien construire sur ce terrain.");
                }
                break;

            case 0:
                System.out.println("Fin de tour");
                    System.out.println("854");
                tourSuivant();
                break;
            default:
                System.out.println("Entrée non valide !");

        }
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Joueur getJoueurCourrant() {
        return joueurCourrant;
    }

    public void acheter() {

        int nb = this.Vjeu.getPopup().showConfirmDialog(null, "Voulez vous achter la propriété ?", "Achat", JOptionPane.YES_NO_OPTION);

        switch (nb) {
            case 0:              
                        joueurCourrant.setFortune(joueurCourrant.getFortune() - joueurCourrant.getCellule().getPropriete().getPrixAchat());
                        joueurCourrant.addProprieter(joueurCourrant.getCellule().getPropriete());
                        banque.getPropriétésJoueur().remove(joueurCourrant.getCellule().getPropriete());
                        joueurCourrant.getCellule().getPropriete().setProprietaire(joueurCourrant);
                        System.out.println("Fortune du joueur " + joueurCourrant.getNom() + ": " + joueurCourrant.getFortune());
                        System.out.println("! Achat confirmé !");
                        System.out.println("Fin de tour");
                        tourSuivant();
                        break;
                    
            case 1:
                        System.out.println("Fin de tour");
                        tourSuivant();
                        break;
                
            
            default:
                acheter();
                
                break;
        }
    }

    public void tourSuivant() {
        joueurs.remove(0);
        joueurs.add(joueurCourrant);
    }

    public void timer() {
        timer = new Timer();
        this.Vjeu.getWestPanel().revalidate();
        this.Vjeu.getWestPanel().repaint();
        this.Vjeu.getSouthPanel().revalidate();
        this.Vjeu.getSouthPanel().repaint();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                acheter();
                timer.cancel();
            }
        }, 0, 50);
        
    }
}
