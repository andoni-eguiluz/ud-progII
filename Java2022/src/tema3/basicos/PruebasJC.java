package tema3.basicos;

import java.awt.Point;
import java.util.*;

public class PruebasJC {
	public static void main(String[] args) {
		// Estructuras de datos
		// homogéneas
		int[] arrayInts = new int[10]; // Tamaño en creación, lineal, indexada
		Point[] arrayPoints = new Point[20];
		arrayInts[0] = 7; // error si fuera "7";
		// heterogéneas --> polimorfismo
		Object[] arrayObjetos = new Object[100];
		arrayObjetos[0] = "hola";
		arrayObjetos[1] = new Point(2,3);
		arrayObjetos[2] = new Peli( "A" );
		arrayObjetos[3] = 5;  // Wrapper Integer - autoboxing
		arrayObjetos[3] = Integer.valueOf(5); // lo mismo que new Integer(5);
		Integer objetoI = new Integer(7);
		int suma = 3 + objetoI.intValue();  // automático autounboxing
		// Tipos primitivos: Float, Double, Character...
		
		// lineales, indexadas, pero sin las limitaciones del array: Tamaño fijo / no inserción ni borrado
		Vector listaObjetos = new Vector();
		listaObjetos.add( "hola" );
		listaObjetos.add( new Point(2,3) );
		listaObjetos.add( 1, new Peli( "B" ) );
		
		Vector listaStrings = new Vector();
		listaStrings.add( "CODA" );
		listaStrings.add( "Belfast" );
		String primero = (String) listaStrings.get(0);
		
		// Versión 1.5 -> GENERICS
		Vector<Object> vectorO = new Vector<>(); // "solo" objects o sea cualquier objeto
		Vector<String> vectorS = new Vector<>(); // solo strings
		vectorO.add( new Integer(5) );
		// error vectorS.add( new Integer(5) );
		vectorS.add( "5" );
		String primero2 = vectorS.get(0);
		
		ArrayList<Integer> lEnteros = new ArrayList<Integer>();
		// CRUD
		// Create, Read (seaRch), Update, Delete
		lEnteros.add( 5 );
		lEnteros.add( 0, 4 );  // 0 a size()
		int i3 = lEnteros.get(1);  // 0 a size()-1
		System.out.println( lEnteros.contains(4) );
		lEnteros.remove( new Integer(5) );
		
		ArrayList<Peli> lPelis = new ArrayList<>();
		lPelis.add( new Peli( "CODA" ) );
		lPelis.add( new Peli( "Dune" ) );
		lPelis.add( new Peli( "CODA" ) );
		System.out.println( lPelis.contains( new Peli( "CODA" ) ) );
		System.out.println( lPelis.indexOf( new Peli( "CODA" ) ) );
		System.out.println( lPelis.lastIndexOf( new Peli( "CODA" ) ) );
		System.out.println( lPelis );
		lPelis.set( 2, new Peli( "Belfast" ) );
		System.out.println( lPelis );
		lPelis.remove( new Peli( "Dune" ) );
		System.out.println( lPelis );
		for (Peli p : lPelis) {  // implementar Iterable
			System.out.print( " " + p );
		}
		System.out.println();
		
		// LinkedList funciona igual
		LinkedList<String> llPelis = new LinkedList<>();
		
		String[] aPelis = { "CODA", "Belfast", "CODA", "Dune", "Drive my car", "CODA", "No mires arriba", "Belfast" };
		// SETS - lineal SIN REPETICIÓN, SIN POSICIONES. CONSULTA RÁPIDA. 
		HashSet<String> setH = new HashSet<>();  // Qué necesita? equals + hashCode()
		TreeSet<String> setT = new TreeSet<>();  // Qué necesita? Ordenable -> Comparable
		// TreeSet<Point> setPoints = new TreeSet<>();
		// setPoints.add( new Point(2,3) );  No funciona porque no es Comparable
		for (String peli : aPelis) {
			setH.add( peli );
			setT.add( peli );
		}
		// No se puede System.out.println( setH.get(1) );
		System.out.println( setH.contains( "CODA" ) );
		System.out.println( setH );
		System.out.println( setT );
		setT.remove( "Belfast" );
		System.out.println( setT );
	}
}

class Peli {
	private String dato;
	public Peli(String dato) {
		this.dato = dato;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Peli) {
			Peli p2 = (Peli) obj;
			return dato.equals(p2.dato);
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return dato;
	}
}
