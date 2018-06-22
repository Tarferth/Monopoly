/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author crosv
 */
public class Vue_Jeu extends JPanel{
    JFrame f_Jeu;
    Vue_Ouest ouest;
    public Vue_Jeu()
    {
        f_Jeu = new JFrame();
        ouest = new Vue_Ouest();
        f_Jeu.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Jeu.setSize(dim);
        this.setLayout(new BorderLayout());
        JLabel t = new JLabel("AAAAAAAAAAAAA");
        this.add(t);
        this.add(ouest,BorderLayout.WEST);
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
