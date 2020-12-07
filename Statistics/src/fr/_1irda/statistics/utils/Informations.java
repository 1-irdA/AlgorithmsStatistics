/*
 * Informations.java                                      7 déc. 2020
 * L3 MIASHS option MIAGE Groupe de Rodez 2020-2021
 * Pas de copyright, aucun droit sur ce source
 */
package fr._1irda.statistics.utils;

/**
 * @author garro
 *
 */
public class Informations {

    /** Algorithm details */
    public static final String[][] ALGO_DETAILS = {
            /* Name, Worst, Average, Better */
            { "Tri par insertion", 
                "Pire : O(n²)", 
                "Moyenne : O(n²)", 
                "Meilleure : O(n)" 
            },

            { "Tri à bulles", 
                "Pire : O(n²)", 
                "Moyenne : O(n²)", 
                "Meilleure : O(n)" 
            },

            { "Tri à bulles optimisé", 
                "Pire : O(n²)", 
                "Moyenne : O(n²)",
                "Meilleure : O(n)" 
            },

            { "Tri à peigne", 
                "Pire : O(n²)", 
                "Moyenne : O(n²)", 
                "Meilleure : O(n log n)" 
            },

            { "Tri par sélection", 
                "Pire : O(n²)", 
                "Moyenne : O(n²)", 
                "Meilleure : O(n²)k" 
            }
    };
}
