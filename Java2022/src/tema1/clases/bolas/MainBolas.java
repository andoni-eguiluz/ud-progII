package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class MainBolas {
	private static VentanaGrafica v;
	private static Bola bola1;
	private static Bola bola2;
	
	public static void main(String[] args) {
		// pruebas();
		// pruebaMovimiento();
		reboteBolas();
	}
	
	private static void reboteBolas() {
		v = new VentanaGrafica( 1000, 600, "Rebote de bolas" );
		v.getJFrame().setLocation( 2000, 0 );
		bola1 = new Bola( 500, 300, 20, Color.BLUE, Color.YELLOW );
		bola1.dibujar( v );
		bola1.setVelX( 500 );
		bola1.setVelY( 200 );
		
		bola2 = new Bola( 200, 200, 25, Color.PINK, Color.CYAN );
		bola2.dibujar( v );
		bola2.setVelX( 100 );
		bola2.setVelY( 100 );
		
		bola1.mover( v );  // NO DEVUELVE EL CONTROL  (BLOQUEANTE)
		bola2.mover( v );
		
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
