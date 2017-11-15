package tppoo;

public class Rond extends Figure implements Surfacable{
	private Point centre;
	private int rayon;
	
	public Rond (Point c, int r) {
		super("ROND");
		centre = c;
		rayon = r;
		
	}
	
	/*
	 * Methodes
	 */
	
	@Override
	public String toString () {
		return ("[ROND "+ centre.toString() + " , " + rayon + "]");
	}
	
	@Override
	public double surface() {
		return (Math.PI * Math.pow(this.getRayon(), 2));
	}
	
	@Override
	public int nbPoints() {
		return 1;
	}
	
	@Override
	public Point[] getPointsFigure() {
		Point[] tab = new Point [nbPoints()];
		tab[0] = getCentre();
		return tab;
	}
	
	/*
	 * Accesseurs
	 */
	
	protected Point getCentre() {
		return centre;
	}

	protected void setCentre(Point centre) {
		this.centre = centre;
	}

	protected int getRayon() {
		return rayon;
	}

	protected void setRayon(int rayon) {
		this.rayon = rayon;
	}
}
