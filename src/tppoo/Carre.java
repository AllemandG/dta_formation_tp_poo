package tppoo;

public class Carre extends Rectangle {

	public Carre (Point sommetHautGauche, int cote) {
		super(sommetHautGauche,Math.abs(cote),Math.abs(cote)*(-1), "CARRE");
	}
	
}
