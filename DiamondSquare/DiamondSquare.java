package DiamondSquare;
import java.util.Random;

public class DiamondSquare {
	// Attributs de la class DiamondSquare
    private static Random random = new Random();
    private static Grille grille;

    public static void main(String[] args) {
    	// Récupération des valeurs envoyés du main
        int TAILLE = Integer.parseInt(args[0]);
        int VARIATION_MIN = Integer.parseInt(args[1]);
        int VARIATION_MAX = Integer.parseInt(args[2]);
        
        // Calcul de la taille de la grille
        int TAILLE_GRILLE = (int) Math.pow(2, TAILLE) + 1;
        
        // Création et initialisation de la grille
        grille = new Grille(TAILLE_GRILLE);
        initialiserGrille(grille, TAILLE_GRILLE);

        int i = TAILLE_GRILLE - 1;
        
        while (i > 1) {
            int id = i / 2;
            // Partie Diamond
            for (int x = id; x < TAILLE_GRILLE; x += i) {
                for (int y = id; y < TAILLE_GRILLE; y += i) {
                    int moyenne = calculerMoyenne(x, y, id, VARIATION_MIN, VARIATION_MAX);
                    grille.getPoint(x, y).setH(moyenne);
                }
            }

            int decalage = 0;
            // Partie Square
            for (int x = 0; x < TAILLE_GRILLE; x += id) {
                if (decalage == 0) {
                    decalage = id;
                } else {
                    decalage = 0;
                }

                for (int y = decalage; y < TAILLE_GRILLE; y += i) {
                    int nouvelleHauteur = calculerNouvelleHauteur(x, y, id, VARIATION_MIN, VARIATION_MAX);
                    grille.getPoint(x, y).setH(nouvelleHauteur);
                }
            }

            i = id;
        }
    }

    // Getter pour la grille
    public static Grille getGrille() {
        return grille;
    }
    
    // Méthode pour renvoyer un nombre aléatoire entre 2 bornes données
    private static int rand(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    // Méthode pour initialiser les 4 coins de la carte
    private static void initialiserGrille(Grille grille, int tailleGrille) {
    	// grille.getPoint(0, 0).setH((10));
    	// grille.getPoint(0, tailleGrille - 1).setH((10));
    	// grille.getPoint(tailleGrille - 1, 0).setH((10));
    	// grille.getPoint(tailleGrille - 1, tailleGrille - 1).setH((10));
    	
        grille.getPoint(0, 0).setH(genererHauteurAleatoire());
        grille.getPoint(0, tailleGrille - 1).setH(genererHauteurAleatoire());
        grille.getPoint(tailleGrille - 1, 0).setH(genererHauteurAleatoire());
        grille.getPoint(tailleGrille - 1, tailleGrille - 1).setH(genererHauteurAleatoire());
    }

    // Méthode pour générer une hauteur alétoire dans la plage 0, 10
    private static int genererHauteurAleatoire() {
        return rand(0, 10);
    }
    
    // Méthode qui permet de calculer la phase Diamond de l'algotithme
    private static int calculerMoyenne(int x, int y, int id, int min, int max) {
    	int moyenne = (
    			grille.getPoint(x - id, y - id).getH() + 
    			grille.getPoint(x - id, y + id).getH() + 
    			grille.getPoint(x + id, y + id).getH() + 
    			grille.getPoint(x + id, y - id).getH() ) 
    			/ 4;
        while (moyenne > 10) {
            moyenne -= rand(min, max);
        }
        while (moyenne < 0) {
            moyenne += rand(min, max);
        }
        return moyenne;
    }
    
    // Méthode qui permet de calculer la phase Square de l'algorithme
    private static int calculerNouvelleHauteur(int x, int y, int id, int min, int max) {
        int somme = 0;
        int n = 0;

        if (x - id >= 0) {
            somme += grille.getPoint(x - id, y).getH();
            n++;
        }
        if (x + id < grille.getTailleGrille()) {
            somme += grille.getPoint(x + id, y).getH();
            n++;
        }
        if (y - id >= 0) {
            somme += grille.getPoint(x, y - id).getH();
            n++;
        }
        if (y + id < grille.getTailleGrille()) {
            somme += grille.getPoint(x, y + id).getH();
            n++;
        }
        
        int nouvelleHauteur = (somme / n + rand(-2, 2));
        
        while (nouvelleHauteur > 10) {
            nouvelleHauteur -= rand(min, max);
        }
        while (nouvelleHauteur < 0) {
            nouvelleHauteur += rand(min, max);
        }
        return (nouvelleHauteur);
    }
}
