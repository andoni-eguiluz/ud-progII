package tema2.ejemplos.bolasYBloques;

import java.awt.Color;
import java.awt.geom.Point2D;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public abstract class ObjetoAnimacion extends Object {
	protected double x;          // Coordenada x del centro de la bola
	protected double y;          // Coordenada y del centro de la bola
	protected double antX;       // Coordenada x del centro en el movimiento anterior (método mover)
	protected double antY;       // Coordenada y del centro en el movimiento anterior (método mover)
	protected double velX;       // Velocidad horizontal del bloque en píxels / segundo 
	protected double velY;       // Velocidad vertical del bloque en píxels / segundo
	protected Color colorBorde;  // Color del borde del bloque
	protected Color colorFondo;  // Color del fondo del bloque

	/** Crea un objeto de animación sin velocidad de borde azul y fondo blanco
	 * @param x	Coordenada x del centro
	 * @param y	Coordenada y del centro
	 */
	public ObjetoAnimacion( double x, double y ) {
		this.x = x;
		this.y = y;
		colorBorde = Color.BLUE;
		colorFondo = Color.WHITE;
	}

	public ObjetoAnimacion(double x, double y, Color colorBorde, Color colorFondo) {
		super();
		this.x = x;
		this.y = y;
		this.colorBorde = colorBorde;
		this.colorFondo = colorFondo;
	}
	
	/** Devuelve la coordenada x del centro
	 * @return	Coordenada horizontal
	 */
	public double getX() {
		return x;
	}
	
	/** Modifica la coordenada x del centro
	 * @param x	Nueva coordenada horizontal
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/** Devuelve la coordenada y del centro
	 * @return	Coordenada vertical
	 */
	public double getY() {
		return y;
	}
	
	/** Modifica la coordenada y del centro
	 * @param y	Nueva coordenada vertical
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/** Devuelve la velocidad x de la bola
	 * @return	Velocidad horizontal, en píxels/segundo
	 */
	public double getVelX() {
		return velX;
	}
	
	/** Modifica la velocidad x de la bola
	 * @param velX	Nueva velocidad horizontal, en píxels/segundo
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	/** Devuelve la velocidad y de la bola
	 * @return	Velocidad vertical, en píxels/segundo
	 */
	public double getVelY() {
		return velY;
	}
	
	/** Modifica la velocidad y de la bola
	 * @param velY	Nueva velocidad vertical, en píxels/segundo
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	/** Modifica la velocidad de la bola
	 * @param velX	Nueva velocidad x en píxeles/segundo
	 * @param velY	Nueva velocidad y en píxeles/segundo
	 */
	public void setVelXY( double velX, double velY ) {
		setVelX( velX );
		setVelY( velY );
	}
	
	/** Modifica la velocidad de la bola
	 * @param p	Nueva velocidad en forma de punto x,y - ambos en píxeles/segundo
	 */
	public void setVelXY( Point2D p ) {
		setVelXY( p.getX(), p.getY() );
	}
	
	/** Devuelve el color de borde de la bola
	 * @return	Color de borde
	 */
	public Color getColor() {
		return colorBorde;
	}
	
	/** Modifica el color de borde de la bola
	 * @param color	Nuevo color de borde
	 */
	public void setColor(Color color) {
		this.colorBorde = color;
	}
	
	/** Devuelve el color de fondo de la bola
	 * @return	Color de fondo
	 */
	public Color getColorFondo() {
		return colorFondo;
	}
	
	/** Modifica el color de fondo de la bola
	 * @param colorFondo	Nuevo color de fondo
	 */
	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}	
	
	public abstract void dibujar( VentanaGrafica v );
	
}
