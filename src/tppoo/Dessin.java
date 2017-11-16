package tppoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dessin {
	/*
	 * Choix de l' ArrayList car pas de clef pour identifier les figures,
	 * possibilit� d'avoir plusieurs figure identiques car elles sont g�n�r�es al�atoirement,
	 * pas un grand nombre de figures � stocker.
	 */
	private List<Figure> liste = new ArrayList<Figure>();
	
	public Dessin() {
	}
	
	/*
	 * Methodes
	 */
	
	public boolean add(Figure f) {
		return liste.add(f);
	}
	
	public Collection<Figure> getFigures() {
		return liste;
	}
}
