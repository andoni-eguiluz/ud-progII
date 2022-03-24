package tema2b.resueltos.registros;

/** Comportamiento de registros con precio
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public interface ConPrecio {
	/** Devuelve el precio del registro
	 * @return	Precio del registro en euros
	 */
	public double getPrecio(); 
	/** Informa si el precio está o no en el rango entre los precios inferior y superior indicados
	 * @param precioInferior	Precio inferior en euros
	 * @param precioSuperior	Precio superior en euros
	 * @return	true si el precio actual está en el rango solicitado, false en caso contrario
	 */
	public boolean estaPrecioEnRango( double precioInferior, double precioSuperior );  
}
