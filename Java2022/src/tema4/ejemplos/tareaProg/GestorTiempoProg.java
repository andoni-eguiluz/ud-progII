package tema4.ejemplos.tareaProg;

import java.util.ArrayList;

/** Clase contenedora
 */
public class GestorTiempoProg {
	private ArrayList<TiempoProg> listaTiempos;

	public GestorTiempoProg() {
		listaTiempos = new ArrayList<>();
	}
	
	public void addTiempo( TiempoProg tiempoProg ) {
		listaTiempos.add( tiempoProg );
	}
	
	// Métodos de borrado, consulta, etc.
	
	public ArrayList<TiempoProg> getListaTiempos() {
		return listaTiempos;
	}
}
