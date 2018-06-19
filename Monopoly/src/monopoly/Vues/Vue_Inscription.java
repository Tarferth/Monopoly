/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monopoly.Message;
import monopoly.Observe;

/**
 *
 * @author fourrieq
 */
public class Vue_Inscription extends Observe{
    private JFrame f_Inscription;
    // Bouton du centre
    private JButton bouton2J = new JButton("2 joueurs");
    private JButton bouton3J = new JButton("3 joueurs");
    private JButton bouton4J = new JButton("4 joueurs");
    private JButton bouton5J = new JButton("5 joueurs");
    private JButton bouton6J = new JButton("6 joueurs");
    private JButton boutonRetour = new JButton("Retour");
    
    public Vue_Inscription(){
        
        f_Inscription = new JFrame();
        f_Inscription.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Inscription.setSize(dim);
        
        JPanel panelVide;
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        
        // Haut
        JPanel haut = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i < 9; i++) {
            switch(i){
                case 5:
                    JPanel titre = new JPanel();
                    JLabel labelTitre = new JLabel("Inscription 1/2");
                    titre.add(labelTitre);
                    labelTitre.setFont(new Font("Arial",Font.BOLD, 32));
                    haut.add(titre);
                    break;
                case 8:
                    JPanel panelQuestion = new JPanel();
                    JLabel labelQuestion = new JLabel("A combien voulez-vous jouer ?");
                    labelQuestion.setFont(new Font("Arial", Font.TYPE1_FONT, 22));
                    panelQuestion.add(labelQuestion);
                    haut.add(panelQuestion);
                    break;
                default:
                    haut.add(panelVide = new JPanel());
            }
        }
        mainPanel.add(haut);
        

        
        // Centre
        JPanel centre = new JPanel(new GridLayout(6,13));
        for (int i = 1; i <= 78; i++) {
            switch(i){
                case 16: 
                    centre.add(bouton2J);
                    break;
                case 18:
                    centre.add(bouton3J);
                    break;
                case 20:
                    centre.add(bouton4J);
                    break;
                case 22:
                    centre.add(bouton5J);
                    break;
                case 24:
                    centre.add(bouton6J);
                    break;
                case 46:
                    centre.add(boutonRetour);
                    break;
                default:
                    centre.add(panelVide = new JPanel());
            }
        }  
        mainPanel.add(centre);
 
        f_Inscription.add(mainPanel);
        
        bouton2J.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.nbJoueurs = 2;
                notifierObservateur(m);
            }
        });
        
        bouton3J.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        bouton4J.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        bouton5J.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        bouton6J.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        boutonRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
    
    public void afficher() {
        this.f_Inscription.setVisible(true);
    }

    public static void main(String [] args) {
        Vue_Inscription exemple1 = new Vue_Inscription();
        exemple1.afficher();
   }  
}
