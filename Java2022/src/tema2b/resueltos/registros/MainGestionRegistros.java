package tema2b.resueltos.registros;

public class MainGestionRegistros {

	public static void main(String[] args) {
		GrupoRegistros grupo = new GrupoRegistros( "datos-registro.txt" );
		System.out.println( "TODOS LOS REGISTROS:" );
		for (Registro reg : grupo.getListaRegistros()) {
			System.out.println( "  " + reg );
		}
		// TODO Listar solo los registros de usuario
		// TODO Listar solo los precios
		System.out.println( "LISTA DE PRECIOS" );
		double suma = 0;
		double cont = 0;
		for (Registro reg : grupo.getListaRegistros()) {
//			if (reg instanceof PrecioCarburante) {
//				
//			} else if (reg instanceof PrecioElectricidad) {
//				
//			}
			if (reg instanceof ConPrecio) {
				ConPrecio precio = (ConPrecio) reg;
				System.out.println( reg.toString() + " --> precio " + precio.getPrecio() );
				suma += precio.getPrecio();
				cont++;
			}
		}
		System.out.println( "MEDIA DE PRECIOS = " + (suma/cont) );
		// TODO Calcular la media de todos los precios
		// TODO Listar todos los usuarios
		// TODO Listar los precios en rango 0.4 y 1.8
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof ConPrecio) {
				ConPrecio precio = (ConPrecio) reg;
				if (precio.estaPrecioEnRango(0.4, 1.8)) {
					System.out.println( precio );
				}
			}
		}
	}

}
