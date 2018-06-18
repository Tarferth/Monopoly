/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author fourrieq
 */
public class Vue_Inscription {
    public Vue_Inscription(){
        private JFrame f_Inscription;
        
        f_Inscription = new JFrame();
        f_Inscription.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Inscription.setSize(dim);
        
    }
    
    public void afficher() {
        this.f_Inscription.setVisible(true);
    }

    public static void main(String [] args) {
        Vue_Inscription exemple1 = new Vue_Inscription();
        exemple1.afficher();
   }  
}
