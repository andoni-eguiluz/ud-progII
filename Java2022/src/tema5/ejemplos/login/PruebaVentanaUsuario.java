package tema5.ejemplos.login;

/** Clase de prueba de ventana de usuario
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class PruebaVentanaUsuario {
	public static void main(String[] args) {
		DatoUsuario[] datos = new DatoUsuario[] {
				new DatoUsuario( "A", 100, 50 ),
				new DatoUsuario( "B", 200, 180 ),
				new DatoUsuario( "C", 120, 90 )
		};
		VentanaUsuario v = new VentanaUsuario( datos );
		v.setLocation( 200, 100 );
		v.setVisible( true );
		
	}
}
