package tppoo;

import java.util.Collection;

public abstract class Figure {
	/*
	 * pourrait etre modifi� pour que
	 * la m�thode getType fasse elle m�me le choix 
	 * en fonction de la classe qui la red�finie
	 */
	private String type;
	
	public Figure (String type) {
		this.type = type;
	}
	
	/*
	 * Methodes
	 */
	
	public void affiche () {
		System.out.println(toString());
	}
	
	public abstract boolean couvrePoint(Point p);
	
	public abstract int nbPoints();
	
	public abstract int getTypeInt();
	
	public abstract Collection<Point> getPoints();
	
	/*
	 * Accesseurs
	 */

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
	
	
}
