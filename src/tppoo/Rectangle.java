package tppoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class Rectangle extends Figure implements Surfacable {
	/*
	 * sommets[0] = BasGauche 
	 * sommets[1] = BasDroit 
	 * sommets[2] = HautDroit
	 * sommets[3] = HautGauche
	 */
	private ArrayList<Point> sommets;

	Rectangle(Point sommet, int largeur, int hauteur, String type) {
		super(type);
		creerPoints(sommet, largeur, hauteur);
	}

	public Rectangle(Point sommet, int largeur, int hauteur) {
		this(sommet, largeur, hauteur, "RECT");
	}

	/*
	 * Methodes
	 */

	@Override
	public String toString() {
		String rectangleString = "[" + getType() + " " + sommetsToString() + "]";
		return rectangleString;
	}

	@Override
	public boolean couvrePoint(Point p) {
		int xMin, xMax, yMin, yMax;
		xMin = getPointBasGauche().getX();
		yMin = getPointBasGauche().getY();
		xMax = getPointHautDroite().getX();
		yMax = getPointHautDroite().getY();
		/*
		 * Test pour vérifier que les coordonnées de p sont comprises dans celles du
		 * rectangle
		 */
		return ((p.getX() >= xMin) && (p.getX() <= xMax) && (p.getY() >= yMin) && (p.getY() <= yMax));
	}

	@Override
	public int hashCode() {
		int code = 0;
		code += (getTypeInt() * 100000000);
		code += (getPointHautGauche().getX() * 1000000);
		code += (getPointHautGauche().getX() * 10000);
		code += (getLargeurX() * 100);
		code += getLargeurY();
		return code;
	}

	@Override
	public int getTypeInt() {
		return 1;
	}

	public String sommetsToString() {
		String sommetsString = "";
		for (Point p : sommets) {
			sommetsString += p.toString();
		}
		return sommetsString;
	}

	@Override
	public double surface() {
		double l1, l2;
		l1 = getPointHautGauche().distance(getPointHautDroite());
		l2 = getPointHautGauche().distance(getPointBasGauche());
		return (l1 * l2);
	}

	@Override
	public int nbPoints() {
		return 4;
	}

	@Override
	public Collection<Point> getPoints() {
		/*
		 * On utilise un set car on ne veut pas de doublons. Tous les points de la
		 * figure sont différents
		 */
		LinkedHashSet<Point> tab = new LinkedHashSet<Point>();
		tab.add(getPointBasGauche());
		tab.add(getPointBasDroite());
		tab.add(getPointHautGauche());
		tab.add(getPointHautDroite());
		return tab;
	}

	@Override
	public boolean equals(Object o) {
		boolean egal = false;
		if (o instanceof Rectangle) {
			Rectangle r = (Rectangle) o;
			boolean p1, p2, p3, p4;
			p1 = getPointBasGauche().equals(r.getPointBasGauche());
			p2 = getPointBasDroite().equals(r.getPointBasDroite());
			p3 = getPointHautGauche().equals(r.getPointHautGauche());
			p4 = getPointHautDroite().equals(r.getPointHautDroite());
			egal = p1 && p2 && p3 && p4;
		}
		return egal;
	}

	/*
	 * Fonction de création des 4 points du rectangle pour l'initialisation.
	 */
	private void creerPoints(Point s, int longX, int longY) {
		sommets = new ArrayList<Point>();

		/*
		 * s0 = BasGauche 
		 * s1 = BasDroite 
		 * s2 = HautDroite 
		 * s3 = HautGauche
		 */
		Point s0, s1, s2, s3;

		s0 = new Point(s.getX(), s.getY());
		s1 = new Point(s.getX() + longX, s.getY());
		s2 = new Point(s.getX() + longX, s.getY() + longY);
		s3 = new Point(s.getX(), s.getY() + longY);

		sommets.add(s0);
		sommets.add(s1);
		sommets.add(s2);
		sommets.add(s3);
	}

	/*
	 * Accesseurs
	 */

	public Point getPointBasGauche() {
		return sommets.get(0);
	}

	public Point getPointBasDroite() {
		return sommets.get(1);
	}

	public Point getPointHautDroite() {
		return sommets.get(2);
	}

	public Point getPointHautGauche() {
		return sommets.get(3);
	}

	public int getLargeurX() {
		return (getPointBasDroite().getX() - getPointBasGauche().getX());
	}

	public int getLargeurY() {
		return (getPointBasDroite().getY() - getPointBasGauche().getY());
	}

}
