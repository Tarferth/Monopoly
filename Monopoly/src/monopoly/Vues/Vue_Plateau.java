/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monopoly.Observe;

/**
 *
 * @author Quentin
 */
public class Vue_Plateau extends Observe{
    private JFrame f_Plateau; 
    
    public Vue_Plateau(){
        f_Plateau = new JFrame();
        f_Plateau.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f_Plateau.setSize(dim);
        
        JPanel  mainPanel = new JPanel(new GridLayout(11,11));
        for (int i = 1; i <= 121; i++) {
            switch(i){
                case 1:
                    JPanel tuile1 = new JPanel(new GridLayout(4, 1));
                    
                    JPanel nom = new JPanel();
                    JLabel labelNom = new JLabel(this.getNomTuile(i));
                    nom.add(labelNom);
                    tuile1.add(nom);
                    
                    JPanel prix = new JPanel();
                    JLabel labelPrix = new JLabel(getPrixTuile(i));
                    nom.add(labelPrix);
                    tuile1.add(prix);
                    
                    JPanel vide = new JPanel();
                    tuile1.add(vide);
                    
                    JPanel couleur = new JPanel();
                    if (this.getCouleur(i) != null) {
                        couleur.setBackground(this.getCouleur(i));
                    }
                    tuile1.add(couleur);
                    
                    mainPanel.add(tuile1);
                    break;
                case 2:
                    JPanel tuile2 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile2);
                    break;
                case 3:
                    JPanel tuile3 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile3);
                    break;
                case 4:
                    JPanel tuile4 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile4);
                    break;
                case 5:
                    JPanel tuile5 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile5);
                    break;
                case 6:
                    JPanel tuile6 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile6);
                    break;
                case 7:
                    JPanel tuile7 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile7);
                    break;
                case 8:
                    JPanel tuile8 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile8);
                    break;
                case 9:
                    JPanel tuile9 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile9);
                    break;
                case 10:
                    JPanel tuile10 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile10);
                    break;
                case 11:
                    JPanel tuile11 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile11);
                    break;
                case 12:
                    JPanel tuile40 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile40);
                    break;
                case 22:
                    JPanel tuile12 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile12);
                    break;
                case 23:
                    JPanel tuile39 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile39);
                    break;
                case 33:
                    JPanel tuile13 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile13);
                    break;
                case 34:
                    JPanel tuile38 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile38);
                    break;
                case 37:
                    JPanel tuileCaisseDeCommu = new JPanel(new BorderLayout());
                    mainPanel.add(tuileCaisseDeCommu);
                    break;
                case 44:
                    JPanel tuile14 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile14);
                    break;
                case 45:
                    JPanel tuile37 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile37);
                    break;
                case 55:
                    JPanel tuile15 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile15);
                    break;
                case 56:
                    JPanel tuile36 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile36);
                    break;
                case 66:
                    JPanel tuile16 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile16);
                    break;
                case 67:
                    JPanel tuile35 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile35);
                    break;
                case 77:
                    JPanel tuile17 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile17);
                    break;
                case 78:
                    JPanel tuile34 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile34);
                    break;
                case 85:
                    JPanel tuileChance = new JPanel(new BorderLayout());
                    mainPanel.add(tuileChance);
                    break;
                case 88:
                    JPanel tuile18 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile18);
                    break;
                case 89:
                    JPanel tuile33 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile33);
                    break;
                case 99:
                    JPanel tuile19 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile19);
                    break;
                case 100:
                    JPanel tuile32 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile32);
                    break;
                case 110:
                    JPanel tuile20 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile20);
                    break;
                case 111:
                    JPanel tuile31 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile31);
                    break;
                case 112:
                    JPanel tuile30 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile30);
                    break;
                case 113:
                    JPanel tuile29 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile29);
                    break;
                case 114:
                    JPanel tuile28 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile28);
                    break;
                case 115:
                    JPanel tuile27 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile27);
                    break;
                case 116:
                    JPanel tuile26 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile26);
                    break;
                case 117:
                    JPanel tuile25 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile25);
                    break;
                case 118:
                    JPanel tuile24 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile24);
                    break;
                case 119:
                    JPanel tuile23 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile23);
                    break;
                case 120:
                    JPanel tuile22 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile22);
                    break;
                case 121:
                    JPanel tuile21 = new JPanel(new BorderLayout());
                    mainPanel.add(tuile21);
                    break;
                default:
                    JPanel tuile = new JPanel(new BorderLayout());
                    tuile.setBackground(Color.red);
                    mainPanel.add(tuile);
                    
            }
        }
        
        this.f_Plateau.add(mainPanel);
    }
    
    public String getNomTuile(int numéro){
        return null;
        
    }
    
    public String getPrixTuile(int numéro){
        return null;
        
    }
    
    public Color getCouleur(int numéro){
        return null;
        
    }
    
    public void afficher() {
        this.f_Plateau.setVisible(true);
    }
    
    public void cacher(){
        this.f_Plateau.setVisible(false);
    }
    
    public static void main(String [] args) {
        Vue_Plateau exemple1 = new Vue_Plateau();
        exemple1.afficher();
        
   }  
}
