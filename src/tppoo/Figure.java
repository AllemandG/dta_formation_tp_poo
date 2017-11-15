package tppoo;

public abstract class Figure {
	/*
	 * pourrait etre modifié pour que
	 * la méthode getType fasse elle même le choix 
	 * en fonction de la classe qui la redéfinie
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
	
	public abstract int nbPoints();
	
	public abstract Point[] getPointsFigure();
	
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
