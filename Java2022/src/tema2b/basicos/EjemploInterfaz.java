package tema2b.basicos;

import java.util.ArrayList;

public class EjemploInterfaz {
	public static void main(String[] args) {
		CA a = new CA();
		CB b = new CB();
		CC c = new CC();
		a.mA();
		// b.mA();
		a.mX();
		c.mX();
		CE e = new CE();
		e.mX();
		IX x = a; x = c; x = e;
		ArrayList<IX> listaDeX = new ArrayList<>();
		listaDeX.add( a );
		listaDeX.add( c );
		// listaDeX.add( b );
		listaDeX.add( e );
		for (IX ix : listaDeX) {
			ix.mX();
			if (ix instanceof CA) {
				CA cajitaA = (CA) ix;
				cajitaA.mA();
				// O lo mismo ((CA)ix).mA();
			}
		}
		ArrayList<Object> listaDeLoQueSea = new ArrayList<>();
		listaDeLoQueSea.add( a );
		listaDeLoQueSea.add( b );
		listaDeLoQueSea.add( c );
		listaDeLoQueSea.add( e );
		listaDeLoQueSea.add( x );
		for (Object o : listaDeLoQueSea) {
			System.out.println( "* " + o.toString() );
			if (o instanceof IX) {
				IX cajitaX = (IX) o;
				cajitaX.mX();
			}
		}
	}
}

interface IX {   
	// No tiene atributos
	// Tiene solo métodos, que son abstractos
	public abstract void mX();  // Son públicos y son abstractos
}

interface IY {
	int mY(int par);
}

interface IYZ extends IY {
	void mZ();
}

class CA /* extends Object */ implements IX, IY {
	public void mA() { System.out.println( "a" ); }
	public void mX() { System.out.println( "x1-a" ); }
	public int mY(int i) { return i*i; }
}

class CB implements IYZ {  // implements IY, IYZ
	public int mY(int j) { return j+j; }
	public void mZ() { System.out.println( "soy b y tengo mz" ); }
}

class CC implements IX {
	public void mX() { System.out.println( "x2-c" ); }
}

abstract class CD implements IX {
	// public abstract void mX();
}

class CE extends CD {  // se hereda --> implements CX {
	public void mX() { System.out.println( "x3-e" ); }
}