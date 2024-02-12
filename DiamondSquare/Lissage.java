package DiamondSquare;

import DiamondSquare.Grille;

public class Lissage {
    public static void lisserGrille(Grille grille) {
        int tailleGrille = grille.getTailleGrille();

        for (int x = 1; x < tailleGrille - 1; x++) {
            for (int y = 1; y < tailleGrille - 1; y++) {
                lisserPoint(grille, x, y);
            }
        }
    }

    private static void lisserPoint(Grille grille, int x, int y) {
    	int nombre_differences = 1;
    	
        int valeurActuelle = grille.getPoint(x, y).getH();
        
        int valeurDessus = grille.getPoint(x, y - 1).getH();
        int valeurDroite = grille.getPoint(x + 1, y).getH();
        int valeurGauche = grille.getPoint(x - 1, y).getH();
        int valeurDessous = grille.getPoint(x, y + 1).getH();
        
        if (valeurActuelle != valeurDessus) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurDroite) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurGauche) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurDessous) {
        	nombre_differences++;
        }
        
        int valeurDiagonaleHautDroit = grille.getPoint(x + 1, y - 1).getH();
        int valeurDiagonaleHautGauche = grille.getPoint(x - 1, y - 1).getH();
        int valeurDiagonaleBasDroit = grille.getPoint(x + 1, y + 1).getH();
        int valeurDiagonaleBasGauche = grille.getPoint(x - 1, y + 1).getH();
        
        if (valeurActuelle != valeurDiagonaleHautDroit) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurDiagonaleHautGauche) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurDiagonaleBasDroit) {
        	nombre_differences++;
        }
        if (valeurActuelle != valeurDiagonaleBasGauche) {
        	nombre_differences++;
        }
        
        
        //if (valeurActuelle < valeurDessus && valeurActuelle < valeurDroite &&
        //    valeurActuelle < valeurGauche && valeurActuelle < valeurDessous) {
        if (nombre_differences > 6) {
            int nouvelleValeur = (valeurDessus + valeurDroite + valeurGauche + valeurDessous) / 4;
            grille.getPoint(x, y).setH(nouvelleValeur); 
        }
    }
}
