/*
 * AboutController.java                                      8 déc. 2020
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
            "Projet réalisé en Java avec JavaFX et Scene Builder.";
    
    /** About project */
    private static final String ABOUT_PROJECT =
            "Ce logiciel permet de regarder le temps de tri des tableaux "
            + "suivant leur taille, \n"
            + "l'ordre des éléments dans les tableaux et "
            + "l'algorithme de tri utilisé.\n\n"
            + "Possibilité de générer un graphique, de l'enregistrer, "
            + "de sauvegarder les résultats \n"
            + "pour les consulter plus tard.\n\n"
            + "Le détail des tirages est disponible après la génération des "
            + "tests et également \nen sauvegarde.";
    
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
