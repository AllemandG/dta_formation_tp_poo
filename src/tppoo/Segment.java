package tppoo;

public class Segment extends Figure{
	private Point debut;
	private Point fin;
	
	public Segment (Point debut, int longeur, boolean horizontal) {
		super("SEGMENT");
		this.debut = debut;
		if (horizontal) {
			this.fin = new Point(debut.getX() + longeur,debut.getY());
		} else {
			this.fin = new Point(debut.getX(),debut.getY() + longeur);
		}
		
	}
	
	@Override
	public String toString() {
		return ("de " + debut.toString() + " à " + fin.toString());
	}
	
	@Override
	public int nbPoints() {
		return 2;
	}
	
	@Override
	public Point[] getPointsFigure() {
		Point[] tab = new Point [nbPoints()];
		tab[0] = getDebut();
		tab[1] = getFin();
		return tab;
	}
	
	protected Point getDebut() {
		return debut;
	}

	protected void setDebut(Point debut) {
		this.debut = debut;
	}

	protected Point getFin() {
		return fin;
	}

	protected void setFin(Point fin) {
		this.fin = fin;
	}
}
