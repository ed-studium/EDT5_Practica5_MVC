package mvc;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Modelo {
	public int contador = 0;
	// Crear un objeto tipo Connection
		public Connection con = null;
		// Data Source Name de la Base de Datos
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empresa?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium.2019;";
		// Creamos una consulta a la base de datos
		String sentencia = "SELECT * FROM empleados";
		// Objeto donde se guarda la información de la consulta a la base de datos
		public ResultSet rs = null;
		// Crear un statement de SQL
		public Statement stmt = null;
		public Modelo() {
			// Cargar el Driver
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Se ha producido un error al cargar el Driver");
			}
			// Establecer la conexión con la base de datos
			try {
				con = DriverManager.getConnection(url, login, password);
			} catch (SQLException e) {
				System.out.println("Se produjo un error al conectar a la Base de Datos");
			}
			// Realizar la consulta
			try {
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery("SELECT * FROM empleados");
				// Para averiguar el número de registros obtenidos
				while (rs.next()) {
					contador++;
				}
				rs.first();
				// Poner en los TextField los valores obtenidos del 1º
				// idEmpleado.setText(Integer.toString(rs.getInt("idEmpleado")));
				// nombreEmpleado.setText(rs.getString("nombreEmpleado"));
			} catch (SQLException e) {
				System.out.println("Error en la sentencia SQL");
			}
		}
		
		public void mostrarDatos(Connection con, int idE, TextField txtIdEmpleadoM,  TextField txtNombreEmpleadoM)
		{
			String sql = "SELECT * FROM empresa WHERE idEmpleado = "+idE;
			try 
			{ 
				txtIdEmpleadoM.setText(idE+"");
				// Creamos un STATEMENT para una consulta SQL INSERT.
				Statement sta = con.createStatement();
				ResultSet rs2 = sta.executeQuery(sql);
				while(rs.next())
				{
					String d = rs2.getString("idEmpleado");
					txtIdEmpleadoM.setText(d);
					String i = rs2.getString("nombreEmpleado");
					txtNombreEmpleadoM.setText(i);
				}
				sta.close();
			} 
			catch (SQLException ex) 
			{
				JOptionPane.showMessageDialog(null, "ERROR:al mostrar"+"\n"+ex);
				ex.printStackTrace();
			}
		}
		public Connection conectar(String bd, String usuario, String clave)
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/"+bd+"?autoReconnect=true&useSSL=false";
			String user = usuario;
			String password = clave;
			Connection con = null;
			try {
				// Cargar los controladores para el acceso a la BD
				Class.forName(driver);
				// Establecer la conexión con la BD empresa
				con = DriverManager.getConnection(url, user, password);
				if (con != null) {
					System.out.println("Conectado a la base de datos");
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERROR:La dirección no es válida o el usuario y clave"+"\n"+ex);
				ex.printStackTrace();
			} catch (ClassNotFoundException cnfe) {
				JOptionPane.showMessageDialog(null, "ERROR:en la conexion"+"\n"+cnfe);
				cnfe.printStackTrace();
			}
			return con;
		}
		public void desconectar(Connection con)
		{
			try
			{
				con.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR: En la desconexion"+"\n"+e);
				e.printStackTrace();
			}
		}
}
