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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monopoly.Message;
import monopoly.Observe;
import monopoly.TypesMessage;

/**
 *
 * @author crosv
 */
public class Vue_Jeu extends Observe{
    private JFrame f_Jeu;
    private Vue_Est eastPanel;
    private Vue_Ouest westPanel;        
    private Vue_Nord northPanel;
    private Vue_Sud  southPanel; 
    private Vue_Plateau plateau;
    private JPanel mainPanel;
    public Vue_Jeu()
    {
        
        f_Jeu = new JFrame();
        f_Jeu.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Jeu.setSize(dim);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // config fenetre
        
        westPanel = new Vue_Ouest();
        mainPanel.add(westPanel,BorderLayout.WEST);
  
        
        eastPanel = new Vue_Est();
        mainPanel.add(eastPanel,BorderLayout.EAST);
       
        plateau = new Vue_Plateau();
        mainPanel.add(plateau,BorderLayout.CENTER);
        
        northPanel = new Vue_Nord();
        mainPanel.add(northPanel, BorderLayout.NORTH);
        
        southPanel = new Vue_Sud();
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        f_Jeu.add(mainPanel);
        
        
        westPanel.getBouton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(TypesMessage.LANCER_DES);
                notifierObservateur(m);
                
            }
        });
        
    }
    
    public void afficher()
    {
        f_Jeu.setVisible(true);
    }
    
    public static void main(String [] args) {
        Vue_Jeu exemple1 = new Vue_Jeu();
        exemple1.afficher();
        
   }  

    public Vue_Est getEastPanel() {
        return eastPanel;
    }

    public Vue_Ouest getWestPanel() {
        return westPanel;
    }

    public Vue_Nord getNorthPanel() {
        return northPanel;
    }

    public Vue_Sud getSouthPanel() {
        return southPanel;
    }

    public Vue_Plateau getPlateau() {
        return plateau;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
    
}
