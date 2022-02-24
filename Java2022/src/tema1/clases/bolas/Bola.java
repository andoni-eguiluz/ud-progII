package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Bola {
	private int xCentro;
	private int yCentro;
	private int radio;
	private Color colorBorde;
	private Color colorFondo;
	
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

	public int getxCentro() {
		return xCentro;
	}

	public void setxCentro(int xCentro) {
		this.xCentro = xCentro;
	}

	public int getyCentro() {
		return yCentro;
	}

	public void setyCentro(int yCentro) {
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
	
	
}
