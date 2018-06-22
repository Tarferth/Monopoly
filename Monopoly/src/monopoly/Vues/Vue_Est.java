/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author crosv
 */
public class Vue_Est extends JPanel {
    private JFrame f;
    
    public Vue_Est()
    {
        f = new JFrame();
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4, Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setLayout(new BorderLayout());
        JComboBox c = new JComboBox();
        JPanel main = new JPanel(new GridLayout(1,2));
        JPanel centre = new JPanel(new GridLayout(4,1));
        JPanel bas = new JPanel(new GridLayout(1,2));
        JLabel argent = new JLabel("Argent : ");
        JLabel montant = new JLabel();
        bas.add(argent);
        bas.add(montant);
        main.add(centre);
        main.add(bas);
        this.add(c,BorderLayout.NORTH);
        this.add(main,BorderLayout.CENTER);
        
        f.add(this);
    }
    public void afficher()
    {
        f.setVisible(true);
    }
    
    public static void main(String [] args) {
        Vue_Est exemple1 = new Vue_Est();
        exemple1.afficher();
        
   }
}
