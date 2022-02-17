package tema1.basicas;

import java.awt.Point;

public class ValorYReferencia {
	public static void main(String[] args) {
		diferenciasEntreValorYReferencia();
	}
	
	private static void diferenciasEntreValorYReferencia() {
		primitivos();
		objetos();
	}
	
	// Los primitivos funcionan por valor
	private static void primitivos() {
		System.out.println( "a" );
		int movil = 666555777;
		int movil2 = 666555777;
		int movil3 = movil;
		if (movil==movil2) {
			System.out.println( "Son iguales" );
		}
		if (movil==movil3) {
			System.out.println( "Son iguales" );
		}
		// if (movil.equals(movil3))
		revisaMovil( movil );
		System.out.println( movil );
		// movil = revisaMovil();
	}
	
	private static void revisaMovil( int m ) {
		// ...
		m = 0;
	}
	
	private static void objetos() {
		Point punto1 = new Point( 5, 6 );
		Point punto2 = new Point( 5, 6 );
		Point punto3 = punto1;
		if (punto1==punto3) {
			System.out.println( "Son iguales objetos" );
		}
		if (punto1==punto2) {
			System.out.println( "Son iguales objetos" );
		}
		// if (punto1.x == punto2.x && punto1.y == punto2.y) {
		if (punto1.equals(punto2)) {
			System.out.println( "Son iguales p1 y p2");
		}
		Point punto4 = (Point) (punto1.clone());
		revisaPunto( punto1 );
		System.out.println( "Punto 1 = " + punto1 );
		Point punto5 = new Point( 10, 5 );
		revisaPunto( new Point(punto1) );
		System.out.println( punto5 );
		// Este cambio no se puede hacer si el objeto es inmutable
		String s = "Hola";
		revisaString( s );
		System.out.println( s );
	}
	
	private static void revisaString( String s ) {
		String trans = s.replaceAll("H", "J");
		System.out.println( trans );
	}
	
	private static void revisaPunto( Point p ) {
		// ...
		p.setLocation( 2, 3 );
		p = null;  // No modifica a punto1
	}
	
}
