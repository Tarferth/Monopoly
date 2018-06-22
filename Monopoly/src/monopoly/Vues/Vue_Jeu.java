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

/**
 *
 * @author crosv
 */
public class Vue_Jeu extends JPanel{
    JFrame f_Jeu;
    
    public Vue_Jeu()
    {
        
        f_Jeu = new JFrame();
        f_Jeu.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Jeu.setSize(dim);
        this.setLayout(new BorderLayout()); // config fenetre
        
        Vue_Ouest westPanel = new Vue_Ouest();
        this.add(westPanel,BorderLayout.WEST);
  
        
        Vue_Est eastPanel = new Vue_Est();
        this.add(eastPanel,BorderLayout.EAST);
       
        Vue_Plateau plateau = new Vue_Plateau();
        this.add(plateau,BorderLayout.CENTER);
        
        
        
        f_Jeu.add(this);
        
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
