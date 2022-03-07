package tema1.clases.bolas;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class MainBolas {
	private static VentanaGrafica v;

	// Lista de bolas
	// private static ArrayList<Bola> listaBolas = new ArrayList<Bola>();
	private static GrupoBolas grupoBolas = new GrupoBolas();
	// private static Bola bola1;  // No es necesario si usamos la lista
	// private static Bola bola2;
	// private static Bola bola3;
	
	private static final double TIEMPO_FOTOGRAMA = 0.01; // Sgs
	
	public static void main(String[] args) {
		// pruebas();
		// pruebaMovimiento();
		reboteBolas();
	}
	
	private static void reboteBolas() {
		v = new VentanaGrafica( 1000, 600, "Rebote de bolas" );
		// v.getJFrame().setLocation( 2000, 0 );  // Segunda pantalla (solo si se tiene)
		Bola bola = new Bola( 500, 300, 20, Color.BLUE, Color.YELLOW );
		// bola.dibujar( v );
		grupoBolas.anyadir( bola );
		bola.setVelX( 500 );
		bola.setVelY( 200 );
		
		bola = new Bola( 200, 200, 25, Color.PINK, Color.CYAN );
		grupoBolas.anyadir( bola );
		// bola.dibujar( v );
		bola.setVelX( 100 );
		bola.setVelY( 100 );
		
		// Bucle de tiempo real
		// INPUT - PROCESS - OUTPUT
		// System.out.println( KeyEvent.VK_PLUS );
		while (!v.estaCerrada()) {
			// System.out.println( v.getCodUltimaTeclaTecleada() );
			int codTecla = v.getCodUltimaTeclaTecleada();
			if (codTecla==KeyEvent.VK_PLUS) {
				Bola bola3 = new Bola(v);  // Crea bola aleatoria
				grupoBolas.anyadir( bola3 );
			}
			Point click = v.getRatonPulsado();
			if (click!=null) {  // Borrar posible bola
				int posicion = grupoBolas.buscarBolaEnPunto(click);
				// System.out.println( posicion );
				if (posicion!=-1) {
					grupoBolas.coger(posicion).borrar(v);
					grupoBolas.borrar( posicion );
				}
			}
			
			// bola1.mover( v, TIEMPO_FOTOGRAMA );
			// bola2.mover( v, TIEMPO_FOTOGRAMA );
			// if (bola3!=null) { bola3.mover( v, TIEMPO_FOTOGRAMA ); }

//			for (int i=0; i<grupoBolas.tamanyo(); i++) {
//				Bola b = grupoBolas.coger(i);
//				b.mover( v, TIEMPO_FOTOGRAMA );
//			}
			grupoBolas.mover( v, TIEMPO_FOTOGRAMA );
			
			// if (bola1.choqueEntreBolas(bola2)) {
				// Invertir velocidades
				// System.out.println( "Choque" );
			//	bola1.setVelX( -bola1.getVelX() );
			//	bola1.setVelY( -bola1.getVelY() );
			//	bola2.setVelX( -bola2.getVelX() );
			//	bola2.setVelY( -bola2.getVelY() );
			// }
			grupoBolas.choqueEntreBolas();
			
			grupoBolas.dibujar( v );
			
			v.espera( (long) (TIEMPO_FOTOGRAMA * 1000) );
		}
		
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
