package tema1.clases;

import java.util.ArrayList;
import java.util.Date;

public class Juego {
	
	// STATIC
	public static int numJuegos;
	public static ArrayList<Juego> listaJuegos = new ArrayList<>();
	
	// NO STATIC
	private String nombre = "default";
	private double precioFinal;
	private double iva;  // Importe de IVA, suponemos el 21%
	private double precioSinIva;
	private Date fechaCompra;
	private String localizacion;
	private ArrayList<String> listaJugadores;
	private Genero genero;  // 0=Shooter, 1=Plataformas, 2=Aventuras...
	private int valoracion; // 0 a 10
	// ArrayList<Genero> si quisiéramos que tuviera varios
	
	public Juego( String nombre ) {
		// Java crea el objeto
		this.nombre = nombre;
		fechaCompra = new Date();
		listaJugadores = new ArrayList<String>();
		// Actualización de static
		numJuegos++;
		listaJuegos.add( this );
		// return this;  es lo que hace Java
	}
	
	public Juego( String nombre, Genero genero, double precio ) {
		this( nombre );
			// this.nombre = nombre;
			// fechaCompra = new Date();
			// listaJugadores = new ArrayList<String>();
			// Actualización de static
			// numJuegos++;
			// listaJuegos.add( this );
		this.genero = genero;
		setPrecioFinal( precio );
	}
	
	public Juego(String nombre, double precio, Date fechaCompra, String localizacion,
			ArrayList<String> listaJugadores, Genero genero) {
		this( nombre );
		setPrecioFinal( precio );
		this.fechaCompra = fechaCompra;
		this.localizacion = localizacion;
		this.listaJugadores = listaJugadores;
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal( double precioFinal ) {
		if (precioFinal < 0) {
			System.err.println( "Error: precio debe ser mayor o igual a 0");
		} else {
			this.precioFinal = precioFinal;
			this.iva = precioFinal / 121.0 * 21.0;
			this.precioSinIva = precioFinal / 121.0 * 100.0;
		}
	}

	public double getPrecioSinIva() {
		return precioSinIva;
	}

	public void setPrecioSinIva(double precioSinIva) {
		if (precioSinIva < 0) {
			System.err.println( "Error: precio debe ser mayor o igual a 0");
		} else {
			this.precioSinIva = precioSinIva;
			this.iva = precioSinIva / 100.0 * 21.0;
			this.precioFinal = precioSinIva + iva;
		}
	}

	public double getIva() {
		return iva;
	}

	public int getValoracion() {
		return valoracion;
	}

	/** Cambia la valoración del juego. Si es incorrecta, no se cambia y sale un mensaje en consola de error
	 * @param valoracion	Nueva valoración en un rango de 0 (pésimo) a 10 (excelente)
	 */
	public void setValoracion(int valoracion) {
		if (valoracion<0 || valoracion>10) {
			System.err.println( "Valoración incorrecta: " + valoracion );
		} else {
			this.valoracion = valoracion;
		}
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public ArrayList<String> getListaJugadores() {
		return listaJugadores;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero( Genero pGenero ) {
		genero = pGenero;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO pendiente comprobar que es un juego
		Juego j = (Juego) obj;
		return nombre.equals(j.nombre);
	}
	
}
