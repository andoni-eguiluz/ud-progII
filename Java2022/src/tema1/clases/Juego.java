package tema1.clases;

import java.util.ArrayList;
import java.util.Date;

public class Juego {
	
	// STATIC
	public static int numJuegos;
	public static ArrayList<Juego> listaJuegos = new ArrayList<>();
	
	// NO STATIC
	private String nombre = "default";
	public double precio;
	public Date fechaCompra;
	public String localizacion;
	ArrayList<String> listaJugadores;
	
	public Juego( String nombre ) {
		// Java crea el objeto
		this.nombre = nombre;
		fechaCompra = new Date();
		// Actualización de static
		numJuegos++;
		listaJuegos.add( this );
		// return this;  es lo que hace Java
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
