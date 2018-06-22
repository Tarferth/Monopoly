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
import monopoly.Plateau;

/**
 *
 * @author Quentin
 */
public class Vue_Plateau extends JPanel{
    private JFrame f_Plateau; 
    private Plateau cellules;
    private int cagnotte;
    
    public Vue_Plateau(){
      //  f_Plateau = new JFrame();
      //  f_Plateau.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      //  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      //  f_Plateau.setSize(dim);
        
        JPanel vide;
        
        JPanel  mainPanel = new JPanel(new GridLayout(11,11));
        for (int i = 1; i <= 121; i++) {
            switch(i){                              
                case 1:
                    JPanel tuile1 = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom1 = new JPanel();
                    JLabel labelNom1 = new JLabel("Depart");
                    nom1.add(labelNom1);
                    tuile1.add(nom1);
                    
                    JPanel prix1 = new JPanel();
                    JLabel labelPrix1 = new JLabel("");
                    prix1.add(labelPrix1);
                    tuile1.add(prix1);
                    
                    mainPanel.add(tuile1);
                    break;
                case 2:
                    JPanel tuile2 = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom2 = new JPanel();
                    JLabel labelNom2 = new JLabel(this.getNomTuile(1));
                    nom2.add(labelNom2);
                    tuile2.add(nom2);
                    
                    JPanel prix2 = new JPanel();
                    JLabel labelPrix2 = new JLabel(getPrixTuile(1));
                    prix2.add(labelPrix2);
                    tuile2.add(prix2);
                    
                    JPanel couleur2 = new JPanel();
                    if (this.getCouleur(1) != null) {
                        couleur2.setBackground(this.getCouleur(1));
                    }
                    tuile2.add(couleur2);
                    
                    mainPanel.add(tuile2);
                    break;
                case 3:
                    JPanel tuile3  = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom3 = new JPanel();
                    JLabel labelNom3 = new JLabel("Caisse de communauté");
                    nom3.add(labelNom3);
                    tuile3.add(nom3);
                    
                    JPanel prix3 = new JPanel();
                    JLabel labelPrix3 = new JLabel("");
                    prix3.add(labelPrix3);
                    tuile3.add(prix3);
                    
                    mainPanel.add(tuile3);
                    break;
                case 4:
                    JPanel tuile4  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom4 = new JPanel();
                    JLabel labelNom4 = new JLabel(this.getNomTuile(3));
                    nom4.add(labelNom4);
                    tuile4.add(nom4);
                    
                    JPanel prix4 = new JPanel();
                    JLabel labelPrix4 = new JLabel(getPrixTuile(3));
                    prix4.add(labelPrix4);
                    tuile4.add(prix4);
                    
                    JPanel couleur4 = new JPanel();
                    if (this.getCouleur(3) != null) {
                        couleur4.setBackground(this.getCouleur(3));
                    }
                    tuile4.add(couleur4);
                    
                    mainPanel.add(tuile4);
                    break;
                case 5:
                    JPanel tuile5  = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom5 = new JPanel();
                    JLabel labelNom5 = new JLabel("Impôts sur le revenu");
                    nom5.add(labelNom5);
                    tuile5.add(nom5);
                    
                    JPanel prix5 = new JPanel();
                    JLabel labelPrix5 = new JLabel(String.valueOf(this.cellules.getCellule(4).getImpot().getMontant()));
                    prix5.add(labelPrix5);
                    tuile5.add(prix5);
                    
                    
                    
                    mainPanel.add(tuile5);
                    break;
                case 6:
                    JPanel tuile6  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom6 = new JPanel();
                    JLabel labelNom6 = new JLabel(this.getNomTuile(5));
                    nom6.add(labelNom6);
                    tuile6.add(nom6);
                    
                    JPanel prix6 = new JPanel();
                    JLabel labelPrix6 = new JLabel(getPrixTuile(5));
                    prix6.add(labelPrix6);
                    tuile6.add(prix6);
                    
                    JPanel couleur6 = new JPanel();
                    if (this.getCouleur(5) != null) {
                        couleur6.setBackground(this.getCouleur(5));
                    }
                    tuile6.add(couleur6);
                    
                    mainPanel.add(tuile6);
                    break;
                case 7:
                    JPanel tuile7  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom7 = new JPanel();
                    JLabel labelNom7 = new JLabel(this.getNomTuile(6));
                    nom7.add(labelNom7);
                    tuile7.add(nom7);
                    
                    JPanel prix7 = new JPanel();
                    JLabel labelPrix7 = new JLabel(getPrixTuile(6));
                    prix7.add(labelPrix7);
                    tuile7.add(prix7);
                    
                    JPanel couleur7 = new JPanel();
                    if (this.getCouleur(6) != null) {
                        couleur7.setBackground(this.getCouleur(6));
                    }
                    tuile7.add(couleur7);
                    
                    mainPanel.add(tuile7);
                    break;
                case 8:
                    JPanel tuile8  = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom8 = new JPanel();
                    JLabel labelNom8 = new JLabel("Chance");
                    nom8.add(labelNom8);
                    tuile8.add(nom8);
                    
                    JPanel prix8 = new JPanel();
                    JLabel labelPrix8 = new JLabel("");
                    prix8.add(labelPrix8);
                    tuile8.add(prix8);
                    
                   
                    
                    mainPanel.add(tuile8);
                    break;
                case 9:
                    JPanel tuile9  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom9 = new JPanel();
                    JLabel labelNom9 = new JLabel(this.getNomTuile(8));
                    nom9.add(labelNom9);
                    tuile9.add(nom9);
                    
                    JPanel prix9 = new JPanel();
                    JLabel labelPrix9 = new JLabel(getPrixTuile(8));
                    prix9.add(labelPrix9);
                    tuile9.add(prix9);
                    
                    JPanel couleur9 = new JPanel();
                    if (this.getCouleur(8) != null) {
                        couleur9.setBackground(this.getCouleur(8));
                    }
                    tuile9.add(couleur9);
                    
                    mainPanel.add(tuile9);
                    break;
                case 10:
                    JPanel tuile10  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel nom10 = new JPanel();
                    JLabel labelNom10 = new JLabel(this.getNomTuile(9));
                    nom10.add(labelNom10);
                    tuile10.add(nom10);
                    
                    JPanel prix10 = new JPanel();
                    JLabel labelPrix10 = new JLabel(getPrixTuile(9));
                    prix10.add(labelPrix10);
                    tuile10.add(prix10);
                    
                    JPanel couleur10 = new JPanel();
                    if (this.getCouleur(9) != null) {
                        couleur10.setBackground(this.getCouleur(9));
                    }
                    tuile10.add(couleur10);
                    
                    mainPanel.add(tuile10);
                    break;
                case 11:
                    JPanel tuile11  = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom11 = new JPanel();
                    JLabel labelNom11 = new JLabel("Prison/Visite");
                    nom11.add(labelNom11);
                    tuile11.add(nom11);
                    
                    JPanel prix11 = new JPanel();
                    JLabel labelPrix11 = new JLabel("");
                    prix11.add(labelPrix11);
                    tuile11.add(prix11);
                    
                    mainPanel.add(tuile11);
                    break;
                case 12:
                    JPanel tuile40  = new JPanel(new BorderLayout());
                    
                    JPanel carte40 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom40 = new JPanel();
                    JLabel labelNom40 = new JLabel(this.getNomTuile(39));
                    nom40.add(labelNom40);
                    carte40.add(nom40);
                    
                    JPanel prix40 = new JPanel();
                    JLabel labelPrix40 = new JLabel(getPrixTuile(39));
                    prix40.add(labelPrix40);
                    carte40.add(prix40);
                    
                    tuile40.add(carte40, BorderLayout.CENTER);
                    
                    JPanel couleur40 = new JPanel();
                    if (this.getCouleur(39) != null) {
                        couleur40.setBackground(this.getCouleur(39));
                    }
                    tuile40.add(couleur40, BorderLayout.EAST);
                    
                    mainPanel.add(tuile40);
                    break;
                case 22:
                    JPanel tuile12  = new JPanel(new BorderLayout());
                    
                    JPanel carte12 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom12 = new JPanel();
                    JLabel labelNom12 = new JLabel(this.getNomTuile(11));
                    nom12.add(labelNom12);
                    carte12.add(nom12);
                    
                    JPanel prix12 = new JPanel();
                    JLabel labelPrix12 = new JLabel(getPrixTuile(11));
                    prix12.add(labelPrix12);
                    carte12.add(prix12);
                    
                    tuile12.add(carte12, BorderLayout.CENTER);
                    
                    JPanel couleur12 = new JPanel();
                    if (this.getCouleur(11) != null) {
                        couleur12.setBackground(this.getCouleur(11));
                    }
                    tuile12.add(couleur12, BorderLayout.WEST);
                    
                    mainPanel.add(tuile12);
                    break;
                case 23:
                    JPanel tuile39  = new JPanel(new BorderLayout());
                    
                    JPanel carte39 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom39 = new JPanel();
                    JLabel labelNom39 = new JLabel("Taxe de luxe");
                    nom39.add(labelNom39);
                    carte39.add(nom39);
                    
                    JPanel prix39 = new JPanel();
                    JLabel labelPrix39 = new JLabel(String.valueOf(this.cellules.getCellule(38).getImpot().getMontant()));
                    prix39.add(labelPrix39);
                    carte39.add(prix39);
                    
                    tuile39.add(carte39, BorderLayout.CENTER);
                    
                    
                    
                    mainPanel.add(tuile39);
                    break;
                case 33:
                    JPanel tuile13  = new JPanel(new BorderLayout());
                    
                    JPanel carte13 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom13 = new JPanel();
                    JLabel labelNom13 = new JLabel(this.getNomTuile(12));
                    nom13.add(labelNom13);
                    carte13.add(nom13);
                    
                    JPanel prix13 = new JPanel();
                    JLabel labelPrix13 = new JLabel(getPrixTuile(12));
                    prix13.add(labelPrix13);
                    carte13.add(prix13);
                    
                    tuile13.add(carte13, BorderLayout.CENTER);
                    
                    JPanel couleur13 = new JPanel();
                    if (this.getCouleur(12) != null) {
                        couleur13.setBackground(this.getCouleur(12));
                    }
                    tuile13.add(couleur13, BorderLayout.WEST);
                    
                    mainPanel.add(tuile13);
                    break;
                case 34:
                    JPanel tuile38  = new JPanel(new BorderLayout());
                    
                    JPanel carte38 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom38 = new JPanel();
                    JLabel labelNom38 = new JLabel(this.getNomTuile(37));
                    nom38.add(labelNom38);
                    carte38.add(nom38);
                    
                    JPanel prix38 = new JPanel();
                    JLabel labelPrix38 = new JLabel(getPrixTuile(37));
                    prix38.add(labelPrix38);
                    carte38.add(prix38);
                    
                    tuile38.add(carte38, BorderLayout.CENTER);
                    
                    JPanel couleur38 = new JPanel();
                    if (this.getCouleur(37) != null) {
                        couleur38.setBackground(this.getCouleur(37));
                    }
                    tuile38.add(couleur38, BorderLayout.EAST);
                    
                    mainPanel.add(tuile38);
                    break;
                case 37:
                    JPanel tuileCaisseDeCommu = new JPanel(new BorderLayout());
                    mainPanel.add(tuileCaisseDeCommu);
                    break;
                case 44:
                    JPanel tuile14  = new JPanel(new BorderLayout());
                    
                    JPanel carte14 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom14 = new JPanel();
                    JLabel labelNom14 = new JLabel(this.getNomTuile(13));
                    nom14.add(labelNom14);
                    carte14.add(nom14);
                    
                    JPanel prix14 = new JPanel();
                    JLabel labelPrix14 = new JLabel(getPrixTuile(13));
                    prix14.add(labelPrix14);
                    carte14.add(prix14);
                    
                    tuile14.add(carte14, BorderLayout.CENTER);
                    
                    JPanel couleur14 = new JPanel();
                    if (this.getCouleur(13) != null) {
                        couleur14.setBackground(this.getCouleur(13));
                    }
                    tuile14.add(couleur14, BorderLayout.WEST);
                    
                    mainPanel.add(tuile14);
                    break;
                case 45:
                    JPanel tuile37  = new JPanel(new BorderLayout());
                    
                    JPanel carte37 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom37 = new JPanel();
                    JLabel labelNom37 = new JLabel("Chance");
                    nom37.add(labelNom37);
                    carte37.add(nom37);
                    
                    JPanel prix37 = new JPanel();
                    JLabel labelPrix37 = new JLabel("");
                    prix37.add(labelPrix37);
                    carte37.add(prix37);
                    
                    tuile37.add(carte37, BorderLayout.CENTER);
                    
                    
                    mainPanel.add(tuile37);
                    break;
                case 55:
                    JPanel tuile15  = new JPanel(new BorderLayout());
                    
                    JPanel carte15 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom15 = new JPanel();
                    JLabel labelNom15 = new JLabel(this.getNomTuile(14));
                    nom15.add(labelNom15);
                    carte15.add(nom15);
                    
                    JPanel prix15 = new JPanel();
                    JLabel labelPrix15 = new JLabel(getPrixTuile(14));
                    prix15.add(labelPrix15);
                    carte15.add(prix15);
                    
                    tuile15.add(carte15, BorderLayout.CENTER);
                    
                    JPanel couleur15 = new JPanel();
                    if (this.getCouleur(14) != null) {
                        couleur15.setBackground(this.getCouleur(14));
                    }
                    tuile15.add(couleur15, BorderLayout.WEST);
                    
                    mainPanel.add(tuile15);
                    break;
                case 56:
                    JPanel tuile36  = new JPanel(new BorderLayout());
                    
                    JPanel carte36 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom36 = new JPanel();
                    JLabel labelNom36 = new JLabel(this.getNomTuile(35));
                    nom36.add(labelNom36);
                    carte36.add(nom36);
                    
                    JPanel prix36 = new JPanel();
                    JLabel labelPrix36 = new JLabel(getPrixTuile(35));
                    prix36.add(labelPrix36);
                    carte36.add(prix36);
                    
                    tuile36.add(carte36, BorderLayout.CENTER);
                    
                    JPanel couleur36 = new JPanel();
                    if (this.getCouleur(35) != null) {
                        couleur36.setBackground(this.getCouleur(35));
                    }
                    tuile36.add(couleur36, BorderLayout.EAST);
                    
                    mainPanel.add(tuile36);
                    break;
                    
                    
                case 61 :
                    JPanel tuile60 = new JPanel(new GridLayout(2, 1));
                    
                    JPanel nom60 = new JPanel();
                    JLabel labelNom60 = new JLabel("Cagnotte");
                    nom60.add(labelNom60);
                    tuile60.add(nom60);
                    
                    JPanel prix60 = new JPanel();
                    JLabel labelPrix60 = new JLabel(String.valueOf(cagnotte));
                    prix60.add(labelPrix60);
                    tuile60.add(prix60);
                    
                    mainPanel.add(tuile60);
                    break;
                    
                    
                case 66:
                    JPanel tuile16  = new JPanel(new BorderLayout());
                    
                    JPanel carte16 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom16 = new JPanel();
                    JLabel labelNom16 = new JLabel(this.getNomTuile(15));
                    nom16.add(labelNom16);
                    carte16.add(nom16);
                    
                    JPanel prix16 = new JPanel();
                    JLabel labelPrix16 = new JLabel(getPrixTuile(15));
                    prix16.add(labelPrix16);
                    carte16.add(prix16);
                    
                    tuile16.add(carte16, BorderLayout.CENTER);
                    
                    JPanel couleur16 = new JPanel();
                    if (this.getCouleur(15) != null) {
                        couleur16.setBackground(this.getCouleur(15));
                    }
                    tuile16.add(couleur16, BorderLayout.WEST);
                    
                    mainPanel.add(tuile16);
                    break;
                case 67:
                    JPanel tuile35  = new JPanel(new BorderLayout());
                    
                    JPanel carte35 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom35 = new JPanel();
                    JLabel labelNom35 = new JLabel(this.getNomTuile(34));
                    nom35.add(labelNom35);
                    carte35.add(nom35);
                    
                    JPanel prix35 = new JPanel();
                    JLabel labelPrix35 = new JLabel(getPrixTuile(34));
                    prix35.add(labelPrix35);
                    carte35.add(prix35);
                    
                    tuile35.add(carte35, BorderLayout.CENTER);
                    
                    JPanel couleur35 = new JPanel();
                    if (this.getCouleur(34) != null) {
                        couleur35.setBackground(this.getCouleur(34));
                    }
                    tuile35.add(couleur35, BorderLayout.EAST);
                    
                    mainPanel.add(tuile35);
                    break;
                case 77:
                    JPanel tuile17  = new JPanel(new BorderLayout());
                    
                    JPanel carte17 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom17 = new JPanel();
                    JLabel labelNom17 = new JLabel(this.getNomTuile(16));
                    nom17.add(labelNom17);
                    carte17.add(nom17);
                    
                    JPanel prix17 = new JPanel();
                    JLabel labelPrix17 = new JLabel(getPrixTuile(16));
                    prix17.add(labelPrix17);
                    carte17.add(prix17);
                    
                    tuile17.add(carte17, BorderLayout.CENTER);
                    
                    JPanel couleur17 = new JPanel();
                    if (this.getCouleur(16) != null) {
                        couleur17.setBackground(this.getCouleur(16));
                    }
                    tuile17.add(couleur17, BorderLayout.WEST);
                    
                    mainPanel.add(tuile17);
                    break;
                case 78:
                    JPanel tuile34  = new JPanel(new BorderLayout());
                    
                    JPanel carte34 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom34 = new JPanel();
                    JLabel labelNom34 = new JLabel("Caisse de communauté");
                    nom34.add(labelNom34);
                    carte34.add(nom34);
                    
                    JPanel prix34 = new JPanel();
                    JLabel labelPrix34 = new JLabel("");
                    prix34.add(labelPrix34);
                    carte34.add(prix34);
                    
                    tuile34.add(carte34, BorderLayout.CENTER);
                    
                    
                    mainPanel.add(tuile34);
                    break;
                case 85:
                    JPanel tuileChance = new JPanel(new BorderLayout());
                    mainPanel.add(tuileChance);
                    break;
                case 88:
                    JPanel tuile18  = new JPanel(new BorderLayout());
                    
                    JPanel carte18 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom18 = new JPanel();
                    JLabel labelNom18 = new JLabel("Caisse de Communauté");
                    nom18.add(labelNom18);
                    carte18.add(nom18);
                    
                    JPanel prix18 = new JPanel();
                    JLabel labelPrix18 = new JLabel("");
                    prix18.add(labelPrix18);
                    carte18.add(prix18);
                    
                    tuile18.add(carte18, BorderLayout.CENTER);
                                        
                    mainPanel.add(tuile18);
                    break;
                case 89:
                    JPanel tuile33  = new JPanel(new BorderLayout());
                    
                    JPanel carte33 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom33 = new JPanel();
                    JLabel labelNom33 = new JLabel(this.getNomTuile(32));
                    nom33.add(labelNom33);
                    carte33.add(nom33);
                    
                    JPanel prix33 = new JPanel();
                    JLabel labelPrix33 = new JLabel(getPrixTuile(32));
                    prix33.add(labelPrix33);
                    carte33.add(prix33);
                    
                    tuile33.add(carte33, BorderLayout.CENTER);
                    
                    JPanel couleur33 = new JPanel();
                    if (this.getCouleur(32) != null) {
                        couleur33.setBackground(this.getCouleur(32));
                    }
                    tuile33.add(couleur33, BorderLayout.EAST);
                    
                    mainPanel.add(tuile33);
                    break;
                case 99:
                    JPanel tuile19  = new JPanel(new BorderLayout());
                    
                    JPanel carte19 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom19 = new JPanel();
                    JLabel labelNom19 = new JLabel(this.getNomTuile(18));
                    nom19.add(labelNom19);
                    carte19.add(nom19);
                    
                    JPanel prix19 = new JPanel();
                    JLabel labelPrix19 = new JLabel(getPrixTuile(18));
                    prix19.add(labelPrix19);
                    carte19.add(prix19);
                    
                    tuile19.add(carte19, BorderLayout.CENTER);
                    
                    JPanel couleur19 = new JPanel();
                    if (this.getCouleur(18) != null) {
                        couleur19.setBackground(this.getCouleur(18));
                    }
                    tuile19.add(couleur19, BorderLayout.WEST);
                    
                    mainPanel.add(tuile19);
                    break;
                case 100:
                    JPanel tuile32  = new JPanel(new BorderLayout());
                    
                    JPanel carte32 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom32 = new JPanel();
                    JLabel labelNom32 = new JLabel(this.getNomTuile(31));
                    nom32.add(labelNom32);
                    carte32.add(nom32);
                    
                    JPanel prix32 = new JPanel();
                    JLabel labelPrix32 = new JLabel(getPrixTuile(31));
                    prix32.add(labelPrix32);
                    carte32.add(prix32);
                    
                    tuile32.add(carte32, BorderLayout.CENTER);
                    
                    JPanel couleur32 = new JPanel();
                    if (this.getCouleur(31) != null) {
                        couleur32.setBackground(this.getCouleur(31));
                    }
                    tuile32.add(couleur32, BorderLayout.EAST);
                    
                    mainPanel.add(tuile32);
                    break;
                case 110:
                    JPanel tuile20  = new JPanel(new BorderLayout());
                    
                    JPanel carte20 = new JPanel(new GridLayout(2,1));
                    
                    JPanel nom20 = new JPanel();
                    JLabel labelNom20 = new JLabel(this.getNomTuile(19));
                    nom20.add(labelNom20);
                    carte20.add(nom20);
                    
                    JPanel prix20 = new JPanel();
                    JLabel labelPrix20 = new JLabel(getPrixTuile(19));
                    prix20.add(labelPrix20);
                    carte20.add(prix20);
                    
                    tuile20.add(carte20, BorderLayout.CENTER);
                    
                    JPanel couleur20 = new JPanel();
                    if (this.getCouleur(19) != null) {
                        couleur20.setBackground(this.getCouleur(19));
                    }
                    tuile20.add(couleur20, BorderLayout.WEST);
                    
                    mainPanel.add(tuile20);
                    break;
                case 111:
                    JPanel tuile31  = new JPanel(new GridLayout(2, 1));

                    JPanel nom31 = new JPanel();
                    JLabel labelNom31 = new JLabel("Allez en prison");
                    nom31.add(labelNom31);
                    tuile31.add(nom31);
                    
                    JPanel prix31 = new JPanel();
                    JLabel labelPrix31 = new JLabel("");
                    prix31.add(labelPrix31);
                    tuile31.add(prix31);          
                    
                    mainPanel.add(tuile31);
                    break;
                case 112:
                    JPanel tuile30  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur30 = new JPanel();
                    if (this.getCouleur(29) != null) {
                        couleur30.setBackground(this.getCouleur(29));
                    }
                    tuile30.add(couleur30);

                    JPanel nom30 = new JPanel();
                    JLabel labelNom30 = new JLabel(this.getNomTuile(29));
                    nom30.add(labelNom30);
                    tuile30.add(nom30);
                    
                    JPanel prix30 = new JPanel();
                    JLabel labelPrix30 = new JLabel(getPrixTuile(29));
                    prix30.add(labelPrix30);
                    tuile30.add(prix30);          
                    
                    mainPanel.add(tuile30);
                    break;
                case 113:
                    JPanel tuile29  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur29 = new JPanel();
                    if (this.getCouleur(28) != null) {
                        couleur29.setBackground(this.getCouleur(28));
                    }
                    tuile29.add(couleur29);

                    JPanel nom29 = new JPanel();
                    JLabel labelNom29 = new JLabel(this.getNomTuile(28));
                    nom29.add(labelNom29);
                    tuile29.add(nom29);
                    
                    JPanel prix29 = new JPanel();
                    JLabel labelPrix29 = new JLabel(getPrixTuile(28));
                    prix29.add(labelPrix29);
                    tuile29.add(prix29);          
                    
                    mainPanel.add(tuile29);
                    break;
                case 114:
                    JPanel tuile28 = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur28 = new JPanel();
                    if (this.getCouleur(27) != null) {
                        couleur28.setBackground(this.getCouleur(27));
                    }
                    tuile28.add(couleur28);

                    JPanel nom28 = new JPanel();
                    JLabel labelNom28 = new JLabel(this.getNomTuile(27));
                    nom28.add(labelNom28);
                    tuile28.add(nom28);
                    
                    JPanel prix28 = new JPanel();
                    JLabel labelPrix28 = new JLabel(getPrixTuile(27));
                    prix28.add(labelPrix28);
                    tuile28.add(prix28);          
                    
                    mainPanel.add(tuile28);
                    break;
                case 115:
                    JPanel tuile27  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur27 = new JPanel();
                    if (this.getCouleur(26) != null) {
                        couleur27.setBackground(this.getCouleur(26));
                    }
                    tuile27.add(couleur27);

                    JPanel nom27 = new JPanel();
                    JLabel labelNom27 = new JLabel(this.getNomTuile(26));
                    nom27.add(labelNom27);
                    tuile27.add(nom27);
                    
                    JPanel prix27 = new JPanel();
                    JLabel labelPrix27 = new JLabel(getPrixTuile(26));
                    prix27.add(labelPrix27);
                    tuile27.add(prix27);          
                    
                    mainPanel.add(tuile27);
                    break;
                case 116:
                    JPanel tuile26  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur26 = new JPanel();
                    if (this.getCouleur(25) != null) {
                        couleur26.setBackground(this.getCouleur(25));
                    }
                    tuile26.add(couleur26);

                    JPanel nom26 = new JPanel();
                    JLabel labelNom26 = new JLabel(this.getNomTuile(25));
                    nom26.add(labelNom26);
                    tuile26.add(nom26);
                    
                    JPanel prix26 = new JPanel();
                    JLabel labelPrix26 = new JLabel(getPrixTuile(25));
                    prix26.add(labelPrix26);
                    tuile26.add(prix26);          
                    
                    mainPanel.add(tuile26);
                    break;
                case 117:
                    JPanel tuile25  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur25 = new JPanel();
                    if (this.getCouleur(24) != null) {
                        couleur25.setBackground(this.getCouleur(24));
                    }
                    tuile25.add(couleur25);

                    JPanel nom25 = new JPanel();
                    JLabel labelNom25 = new JLabel(this.getNomTuile(24));
                    nom25.add(labelNom25);
                    tuile25.add(nom25);
                    
                    JPanel prix25 = new JPanel();
                    JLabel labelPrix25 = new JLabel(getPrixTuile(24));
                    prix25.add(labelPrix25);
                    tuile25.add(prix25);          
                    
                    mainPanel.add(tuile25);
                    break;
                case 118:
                    JPanel tuile24  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur24 = new JPanel();
                    if (this.getCouleur(23) != null) {
                        couleur24.setBackground(this.getCouleur(23));
                    }
                    tuile24.add(couleur24);

                    JPanel nom24 = new JPanel();
                    JLabel labelNom24 = new JLabel(this.getNomTuile(23));
                    nom24.add(labelNom24);
                    tuile24.add(nom24);
                    
                    JPanel prix24 = new JPanel();
                    JLabel labelPrix24 = new JLabel(getPrixTuile(23));
                    prix24.add(labelPrix24);
                    tuile24.add(prix24);          
                    
                    mainPanel.add(tuile24);
                    break;
                case 119:
                    JPanel tuile23  = new JPanel(new GridLayout(2, 1));
                    
                    

                    JPanel nom23 = new JPanel();
                    JLabel labelNom23 = new JLabel("Chance");
                    nom23.add(labelNom23);
                    tuile23.add(nom23);
                    
                    JPanel prix23 = new JPanel();
                    JLabel labelPrix23 = new JLabel("");
                    prix23.add(labelPrix23);
                    tuile23.add(prix23);          
                    
                    mainPanel.add(tuile23);
                    break;
                case 120:
                    JPanel tuile22  = new JPanel(new GridLayout(3, 1));
                    
                    JPanel couleur22 = new JPanel();
                    if (this.getCouleur(21) != null) {
                        couleur22.setBackground(this.getCouleur(21));
                    }
                    tuile22.add(couleur22);

                    JPanel nom22 = new JPanel();
                    JLabel labelNom22 = new JLabel(this.getNomTuile(21));
                    nom22.add(labelNom22);
                    tuile22.add(nom22);
                    
                    JPanel prix22 = new JPanel();
                    JLabel labelPrix22 = new JLabel(getPrixTuile(21));
                    prix22.add(labelPrix22);
                    tuile22.add(prix22);          
                    
                    mainPanel.add(tuile22);
                    break;
                case 121:
                    JPanel tuile21  = new JPanel(new GridLayout(2, 1));

                    JPanel nom21 = new JPanel();
                    JLabel labelNom21 = new JLabel("Parc Gratuit");
                    nom21.add(labelNom21);
                    tuile21.add(nom21);
                    
                    JPanel prix21 = new JPanel();
                    JLabel labelPrix21 = new JLabel("");
                    prix21.add(labelPrix21);
                    tuile21.add(prix21);          
                    
                    mainPanel.add(tuile21);
                    break;
                    
                
                default:
                    JPanel tuile = new JPanel(new BorderLayout());
                    tuile.setBackground(Color.GRAY);
                    mainPanel.add(tuile);
                    
            }
        }
        
        //this.f_Plateau.add(mainPanel);
       this.add(mainPanel);
    }
    
    public String getNomTuile(int numéro){
        return this.cellules.getCellule(numéro).getNomCellule();
        
    }
    
    public String getPrixTuile(int numéro){
        if (this.cellules.getCellule(numéro).getPropriete().getProprietaire().getNom() == "banque")
        {
        return String.valueOf(this.cellules.getCellule(numéro).getPropriete().getPrixAchat());
        }
        else
        {
            return String.valueOf(this.cellules.getCellule(numéro).getPropriete().getLoyer());
        }
    }
    
    public Color getCouleur(int numéro){
        String s = (String) this.cellules.getCellule(numéro).getPropriete().getCouleur();
        
        switch (s)
        {
            case "RED":
                return Color.RED;
                
            case "PINK":
                return Color.PINK;
                
            case "PURPLE":
                return Color.BLACK;
            
            case "YELLOW":
                return Color.YELLOW;
            
            case "GREEN":
                return Color.GREEN;
                
            case "BLUE" : 
                return Color.BLUE;
             
            case "CYAN" : 
                return Color.CYAN;
                
            case "ORANGE":
                return Color.ORANGE;
                
            default :
                return Color.WHITE;
                
                 }
        
        
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

    public void setCellules(Plateau cellules) {
        this.cellules = cellules;
    }

    public void setCagnotte(int cagnotte) {
        this.cagnotte = cagnotte;
    }
    
    
    
}
