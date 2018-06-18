/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fourrieq
 */
public class Vue_Inscription2 {
    private JFrame f_Inscription2;
    // Bouton du centre
    private int nbJoueurs = 2;
    private JButton boutonRetour = new JButton("Retour");
    
    public Vue_Inscription2(){
        
        f_Inscription2 = new JFrame();
        f_Inscription2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Inscription2.setSize(dim);
        
        JPanel panelVide;
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        
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
        switch(nbJoueurs){
            case 2:
                JPanel centre = new JPanel(new GridLayout(1, 2));
                
                JPanel panelJoueur1 = new JPanel(new GridLayout(2, 1));
                
                JPanel pJoueur1 = new JPanel();
                JLabel labelJoueur1 = new JLabel("Joueur 1");
                pJoueur1.add(labelJoueur1);
                panelJoueur1.add(pJoueur1);
                
                JPanel champsARemplir1 = new JPanel(new GridLayout(5, 5));
                for (int i = 1; i <= 25; i++) {
                    switch(i){
                        case 7:
                            JLabel labelNomJ1 = new JLabel("Nom: ");
                            champsARemplir1.add(labelNomJ1);
                            break;
                        case 9:
                            JTextField champNomJ1 = new JTextField();
                            champsARemplir1.add(champNomJ1);
                            break;
                        case 17:
                            JLabel labelSymboleJ1 = new JLabel("Symbole: ");
                            champsARemplir1.add(labelSymboleJ1);
                            break;
                        case 19:
                            JTextField champSymboleJ1 = new JTextField();
                            champsARemplir1.add(champSymboleJ1);
                            break;
                        default:
                            centre.add(panelVide = new JPanel());
                    }
                }
                break;
        }
    }
    public void afficher() {
        this.f_Inscription2.setVisible(true);
    }

    public static void main(String [] args) {
        Vue_Inscription2 exemple1 = new Vue_Inscription2();
        exemple1.afficher();
   } 
}
