import DiamondSquare.Grille;
import DiamondSquare.DiamondSquare;
import DiamondSquare.AffichageGrille;
import DiamondSquare.Lissage;

public class Main {
	public static void main(String[] args) {
	// Variables de génération
      int TAILLE = 7;
      int VARIATION_MIN = 3;
      int VARIATION_MAX = 4;
      
      int TAILLE_FENETRE = 1000;
	  
      int nombre_cartes_generees = 1;
      int nombre_lissage = 1;

      // Génération des cartes 
      for (int i = 0; i < nombre_cartes_generees; i++) {
    	  DiamondSquare.main(new String[]{String.valueOf(TAILLE), String.valueOf(VARIATION_MIN), String.valueOf(VARIATION_MAX)});
    	  Grille grille = DiamondSquare.getGrille();
    	  // Lissage des cartes
		  for (int j = 0; j < nombre_lissage; j++) {
			  Lissage.lisserGrille(grille);
		  }
		  // Affichage des cartes
	      AffichageGrille affichage = new AffichageGrille(grille, TAILLE_FENETRE);
	      affichage.setVisible(true);
	      }
     }
}
