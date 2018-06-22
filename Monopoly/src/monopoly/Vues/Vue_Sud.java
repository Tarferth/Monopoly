/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Sud {
    private JPanel vue_Sud;
    
    public Vue_Sud(){
        this.vue_Sud = new JPanel(new BorderLayout());
        
        JPanel joueurCourantHaut = new JPanel(new GridLayout(1,2));
        JLabel nomJ1 = new JLabel(getNomJCourant());
        joueurCourantHaut.add(nomJ1);
        joueurCourantHaut.setBackground(getCouleurJCourant());
        this.vue_Sud.add(joueurCourantHaut, BorderLayout.NORTH);
        
        JPanel joueurCourantAction = new JPanel(new GridLayout(5,4));
        // liste des actions
        this.vue_Sud.add(joueurCourantAction, BorderLayout.CENTER);
    }
}
