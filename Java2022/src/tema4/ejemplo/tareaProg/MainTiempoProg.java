package tema4.ejemplo.tareaProg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class MainTiempoProg {
	private static GestorTiempoProg gestor;
	private static final SimpleDateFormat FORMATO_DMYHM = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );

	public static void main(String[] args) {
		gestor = new GestorTiempoProg();
		menu();
	}
	
	public static void menu() {
		String[] opciones = {
			"Añadir tiempo", "Guardar fichero", "Cargar fichero", "Fin"
		};
		String respuestaString;
		do {
			Object respuesta = JOptionPane.showInputDialog( null, "¿Qué quieres hacer?", "Menú principal", JOptionPane.QUESTION_MESSAGE, null, 
					opciones, "Añadir tiempo" );
			respuestaString = (String) respuesta;
			// System.out.println( respuesta );
			if ("Añadir tiempo".equals(respuestaString)) {
				anyadirTiempo();
			} else if ("Guardar fichero".equals(respuestaString)) {
				guardarFichero();
			} else if ("Cargar fichero".equals(respuestaString)) {
				cargarFichero();
			}
			
		} while (!"Fin".equals(respuestaString) && respuestaString!=null);
	}
	
	public static void anyadirTiempo() {
		String resp = JOptionPane.showInputDialog( "Introduce fecha en la que has programado (formato dd/mm/aaaa hh:mm)", 
				FORMATO_DMYHM.format(new Date()) );
		try {
			Date fecha = FORMATO_DMYHM.parse( resp );
			resp = JOptionPane.showInputDialog( "Introduce minutos programando:" );
			int tiempo = Integer.parseInt( resp );
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog( null, "Error en entrada. Los minutos deben ser enteros y mayores que cero" );
		} catch (ParseException e) {
			JOptionPane.showMessageDialog( null, "Error en entrada. Debe tener el formato dd/mm/aaaa hh:mm" );
		}
	}
	
	public static void guardarFichero() {
		// TODO
	}
	
	public static void cargarFichero() {
		// TODO
	}
	
}
