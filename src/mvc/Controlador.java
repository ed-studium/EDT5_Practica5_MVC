package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
public class Controlador implements WindowListener, ActionListener 
{
	String BaseDatos="empresa";
	String UsuarioDB="root";
	String ClaveBD="Studium.2019;";
	int contador = 0;
	Vista vista = null;
	Modelo modelo = null;
	public Controlador(Vista vista, Modelo modelo) 
	{
		this.vista = vista;
		this.modelo = modelo;
		// Añadir los Listeners a las opciones de menú, a los botones, al dialog y al Frame

		vista.mniConsulta.addActionListener(this);
		vista.mniAlta.addActionListener(this);
		vista.mniMod.addActionListener(this);
		vista.mniBorrar.addActionListener(this);
		vista.btnOperar1.addActionListener(this);
		vista.btnOperar2.addActionListener(this);
		vista.btnOperar3.addActionListener(this);
		vista.btnOperar4.addActionListener(this);
		vista.btnOperar5.addActionListener(this);
		vista.btnOperar6.addActionListener(this);
		vista.btnOperar7.addActionListener(this);
		vista.btnOperar8.addActionListener(this);
		vista.dlgDatos.addWindowListener(this);
		vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		Object a = evento.getSource();
		if (a.equals(vista.mniConsulta)) 
		{
			// Asigno la etiqueta al botón
			vista.btnOperar1.setLabel("Atras");
			vista.btnOperar2.setLabel("Siguiente");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlConsulta);
			
			try {
				// Para averiguar el número de registros obtenidos
				while (modelo.rs.next()) {
					contador++;
				}
				modelo.rs.first();
				// Poner en los TextField los valores obtenidos del 1º
				vista.txtIdEmpleadoC.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
				vista.txtNombreEmpleadoC.setText(modelo.rs.getString("nombreEmpleado"));
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}

		if (a.equals(vista.mniAlta)) 
		{
			// Asigno la etiqueta al botón
			vista.btnOperar3.setLabel("Aceptar");
			vista.btnOperar4.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlAlta);
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.mniMod)) 
		{
			// Asigno la etiqueta al botón
						vista.btnOperar5.setLabel("Atras");
						vista.btnOperar6.setLabel("Siguiente");
						// Añadimos el panel al Dialog
						vista.dlgDatos.add(vista.pnlMod);
						
						try {
							// Para averiguar el número de registros obtenidos
							while (modelo.rs.next()) {
								contador++;
							}
							modelo.rs.first();
							// Poner en los TextField los valores obtenidos del 1º
							vista.txtIdEmpleadoM.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
							vista.txtNombreEmpleadoM.setText(modelo.rs.getString("nombreEmpleado"));
						} catch (SQLException e) {
							System.out.println("Error en la sentencia SQL" + e.getMessage());
						}
						// Asignamos un tamaño al Dialog
						vista.dlgDatos.setSize(190, 250);
						// Hacemos visible el Dialog
						vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.mniBorrar)) 
		{
			// Asigno la etiqueta al botón
			vista.btnOperar7.setLabel("Atras");
			vista.btnOperar8.setLabel("Siguiente");
			vista.btnOperar11.setLabel("Borrar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlBorrar);
			try {
				// Para averiguar el número de registros obtenidos
				while (modelo.rs.next()) {
					contador++;
				}
				modelo.rs.first();
				// Poner en los TextField los valores obtenidos del 1º
				vista.txtIdEmpleadoB.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
				vista.txtNombreEmpleadoB.setText(modelo.rs.getString("nombreEmpleado"));
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.btnOperar1)) 
		{
			try {
					if (modelo.rs.previous()) {
						vista.txtIdEmpleadoC.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
						vista.txtNombreEmpleadoC.setText(modelo.rs.getString("nombreEmpleado"));
				} 
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
		}
		if (a.equals(vista.btnOperar2)) 
		{
			try {
				// Si no hemos llegado al final
				if (modelo.rs.next()) {
					// Poner en los TextField los valores obtenidos
					vista.txtIdEmpleadoC.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
					vista.txtNombreEmpleadoC.setText(modelo.rs.getString("nombreEmpleado"));
				}
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
		}
		if (a.equals(vista.btnOperar3)) 
		{
			// Conectar BD
						Connection conAceptar=modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
						// Hacer el INSERT
						int respuesta = modelo.insertar (conAceptar, "empleados", vista.txtNombreEmpleadoA.getText());
						// Mostramos resultado
						if(respuesta == 0)
						{
							System.out.println("Alta realizada Correctamente");
						}
						else
						{
							System.out.println("Error en ALTA de empleado");
						}
						// Desconectar de la base
					
						modelo.desconectar(conAceptar);
			
			
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}
		if (a.equals(vista.btnOperar4)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}
		if (a.equals(vista.btnOperar5)) 
		{
			try {
					if (modelo.rs.previous()) {
						vista.txtIdEmpleadoM.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
						vista.txtNombreEmpleadoM.setText(modelo.rs.getString("nombreEmpleado"));
				} 
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
		}
		if (a.equals(vista.btnOperar6)) 
		{
			try {
				// Si no hemos llegado al final
				if (modelo.rs.next()) {
					// Poner en los TextField los valores obtenidos
					vista.txtIdEmpleadoM.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
					vista.txtNombreEmpleadoM.setText(modelo.rs.getString("nombreEmpleado"));
				}
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
		}
		if (a.equals(vista.btnOperar7)) 
		{
			try {
					if (modelo.rs.previous()) {
						vista.txtIdEmpleadoB.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
						vista.txtNombreEmpleadoB.setText(modelo.rs.getString("nombreEmpleado"));
				} 
					
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
			if (a.equals(vista.btnOperar11)) 
			{
				System.out.println("Pulsando boton borrado");
				Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD); 
				// Borrar
				int respuesta = modelo.borrar(con, vista.txtIdEmpleadoB.getText());
				// Mostramos resultado
				if(respuesta == 0)
				{
					System.out.println("Borrado de Clinica correcto");
				}
				else
				{
					System.out.println("Error en Borrado de Clinica");
				}
			}
		}
		if (a.equals(vista.btnOperar8)) 
		{
			try {
				// Si no hemos llegado al final
				if (modelo.rs.next()) {
					// Poner en los TextField los valores obtenidos
					vista.txtIdEmpleadoB.setText(Integer.toString(modelo.rs.getInt("idEmpleado")));
					vista.txtNombreEmpleadoB.setText(modelo.rs.getString("nombreEmpleado"));
				}
				
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
			if (a.equals(vista.btnOperar11)) 
			{
				System.out.println("Pulsando boton borrado");
				Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD); 
				// Borrar
				int respuesta = modelo.borrar(con, vista.txtIdEmpleadoB.getText());
				// Mostramos resultado
				if(respuesta == 0)
				{
					System.out.println("Borrado de Clinica correcto");
				}
				else
				{
					System.out.println("Error en Borrado de Clinica");
				}
			}
		}

		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosed(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosing(WindowEvent we) 
	{
		if (vista.dlgDatos.isActive()) 
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		} 
		else 
		{
			System.exit(0);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void windowIconified(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void windowOpened(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
}