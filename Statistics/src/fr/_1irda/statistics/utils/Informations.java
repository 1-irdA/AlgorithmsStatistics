/*
 * Informations.java                                      7 d�c. 2020
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
                "Pire : O(n�)", 
                "Moyenne : O(n�)", 
                "Meilleure : O(n)" 
            },

            { "Tri � bulles", 
                "Pire : O(n�)", 
                "Moyenne : O(n�)", 
                "Meilleure : O(n)" 
            },

            { "Tri � bulles optimis�", 
                "Pire : O(n�)", 
                "Moyenne : O(n�)",
                "Meilleure : O(n)" 
            },

            { "Tri � peigne", 
                "Pire : O(n�)", 
                "Moyenne : O(n�)", 
                "Meilleure : O(n log n)" 
            },

            { "Tri par s�lection", 
                "Pire : O(n�)", 
                "Moyenne : O(n�)", 
                "Meilleure : O(n�)k" 
            }
    };
}
