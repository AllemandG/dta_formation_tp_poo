package tppoo;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Segment extends Figure {
	private Point debut;
	private Point fin;

	public Segment(Point debut, int longeur, boolean horizontal) {
		super("SEGMENT");
		this.debut = debut;
		if (horizontal) {
			this.fin = new Point(debut.getX() + Math.abs(longeur), debut.getY());
		} else {
			this.fin = new Point(debut.getX(), debut.getY() + Math.abs(longeur));
		}

	}

	@Override
	public String toString() {
		return ("de " + debut.toString() + " à " + fin.toString());
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		code += (getTypeInt() * 10000000);
		code += (getDebut().getX() * 100000);
		code += (getDebut().getY() * 1000);
		code += (getLongueur() * 10);
		code += getHorizontalInt();
		return code;
	}

	@Override
	public boolean couvrePoint(Point p) {
		boolean couvert = false;
		if (debut.getY() == fin.getY()) { // Segment horizontal
			if (p.getY() == debut.getY() && (p.getX() >= debut.getX() && p.getX() <= fin.getX())) {
				couvert = true;
			}
		} else { // Segment vertical
			if (p.getX() == debut.getX() && (p.getY() >= debut.getY() && p.getY() <= fin.getY())) {
				couvert = true;
			}
		}
		return couvert;
	}
	
	@Override
	public int getTypeInt() {
		return 3;
	}

	@Override
	public int nbPoints() {
		return 2;
	}

	@Override
	public Collection<Point> getPoints() {
		/*
		 * On utilise un set car on ne veut pas de doublons. Tous les points de la
		 * figure sont différents
		 */
		LinkedHashSet<Point> tab = new LinkedHashSet<Point>();
		tab.add(getDebut());
		tab.add(getFin());
		return tab;
	}
	
	@Override
	public boolean equals (Object o) {
		boolean egal = false;
		if (o instanceof Segment) {
			Segment s = (Segment) o;
			boolean p1, p2;
			p1 = getDebut().equals(s.getDebut());
			p2 = getFin().equals(s.getFin());
			egal = p1 && p2;
		}
		return egal;
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
	
	public int  getLongueur () {
		if (getHorizontal()) {
			return fin.getX() - debut.getX();
		} else {
			return fin.getY() - debut.getY();
		}
	}
	
	public int getHorizontalInt () {
		return ( (getDebut().getY() == getFin().getY())?1:0 );
	}
	
	public boolean getHorizontal () {
		return (getDebut().getY() == getFin().getY());
	}
}
