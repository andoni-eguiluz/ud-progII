package tema3.resueltos.registros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class GrupoRegistros {

	protected ArrayList<Registro> listaRegistros;
	protected HashSet<Registro> setRegistros;
	protected TreeSet<String> setUsuarios;
	protected HashMap<String,Integer> mapaConteoRegistros;
	
	public GrupoRegistros( String nomFichero ) {
		listaRegistros = new ArrayList<>();
		setRegistros = new HashSet<>();
		setUsuarios = new TreeSet<>();
		mapaConteoRegistros = new HashMap<>();
		Scanner lector = new Scanner( GrupoRegistros.class.getResourceAsStream( "datos-registro.txt" ) );
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			Registro registro = Registro.crearDeLinea( linea );
			if (registro!=null) {
				anyadirInterno( registro );
			}
		}
		lector.close();
	}
	
	public void anyadir( Registro registro ) {
		anyadirInterno( registro );
	}
	
	private void anyadirInterno( Registro registro ) {
		listaRegistros.add( registro );
		setRegistros.add( registro );
		if (registro instanceof RegistroDeUsuario) {
			RegistroDeUsuario ru = (RegistroDeUsuario) registro;
			setUsuarios.add( ru.getUsuario() );
		}
		if (registro instanceof RegistroDeUsuario) {
			RegistroDeUsuario ru = (RegistroDeUsuario) registro;
			if (mapaConteoRegistros.containsKey(ru.getUsuario())) {
				mapaConteoRegistros.replace( ru.getUsuario(), mapaConteoRegistros.get(ru.getUsuario()) + 1 );
			} else {
				mapaConteoRegistros.put( ru.getUsuario(), 1 );
			}
		}
	}
	
	public int getNumRegistros( String usuario ) {
		if (mapaConteoRegistros.containsKey(usuario)) {
			return mapaConteoRegistros.get( usuario );
		} else {
			return 0;
		}
	}
	
	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}
	
	public boolean estaEnGrupo( Registro r ) {
//		for (Registro reg : listaRegistros) {
//			if (reg.equals(r)) {
//				return true;
//			}
//		}
//		return false;
		return listaRegistros.contains( r ); // tiempo lineal
	}

	public boolean estaEnGrupoEficiente( Registro r ) {
		return setRegistros.contains( r );  // tiempo constante
	}

	public TreeSet<String> getUsuariosUnicosOrdenados() {
		return setUsuarios;
	}
	
}
