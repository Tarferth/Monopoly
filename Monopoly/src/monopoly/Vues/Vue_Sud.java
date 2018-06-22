/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Sud extends JPanel{
    private JPanel vue_Sud;
    
    public Vue_Sud(){
        this.vue_Sud = new JPanel(new BorderLayout());
        
        JPanel joueurCourantHaut = new JPanel(new GridLayout(1,2));
        JLabel nomJ1 = new JLabel(getNomJCourant());
        joueurCourantHaut.add(nomJ1);
        joueurCourantHaut.setBackground(getCouleurJCourant());
        this.vue_Sud.add(joueurCourantHaut, BorderLayout.NORTH);
        
        JPanel joueurCourantAction = new JPanel(new GridLayout(3,5));
        JPanel vide = new JPanel();
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        // liste des actions
        JButton boutonAcheter = new JButton("Acheter");
        joueurCourantAction.add(boutonAcheter);
        joueurCourantAction.add(vide);
        JButton boutonPasserSonTour = new JButton("Passer son tour");
        joueurCourantAction.add(boutonPasserSonTour);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        joueurCourantAction.add(vide);
        this.vue_Sud.add(joueurCourantAction, BorderLayout.CENTER);
    }

    private String getNomJCourant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Color getCouleurJCourant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
