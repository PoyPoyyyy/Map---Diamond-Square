package DiamondSquare;
import javax.swing.*;
import java.awt.*;

public class AffichageGrille extends JFrame {
    private Grille grille;
    public AffichageGrille(Grille grille, int TAILLE_FENETRE) {
        this.grille = grille;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(TAILLE_FENETRE, TAILLE_FENETRE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(grille.getTailleGrille(), grille.getTailleGrille()));

        for (int i = 0; i < grille.getTailleGrille(); i++) {
            for (int j = 0; j < grille.getTailleGrille(); j++) {
                Color couleur = Couleur.associerCouleur(grille.getPoint(i, j).getH());
                JPanel cellule = new JPanel();
                cellule.setBackground(couleur);
                panel.add(cellule);
            }
        }

        add(panel);
        setVisible(true);
    }
}
