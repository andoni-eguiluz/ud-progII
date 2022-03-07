package tema1.clases.bolas;

import java.awt.Point;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class GrupoBolas {
	
	private ArrayList<Bola> listaBolas;
	
	public GrupoBolas() {
		listaBolas = new ArrayList<Bola>();
	}
	
	/** Añade una bola al grupo
	 * @param bola	Bola a añadir
	 */
	public void anyadir( Bola bola ) {
		listaBolas.add( bola );
	}
	
	public int tamanyo() {
		return listaBolas.size();
	}
	
	public Bola coger( int indice ) {
		return listaBolas.get( indice );
	}
	
	public void borrar( int indice ) {
		listaBolas.remove( indice );
	}
	
	public void mover( VentanaGrafica v, double tiempo ) {
		for (Bola bola : listaBolas) {
			bola.mover( v, tiempo );
		}
	}
	
	/** Dibuja todas las bolas del grupo
	 * @param v	Ventana en la que dibujarlas
	 */
	public void dibujar( VentanaGrafica v ) {
		for (Bola bola : listaBolas) {
			bola.dibujar( v );
		}
	}
	
	public void choqueEntreBolas() {
		for (int i=0; i<listaBolas.size(); i++) {
			for (int j=i+1; j<listaBolas.size(); j++) {  // i y j no coinciden, son todas las parejas sin repetición
				Bola bola1 = listaBolas.get(i);
				Bola bola2 = listaBolas.get(j);
				if (bola1.choqueEntreBolas(bola2)) {  // Rebote - invertir velocidades
					bola1.setVelX( -bola1.getVelX() );
					bola1.setVelY( -bola1.getVelY() );
					bola2.setVelX( -bola2.getVelX() );
					bola2.setVelY( -bola2.getVelY() );
				}
			}
		}
	}
	
	/** Busca la bola que contiene a un punto de la ventana
	 * @param punto	Punto que se consulta
	 * @return	posición de la bola que lo contiene, -1 si ninguna está en ese punto
	 */
	public int buscarBolaEnPunto( Point punto ) {
		for (int i=0; i<listaBolas.size(); i++) {
			Bola bola = listaBolas.get(i);
			if (bola.contienePunto(punto)) {
				return i;
			}
		}
		return -1;
	}
	
}
