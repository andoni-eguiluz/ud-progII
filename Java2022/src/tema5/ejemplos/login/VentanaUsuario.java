package tema5.ejemplos.login;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class VentanaUsuario extends JFrame {
	private static final int ANCHO_LABEL_DATO = 40;
	private static final int ALTO_LABEL_DATO = 20;
	private DatoUsuario[] datos;
	private JPanel pCentral;
	private JComboBox<TipoUsuario> cbTipoUsuario;
	private JList<DatoUsuario> lDatosUsuario;
	private DefaultListModel<DatoUsuario> modeloDatosUsuario;
	public VentanaUsuario( DatoUsuario[] datos ) {
		// 1.- Configurar ventana
		setDatosUsuario(datos);
		
		this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );

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
		cbTipoUsuario = new JComboBox<TipoUsuario>( TipoUsuario.values() );
		modeloDatosUsuario = new DefaultListModel<>();
		for (DatoUsuario dato : datos) {
			modeloDatosUsuario.addElement( dato );
		}
		lDatosUsuario = new JList<DatoUsuario>( modeloDatosUsuario );
		JScrollPane spLista = new JScrollPane( lDatosUsuario );
		
		spLista.setPreferredSize( new Dimension( 100, 50 ) ); // Tamaños preferidos, mínimos, máximos
		
		// Los 3 más habituales de JScrollPane: JList, JTable, JTextArea
		// 5.- Configurar componentes
		configurarDatosPanelCentral();
		// 6.- Asignar componentes a contenedores
		add( pSuperior, BorderLayout.NORTH );
		add( pCentral, BorderLayout.CENTER );
		add( spLista, BorderLayout.WEST );
		pSuperior.add( cbTipoUsuario );
		// 7.- Eventos
		cbTipoUsuario.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( "COMBO " + cbTipoUsuario.getSelectedItem() + " " + e );
			}
		});
		lDatosUsuario.addListSelectionListener( new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					System.out.println( "LISTSELECTION " + e );
					for (Component c : pCentral.getComponents()) {
						JLabel l = (JLabel) c;
						if (l.getText().equals( ((DatoUsuario) lDatosUsuario.getSelectedValue()).getNombre() )) {
							l.setBackground( Color.GREEN );
						} else {
							l.setBackground( Color.LIGHT_GRAY );
						}
					}
				}
			}
		});
		// Posibilidad 1 - que el ratón lo escuche el panel
		MouseAdapter ma = new MouseAdapter() {  
			// MouseAdapter (clase) vs MouseListener (interfaz).  MouseAdapter además implementa tanto ML como MML
			JLabel lSelec = null;
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( "CLICK " + e );
				System.out.println( e.isControlDown() );
				if (e.getClickCount()==2) {
					JLabel l = new JLabel( "NEW" );
					l.setBackground( Color.LIGHT_GRAY );
					l.setOpaque( true );
					l.setHorizontalAlignment( JLabel.CENTER );
					l.setSize( ANCHO_LABEL_DATO, ALTO_LABEL_DATO );
					l.setLocation( e.getX()-ANCHO_LABEL_DATO/2, e.getY()-ALTO_LABEL_DATO/2 );
					pCentral.add( l );
					pCentral.repaint();  // Observar que sin el repaint() no se ve salvo que se reescale la ventana (algunos cambios en caliente necesitan repaint()
					// otros necesitan revalidate() - si hay cambio significativo de layout
					// Añadir item:
					DatoUsuario du = new DatoUsuario( "NEW", e.getX(), e.getY() );
					modeloDatosUsuario.addElement( du );
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println( "PRESSED " + e );
				lSelec = null;
				for (Component c : pCentral.getComponents()) {
					double dist = e.getPoint().distance( c.getX()+ANCHO_LABEL_DATO/2, c.getY()+ ALTO_LABEL_DATO/2);
					if (dist < 11) {
						if (c instanceof JLabel) {
							JLabel l = (JLabel) c;
							lSelec = l;
							lSelec.setBackground( Color.CYAN );
							break;
						}
					}
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println( "DRAGGED " + e );
				if (lSelec!=null) {
					lSelec.setLocation( e.getX()-ANCHO_LABEL_DATO/2, e.getY()-ALTO_LABEL_DATO/2 );
				}
				// TODO pendiente actualizar el item correspondinte
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println( "RELEASED " + e );
				if (lSelec!=null) {
					lSelec.setBackground( Color.LIGHT_GRAY );
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println( "ENTERED " + e );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println( "EXITED " + e );
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println( "MOVED " + e );
			}
		};
		pCentral.addMouseListener( ma );
		pCentral.addMouseMotionListener( ma );
		// Posibilidad 2 - que el ratón lo escuchen los labels
		// (ver código de configurarDatosPanelCentral)

		pCentral.addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println( "COMP RESIZED" );
				for (Component c : pCentral.getComponents()) {
					JLabel l = (JLabel) c;
					if (l.getX()+ANCHO_LABEL_DATO > pCentral.getWidth() || l.getY()+ALTO_LABEL_DATO>pCentral.getHeight()) {
						l.setBackground( Color.RED );
					}
				}
			}
		});
		this.addWindowListener( new WindowListener() {  
			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println( "WINDOW ICONIFIED" );
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println( "WINDOW DEICONIFIED" );
			}
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println( "WINDOW ACTIVATED" );
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println( "WINDOW DEACTIVATED" );
			}
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println( "WINDOW OPENED" );
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println( "WINDOW CLOSING" );
				if (cbTipoUsuario.getSelectedItem()==TipoUsuario.ADMINISTRADOR) {
					VentanaUsuario.this.dispose();  // Observar esta notación de this (para clases internas)
				}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println( "WINDOW CLOSED" );
			}
		});
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
			
			// Posibilidad 2 de eventos de ratón
			MouseAdapter ma = new MouseAdapter() {
				Point posicionInicial;
				Point posicionLabelInicial;
				@Override
				public void mousePressed(MouseEvent e) {
					posicionInicial = e.getPoint();
					l.setBackground( Color.CYAN );
					posicionLabelInicial = l.getLocation();
				}
				@Override
				public void mouseDragged(MouseEvent e) {
					if (posicionInicial!=null) {
						int despX = e.getX()-posicionInicial.x;
						int despY = e.getY()-posicionInicial.y;
						System.out.println( posicionInicial + " --> " + e.getPoint() + " - despl. " + despX + "," + despY );
						l.setLocation( l.getX() + despX, l.getY() + despY );
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					posicionInicial = null;
					l.setBackground( Color.LIGHT_GRAY );
					// TODO actualizar el dato en la lista / contenedor de datos
					// Comprobar que el drag no se haga fuera de la ventana
					recolocarLabel( l, posicionLabelInicial );
				}
			};
			l.addMouseListener(ma);
			l.addMouseMotionListener(ma);
		}
	}
	
	private void recolocarLabel( JLabel l, Point posicionInicial ) {
		Thread hilo = new Thread() {
			public void run() {
				Point posicion = l.getLocation();
				if (posicion.x>pCentral.getWidth() || posicion.y>pCentral.getHeight() || posicion.x<0 || posicion.y<0) {
					double posX = l.getX();
					double posY = l.getY();
					double incX = (posicionInicial.x - posX) / 100;
					double incY = (posicionInicial.y - posY) / 100;
					l.setBackground( Color.YELLOW );
					for (int i=0; i<100; i++) {
						posX += incX;
						posY += incY;
						l.setLocation( (int) posX, (int) posY );
						try {
							Thread.sleep( 50 );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					l.setBackground( Color.LIGHT_GRAY );
				}
			}
		};
		hilo.start();
	}
	
	public void setDatosUsuario( DatoUsuario[] datos ) {
		this.datos = datos;
	}
}
