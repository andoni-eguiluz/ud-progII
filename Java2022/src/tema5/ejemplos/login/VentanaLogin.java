package tema5.ejemplos.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame {
	
	private JTextField tfUsuario;
	private JTextField tfPassword;
	
	public VentanaLogin() {
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize( 600, 300 );
		this.setLocation( 2000, 100 );
		this.setTitle( "Login" );
		// 1.- Crear contenedores
		// new JFrame()  -- estoy en él
		JPanel pCentral = new JPanel();
		JPanel pLinea1 = new JPanel();
		JPanel pLinea2 = new JPanel();
		JPanel pInferior = new JPanel();
		// 2.- Configurar contenedores
		// this.setLayout( new BorderLayout() );  // por defecto
		// lo mismo por defecto pLinea1 y pLinea2 y pInferior
		pCentral.setLayout( new BoxLayout( pCentral, BoxLayout.Y_AXIS ));
		pCentral.setBackground( Color.YELLOW );
		pInferior.setBackground( Color.WHITE );
		pLinea1.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		pLinea2.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		// 3.- Crear componentes
		JLabel lMensajeSuperior = new JLabel( "Introduce usuario y contraseña" );
		JLabel lUsuario = new JLabel( "Usuario:" );
		tfUsuario = new JTextField( "", 12 );
		JLabel lPassword = new JLabel( "Password:" );
		tfPassword = new JTextField( "", 15 );
		JCheckBox cbRecuerdame = new JCheckBox( "Recuérdame", true );
		JLabel lMensajeInfo = new JLabel( " " );
		JLabel lLogo = new JLabel( new ImageIcon( "src/utils/ventanas/ventanaBitmap/img/UD-blue-girable.png" ) );
		JButton bRegistro = new JButton( "Registro" );
		JButton bAceptar = new JButton( "Aceptar" );
		JButton bCancelar = new JButton( "Cancelar" );
		JButton bOlvidada = new JButton( "He olvidado mi contraseña" );
		// 4.- Configuración de componentes
		bAceptar.setForeground( Color.GREEN );
		bAceptar.setEnabled( false );
		bOlvidada.setVisible( false );
		bCancelar.setToolTipText( "Pulsa aquí para cancelar el login" );
		// 5.- Asignación de componentes a contenedores
		this.add( lMensajeSuperior, BorderLayout.NORTH );
		this.add( lLogo, BorderLayout.WEST );
		this.add( pCentral, BorderLayout.CENTER );
		this.add( pInferior, BorderLayout.SOUTH );
		pCentral.add( pLinea1 );
		pCentral.add( pLinea2 );
		pCentral.add( cbRecuerdame );
		pCentral.add( lMensajeInfo );
		pLinea1.add( lUsuario );
		pLinea1.add( tfUsuario );
		pLinea2.add( lPassword );
		pLinea2.add( tfPassword );
		pInferior.add( bRegistro );
		pInferior.add( bAceptar );
		pInferior.add( bCancelar );
		pInferior.add( bOlvidada );
		// 6.- Crear y asignar gestores de evento
		bCancelar.addActionListener( new EscuchadorBoton() );
	}
	
	public String getUsuario() {
		return tfUsuario.getText();
	}
}

class EscuchadorBoton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println( "Pulsado!" );
	}
}
