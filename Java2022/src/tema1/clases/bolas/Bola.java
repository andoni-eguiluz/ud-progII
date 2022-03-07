package tema1.clases.bolas;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Bola {
	private static Random random = new Random();  // Generador de aleatorios (1 PARA TODAS)
	private static Color[] colores = { Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.BLACK };
	// Otra manera de inicializar los estáticos:
//	static {
//		random = new Random(); 
//	}
	
	private double xCentro;
	private double yCentro;
	private int radio;
	private Color colorBorde;
	private Color colorFondo;
	private double velX;
	private double velY;
	
	/**
	 * @param xCentro
	 * @param yCentro
	 * @param radio
	 * @param colorBorde
	 * @param colorFondo
	 */
	public Bola(int xCentro, int yCentro, int radio, Color colorBorde, Color colorFondo) {
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		this.radio = radio;
		this.colorBorde = colorBorde;
		this.colorFondo = colorFondo;
	}

	/** Crea una nueva bola de radio 10, borde azul y fondo blanco
	 * @param xCentro	coordenada x del centro
	 * @param yCentro	coordenada y del centro
	 */
	public Bola(int xCentro, int yCentro) {
		this( xCentro, yCentro, 10, Color.BLUE, new Color(255,255,255) );
	}

	/** Crea una nueva bola en las coordenadas 0,0 de radio 10, borde azul y fondo blanco
	 */
	public Bola() {
		this( 0, 0, 10, Color.BLUE, new Color(255,255,255) );
	}
	
	/** Crea una bola aleatoria 
	 * Toda la bola dentro de la ventana recibida
	 * Radio entre 5 y 30 pixels
	 * Velocidad x,y entre 20 y 100 pixels / seg, positiva o negativa
	 * Color de borde y fondo aleatorios entre los colores amarillo, rojo, verde, azul, cyan, magenta y negro
	 * @param v	Ventana de referencia para la creación
	 */
	public Bola(VentanaGrafica v) {
		radio = random.nextInt(26) + 5;
		xCentro = random.nextInt(v.getAnchura()-radio-radio) + radio;
		yCentro = random.nextInt(v.getAltura()-radio-radio) + radio;
		velX = random.nextInt(80) + 20;
		velY = random.nextInt(80) + 20;
		if (random.nextBoolean() ) {
			velX = -velX;
		}
		if (random.nextBoolean()) {
			velY = -velY;
		}
		colorBorde = colores[ random.nextInt(colores.length) ];
		colorFondo = colores[ random.nextInt(colores.length) ];
	}

	public double getxCentro() {
		return xCentro;
	}

	public void setxCentro(double xCentro) {
		this.xCentro = xCentro;
	}

	public double getyCentro() {
		return yCentro;
	}

	public void setyCentro(double yCentro) {
		this.yCentro = yCentro;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Color getColorBorde() {
		return colorBorde;
	}

	public void setColorBorde(Color colorBorde) {
		this.colorBorde = colorBorde;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}
	
	/** Devuelve la velocidad horizontal de la bola
	 * @return	Velocidad en pixels / segundo
	 */
	public double getVelX() {
		return velX;
	}

	/** Cambia la velocidad en x de la bola
	 * @param velX	Nueva velocidad en píxels / segundo
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	@Override
	public boolean equals(Object obj) {
		Bola bola2 = (Bola) obj;
		return xCentro==bola2.xCentro && yCentro==bola2.yCentro && radio==bola2.radio;
	}

	@Override
	public String toString() {
		return "Bola [xCentro=" + xCentro + ", yCentro=" + yCentro + ", radio=" + radio + "]";
	}
	
	
	public void borrar( VentanaGrafica v ) {
		v.dibujaCirculo(this.getxCentro(), this.getyCentro(), this.getRadio(), 2, 
				Color.WHITE, Color.WHITE );
	}
	
	public void dibujar( VentanaGrafica v ) {
		v.dibujaCirculo(this.getxCentro(), this.getyCentro(), this.getRadio(), 2, 
				this.getColorBorde(), this.getColorFondo() );
	}

	/** Mueve la bola un tiempo indicado
	 * @param v	Ventana en la que se dibuja
	 * @param tiempo	Tiempo de movimiento
	 */
	public void mover( VentanaGrafica v, double tiempo ) {
		borrar( v );
		setxCentro( xCentro + velX * tiempo );
		setyCentro( yCentro + velY * tiempo );
		if (chocaEnVertical( v )) { // bola choca con el borde superior o inferior) {
			velY = -velY;
		}
		if (chocaEnHorizontal( v )) {
			velX = -velX;
		}
		dibujar( v );
	}
	
	// Mover bloqueante
	/** Mueve la bola y la rebota hasta que se cierre la ventana
	 * @param v
	 */
	public void mover( VentanaGrafica v ) {
		double tiempo = 0.01;  // segundos
		long espera = (long) (tiempo * 1000); // milisegundos
		double fps = 1 / tiempo;
		System.out.println( "Tiempo sgs = " + tiempo + " / fps = " + fps );
		while (!v.estaCerrada()) {
			borrar( v );
			// Muevo
			setxCentro( xCentro + velX * tiempo );  // xCentro = xCentro + velX;   // xCentro += velX;
			setyCentro( yCentro + velY * tiempo );
			// Compruebo posibles choques
			if (chocaEnVertical( v )) { // bola choca con el borde superior o inferior) {
				velY = -velY;
			}
			if (chocaEnHorizontal( v )) {
				velX = -velX;
			}
			dibujar( v );
			v.espera( espera );
		}
	}
	
	public boolean chocaEnVertical( VentanaGrafica v ) {
		if (yCentro < 0 + radio) {
			return true;
		}
		if (yCentro > v.getAltura() - radio) {
			return true;
		}
		return false;
		// return (yCentro < 0) || (yCentro > v.getAltura());
	}
	
	public boolean chocaEnHorizontal( VentanaGrafica v ) {
		return (xCentro < radio) || (xCentro > v.getAnchura() - radio);
	}
	
	/** Comprueba si hay choque entre bolas
	 * @param otraBola	Bola con la que comprobar choque
	 * @return	true si se tocan this con otraBola, false si no
	 */
	public boolean choqueEntreBolas(Bola otraBola) {
		double distCentros = Math.sqrt( (xCentro-otraBola.xCentro)*(xCentro-otraBola.xCentro) + (yCentro-otraBola.yCentro)*(yCentro-otraBola.yCentro) );
		return distCentros <= radio + otraBola.radio;		
	}
	
	public boolean contienePunto( Point punto ) {
		double distAlCentro = Math.sqrt( (xCentro-punto.x)*(xCentro-punto.x) + (yCentro-punto.y)*(yCentro-punto.y) );
		return distAlCentro <= radio;
	}
	
}
