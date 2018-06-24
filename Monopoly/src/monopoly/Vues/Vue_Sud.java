/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.Vues;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quentin
 */
public class Vue_Sud extends JPanel{
    private JLabel nomJCourrant, labelConsole;
    private JLabel fortuneJCourrant, prixCaseCourrante, nomCaseCourrante;
    
    
    public Vue_Sud(){
        
        
        this.setLayout(new GridLayout(1,2));
        JPanel infoJoueur = new JPanel(new GridLayout(2,1));
        JPanel rouge = new JPanel();
        rouge.setBackground(Color.red);
        this.nomJCourrant = new JLabel("AAAAAAAAA");
        rouge.add(nomJCourrant);
        infoJoueur.add(rouge);
        
        JPanel infos = new JPanel();
        JPanel joueurCase = new JPanel(new GridLayout(3,1));
        
        this.nomCaseCourrante = new JLabel("aaaaaaaaa");
        joueurCase.add(nomCaseCourrante);
        this.prixCaseCourrante = new JLabel("bbbbbbbbb");
        joueurCase.add(prixCaseCourrante);
        this.fortuneJCourrant = new JLabel("ccccccccc");
        joueurCase.add(fortuneJCourrant);
        infos.add(joueurCase);
        infoJoueur.add(infos);
        this.add(infoJoueur);
        
        JPanel console = new JPanel();
        this.labelConsole = new JLabel("Etat");
        console.add(labelConsole);
        this.add(console);
        
    }
    
    public JLabel getNomJCourrant() {
        return this.nomJCourrant;
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

    public JLabel getLabelConsole() {
        return labelConsole;
    }

    public void setLabelConsole(JLabel labelConsole) {
        this.labelConsole = labelConsole;
    }

    

    public void setNomJCourrant(String nomJCourrant) {
        this.nomJCourrant.setText(nomJCourrant);
    }

    public void setFortuneJCourrant(String fortuneJCourrant) {
        this.fortuneJCourrant.setText(fortuneJCourrant);
    }

    public void setPrixCaseCourrante(String prixCaseCourrante) {
        this.prixCaseCourrante.setText(prixCaseCourrante);
    }

    public void setNomCaseCourrante(String nomCaseCourrante) {
        this.nomCaseCourrante.setText(nomCaseCourrante);
    }
    
}
