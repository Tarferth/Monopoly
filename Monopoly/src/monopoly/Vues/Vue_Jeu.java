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
import java.awt.List;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monopoly.Observe;

/**
 *
 * @author crosv
 */
public class Vue_Jeu extends Observe{
    JFrame f_Jeu;
    
    public Vue_Jeu()
    {
        
        f_Jeu = new JFrame();
        f_Jeu.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Jeu.setSize(dim);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // config fenetre
        
        Vue_Ouest westPanel = new Vue_Ouest();
        mainPanel.add(westPanel,BorderLayout.WEST);
  
        
        Vue_Est eastPanel = new Vue_Est();
        mainPanel.add(eastPanel,BorderLayout.EAST);
       
        Vue_Plateau plateau = new Vue_Plateau();
        mainPanel.add(plateau,BorderLayout.CENTER);
        
        Vue_Nord northPanel = new Vue_Nord();
        this.add(northPanel, BorderLayout.NORTH);
        
        Vue_Sud southPanel = new Vue_Sud();
        this.add(southPanel, BorderLayout.SOUTH);
        
        f_Jeu.add(mainPanel);
        
        
    }
    
    public void afficher()
    {
        f_Jeu.setVisible(true);
    }
    
    public static void main(String [] args) {
        Vue_Jeu exemple1 = new Vue_Jeu();
        exemple1.afficher();
        
   }  
}
