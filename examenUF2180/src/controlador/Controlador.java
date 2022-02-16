/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import dao.DepartamentoDAO;
import modelo.Centro;
import modelo.Departamento;
import vista.DialogoA�adirCentro;
import vista.DialogoA�adirDepartamento;
import vista.VentanaMostrarCentros;
import vista.VentanaMostrarDepartamentos;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoA�adirCentro dialogoA�adirCentro;
	private VentanaMostrarDepartamentos ventanaMostrarDepartamentos;
	private DialogoA�adirDepartamento dialogoA�adirDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDAO departamentoDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoA�adirCentro = new DialogoA�adirCentro();
		ventanaMostrarDepartamentos = new VentanaMostrarDepartamentos();
		dialogoA�adirDepartamento= new DialogoA�adirDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoA�adirCentro.setControlador(this);
		ventanaMostrarDepartamentos.setControlador(this);
		dialogoA�adirDepartamento.setControlador(this);
		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDAO = new DepartamentoDAO();
	}
	
	
	/**
	 * M�todo que arranca el programa principal
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
		dialogoA�adirCentro.setVisible(true);
	}


	/** 
	 * M�todo del controlador que a�ade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Insercion del centro correcta");
			dialogoA�adirCentro.setVisible(false);
		}
	}
	
	public void mostrarListaDepartamentos() {
		ArrayList<Departamento> lista= departamentoDAO.obtenerDepartamentos();
		ventanaMostrarDepartamentos.setListaDepartamentos(lista);
		ventanaMostrarDepartamentos.setVisible(true);
	}
	
	public void insertaDepartamento(Departamento departamento) {
		// Invocando a departamentoDAO
		int resultado = departamentoDAO.insertarDepartamento(departamento);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoA�adirDepartamento, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(dialogoA�adirDepartamento, "Insercion del departamento correcta");
			dialogoA�adirDepartamento.setVisible(false);
		}
	}


	public void mostrarInsertarDepartamentos() {
		ArrayList<Centro> listaCentros = centroDAO.obtenerCentros();
		dialogoA�adirDepartamento.setCentros(listaCentros);
		dialogoA�adirDepartamento.setVisible(true);
		
	}
	
	
}
