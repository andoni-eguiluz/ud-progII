package tema2.resueltos.brickBreaker;

import java.awt.Color;
import java.awt.Font;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class BloqueRompible extends Bloque {
	
	protected int vida;

	/** Crea un bloque nuevo
	 * @param x	Coordenada x del centro
	 * @param y	Coordenada x del centro
	 * @param ancho	Píxels de ancho
	 * @param alto	Píxels de alto
	 * @param color	Color de borde
	 * @param colorFondo	Color de fondo
	 * @param vidaInicial	Valor inicial de vida del objeto (mayor que cero)
	 */
	public BloqueRompible(double x, double y, double ancho, double alto, Color color, Color colorFondo, int vidaInicial ) {
		super( x, y, ancho, alto, 0, 0, color, colorFondo );
		vida = vidaInicial;
	}
	
	@Override
	public void dibujar(VentanaGrafica v) {
		super.dibujar(v);
		Font miTipo = new Font( "Arial", Font.PLAIN, 20 );
		Color colorTexto = Color.WHITE;
		if (colorFondo.getRed()>100 && colorFondo.getGreen()>100 && colorFondo.getBlue()>100) {
			colorTexto = Color.BLACK;
		}
		v.dibujaTextoCentrado( getX()-getAncho()/2, y-alto/2, ancho, alto, vida + "", miTipo, colorTexto, true );
	}
}
