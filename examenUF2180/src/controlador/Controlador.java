/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import modelo.Centro;
import vista.DialogoAñadirCentro;
import vista.VentanaMostrarCentros;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoAñadirCentro dialogoAñadirCentro;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoAñadirCentro = new DialogoAñadirCentro();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoAñadirCentro.setControlador(this);

		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
	}
	
	
	/**
	 * Método que arranca el programa principal
	 */
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarListarCentros() {
		ArrayList<Centro> lista = centroDAO.obtenerCentros();
		ventanaMostrarCentros.setListaCentros(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	
	public void mostrarInsertarCentros() {
		dialogoAñadirCentro.setVisible(true);
	}


	/** 
	 * Método del controlador que añade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Insercion del centro correcta");
			dialogoAñadirCentro.setVisible(false);
		}
	}
	
	
}
