/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

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
    private int nbJoueurs = 6;
    
    public Vue_Nord(){
        this.vue_Nord = new JPanel(new GridLayout(1,this.getNbJoueurs()));
        
        // 1er joueur
        JPanel joueur1 = new JPanel();
        this.nomJ1 = new JLabel("");
        joueur1.add(nomJ1);
        this.vue_Nord.add(joueur1);
        
        // 2eme Joueur
        JPanel joueur2 = new JPanel();
        this.nomJ2 = new JLabel("");
        joueur2.add(nomJ2);
        this.vue_Nord.add(joueur2);
        
        if (this.getNbJoueurs() > 2) {
            // 3eme Joueur
            JPanel joueur3 = new JPanel();
            this.nomJ3 = new JLabel("");
            joueur3.add(nomJ3);
            this.vue_Nord.add(joueur3);
        }
        
        if (this.getNbJoueurs() > 3) {
            // 4eme Joueur
            JPanel joueur4 = new JPanel();
            this.nomJ4 = new JLabel("");
            joueur4.add(nomJ4);
            this.vue_Nord.add(joueur4);
        }
        
        if (this.getNbJoueurs() > 4) {
            // 5eme Joueur
            JPanel joueur5 = new JPanel();
            this.nomJ5 = new JLabel("");
            joueur5.add(nomJ5);
            this.vue_Nord.add(joueur5);
        }
        
        if (this.getNbJoueurs() > 5) {
            // 6eme Joueur
            JPanel joueur6 = new JPanel();
            this.nomJ6 = new JLabel("");
            joueur6.add(nomJ6);
            this.vue_Nord.add(joueur6);
        }
        this.add(vue_Nord);
    }



    private int getNbJoueurs() {
        return this.nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
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
