package mvc;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
public class Vista extends Frame {
	private static final long serialVersionUID = 1L;
	// Elementos del Menú
	MenuBar mb = new MenuBar();
	Menu mnEmpleado = new Menu("Empleado");
	MenuItem mniConsulta = new MenuItem("Consulta");
	MenuItem mniAlta = new MenuItem("Alta");
	MenuItem mniMod = new MenuItem("Modificar");
	MenuItem mniBorrar = new MenuItem("Borrar");
	// Elementos del diálogo
	Dialog dlgDatos = new Dialog(this, "Diálogo con mensaje", true);
	
	Panel pnlConsulta = new Panel();
	Panel pnlConsulta1 = new Panel();
	Panel pnlAlta = new Panel();
	Panel pnlMod = new Panel();
	Panel pnlBorrar = new Panel();
	
	Button btnOperar11 = new Button("");
	Button btnOperar21 = new Button("");
	Label lblEmpleadoChC = new Label("Selecciona el empleado:");
	Choice choEmpleadoC = new Choice();
	
	Label lblConsulta = new Label("Consulta de Empleado");
	Label lblIdEmpleadoC = new Label("Id Empleado");
	Label lblNombreEmpleadoC = new Label("Nombre Empleado");
	TextField txtIdEmpleadoC = new TextField(20);
	TextField txtNombreEmpleadoC = new TextField(20);
	Button btnOperar1 = new Button("");
	Button btnOperar2 = new Button("");
	
	Label lblAlta = new Label("Alta de Empleado");
	Label lblIdEmpleadoA = new Label("Id Empleado");
	Label lblNombreEmpleadoA = new Label("Nombre Empleado");
	TextField txtIdEmpleadoA = new TextField(20);
	TextField txtNombreEmpleadoA = new TextField(20);
	Button btnOperar3 = new Button("");
	Button btnOperar4 = new Button("");
	
	Label lblMod = new Label("Modificacion de Empleado");
	Label lblIdEmpleadoM = new Label("Id Empleado");
	Label lblNombreEmpleadoM = new Label("Nombre Empleado");
	TextField txtIdEmpleadoM = new TextField(20);
	TextField txtNombreEmpleadoM = new TextField(20);
	Button btnOperar5 = new Button("");
	Button btnOperar6 = new Button("");
	
	Label lblBorrar = new Label("Borrado de Empleado");
	Label lblIdEmpleadoB = new Label("Id Empleado");
	Label lblNombreEmpleadoB = new Label("Nombre Empleado");
	TextField txtIdEmpleadoB = new TextField(20);
	TextField txtNombreEmpleadoB = new TextField(20);
	Button btnOperar7 = new Button("");
	Button btnOperar8 = new Button("");
	
	// Campos de texto para introducir el valor y exponente del monomio

	public Vista() {
		setLayout(new FlowLayout());
		// Establecer el título de la aplicación
		setTitle("Empleados");
		// Montar el menú
		setMenuBar(mb);
		mb.add(mnEmpleado);
		mnEmpleado.add(mniConsulta);
		mnEmpleado.add(mniAlta);
		mnEmpleado.add(mniMod);
		mnEmpleado.add(mniBorrar);
		// Montar los paneles
		pnlConsulta1.add(lblEmpleadoChC);
		pnlConsulta1.add(choEmpleadoC);
		
		pnlConsulta1.add(btnOperar21);
		pnlConsulta.add(lblConsulta);
		pnlConsulta.add(lblIdEmpleadoC);
		pnlConsulta.add(txtIdEmpleadoC);
		pnlConsulta.add(lblNombreEmpleadoC);
		pnlConsulta.add(txtNombreEmpleadoC);
		pnlConsulta.add(btnOperar1);
		pnlConsulta.add(btnOperar2);
		
		pnlAlta.add(lblAlta);
		pnlAlta.add(lblIdEmpleadoA);
		pnlAlta.add(txtIdEmpleadoA);
		pnlAlta.add(lblNombreEmpleadoA);
		pnlAlta.add(txtNombreEmpleadoA);
		pnlAlta.add(btnOperar3);
		pnlAlta.add(btnOperar4);
		
		pnlMod.add(lblMod);
		pnlMod.add(lblIdEmpleadoM);
		pnlMod.add(txtIdEmpleadoM);
		pnlMod.add(lblNombreEmpleadoM);
		pnlMod.add(txtNombreEmpleadoM);
		pnlMod.add(btnOperar5);
		pnlMod.add(btnOperar6);
		
		pnlBorrar.add(lblBorrar);
		pnlBorrar.add(lblIdEmpleadoB);
		pnlBorrar.add(txtIdEmpleadoB);
		pnlBorrar.add(lblNombreEmpleadoB);
		pnlBorrar.add(txtNombreEmpleadoB);
		pnlBorrar.add(btnOperar7);
		pnlBorrar.add(btnOperar8);
		pnlBorrar.add(btnOperar11);
		
		// Establecer el tamaño del Frame
		setSize(200, 200);
		
		txtIdEmpleadoC.setEnabled(false);
		txtIdEmpleadoA.setEnabled(false);
		txtIdEmpleadoM.setEnabled(false);
		txtIdEmpleadoB.setEnabled(false);
		
		// Mostrar el Frame en pantalla
		setVisible(true);
	}
}