/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Sud extends JPanel{
    private JLabel nomJCourrant;
    private JLabel fortuneJCourrant, prixCaseCourrante, nomCaseCourrante;
    
    public Vue_Sud(){
        
        
        this.setLayout(new GridLayout(2,1));
        JPanel rouge = new JPanel();
        rouge.setBackground(Color.red);
        this.nomJCourrant = new JLabel("AAAAAAAAA");
        rouge.add(nomJCourrant);
        this.add(rouge);
        
        JPanel infos = new JPanel();
        JPanel joueurCase = new JPanel(new GridLayout(3,1));
        
        this.nomCaseCourrante = new JLabel("aaaaaaaaa");
        joueurCase.add(nomCaseCourrante);
        this.prixCaseCourrante = new JLabel("bbbbbbbbb");
        joueurCase.add(prixCaseCourrante);
        this.fortuneJCourrant = new JLabel("ccccccccc");
        joueurCase.add(fortuneJCourrant);
        infos.add(joueurCase);
        this.add(infos);
        
    }
    
    public JLabel getNomJCourrant() {
        return this.nomJCourrant;
    }

    private Color getCouleurJCourant() {
        return Color.BLACK;
        }

    public JLabel getFortuneJCourrant() {
        return this.fortuneJCourrant;
    }

    public JLabel getPrixCaseCourrante() {
        return this.prixCaseCourrante;
    }

    public JLabel getNomCaseCourrante() {
        return this.nomCaseCourrante;
    }

    

    public void setNomJCourrant(JLabel nomJCourrant) {
        this.nomJCourrant = nomJCourrant;
    }

    public void setFortuneJCourrant(String fortuneJCourrant) {
        this.fortuneJCourrant.setText(fortuneJCourrant);
    }

    public void setPrixCaseCourrante(JLabel prixCaseCourrante) {
        this.prixCaseCourrante = prixCaseCourrante;
    }

    public void setNomCaseCourrante(JLabel nomCaseCourrante) {
        this.nomCaseCourrante = nomCaseCourrante;
    }
    
}
