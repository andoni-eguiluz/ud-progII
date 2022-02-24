package tema1.clases;

public class MainJuego {
	public static void main(String[] args) {
		Juego juego = new Juego( "Mario" );
		juego.setGenero( Genero.PLATAFORMAS );
		Juego juego2 = new Juego( "Mario" );
		juego2.setGenero( Genero.PLATAFORMAS );
		if (juego.equals(juego2)) {
			System.out.println( "Marios son iguales" );
		}
		if (juego.getGenero()==juego2.getGenero()) {
			System.out.println( "Los géneros son iguales" );
		}
		// juego2.precio = -100;
		juego2.setPrecioFinal( 150 );
		Juego juego3 = new Juego( "COD", Genero.SHOOTER, 100 );
		System.out.println( juego2.getIva() );
		// juego2.iva = 25;
		juego3.setPrecioSinIva( 100 );
		System.out.println( juego3.getPrecioFinal() );
		juego3.setValoracion( 5 );
		
		// juego.nombre = "Tetris";
		System.out.println( juego.getNombre() );
		juego.setPrecioFinal( 12.199999999 );
		System.out.println( "Mi juego es: " + juego.toString() );
	}
}
