package tppoo;

import java.util.ArrayList;

public class Rectangle extends Figure implements Surfacable {
	/*
	 * sommets[0] = BasGauche
	 * sommets[1] = BasDroit
	 * sommets[2] = HautDroit
	 * sommets[3] = HautGauche
	 */
	private ArrayList<Point> sommets;
	
	Rectangle (Point sommet, int largeur, int hauteur, String type) {
		super(type);
		sommets = creerPoints(sommet, largeur, hauteur);
	}
	
	public Rectangle (Point sommet, int largeur, int hauteur) {
		this(sommet, largeur, hauteur, "RECT");
	}
	
	/*
	 * Methodes
	 */
	
	@Override
	public String toString () {
		String rectangleString = "["+ getType() +" "+ sommetsToString() +"]";
		return rectangleString;
	}

	public String sommetsToString() {
		String sommetsString = "";
		for (Point p : sommets) {
			sommetsString += p.toString();
		}
		return sommetsString;
	}
	
	@Override
	public double surface () {
		double l1, l2;
		l1 = getPointHautGauche().distance( getPointHautDroite() );
		l2 = getPointHautGauche().distance( getPointBasGauche() );
		return ( l1 * l2 );
	}
	
	@Override
	public int nbPoints() {
		return 4;
	}
	
	@Override
	public Point[] getPointsFigure() {
		Point[] tab = new Point [nbPoints()];
		tab[0] = getPointBasGauche();
		tab[1] = getPointBasDroite();
		tab[2] = getPointHautGauche();
		tab[3] = getPointHautDroite();
		return tab;
	}
	
	/*
	 * Fonction de création des 4 points du rectangle pour l'initialisation.
	 */
	private ArrayList<Point> creerPoints (Point s, int longX, int longY) {
		ArrayList<Point> listeSommets = new ArrayList<Point>();
		
		/* s0 = BasGauche
		 * s1 = BasDroite
		 * s2 = HautDroite
		 * s3 = HautGauche
		 */
		Point s0, s1, s2, s3;
		
		if (longX > 0 && longY > 0) {
			s0 = s;
			s1 = new Point(s.getX()+longX,s.getY());
			s2 = new Point(s.getX()+longX,s.getY()+longY);
			s3 = new Point(s.getX(),s.getY()+longY);
		} else if (longX > 0 && longY < 0) {
			s0 = new Point(s.getX(),s.getY()+longY);
			s1 = new Point(s.getX()+longX,s.getY()+longY);
			s2 = new Point(s.getX()+longX,s.getY());
			s3 = s;
		} else if (longX < 0 && longY > 0) {
			s0 = new Point(s.getX()+longX,s.getY());
			s1 = s;
			s2 = new Point(s.getX(),s.getY()+longY);
			s3 = new Point(s.getX()+longX,s.getY()+longY);
		} else {
			s0 = new Point(s.getX()+longX,s.getY()+longY);
			s1 = new Point(s.getX(),s.getY()+longY);
			s2 = s;
			s3 = new Point(s.getX()+longX,s.getY());
		}
		
		listeSommets.add(s0);
		listeSommets.add(s1);
		listeSommets.add(s2);
		listeSommets.add(s3);
		
		return listeSommets;
	}
	
	/*
	 * Accesseurs
	 */
	
	public Point getPointBasGauche () {
		return sommets.get(0);
	}
	
	public Point getPointBasDroite () {
		return sommets.get(1);
	}
	
	public Point getPointHautDroite () {
		return sommets.get(2);
	}
	
	public Point getPointHautGauche () {
		return sommets.get(3);
	}
	
}
