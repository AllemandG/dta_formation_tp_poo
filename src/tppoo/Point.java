package tppoo;

public class Point implements Comparable<Point>{
	private static final int INIT_X = 25; // Tp 11
	private static final int INIT_Y = 25; // Tp 11
	
	private int coordX;
	private int coordY;
	
	public Point () { // Tp 11
		this(INIT_X,INIT_Y);
	}
	
	public Point (int x, int y) {
		coordX = x;
		coordY = y;
	}
	
	/*
	 * Methodes
	 */
	
	public void deplace (int deltaX, int deltaY) {
		setCoordX(getX()+deltaX);
		setCoordY(getY()+deltaY);
	}
	
	public String toString () {
		return ("["+ coordX +";"+ coordY +"]");
	}
	
	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point p = (Point) o;
			return ( compareTo(p) == 0 );
		} else {
			return false;
		}
	}
	
	public int distance(Point p) {
		double distX, distY;
		distX = Math.pow( (p.getX() - getX()), 2);
		distY = Math.pow( (p.getY() - getY()), 2 );
		int dist = (int) Math.round( Math.sqrt(distX + distY) );
		return dist;
	}
	
	public int hashCode () {
		return ( getX() * 100 + getY());
	}
	
	/*
	 * Accesseurs
	 */
	public int getX() {
		return coordX;
	}

	protected void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getY() {
		return coordY;
	}

	protected void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	@Override
	public int compareTo(Point p) {
		if ( (this.getX() > p.getX()) && (this.getY() > p.getY()) ) {
			return 1;
		} else if ((this.getX() < p.getX()) && (this.getY() < p.getY())) {
			return -1;
		} else {
			return 0;
		}
			
	}
	
	
}
