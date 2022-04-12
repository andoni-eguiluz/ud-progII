package tema4.ejemplo.registros;

public class PruebaFicheros {
	public static void main(String[] args) {
		try {
			GrupoRegistros grupo = new GrupoRegistros( "datos-registro.txt" );
			System.out.println( grupo.getListaRegistros().size() + "  " + grupo.getListaRegistros() );
			// Sacar datos a otro fichero
			grupo.volcarAFicheroTexto( "datos-salida.txt" );
			System.out.println( "Fichero de salida generado correctamente.");
		} catch (NumberFormatException | NullPointerException ex) {
			System.out.println( "Error crítico: error en lectura" );
			ex.printStackTrace();  // Es lo que ocurre si no se gestiona la excepción
		} catch (Exception ex) {
			System.out.println( "Otro error imprevisto" );
		}
		System.out.println( "Vuelve el flujo al programa!" );
		System.out.println( "Se acaba el programa" );
	}
}
