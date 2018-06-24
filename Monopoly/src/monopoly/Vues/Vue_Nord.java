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
    private JLabel nomJ1, nomJ2, nomJ3, nomJ4, nomJ5, nomJ6;
    
    
    public Vue_Nord(){
        
        this.vue_Nord = new JPanel(new GridLayout(1,getNbJoueurs()));
        
        // 1er joueur
        JPanel joueur1 = new JPanel();
        this.nomJ1 = new JLabel("");
        joueur1.add(nomJ1);
        joueur1.setBackground(getCouleur(1));
        this.vue_Nord.add(joueur1);
        
        // 2eme Joueur
        JPanel joueur2 = new JPanel();
        this.nomJ2 = new JLabel("");
        joueur2.add(nomJ2);
        joueur2.setBackground(getCouleur(2));
        this.vue_Nord.add(joueur2);
        
        if (getNbJoueurs() > 2) {
            // 3eme Joueur
            JPanel joueur3 = new JPanel();
            this.nomJ3 = new JLabel("");
            joueur3.add(nomJ3);
            joueur3.setBackground(getCouleur(3));
            this.vue_Nord.add(joueur3);
        }
        
        if (getNbJoueurs() > 3) {
            // 4eme Joueur
            JPanel joueur4 = new JPanel();
            this.nomJ4 = new JLabel("");
            joueur4.add(nomJ4);
            joueur4.setBackground(getCouleur(4));
            this.vue_Nord.add(joueur4);
        }
        
        if (getNbJoueurs() > 4) {
            // 5eme Joueur
            JPanel joueur5 = new JPanel();
            this.nomJ5 = new JLabel("");
            joueur5.add(nomJ5);
            joueur5.setBackground(getCouleur(5));
            this.vue_Nord.add(joueur5);
        }
        
        if (getNbJoueurs() > 5) {
            // 6eme Joueur
            JPanel joueur6 = new JPanel();
            this.nomJ6 = new JLabel("");
            joueur6.add(nomJ6);
            joueur6.setBackground(getCouleur(6));
            this.vue_Nord.add(joueur6);
        }
        this.add(vue_Nord);
    }

    private Color getCouleur(int i) {
        return Color.black;
    }

    private int getNbJoueurs() {
        return 4;
    }

    public JLabel getNomJ1() {
        return nomJ1;
    }

    public JLabel getNomJ2() {
        return nomJ2;
    }

    public JLabel getNomJ3() {
        return nomJ3;
    }

    public JLabel getNomJ4() {
        return nomJ4;
    }

    public JLabel getNomJ5() {
        return nomJ5;
    }

    public JLabel getNomJ6() {
        return nomJ6;
    }

    public void setNomJ1(String nomJ1) {
        this.nomJ1.setText(nomJ1);
    }

    public void setNomJ2(String nomJ2) {
        this.nomJ2.setText(nomJ2);
    }

    public void setNomJ3(String nomJ3) {
        this.nomJ3.setText(nomJ3);
    }

    public void setNomJ4(String nomJ4) {
        this.nomJ4.setText(nomJ4);
    }

    public void setNomJ5(String nomJ5) {
        this.nomJ5.setText(nomJ5);
    }

    public void setNomJ6(String nomJ6) {
        this.nomJ6.setText(nomJ6);
    }
    
}
