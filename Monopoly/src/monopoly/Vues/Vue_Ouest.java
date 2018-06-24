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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.text.StyleConstants.Bold;
import monopoly.Message;
import monopoly.TypesMessage;

/**
 *
 * @author crosv
 */
public class Vue_Ouest extends JPanel {
    
    private List liste;
    private JButton lancer;
    private JLabel de1,de2;
    
    public Vue_Ouest()
    {
              
        
        this.setLayout(new GridLayout(2,1));
        liste = new List() ;
        for (int i =0 ;i<100;i++)
        {
            JLabel j = new JLabel(""+i);
            liste.add(j.getText());
        }
        
        
        
        this.add(liste);
        
        lancer = new JButton("Lancer les dés");
        
        JPanel panelLancer = new JPanel(new GridLayout(2,1));
        this.add(panelLancer);
        panelLancer.add(lancer);
        
        JPanel panelValeur = new JPanel(new GridLayout(1,2));
        panelLancer.add(panelValeur);
        
         de1 = new JLabel("   1");
         de2 = new JLabel("       2   ");
        de1.setFont(new Font("DE",1,25));
        de2.setFont(new Font("DE",1,25));
        
        panelValeur.add(de1);
        panelValeur.add(de2);
        
        
        
        
    }
    
    public JButton getBouton()
    {
        return this.lancer;
    }

    public JLabel getDe1() {
        return de1;
    }

    public JLabel getDe2() {
        return de2;
    }
    
}
