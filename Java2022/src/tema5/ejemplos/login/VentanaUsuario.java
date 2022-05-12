package tema5.ejemplos.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaUsuario extends JFrame {
	private static final int ANCHO_LABEL_DATO = 40;
	private static final int ALTO_LABEL_DATO = 20;
	private DatoUsuario[] datos;
	private JPanel pCentral;
	private JComboBox<TipoUsuario> cbTipoUsuario;
	private JList lDatosUsuario;
	private DefaultListModel<DatoUsuario> modeloDatosUsuario;
	public VentanaUsuario( DatoUsuario[] datos ) {
		// 1.- Configurar ventana
		setDatosUsuario(datos);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Gestión de usuario" );
		setSize( 400, 300 );
		// setLayout( new BorderLayout() );  No hace falta
		// 2.- Crear contenedores
		pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		// 3.- Configurar contenedores
		// pSuperior.setLayout( new FlowLayout() );   No hace falta
		pCentral.setLayout( null );
		pCentral.setBackground( Color.WHITE );
		// 4.- Crear componentes
		cbTipoUsuario = new JComboBox( TipoUsuario.values() );
		modeloDatosUsuario = new DefaultListModel<>();
		for (DatoUsuario dato : datos) {
			modeloDatosUsuario.addElement( dato );
		}
		lDatosUsuario = new JList( modeloDatosUsuario );
		JScrollPane spLista = new JScrollPane( lDatosUsuario );
		// Los 3 más habituales de JScrollPane: JList, JTable, JTextArea
		// 5.- Configurar componentes
		configurarDatosPanelCentral();
		// 6.- Asignar componentes a contenedores
		add( pSuperior, BorderLayout.NORTH );
		add( pCentral, BorderLayout.CENTER );
		add( spLista, BorderLayout.WEST );
		pSuperior.add( cbTipoUsuario );
	}
	private void configurarDatosPanelCentral() {
		pCentral.removeAll();
		for (DatoUsuario dato : datos) {
			JLabel l = new JLabel();
			l.setLocation( dato.getX() - ANCHO_LABEL_DATO/2, dato.getY() - ALTO_LABEL_DATO/2);
			l.setSize( ANCHO_LABEL_DATO, ALTO_LABEL_DATO );
			l.setBackground( Color.LIGHT_GRAY );
			l.setText( dato.getNombre() );
			l.setOpaque( true );
			l.setHorizontalAlignment( JLabel.CENTER );
			pCentral.add( l );
		}
	}
	public void setDatosUsuario( DatoUsuario[] datos ) {
		this.datos = datos;
	}
}
