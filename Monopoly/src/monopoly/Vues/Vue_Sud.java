/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Sud extends JPanel{
    private JPanel vue_Sud;
    private JLabel nomJCourrant;
    private JLabel fortuneJCourrant, prixCaseCourrante, nomCaseCourrante;
    
    public Vue_Sud(){
        this.vue_Sud = new JPanel(new BorderLayout());
        
        JPanel joueurCourantHaut = new JPanel(new GridLayout(1,2));
        this.nomJCourrant = new JLabel("");
        joueurCourantHaut.add(nomJCourrant);
        joueurCourantHaut.setBackground(getCouleurJCourant());
        this.vue_Sud.add(joueurCourantHaut, BorderLayout.NORTH);
        
        JPanel joueurCase = new JPanel(new GridLayout(3,1));
        this.nomCaseCourrante = new JLabel("");
        joueurCase.add(nomCaseCourrante);
        this.prixCaseCourrante = new JLabel("");
        joueurCase.add(prixCaseCourrante);
        this.fortuneJCourrant = new JLabel("");
        joueurCase.add(fortuneJCourrant);
        this.vue_Sud.add(joueurCase, BorderLayout.CENTER);
        this.add(vue_Sud);
    }
    
    private JLabel getNomJCourrant() {
        return this.nomJCourrant;
    }

    private Color getCouleurJCourant() {
        return Color.BLACK;
        }

    public JLabel getFortuneJCourrant() {
        return this.fortuneJCourrant;
    }

    public JLabel getPrixCaseCourrante() {
        return this.prixCaseCourrante;
    }

    public JLabel getNomCaseCourrante() {
        return this.nomCaseCourrante;
    }

    public void setVue_Sud(JPanel vue_Sud) {
        this.vue_Sud = vue_Sud;
    }

    public void setNomJCourrant(String nomJCourrant) {
        this.nomJCourrant.setText(nomJCourrant);
    }

    public void setFortuneJCourrant(String fortuneJCourrant) {
        this.fortuneJCourrant.setText(fortuneJCourrant);
    }

    public void setPrixCaseCourrante(String prixCaseCourrante) {
        this.prixCaseCourrante.setText(prixCaseCourrante);
    }

    public void setNomCaseCourrante(String nomCaseCourrante) {
        this.nomCaseCourrante.setText(nomCaseCourrante);
    }
    
}
