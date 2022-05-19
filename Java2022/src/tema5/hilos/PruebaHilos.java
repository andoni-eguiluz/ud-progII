package tema5.hilos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class PruebaHilos {
	public static void main(String[] args) {
		System.out.println( "inicio" );

		// Lanzar un segundo hilo antes del while - Swing
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		ventana.setLocation( 2800, 100 );
		ventana.setSize( 400, 300 );
		ventana.getContentPane().addMouseMotionListener( new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				visuCaracter( 'm' );
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		ventana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ventanaActiva = false;
			}
		});
		ventanaActiva = true;
		ventana.setVisible( true );
		
		// Lanzar un tercer hilo (Thread) antes de while
		Thread hilo = new Thread() {
			@Override
			public void run() {
				long tiempoIni = System.currentTimeMillis();
				while (ventanaActiva) {
					visuCaracter( 'h' );
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		hilo.start();  // Esto LANZA el nuevo hilo
		
		// Lanzar un cuarto hilo implementando Runnable
		Runnable ejecutable2 = new Runnable() {
			public void run() {
				long tiempoIni = System.currentTimeMillis();
				while (tiempoIni + 10000 > System.currentTimeMillis()) {
					visuCaracter( '2' );
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hilo2 = new Thread( ejecutable2 );
		hilo2.start();
		
		long tiempoIni = System.currentTimeMillis();
		while (tiempoIni + 10000 > System.currentTimeMillis()) {
			visuCaracter( '-' );
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Después while
	}
	
	private static boolean ventanaActiva = false;
	private static int numCars = 0;
	private static void visuCaracter( char caracter ) {
		System.out.print( caracter );
		numCars++;
		if (numCars>=100) {
			System.out.println();
			numCars = 0;
		}
	}
}
