/*
 * AboutController.java                                      8 d�c. 2020
 * L3 MIASHS option MIAGE Groupe de Rodez 2020-2021
 * Pas de copyright, aucun droit sur ce source
 */
package fr._1irda.statistics.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author garro
 *
 */
public class AboutController {
    
    /** About project langage */
    private static final String ABOUT =  
            "Projet r�alis� en Java avec JavaFX et Scene Builder.";
    
    /** About project */
    private static final String ABOUT_PROJECT =
            "Ce logiciel permet de regarder le temps de tri des tableaux "
            + "suivant leur taille, \n"
            + "l'ordre des �l�ments dans les tableaux et "
            + "l'algorithme de tri utilis�.\n\n"
            + "Possibilit� de g�n�rer un graphique, de l'enregistrer, "
            + "de sauvegarder les r�sultats \n"
            + "pour les consulter plus tard.\n\n"
            + "Le d�tail des tirages est disponible apr�s la g�n�ration des "
            + "tests et �galement \nen sauvegarde.";
    
    /** Label java */
    @FXML
    private Label labelJava;
    
    /** Label to explain project */
    @FXML
    private Label labelAbout;
    
    /**
     * Initialize widgets 
     */
    @FXML
    public void initialize() {
        labelJava.setText(ABOUT);
        labelAbout.setText(ABOUT_PROJECT);
    }
}
