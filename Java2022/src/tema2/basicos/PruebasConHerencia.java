package tema2.basicos;

import java.util.ArrayList;

/** Clase de prueba para el concepto de herencia
 */
public class PruebasConHerencia {
	public static void main(String[] args) {
		Obra miObra = new Obra( "Cualquiera");
		// miObra.setTitulo( "Cualquiera" );
		System.out.println( miObra.getTitulo() );
		Pelicula miPeli = new Pelicula( "Batman última", "Matt Reeves" );
		// miPeli.setTitulo(  );
		// miPeli.setDirector_a( "Matt Reeves" );
		System.out.println( miPeli.getTitulo() );
		System.out.println( miObra.toString() );
		System.out.println( miPeli.toString() );
		Libro miLibro = new Libro( "Sapiens", "Harari" );
		System.out.println( miLibro );
		System.out.println( miLibro.equals( miPeli ));
		Libro miLibro2 = new Libro( "Sapiens", "Harari" );
		System.out.println( miLibro.equals( miLibro2 ) );
		
		// Tipo estricto en Java
		// Pero con herencia es polimórfico
		Libro ejemploL = new Libro( "A", "B" );
		Obra ejemploO = new Libro( "A", "B" );
		System.out.println( ejemploL.getNumPaginas() );
		System.out.println( ejemploO.getTitulo() );
		System.out.println( ((Libro)ejemploO).getNumPaginas() );
		ejemploO = new Pelicula( "A", "D" );
		System.out.println( ejemploO.getTitulo() );
		System.out.println( ((Libro)ejemploO).getNumPaginas() );
		// Libro ejemploMal = new Obra( "A" );  // No se puede
		ArrayList<Libro> lLibros = new ArrayList<>();
		lLibros.add( miLibro );
		// No se puede lLibros.add( miPeli );
		ArrayList<Obra> lObras = new ArrayList<>();
		lObras.add( miLibro );
		lObras.add( miPeli );
	}
}

class Obra extends Object {  // Clase padre
	protected String titulo;
	protected String argumento;
	protected String resumen;
	protected int puntuacion;
	public Obra( String titulo ) {
		this.titulo = titulo;
		argumento = "";
		resumen = "";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}
	public String toString() {
		return titulo;
	}
}

class Pelicula extends Obra {
	// titulo, argumento, resumen, puntuacion
	protected ArrayList<String> listaActoresActrices;  // Nuevos atributos
	protected String director_a;
	public Pelicula(String titulo, String director_a) {
		super(titulo);
		this.listaActoresActrices = new ArrayList<>();
		this.director_a = director_a;
	}
	@Override
	public String toString() {
		return super.toString() + " (" + director_a + ")"; // si titulo es private getTitulo();
	}
	public void setDirector_a( String director_a ) {
		this.director_a = director_a;
	}
	public String getDirector_a() {
		return director_a;
	}
 }

class Libro extends Obra {
	protected String autor_a;
	protected int numPaginas;
	public Libro( String titulo, String autor_a ) {
		super( titulo );  // Sintaxis de llamada al constructor del padre
		// this.titulo = titulo;
		this.autor_a = autor_a;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	@Override
	public String toString() {
		return super.toString() + " (" + autor_a + ")";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Libro) {
			Libro libro2 = (Libro) obj;
			return titulo.equals(libro2.titulo) && autor_a.equals(libro2.autor_a);
		} else {
			return false;
		}
	}
}

