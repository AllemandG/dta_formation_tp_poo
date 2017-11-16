package tests;

import java.util.Collection;
import java.util.Iterator;

import tppoo.*;

public class Tests {

	public static void main(String[] args) {
		System.out.println("===========================");
		System.out.println("TP 10");
		Point point1 = new Point(1, 5);
		System.out.println(point1.toString());

		Point point2 = new Point(-6, 12);
		Rond rond1 = new Rond(point2, 3);

		rond1.affiche();

		Point point3 = new Point(3, -2);
		Rectangle rectangle1 = new Rectangle(point3, 7, -3);

		rectangle1.affiche();

		System.out.println("===========================");
		System.out.println("TP 11");

		Point point11 = new Point();
		Point point12 = new Point(10, -7);
		System.out.println(point11.toString());
		System.out.println(point12.toString());

		Rond rond11 = FigureUtil.getRandomRond();
		Rond rond12 = FigureUtil.getRandomRond();
		rond11.affiche();
		rond12.affiche();

		Rectangle rect11 = FigureUtil.getRandomRectangle();
		Rectangle rect12 = FigureUtil.getRandomRectangle();
		rect11.affiche();
		rect12.affiche();

		System.out.println("===========================");
		System.out.println("TP 12");

		Rectangle rect21 = FigureUtil.getRandomRectangle();
		Rectangle rect22 = FigureUtil.getRandomRectangle();
		rect21.affiche();
		rect22.affiche();

		Carre carre21 = FigureUtil.getRandomCarre();
		Carre carre22 = FigureUtil.getRandomCarre();
		carre21.affiche();
		carre22.affiche();

		System.out.println("===========================");
		System.out.println("TP 13");

		System.out.println(point11.equals(point12));
		System.out.println(point11.equals(point11));

		System.out.println("===========================");
		System.out.println("TP 14");

		System.out.println(FigureUtil.getRandomFigure());
		System.out.println(FigureUtil.getRandomFigure());
		System.out.println(FigureUtil.getRandomFigure());
		System.out.println(FigureUtil.getRandomFigure());
		System.out.println(FigureUtil.getRandomFigure());
		System.out.println(FigureUtil.getRandomFigure());

		System.out.println("===========================");
		System.out.println("TP 15");

		Rectangle rect51 = FigureUtil.getRandomRectangle();
		Rectangle rect52 = FigureUtil.getRandomRectangle();
		Rectangle rect53 = FigureUtil.getRandomRectangle();

		rect51.affiche();
		System.out.println(rect51.surface());
		rect52.affiche();
		System.out.println(rect51.surface());
		rect53.affiche();
		System.out.println(rect51.surface());

		Rond rond51 = FigureUtil.getRandomRond();
		Rond rond52 = FigureUtil.getRandomRond();
		Rond rond53 = FigureUtil.getRandomRond();

		rond51.affiche();
		System.out.println(rond51.surface());
		rond52.affiche();
		System.out.println(rond52.surface());
		rond53.affiche();
		System.out.println(rond53.surface());

		Carre carre51 = FigureUtil.getRandomCarre();
		Carre carre52 = FigureUtil.getRandomCarre();
		Carre carre53 = FigureUtil.getRandomCarre();

		carre51.affiche();
		System.out.println(carre51.surface());
		carre52.affiche();
		System.out.println(carre52.surface());
		carre53.affiche();
		System.out.println(carre53.surface());

		System.out.println(FigureUtil.getRandomSurfacable().surface());
		System.out.println(FigureUtil.getRandomSurfacable().surface());
		System.out.println(FigureUtil.getRandomSurfacable().surface());
		System.out.println(FigureUtil.getRandomSurfacable().surface());
		System.out.println(FigureUtil.getRandomSurfacable().surface());
		System.out.println(FigureUtil.getRandomSurfacable().surface());

		System.out.println("===========================");
		System.out.println("TP 20");

		int N = 10;
		Figure[] tabFigures = new Figure[N];
		for (int iTabFigures = 0; iTabFigures < N; iTabFigures++) {
			tabFigures[iTabFigures] = FigureUtil.getRandomFigure();
		}

		System.out.println("Avec tableau");
		for (Point p : FigureUtil.getPoints(tabFigures)) {
			System.out.println(p);
		}

		System.out.println("Avec arguments");
		for (Point p : FigureUtil.getPoints(FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure(),
				FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure())) {
			System.out.println(p);
		}

		System.out.println("Avec arguments");
		for (Point p : FigureUtil.getPoints()) {
			System.out.println(p);
		}

		System.out.println("Avec arguments");
		for (Point p : FigureUtil.getPoints(FigureUtil.getRandomFigure())) {
			System.out.println(p);
		}

		System.out.println("===========================");
		System.out.println("TP 20 et 21");

		System.out.println("N = 10");
		for (Point p : FigureUtil.getPoints(FigureUtil.genere(10).toArray(new Figure[0]))) {
			System.out.println(p);
		}

		System.out.println("N = 1");
		for (Point p : FigureUtil.getPoints(FigureUtil.genere(1).toArray(new Figure[0]))) {
			System.out.println(p);
		}

		System.out.println("N = 2");
		for (Point p : FigureUtil.getPoints(FigureUtil.genere(2).toArray(new Figure[0]))) {
			System.out.println(p);
		}

		System.out.println("===========================");
		System.out.println("TP 22");

		Dessin col = FigureUtil.getRandomDessin();

		Collection<Point> figs = FigureUtil.getPoints(col.getFigures().toArray(new Figure[0]));

		Iterator<Point> itr = figs.iterator();

		Point p221 = itr.next();

		System.out.println(p221.toString());
		FigureUtil.getFigureEn(p221, col).affiche();

		Point pr;
		Figure fp;
		for (int i = 0; i < 5; i++) {
			pr = FigureUtil.pointRandom();
			System.out.println(pr.toString());
			fp = FigureUtil.getFigureEn(pr, col);
			if (fp != null) {
				fp.affiche();
			} else {
				System.out.println("Pas de figure");
			}
		}

		System.out.println("===========================");
		System.out.println("TP 23");
		
		
		System.out.println("true");
		if (new Point().equals(new Point())) {
			System.out.println("même point");
		} else {
			System.out.println("pas même point");
		}
		
		Figure f231;
		Figure f232;
		
		System.out.println("RECT et CARRE true");
		f231  = new Rectangle(new Point(), 5, 5);
		f232  = new Carre(new Point(), 5);
		if (f231.equals(f232)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("RECT et CARRE false");
		f231  = new Rectangle(new Point(), 7, 5);
		f232  = new Carre(new Point(), 5);
		if (f231.equals(f232)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("RECT et RECT true");
		f231  = new Rectangle(new Point(), 7, 5);
		f232  = new Rectangle(new Point(), 7, 5);
		if (f231.equals(f232)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("RECT et RECT false");
		f231  = new Rectangle(new Point(), 7, 5);
		f232  = new Rectangle(new Point(), 5, 7);
		if (f231.equals(f232)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		
		System.out.println("ROND et ROND true");
		f231  = new Rond(new Point(), 5);
		f232  = new Rond(new Point(), 5);
		if (f232.equals(f231)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("ROND et ROND false");
		f231  = new Rond(new Point(7,5), 5);
		f232  = new Rond(new Point(), 8);
		if (f232.equals(f231)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		
		System.out.println("SGT et SGT true");
		f231  = new Segment(new Point(), 5, true);
		f232  = new Segment(new Point(), 5, true);
		if (f232.equals(f231)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("SGT et SGT true");
		f231  = new Segment(new Point(), 5, true);
		f232  = new Segment(new Point(5,7), 5, false);
		if (f232.equals(f231)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		System.out.println("SGT et SGT true");
		f231  = new Segment(new Point(), 8, false);
		f232  = new Segment(new Point(), 5, true);
		if (f232.equals(f231)) {
			System.out.println("même figure");
		} else {
			System.out.println("pas même figure");
		}
		
	}
}
