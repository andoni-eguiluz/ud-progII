package tema4.ejemplos.tareaProg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/** Clase contenedora
 */
public class GestorTiempoProg2 {
	private ArrayList<TiempoProg> listaTiempos;

	public GestorTiempoProg2() {
		listaTiempos = new ArrayList<>();
	}
	
	public void addTiempo( TiempoProg tiempoProg ) {
		listaTiempos.add( tiempoProg );
	}
	
	// Métodos de borrado, consulta, etc.
	
	public ArrayList<TiempoProg> getListaTiempos() {
		return listaTiempos;
	}
	
	// Métodos de E/S en fichero
	/** Guarda un fichero ...
	 * @param binario
	 * @param nombreFic
	 * @throws IOException	Si hay cualquier error al escribir
	 */
	public void guardarFichero( boolean binario, String nombreFic ) throws IOException {
		if (binario) {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(nombreFic) );
			oos.writeObject( listaTiempos );
			oos.close();
		} else {
			PrintStream ps = new PrintStream(nombreFic);
			// ps.println( listaTiempos );
			for (TiempoProg tp : listaTiempos) {
				ps.println( tp.aLinea() );
			}
			ps.close();
		}
	}
	
	/**
	 * @param binario
	 * @param nombreFic
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void cargarFichero( boolean binario, String nombreFic ) throws IOException, ClassNotFoundException {
		if (binario) {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream(nombreFic) );
			listaTiempos = (ArrayList<TiempoProg>) ois.readObject();
			ois.close();
		} else {
			// TODO
		}
	}
	
}
