package tema2b.basicos;

import java.util.ArrayList;
import java.util.Collections;

public class Persona implements Comparable<Persona> {
	public static void main(String[] args) {
		ArrayList<Persona> l = new ArrayList<>();
		Persona p = new Persona( "Andoni" );
		l.add( p );
		l.add( new Persona( "Elena" ) );
		l.add( new Persona( "Rafael") );
		l.add( new Persona( "Idoia" ) );
		if (l.contains( new Persona( "Andoni" ) ) ) {
			System.out.println( "He encontrado a Andoni" );
		}
		l.sort(null);
		System.out.println( l );
	}
	
	@Override  // Implementación de Comparable
	public int compareTo(Persona o) {
		return nombre.compareTo( o.nombre );
	}
	
	@Override  // Herencia de Object
	public boolean equals(Object obj) {
		if (obj instanceof Persona) {
			Persona p2 = (Persona) obj;
			return p2.nombre.equals( this.nombre );
		} else {
			return false;
		}
	}
	
	private String nombre;
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

}
