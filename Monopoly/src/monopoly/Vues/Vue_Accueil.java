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
import monopoly.Message;
import monopoly.Observe;
import monopoly.TypesMessage;

/**
 *
 * @author fourrieq
 */
public class Vue_Accueil extends Observe{
    private JFrame f_Accueil; 
    private JButton bouton_Jouer;
    private JButton bouton_Quitter;
    
    public Vue_Accueil(){
        f_Accueil = new JFrame();
        f_Accueil.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Accueil.setSize(dim);
        
        JPanel mainPanel = new JPanel(new GridLayout(2,1));

        JLabel imageMonopoly = new JLabel(new ImageIcon("src/Images/Monopoly.svg.png"));
        JPanel panelBouton = new JPanel(new GridLayout(2,3));
        JPanel panelVide;
        
        panelBouton.add(panelVide = new JPanel());
        JPanel panelJouer = new JPanel(new GridLayout(3,1));
        panelJouer.add(panelVide = new JPanel());
        panelJouer.add(bouton_Jouer = new JButton("Jouer"));
        panelJouer.add(panelVide = new JPanel());
        panelBouton.add(panelJouer);
        
        panelBouton.add(panelVide = new JPanel());
        panelBouton.add(panelVide = new JPanel());
        
        JPanel panelQuitter = new JPanel(new GridLayout(3,1));
        panelQuitter.add(bouton_Quitter = new JButton("Quitter"));
        panelQuitter.add(panelVide = new JPanel());
        panelQuitter.add(panelVide = new JPanel());
        panelBouton.add(panelQuitter);
        
        panelBouton.add(panelVide = new JPanel());        
        
        mainPanel.add(imageMonopoly);
        mainPanel.add(panelBouton);
        f_Accueil.add(mainPanel) ;
        
        
        // Gestion des cliques sur bouton
        bouton_Jouer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(TypesMessage.AFFICHER_INSCRIPTION_1);
                notifierObservateur(m);
            }
        });
        
        bouton_Quitter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message(TypesMessage.QUITTER);
                notifierObservateur(m);
            }
        });
        
        
    }
    public void afficher() {
        this.f_Accueil.setVisible(true);
    }
    public void cacher(){
        this.f_Accueil.setVisible(false);
    }
    public static void main(String [] args) {
        Vue_Accueil exemple1 = new Vue_Accueil();
        exemple1.afficher();
   }  
   
}
