package tema5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class MiPrimeraVentana {
	public static void main(String[] args) {
		// Ventanas Frame (antigua - AWT) - JFrame (Swing)
		// Construcción
		// 1.- Crear contenedor principal
		JFrame ventana = new JFrame();
		ventana.setSize( 600, 400 );
		ventana.setLocation( 2000, 0 );
		ventana.setTitle( "Prueba de ventana" );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// 1b.- Crear contenedores secundarios
		JPanel panelInferior = new JPanel();
		JPanel panelCentral = new JPanel();
		// 1c.- Definir layouts
		ventana.setLayout( new BorderLayout() );  // Por defecto las ventanas
		// ventana.setLayout( new FlowLayout() );
		// ventana.setLayout( new BoxLayout( ventana.getContentPane(), BoxLayout.X_AXIS ));
		// ventana.setLayout( null );
		panelInferior.setLayout( new FlowLayout() );  // Por defecto en los paneles
		// 2.- Crear componentes
		JButton boton = new JButton( "Púlsame mucho!" );
		JButton boton2 = new JButton( "A mí!!" );
		JButton boton3 = new JButton( "Botón 3" );
		JButton boton4 = new JButton( "Botón 4" );
		JButton boton5 = new JButton( "Botón 5" );
		JButton boton6 = new JButton( "Otro" );
		JTextField textFieldNombre = new JTextField( "", 20 );
		JTextArea textAreaDatos = new JTextArea( 5, 50 );
		JLabel labelEtiqueta = new JLabel( "Introduce info" );
		JCheckBox checkBox = new JCheckBox( "Selecciona" );
		String[] opciones = { "opción 1", "opción 2", "opción 3" };
		JComboBox comboBox = new JComboBox<>( opciones );
		// 2b.- Configurar componentes
		boton.setSize( 150, 50 );
		boton.setLocation( 200, 100 );
		boton2.setBounds( 220, 120, 100, 40 );
		// 3.- Añadir componentes al contenedor principal y secundarios
		ventana.add( boton, BorderLayout.NORTH );
		ventana.add( boton3, BorderLayout.EAST );
		ventana.add( boton4, BorderLayout.WEST );
		ventana.add( panelCentral, BorderLayout.CENTER );
		ventana.add( panelInferior, BorderLayout.SOUTH );
		panelInferior.add( boton2 );
		panelInferior.add( boton6 );
		panelCentral.add( labelEtiqueta );
		panelCentral.add( textFieldNombre );
		panelCentral.add( boton5 );
		panelCentral.add( textAreaDatos );
		panelCentral.add( checkBox );
		panelCentral.add( comboBox );
		
		
		// Visibilizarla
		ventana.setVisible( true );  // MAGIA!
		// ventana.dispose();
		// Si quisiéramos podríamos tener más ventanas
		/*
		JFrame v2 = new JFrame();
		v2.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		v2.setVisible( true );
		*/
		System.out.println( "fin" );
	}
}
