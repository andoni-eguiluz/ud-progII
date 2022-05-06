package tema5.ejemplos.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame {
	
	private JTextField tfUsuario;
	private JTextField tfPassword;
	private JLabel lMensajeInfo;
	
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
		lMensajeInfo = new JLabel( " " );
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
		// bCancelar.addActionListener( new EscuchadorBotonExterno() );  // Posibilidad 1: clase externa
		// bCancelar.addActionListener( new EscuchadorBotonInterno() );  // Posibilidad 2: clase interna
		// Posibilidad 3: clase interna anónima
		bCancelar.addActionListener( new ActionListener() {
			// Creando un atributo equivalente a la local
			@Override
			public void actionPerformed(ActionEvent e) {
				// lLogo.setText( "logo?" );
				lMensajeInfo.setText( "Pulsado cancelar" );
			}
		});
		bAceptar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lMensajeInfo.setText( "Pulsado aceptar" );
			}
		});
		tfUsuario.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lMensajeInfo.setText( "Enter en texto usuario" );
			}
		});
		tfUsuario.addKeyListener( new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (tfUsuario.getText().length() >= 10) {
					e.consume();
				}
				if (e.getKeyChar()>='a' && e.getKeyChar()<='z') {
					System.out.println( "minúscula");
				} else {
					e.consume();
				}
				System.out.println( "TYPED " + e );
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println( "RELEASED " + e );
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println( "PRESSED " + e );
			}
		});
		KeyListener escuchadorEscape = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					dispose();
				}
			}
		};
		tfUsuario.addKeyListener(escuchadorEscape);
		tfPassword.addKeyListener(escuchadorEscape);
		cbRecuerdame.addKeyListener(escuchadorEscape);
		bAceptar.addKeyListener(escuchadorEscape);
		bCancelar.addKeyListener(escuchadorEscape);
		bOlvidada.addKeyListener(escuchadorEscape);
		bRegistro.addKeyListener(escuchadorEscape);
		tfUsuario.addFocusListener( new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println( "LOST " + e );
				System.out.println( "Valido que el usuario sea correcto..." );
				if (!tfUsuario.getText().equals("andoni")) {
					lMensajeInfo.setText( "Usuario incorrecto" );
					tfUsuario.requestFocus();
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println( "GAINED " + e );
				tfUsuario.select(0, tfUsuario.getText().length());
			}
		});
		KeyListener comprobarDatosEnUP = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (tfUsuario.getText().length()>0 && tfPassword.getText().length()>0) {
					bAceptar.setEnabled( true );
				} else {
					bAceptar.setEnabled( false );
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
		tfUsuario.addKeyListener(comprobarDatosEnUP);
		tfPassword.addKeyListener(comprobarDatosEnUP);
	}
	
	public String getUsuario() {
		// Podría acceder a este atributo: lMensajeInfo.setText( "Nada" );
		return tfUsuario.getText();
	}
	
	
	// 2: Clase interna
	class EscuchadorBotonInterno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println( "Pulsado!" );
			lMensajeInfo.setText( "Pulsado cancelar" );
		}
	}
	
}

// 1: Clase externa
class EscuchadorBotonExterno implements ActionListener {
	// private JLabel miCampoMensaje
	// public void setCampoMensaje( JLabel l ) ...
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println( "Pulsado!" );
		// No tenemos acceso a lMensajeInfo.setText( "Pulsado cancelar" );
	}
}
