package tppoo;

import java.util.ArrayList;
import java.util.Collection;

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
	public boolean couvrePoint(Point p) {
		return (getCentre().distance(p) <= getRayon());
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		code += (getTypeInt() * 1000000);
		code += (getCentre().getX() * 10000);
		code += (getCentre().getY() * 100);
		code += getRayon();
		return code;
	}
	
	@Override
	public int getTypeInt() {
		return 2;
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
	public Collection<Point> getPoints() {
		/*
		 * On utilise un peu ce qu'on veut vu qu'il n'y aura qu'un point #osef
		 */
		ArrayList<Point> tab = new ArrayList<Point>();
		tab.add(getCentre());
		return tab;
	}
	
	@Override
	public boolean equals (Object o) {
		boolean egal = false;
		if (o instanceof Rond) {
			Rond r = (Rond) o;
			boolean p1, p2;
			p1 = getCentre().equals(r.getCentre());
			p2 = getRayon() == r.getRayon();
			egal = p1 && p2;
		}
		return egal;
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
