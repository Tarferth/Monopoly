/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fourrieq
 */
public class Vue_Accueil {
    private JFrame f_Accueil; 
    private JButton bouton_Jouer;
    private JButton bouton_Quitter;
    
    public Vue_Accueil(){
        f_Accueil = new JFrame();
        f_Accueil.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        f_Accueil.setSize(800, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Accueil.setLocation(dim.width/2-f_Accueil.getSize().width/2, dim.height/2-f_Accueil.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new GridLayout(2,1));

        JLabel imageMonopoly = new JLabel(new ImageIcon("src/Images/Monopoly.svg.png"));
        JPanel panelBouton = new JPanel(new GridLayout(2,3));
        JLabel labelVide = new JLabel(" ");
        panelBouton.add(labelVide);
        panelBouton.add(bouton_Jouer = new JButton("Jouer"));
        panelBouton.add(labelVide);
        panelBouton.add(labelVide);
        panelBouton.add(bouton_Quitter = new JButton("Quitter"));
        panelBouton.add(labelVide);
        
        
        mainPanel.add(imageMonopoly);
        mainPanel.add(panelBouton);
        f_Accueil.add(mainPanel) ;
        
        
        // Gestion des cliques sur bouton
        bouton_Jouer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

               
            }
        });
        
        bouton_Quitter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        
    }
    public void afficher() {
        this.f_Accueil.setVisible(true);
    }

    public static void main(String [] args) {
        Vue_Accueil exemple1 = new Vue_Accueil();
        exemple1.afficher();
   }  
   
}
