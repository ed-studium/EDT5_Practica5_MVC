package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
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
		vista.btnOperar11.addActionListener(this);
		vista.btnOperar21.addActionListener(this);
		vista.aceptar.addActionListener(this);
		vista.dlgDatos.addWindowListener(this);
		vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		Object a = evento.getSource();
		// Evento de menu consulta.
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
			} 
			catch (SQLException e) {
				System.out.println("Error en la sentencia SQL" + e.getMessage());
			}
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		// Evento de menu Alta.
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
		// Evento de menu Modificar.
		if (a.equals(vista.mniMod)) 
		{
			vista.choEmpleadoM.add("Seleccionar uno...");
			// Conectar a la base de datos
			Connection con4 = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
			// Sacar los datos de la tabla edificios
			// Rellenar el Choice
			String sqlSelect4 = "SELECT * FROM empleados";
			try {
				// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
				Statement stmt4 = con4.createStatement();
				ResultSet rs4 = stmt4.executeQuery(sqlSelect4);
				while (rs4.next()) 
				{
					vista.choEmpleadoM.add(rs4.getInt("idEmpleado")+
							"-"+rs4.getString("nombreEmpleado"));
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERROR: En la consulta"+"\n"+ex);
				ex.printStackTrace();
			}
			// Cerrar la conexión
			modelo.desconectar(con4);
			vista.dlgDatos2.add(vista.pnlMod1);
			vista.btnOperar5.setLabel("Seleccionar");
			
						// Asignamos un tamaño al Dialog
						vista.dlgDatos2.setSize(190, 250);
						// Hacemos visible el Dialog
						vista.dlgDatos2.setVisible(true);	
		}
		// Evento de boton selecionar de modificar
				if (a.equals(vista.btnOperar5)) 
				{
					Connection con6 = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD); 
					int EmpleadoM = Integer.parseInt(vista.choEmpleadoM.getSelectedItem().split("-")[0]);
					String sql6 = "SELECT * FROM empleados WHERE idEmpleado = "+EmpleadoM;
					
					try 
					{ 
						vista.txtIdEmpleadoM.setText(EmpleadoM+"");
						// Creamos un STATEMENT para una consulta SQL INSERT.
						Statement stmt6 = con6.createStatement();
						ResultSet rs6 = stmt6.executeQuery(sql6);
						while (rs6.next()) 
						{
							vista.txtIdEmpleadoM.setText(Integer.toString(rs6.getInt("idEmpleado")));
							vista.txtNombreEmpleadoM.setText(rs6.getString("nombreEmpleado"));
						}
					}
					
					catch (SQLException ex) 
					{
						JOptionPane.showMessageDialog(null, "ERROR:al mostrar"+"\n"+ex);
						ex.printStackTrace();
					}
					
					modelo.desconectar(con6);
					vista.btnOperar6.setLabel("Guardar");
					vista.dlgDatos.add(vista.pnlMod);
					// Asignamos un tamaño al Dialog
					vista.dlgDatos.setSize(190, 250);
					// Hacemos visible el Dialog
					vista.dlgDatos.setVisible(true);
				}
		if (a.equals(vista.mniBorrar)) 
		{

			vista.choEmpleadoB.add("Seleccionar uno...");
			// Conectar a la base de datos
			Connection con3 = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
			// Sacar los datos de la tabla edificios
			// Rellenar el Choice
			String sqlSelect = "SELECT * FROM empleados";
			try {
				// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
				Statement stmt3 = con3.createStatement();
				ResultSet rs3 = stmt3.executeQuery(sqlSelect);
				while (rs3.next()) 
				{
					vista.choEmpleadoB.add(rs3.getInt("idEmpleado")+
							"-"+rs3.getString("nombreEmpleado"));
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERROR: En la consulta"+"\n"+ex);
				ex.printStackTrace();
			}
			// Cerrar la conexión
			modelo.desconectar(con3);
			
			vista.btnOperar21.setLabel("Borrar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlBorrar1);
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		// Evento de boton Borrar.
		Object ab = evento.getSource();
		if (ab.equals(vista.btnOperar21)) 
		{
			
			// Conectar a BD
						Connection con4 = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD); 
						// Borrar
						String[] EmpleadoB=vista.choEmpleadoB.getSelectedItem().split("-");
						int respuesta = modelo.borrar2(con4, Integer.parseInt(EmpleadoB[0]));
						// Mostramos resultado
						if(respuesta == 0)
						{
							//Muestra una ventana indicando que el alta, se ha realizado correctamente
							String Titulo="Borrado realizada";
							String Etiqueta="Borrado realizada Correctamente";
							vista.dialogo(Etiqueta, Titulo);
						}
						else
						{
							//Muestra una ventana indicando que el alta, no se ha realizado
							String Titulo="Borrado Erronea";
							String Etiqueta="Error en borrado";
							vista.dialogo(Etiqueta, Titulo);
						}
						// Actualizar el Choice
						vista.choEmpleadoB.removeAll();
						vista.choEmpleadoB.add("Seleccionar uno...");
						String sqlSelect = "SELECT * FROM empleados";
						try {
							// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
							Statement stmt4 = con4.createStatement();
							ResultSet rs4 = stmt4.executeQuery(sqlSelect);
							while (rs4.next()) 
							{
								vista.choEmpleadoB.add(rs4.getInt("idEmpleado")+
										"-"+rs4.getString("nombreEmpleado"));
							}
						} catch (SQLException ex) {
							JOptionPane.showMessageDialog(null, "ERROR: En la consultar"+"\n"+ex);
							ex.printStackTrace();
						}
						// Desconectar
						modelo.desconectar(con4);
		}
		// Evento de boton atras de consulta 
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
		// Evento de boton siguiente de consulta
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
							//Muestra una ventana indicando que el alta, se ha realizado correctamente
							String Titulo="Alta realizada";
							String Etiqueta="Alta realizada Correctamente";
							vista.dialogo(Etiqueta, Titulo);
						}
						else
						{
							//Muestra una ventana indicando que el alta, no se ha realizado
							String Titulo="Alta Erronea";
							String Etiqueta="Error en alta";
							vista.dialogo(Etiqueta, Titulo);
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
		
		// Evento de boton Guardar de modificar
		if (a.equals(vista.btnOperar6)) 
		{
			
			int respuesta = 0;
			int idEmpleadoM = Integer.parseInt(vista.txtIdEmpleadoM.getText());
			String nombreEmpleadoM = vista.txtNombreEmpleadoM.getText();
			
			// Conectar a la base de datos
			Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
			// Ejecutar el UPDATE
			String sql ="UPDATE empleados SET nombreEmpleado = '"+nombreEmpleadoM+"' WHERE idEmpleado="+idEmpleadoM;
			try {
				// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERROR:al insertar los cambios"+"\n"+ex);
				ex.printStackTrace();
				respuesta = 1;
			}
			// Cerrar la conexión
			modelo.desconectar(con);
			
			if(respuesta == 0)
			{
				//Muestra una ventana indicando que el alta, se ha realizado correctamente
				String Titulo="Modificacion realizada";
				String Etiqueta="Modificacion realizada Correctamente";
				vista.dialogo(Etiqueta, Titulo);
			}
			else
			{
				//Muestra una ventana indicando que el alta, no se ha realizado
				String Titulo="Modificacion Erroneaa";
				String Etiqueta="Error en Modificacion";
				vista.dialogo(Etiqueta, Titulo);
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
			// Cerrar la conexión
						modelo.desconectar(con);
		}
		if (a.equals(vista.aceptar)) 
		{

			vista.dlgDatos3.removeAll();
			vista.dlgDatos3.setVisible(false);
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
		//Lo pongo para forzar a salir.
		if (vista.dlgDatos.isActive() || vista.dlgDatos2.isActive()||vista.dlgDatos3.isActive())
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos.removeAll();
			vista.dlgDatos.setVisible(false);
			vista.dlgDatos2.removeAll();
			vista.dlgDatos2.setVisible(false);
			vista.dlgDatos3.removeAll();
			vista.dlgDatos3.setVisible(false);
		} else if ((vista.dlgDatos.isActive()) & (vista.dlgDatos2.isActive())&(vista.dlgDatos3.isActive()))
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos.removeAll();
			vista.dlgDatos.setVisible(false);
			vista.dlgDatos2.removeAll();
			vista.dlgDatos2.setVisible(false);
			vista.dlgDatos3.removeAll();
			vista.dlgDatos3.setVisible(false);
		} else if (vista.dlgDatos2.isActive()) 
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos2.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos2.setVisible(false);
		}else if (vista.dlgDatos.isActive()) 
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		} 
		else if (vista.dlgDatos.isActive()) 
		{
			// Funciones que inician el valor de los componentes del Dialog.
			// Elimina todos los componentes del Dialog.
			vista.dlgDatos3.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos3.setVisible(false);
		} else
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
