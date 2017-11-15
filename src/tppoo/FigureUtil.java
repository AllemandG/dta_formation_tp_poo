package tppoo;

import java.util.Collection;

public class FigureUtil {
	/*
	 * Attributs
	 */
	private static final int SIZE_MIN = 1;
	private static final int SIZE_MAX = 20;
	
	private static final int X_MIN = 0;
	private static final int X_MAX = 99;
	
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 99;
	
	/*
	 * Méthodes
	 */
	
	public static Point[] getPointsTab(Figure[] figures) {
		int taille = figures.length;
		Point[] tabPoints;
		if (taille > 0) { //On va faire cette saletée de tableau
			int nbPointsTot = 0;
			for (Figure f : figures) {
				nbPointsTot += f.nbPoints();
			}
			tabPoints = new Point[nbPointsTot]; //On a initialisé le tableau
			int iTabPoints = 0;
			for (Figure f : figures) {
				for (Point p : f.getPointsFigure()) {
					tabPoints[iTabPoints] = p;
					iTabPoints++;
				}
			}
		} else { //là c'est easy
			tabPoints = new Point[0];
		}
		return tabPoints;
	}
	
	public static  Point[] getPoints(Figure... figures) {
		return getPointsTab(figures);
	}
	
	public static Figure getRandomFigure() {
		return getRandomFigure(1, 4);
	}
	
	public static Surfacable getRandomSurfacable () {
		return (Surfacable) getRandomFigure(1, 3);
	}
	
	/*
	 * Fonction qui renvoie une figure aléatoire,
	 * 
	 * Le param "min" sert à définir à partir d'où on part,
	 * si min = 1 alors on peut avoir des Surfacables
	 * si min = 3 alors on ne peut pas avoir un Surfacable
	 * 
	 * Le param "max" sert à définir jusqu'ou on veut aller,
	 * si max = 3 alors on obtiendra un Surfacable
	 * si max = 4 alors on obtiendra tout type de Figure
	 */
	private static Figure getRandomFigure(int min, int max) {
		int i = min + (int) (Math.random() * ((max - min) + 1));
		switch ( i ){
		case 1 :
			return getRandomRond();
		case 2 :
			return getRandomRectangle();
		case 3 : 
			return getRandomCarre();
		case 4 : 
			return getRandomSegment();
		default :
			return null;
		}
	}
	
	
	public static Collection<Figure> genere (int nombreFigures) {
		Dessin ensemble = new Dessin();
		for (int n = 0; n < nombreFigures; n++) {
			ensemble.add(getRandomFigure());
		}
		return ensemble.getFigures();
	}
	
	
	/*
	 * Méthodes de création des Figures.
	 */
	
	public static Rond getRandomRond() {
		int l1 = randInt();
		Point p = pointRandom(l1);
		return new Rond ( p, l1);
	}
	
	public static Rectangle getRandomRectangle() {
		int l1 = randInt();
		int l2 = randInt();
		Point p = pointRandom(Math.max(l1, l2));
		return new Rectangle (p, l1, l2);
	}
	
	public static Carre getRandomCarre() {
		int l1 = randInt();
		Point p = pointRandom(l1);
		
		return new Carre(p, l1);
	}
	
	public static Segment getRandomSegment() {
		boolean horivert = true;
		if (Math.random() >= 0.5)
			horivert = false;
		
		
		int l1 = randInt();
		Point p = pointRandom(l1);
		return new Segment(p, l1, horivert);
	}
	
	
	/*
	 * Méthodes servant à la création d'éléments de base de manière "aléatoire"
	 * et utilisées pour la création de Figures. 
	 */
	
	private static Point pointRandom() {
		return pointRandom(X_MAX, Y_MAX);
	}
	
	private static Point pointRandom(int l) {
		return pointRandom(l, l);
	}
	
	private static int randInt() {
		return randInt(SIZE_MIN, SIZE_MAX);
	}
	
	private static int randCoordX(int l) {
		return randInt(X_MIN + l, X_MAX - l);
	}
	
	private static int randCoordY(int l) {
		return randInt(Y_MIN + l, Y_MAX - l);
	}
	
	private static Point pointRandom(int maxX, int maxY) {
		return new Point (randCoordX(maxX),randCoordY(maxY));
	}
	
	private static int randInt(int min, int max) {
		return  min + (int)(Math.random() * (max - min));
	}
	
}
