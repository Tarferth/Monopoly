/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Nord extends JPanel{
    private JPanel vue_Nord;
    
    public Vue_Nord(){
        
        this.vue_Nord = new JPanel(new GridLayout(1,getNbJoueurs()));
        
        // 1er joueur
        JPanel joueur1 = new JPanel(new GridLayout(2, 1));
        JLabel nomJ1 = new JLabel(getNom(1));
        joueur1.add(nomJ1);
        joueur1.setBackground(getCouleur(1));
        this.vue_Nord.add(joueur1);
        
        // 2eme Joueur
        JPanel joueur2 = new JPanel();
        JLabel nomJ2 = new JLabel(getNom(2));
        joueur2.add(nomJ2);
        joueur2.setBackground(getCouleur(2));
        this.vue_Nord.add(joueur2);
        
        if (getNbJoueurs() > 2) {
            // 3eme Joueur
            JPanel joueur3 = new JPanel();
            JLabel nomJ3 = new JLabel(getNom(3));
            joueur3.add(nomJ3);
            joueur3.setBackground(getCouleur(3));
            this.vue_Nord.add(joueur3);
        }
        
        if (getNbJoueurs() > 3) {
            // 4eme Joueur
            JPanel joueur4 = new JPanel();
            JLabel nomJ4 = new JLabel(getNom(4));
            joueur4.add(nomJ4);
            joueur4.setBackground(getCouleur(4));
            this.vue_Nord.add(joueur4);
        }
        
        if (getNbJoueurs() > 4) {
            // 5eme Joueur
            JPanel joueur5 = new JPanel();
            JLabel nomJ5 = new JLabel(getNom(5));
            joueur5.add(nomJ5);
            joueur5.setBackground(getCouleur(5));
            this.vue_Nord.add(joueur5);
        }
        
        if (getNbJoueurs() > 5) {
            // 6eme Joueur
            JPanel joueur6 = new JPanel();
            JLabel nomJ6 = new JLabel(getNom(6));
            joueur6.add(nomJ6);
            joueur6.setBackground(getCouleur(6));
            this.vue_Nord.add(joueur6);
        }
    }

    private String getNom(int i) {
        return "Jean";
    }

    private Color getCouleur(int i) {
        return Color.black;
    }

    private int getNbJoueurs() {
        return 4;
    }
}
