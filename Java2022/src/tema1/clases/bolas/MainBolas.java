package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class MainBolas {
	public static void main(String[] args) {
		// pruebas();
		pruebaMovimiento();
	}
	private static void pruebaMovimiento() {
		VentanaGrafica v = new VentanaGrafica( 1000, 600, "Bolitas" );
		v.getJFrame().setLocation(2000, 0);
		Bola bola1 = new Bola();
		bola1.setxCentro( 500 );
		bola1.setyCentro( 300 );
		v.dibujaCirculo(bola1.getxCentro(), bola1.getyCentro(), bola1.getRadio(), 2, bola1.getColorBorde(), bola1.getColorFondo() );
		for (int inc=0; inc<100; inc++) {
			bola1.borrar( v );
			bola1.setxCentro( 500 + inc );
			bola1.setyCentro( 300 + inc );
			bola1.dibujar( v );
			v.espera( 20 );
		}
	}
	private static void pruebas() {
		Bola bola1 = new Bola();
		System.out.println( bola1.getxCentro() + "," + bola1.getyCentro() );
		System.out.println( bola1 );
		// TODO completar pruebas en consola
	}
}
