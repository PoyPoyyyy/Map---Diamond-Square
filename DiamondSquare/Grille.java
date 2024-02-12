package DiamondSquare;

public class Grille {
	// Attributs de la class Grille
    private int tailleGrille;
    private Point[][] grille;

    // Méthode qui initialisse une grille à partir de la class Point
    // La hauteur est initialisée à 0
    // Prend en paramètre la taille de la grille calculée à partir de cette formule (int) Math.pow(2, TAILLE) + 1
    public Grille(int tailleGrille) {
        this.tailleGrille = tailleGrille;
        this.grille = new Point[tailleGrille][tailleGrille];

        for (int i = 0; i < tailleGrille; i++) {
            for (int j = 0; j < tailleGrille; j++) {
                grille[i][j] = new Point(i, j, 0);
            }
        }
    }

    // Getter pour la taille de la grille
    public int getTailleGrille() {
        return tailleGrille;
    }
    
    // Getter pour obtenir les coordonnées x, y d'un point
    public Point getPoint(int x, int y) {
        return grille[x][y];
    }
}
