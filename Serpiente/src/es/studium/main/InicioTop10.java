package es.studium.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InicioTop10 extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	static List lista=new List(6, false);
	JButton btnAceptar=new JButton ("Aceptar");

	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/snake?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public InicioTop10() {
		addWindowListener(this);
		setTitle ("Consultar Cita");
		setSize(300,250);

		String cadena="";

		try
		{
			connection = DriverManager.getConnection(url, login, password);
		}
		catch(SQLException arg0)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}
		//PREPARAR EL STATEMENT
		try
		{
			statement=connection.createStatement();
			rs=statement.executeQuery("SELECT * FROM puntos;");

		}
		catch(SQLException arg0)
		{
			System.out.println("Error en la sentencia SQL");
		}
		cadena= ("SELECT * FROM puntos order by puntos DESC LIMIT 10;");

		//CARGAR EL DRIVER
		try
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException arg0)
		{
			System.out.println("Se ha producido un error al cargar el Driver");
		}
		//PREPARAR EL STATEMENT
		try
		{
			statement=connection.createStatement();
			rs= statement.executeQuery(cadena);

			while (rs.next())
			{

				InicioTop10.lista.add(rs.getString("nombre")+" "+rs.getString("puntos")+"  Puntos");

			}
			
			System.out.println("Consulta Correcta");
		}
		catch(SQLException arg0)
		{
			System.out.println("Error en la sentencia SQL");
		}


		pnlCent.setLayout(new GridLayout(1,1));
		pnlCent.add(lista);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);

		add(pnlCent,"Center");
		add(pnlInf,"South");

		lista.setEnabled(false);

		setLocationRelativeTo(null);
		setLocation(480, 200);
		//setVisible(true);

		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
					setVisible(false);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new InicioTop10();

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

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
	public void windowClosing(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

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
