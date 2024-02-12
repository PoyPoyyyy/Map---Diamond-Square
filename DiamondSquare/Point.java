package DiamondSquare;

public class Point {
	// Attributs de la class Point
    private int x;
    private int y;
    private int h;

    // Constructeur par défaut
    public Point() {
        this.x = 0;
        this.y = 0;
        this.h = 0;
    }
    
    // constructeur
    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
    
    // Getter de hauteur d'un point
    public int getH() {
        return h;
    }

    // Setteur de hauteur d'un point
    public void setH(int h) {
        this.h = h;
    }

    // toString de hauteur d'un point
    public String toString() {
        return Integer.toString(this.h);
    }
}
