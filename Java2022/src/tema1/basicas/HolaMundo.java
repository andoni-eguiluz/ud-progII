package tema1.basicas;

/** Clase de prueba hola mundo
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class HolaMundo {
	
	// STATIC
	static String mensaje = "Hola mundo";
	
	/** Programa de prueba
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		// NO HAY this
		System.out.println( mensaje );
		System.err.println( Math.sqrt(5.0));
		// prueba();   No se puede llamar a no static
		for (String s : args) {
			System.out.println( "String: " + s );
		}
	}

	
	// NO STATIC
	
	/** Método de ejemplo (documentación ficticia) Devuelve cálculo
	 * @param d	Número de bla
	 * @param s	Nombre
	 * @return	Calcula devolviendo -1 si pasa otra historia
	 */
	public int prueba2( double d, String s ) {
		return 0;
	}
	
	// Método de ejemplo - para ver diferencias entre static y no static
	public void prueba() {
		// HAY this
		System.out.println( Math.sqrt(5.0) );
		main(null);  // Se puede llamar a static
		int i = prueba2( 5.0, "a" );
		System.out.println( i );
	}
	
}
