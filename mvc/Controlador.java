package mvc;
import java.awt.TextField;
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
		vista.dlgDatos.addWindowListener(this);
		vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		Object a = evento.getSource();
		if (a.equals(vista.mniConsulta)) 
		{
			lista();
			// Asigno la etiqueta al botón
			vista.btnOperar11.setLabel("Buscar");
			vista.btnOperar21.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlConsulta1);
			// Asigno tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);

		}
		if (a.equals(vista.btnOperar11)) 
		{
			System.out.println("Entrando en consulta");
			int idE = Integer.parseInt(vista.choEmpleadoC.getSelectedItem().split("-")[0]);
			// Conectar a la base de datos
			Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
			mostrarDatos(con, idE, vista.txtIdEmpleadoM, vista.txtNombreEmpleadoM);

			//modelo.mostrarDatos(con, idE, vista.txtIdEmpleadoM, vista.txtNombreEmpleadoM);
			//modelo.desconectar(con);
			// Asigno la etiqueta al botón
			vista.btnOperar1.setLabel("Aceptar");
			vista.btnOperar2.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlConsulta);
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.btnOperar21)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
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
			vista.btnOperar5.setLabel("Aceptar");
			vista.btnOperar6.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlMod);
			// Asigno tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.mniBorrar)) 
		{
			// Asigno la etiqueta al botón
			vista.btnOperar7.setLabel("Aceptar");
			vista.btnOperar8.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlBorrar);
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.btnOperar1)) 
		{
			System.out.println("btn Operar 1");
			int idE = Integer.parseInt(vista.choEmpleadoC.getSelectedItem().split("-")[0]);
			String BaseDatos="empresa";
			String UsuarioDB="root";
			String ClaveBD="Studium.2019;";
			Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
			modelo.mostrarDatos(con, idE, vista.txtIdEmpleadoM, vista.txtNombreEmpleadoM);
			// Asigno la etiqueta al botón
			vista.btnOperar1.setLabel("Aceptar");
			vista.btnOperar2.setLabel("Cancelar");
			// Añadimos el panel al Dialog
			vista.dlgDatos.add(vista.pnlConsulta);
			// Asignamos un tamaño al Dialog
			vista.dlgDatos.setSize(190, 250);
			// Hacemos visible el Dialog
			vista.dlgDatos.setVisible(true);
		}
		if (a.equals(vista.btnOperar2)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}
		if (a.equals(vista.btnOperar3)) 
		{
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
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}
		if (a.equals(vista.btnOperar6)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}if (a.equals(vista.btnOperar7)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
		}
		if (a.equals(vista.btnOperar8)) 
		{
			vista.dlgDatos.removeAll();
			// Ocultamos el cuadro de diálogo.
			vista.dlgDatos.setVisible(false);
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
	public void lista() {
		Connection con = modelo.conectar(BaseDatos, UsuarioDB, ClaveBD);
		try {
			while (modelo.rs.next()) {
				vista.choEmpleadoC.add(modelo.rs.getInt("idEmpleado")+
						"-"+modelo.rs.getString("nombreEmpleado"));
			}
			modelo.rs.close();
			modelo.stmt.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:al rellenar el despegable"+"\n"+ex);
			ex.printStackTrace();
		}
		// Cerrar la conexión
		modelo.desconectar(con);
	}

	public void mostrarDatos(Connection con, int idE, TextField txtIdEmpleadoM, TextField txtNombreEmpleadoM)
	{
		String sql = "SELECT * FROM empresa WHERE idEmpleado = "+idE;
		try 
		{ 
			txtIdEmpleadoM.setText(idE+"");
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta2 = con.createStatement();
			ResultSet rs2 = sta2.executeQuery(sql);
			while(rs2.next())
			{
				String ne = rs2.getString("nombreEmpleado");
				txtNombreEmpleadoM.setText(ne);
			}
			sta2.close();
		} 
		catch (SQLException ex) 
		{
			JOptionPane.showMessageDialog(null, "ERROR:al mostrar"+"\n"+ex);
			ex.printStackTrace();
		}
		modelo.desconectar(con);
	}
}