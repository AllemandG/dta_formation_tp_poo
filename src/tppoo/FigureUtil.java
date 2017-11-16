package tppoo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

	public static Collection<Point> getPoints(Figure... figures) {
		ArrayList<Point> tabPoints;
		tabPoints = new ArrayList<Point>();
		for (Figure f : figures) {
			tabPoints.addAll(f.getPoints());
		}
		return tabPoints;
	}

	public static Figure getRandomFigure() {
		return getRandomFigure(1, 4);
	}

	public static Surfacable getRandomSurfacable() {
		return (Surfacable) getRandomFigure(1, 3);
	}

	/*
	 * Fonction qui renvoie une figure aléatoire,
	 * 
	 * Le param "min" sert à définir à partir d'où on part, si min = 1 alors on peut
	 * avoir des Surfacables si min = 3 alors on ne peut pas avoir un Surfacable
	 * 
	 * Le param "max" sert à définir jusqu'ou on veut aller, si max = 3 alors on
	 * obtiendra un Surfacable si max = 4 alors on obtiendra tout type de Figure
	 */
	private static Figure getRandomFigure(int min, int max) {
		int i = min + (int) (Math.random() * ((max - min) + 1));
		switch (i) {
		case 1:
			return getRandomRond();
		case 2:
			return getRandomRectangle();
		case 3:
			return getRandomCarre();
		case 4:
			return getRandomSegment();
		default:
			return null;
		}
	}

	public static Collection<Figure> genere(int nombreFigures) {
		ArrayList<Figure> ensemble = new ArrayList<Figure>();
		for (int n = 0; n < nombreFigures; n++) {
			ensemble.add(getRandomFigure());
		}
		return ensemble;
	}
	
	public static Dessin getRandomDessin () {
		Dessin d = new Dessin();
		
		ArrayList<Figure> ens = (ArrayList<Figure>) genere(randInt());
		
		for (int i = 0; i < ens.size(); i++) {
			d.add(ens.get(i));
		}
		
		return d;
	}
	
	public static Figure getFigureEn(Point p, Dessin dessin) {
		Figure f = null;
		
		Iterator<Figure> it = dessin.getFigures().iterator();
		Figure temp;
		
		while (it.hasNext()) { // On recherche la première figure recouvrant le point
			temp = it.next();
			if (temp.couvrePoint(p)) {
				f = temp;
				return f;
			}
		}
		
		return f;
	}
	
	public static void deplaceAllPointFromList(ArrayList<Point> list_points, int deltaX, int deltaY) {
		list_points.forEach(p -> p.deplace(deltaX, deltaY));
	}

	/*
	 * Méthodes de création des Figures.
	 */

	public static Rond getRandomRond() {
		int l1 = randInt();
		Point p = pointRandom(l1);
		return new Rond(p, l1);
	}

	public static Rectangle getRandomRectangle() {
		int l1 = randInt();
		int l2 = randInt();
		Point p = pointRandom(Math.max(l1, l2));
		return new Rectangle(p, l1, l2);
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
	 * Méthodes servant à la création d'éléments de base de manière "aléatoire" et
	 * utilisées pour la création de Figures.
	 */

	public static Point pointRandom() {
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
		return new Point(randCoordX(maxX), randCoordY(maxY));
	}

	private static int randInt(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

}
