package tppoo;

import java.util.ArrayList;
import java.util.Collection;

public class Dessin {
	private ArrayList<Figure> liste;
	
	public Dessin() {
		liste = new ArrayList<Figure>();
	}
	
	/*
	 * Methodes
	 */
	
	public boolean add(Figure f) {
		return liste.add(f);
	}
	
	public Collection<Figure> getFigures() {
		return getListe();
	}
	
	
	/*
	 * Accesseurs
	 */
	
	protected ArrayList<Figure> getListe() {
		return liste;
	}

	protected void setListe(ArrayList<Figure> liste) {
		this.liste = liste;
	}
}
