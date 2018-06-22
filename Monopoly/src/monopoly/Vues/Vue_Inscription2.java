/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import monopoly.Joueur;
import monopoly.Message;
import monopoly.Observe;
import monopoly.TypesMessage;

/**
 *
 * @author fourrieq
 */
public class Vue_Inscription2 extends Observe{
    private JFrame f_Inscription2;
    private int nbJoueurs;
    // Bouton du centre
    private JButton boutonRetour = new JButton("Retour");
    private JButton boutonConfirmer = new JButton("Confirmer");
    
    // Champ Nom
    private JTextField champNomJ1;
    private JTextField champNomJ2;
    private JTextField champNomJ3;
    private JTextField champNomJ4;
    private JTextField champNomJ5;
    private JTextField champNomJ6;
    
    
    public Vue_Inscription2(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
        f_Inscription2 = new JFrame();
        f_Inscription2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Inscription2.setSize(dim);
        
        JPanel panelVide;
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        
        // Haut
        JPanel haut = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i < 9; i++) {
            switch(i){
                case 5:
                    JPanel titre = new JPanel();
                    JLabel labelTitre = new JLabel("Inscription 2/2");
                    titre.add(labelTitre);
                    labelTitre.setFont(new Font("Arial",Font.BOLD, 32));
                    haut.add(titre);
                    break;
                case 8:
                    JPanel panelInformation = new JPanel();
                    JLabel labelInformation = new JLabel("Remplissez vos informations svp");
                    labelInformation.setFont(new Font("Arial", Font.TYPE1_FONT, 22));
                    panelInformation.add(labelInformation);
                    haut.add(panelInformation);
                    break;
                default:
                    haut.add(panelVide = new JPanel());
            }
        }
        mainPanel.add(haut);
        
        // Centre
                JPanel centre = new JPanel(new GridLayout(1, nbJoueurs));
                if(nbJoueurs >= 2){
                    // Joueur 1
                    JPanel panelJoueur1 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur1 = new JPanel();
                    JLabel labelJoueur1 = new JLabel("Joueur 1");
                    pJoueur1.add(labelJoueur1);
                    panelJoueur1.add(pJoueur1, BorderLayout.NORTH);

                    JPanel champsARemplir1 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ1 = new JLabel("Nom: ");
                                champsARemplir1.add(labelNomJ1);
                                break;
                            case 9:
                                this.champNomJ1 = new JTextField();
                                champsARemplir1.add(champNomJ1);
                                break;
                            case 17:
                                JLabel labelSymboleJ1 = new JLabel("Symbole: ");
                                champsARemplir1.add(labelSymboleJ1);
                                break;
                            case 19:
                                JLabel champSymboleJ1 = new JLabel("1");
                                champsARemplir1.add(champSymboleJ1);
                                break;
                            default:
                                champsARemplir1.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur1.add(champsARemplir1, BorderLayout.CENTER);
                    centre.add(panelJoueur1); 
                    
                    // Joueur 2
                    JPanel panelJoueur2 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur2 = new JPanel();
                    JLabel labelJoueur2 = new JLabel("Joueur 2");
                    pJoueur2.add(labelJoueur2);
                    panelJoueur2.add(pJoueur2, BorderLayout.NORTH);

                    JPanel champsARemplir2 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ2 = new JLabel("Nom: ");
                                champsARemplir2.add(labelNomJ2);
                                break;
                            case 9:
                                this.champNomJ2 = new JTextField();
                                champsARemplir2.add(champNomJ2);
                                break;
                            case 17:
                                JLabel labelSymboleJ2 = new JLabel("Symbole: ");
                                champsARemplir2.add(labelSymboleJ2);
                                break;
                            case 19:
                                JLabel champSymboleJ2 = new JLabel("2");
                                champsARemplir2.add(champSymboleJ2);
                                break;
                            default:
                                champsARemplir2.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur2.add(champsARemplir2, BorderLayout.CENTER);
                    centre.add(panelJoueur2);
                }
                if(nbJoueurs > 2){
                    // Joueur 3
                    System.out.println("ICI ligne 140");
                    JPanel panelJoueur3 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur3 = new JPanel();
                    JLabel labelJoueur3 = new JLabel("Joueur 3");
                    pJoueur3.add(labelJoueur3);
                    panelJoueur3.add(pJoueur3, BorderLayout.NORTH);

                    JPanel champsARemplir3 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ3 = new JLabel("Nom: ");
                                champsARemplir3.add(labelNomJ3);
                                break;
                            case 9:
                                this.champNomJ3 = new JTextField();
                                champsARemplir3.add(champNomJ3);
                                break;
                            case 17:
                                JLabel labelSymboleJ3 = new JLabel("Symbole: ");
                                champsARemplir3.add(labelSymboleJ3);
                                break;
                            case 19:
                                JLabel champSymboleJ3 = new JLabel("3");
                                champsARemplir3.add(champSymboleJ3);
                                break;
                            default:
                                champsARemplir3.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur3.add(champsARemplir3, BorderLayout.CENTER);
                    centre.add(panelJoueur3);
                }
                if (nbJoueurs >= 4) {
                    // Joueur 4
                    JPanel panelJoueur4 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur4 = new JPanel();
                    JLabel labelJoueur4 = new JLabel("Joueur 4");
                    pJoueur4.add(labelJoueur4);
                    panelJoueur4.add(pJoueur4, BorderLayout.NORTH);

                    JPanel champsARemplir4 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ4 = new JLabel("Nom: ");
                                champsARemplir4.add(labelNomJ4);
                                break;
                            case 9:
                                this.champNomJ4 = new JTextField();
                                champsARemplir4.add(champNomJ4);
                                break;
                            case 17:
                                JLabel labelSymboleJ4 = new JLabel("Symbole: ");
                                champsARemplir4.add(labelSymboleJ4);
                                break;
                            case 19:
                                JLabel champSymboleJ4 = new JLabel("4");
                                champsARemplir4.add(champSymboleJ4);
                                break;
                            default:
                                champsARemplir4.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur4.add(champsARemplir4, BorderLayout.CENTER);
                    centre.add(panelJoueur4);
                }
                if (nbJoueurs >= 5) {
                    // Joueur 5
                    JPanel panelJoueur5 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur5 = new JPanel();
                    JLabel labelJoueur5 = new JLabel("Joueur 5");
                    pJoueur5.add(labelJoueur5);
                    panelJoueur5.add(pJoueur5, BorderLayout.NORTH);

                    JPanel champsARemplir5 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ5 = new JLabel("Nom: ");
                                champsARemplir5.add(labelNomJ5);
                                break;
                            case 9:
                                this.champNomJ5 = new JTextField();
                                champsARemplir5.add(champNomJ5);
                                break;
                            case 17:
                                JLabel labelSymboleJ5 = new JLabel("Symbole: ");
                                champsARemplir5.add(labelSymboleJ5);
                                break;
                            case 19:
                                JLabel champSymboleJ5 = new JLabel("5");
                                champsARemplir5.add(champSymboleJ5);
                                break;
                            default:
                                champsARemplir5.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur5.add(champsARemplir5, BorderLayout.CENTER);
                    centre.add(panelJoueur5);
                }
                if (nbJoueurs >= 6) {
                    // Joueur 6
                    JPanel panelJoueur6 = new JPanel(new BorderLayout());
                
                    JPanel pJoueur6 = new JPanel();
                    JLabel labelJoueur6 = new JLabel("Joueur 6");
                    pJoueur6.add(labelJoueur6);
                    panelJoueur6.add(pJoueur6, BorderLayout.NORTH);

                    JPanel champsARemplir6 = new JPanel(new GridLayout(9, 5));
                    for (int j = 1; j <= 45; j++) {
                        switch(j){
                            case 7:
                                JLabel labelNomJ6 = new JLabel("Nom: ");
                                champsARemplir6.add(labelNomJ6);
                                break;
                            case 9:
                                this.champNomJ6 = new JTextField();
                                champsARemplir6.add(champNomJ6);
                                break;
                            case 17:
                                JLabel labelSymboleJ6 = new JLabel("Symbole: ");
                                champsARemplir6.add(labelSymboleJ6);
                                break;
                            case 19:
                                JLabel champSymboleJ6 = new JLabel("6");
                                champsARemplir6.add(champSymboleJ6);
                                break;
                            default:
                                champsARemplir6.add(panelVide = new JPanel());
                        }
                    }
                    panelJoueur6.add(champsARemplir6, BorderLayout.CENTER);
                    centre.add(panelJoueur6);
                }
                mainPanel.add(centre);
                
                
                
                
        JPanel bas = new JPanel(new GridLayout(7, 7));
        for (int i = 1; i <= 49; i++) {
            switch(i){
                case 24:
                    bas.add(boutonRetour);
                    break;
                case 26:
                    bas.add(boutonConfirmer);
                    break;
                default:
                    bas.add(panelVide = new JPanel());
            }
        }
        mainPanel.add(bas);
        f_Inscription2.add(mainPanel);
        
        // Gestion des boutons
        boutonConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Joueur> listeJoueurs = new ArrayList<>();
                listeJoueurs.add(new Joueur(champNomJ1.getText(), "1", 1500, 0));
                listeJoueurs.add(new Joueur(champNomJ2.getText(), "2", 1500, 0));
                if (nbJoueurs > 2) {
                    listeJoueurs.add(new Joueur(champNomJ3.getText(), "3", 1500, 0));
                }
                if (nbJoueurs > 3) {
                    listeJoueurs.add(new Joueur(champNomJ4.getText(), "4", 1500, 0));
                }
                if (nbJoueurs > 4) {
                    listeJoueurs.add(new Joueur(champNomJ5.getText(), "5", 1500, 0));
                }
                if (nbJoueurs > 5) {
                    listeJoueurs.add(new Joueur(champNomJ6.getText(), "6", 1500, 0));
                }
                Message m = new Message(TypesMessage.LANCEMENT_PARTIE, listeJoueurs);
                notifierObservateur(m);
            }
        });
        
        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(TypesMessage.RETOUR_INSCRIPTION_1);
                notifierObservateur(m);
            }
        });
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }
    
    public void afficher() {
        this.f_Inscription2.setVisible(true);
    }
    
    public void cacher(){
        this.f_Inscription2.setVisible(false);
    }

    public static void main(String [] args) {
        Vue_Inscription2 exemple1 = new Vue_Inscription2(2);
        exemple1.afficher();
   } 
}
