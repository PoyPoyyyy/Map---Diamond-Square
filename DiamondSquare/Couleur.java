package DiamondSquare;
import java.awt.Color;

public class Couleur {
	// Attribut de la class Couleur
	// Liste des couleurs qui seront affichées
    private static final Color[] COULEURS = {
            new Color(25, 3, 124),
            new Color(96, 74, 196),
            new Color(170, 218, 249),
            new Color(232, 249, 170),
            new Color(44, 234, 125),
            new Color(18, 162, 79),
            new Color(11, 95, 47),
            new Color(154, 153, 160),
            new Color(64, 63, 66),
            new Color(71, 71, 71),
            new Color(255, 255, 255),
            new Color(255, 255, 255),
    };

    // Méthode pour associer une hauteur à une couleur 
    public static Color associerCouleur(int hauteur) {
        int indiceCouleur = (int) (hauteur / 1.0);
        return COULEURS[Math.min(indiceCouleur, COULEURS.length - 1)];
    }
}
