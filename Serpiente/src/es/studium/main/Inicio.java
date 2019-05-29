package es.studium.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inicio extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	VerAyuda verayuda=new VerAyuda();
	InicioNombreError inicionombreerror=new InicioNombreError();
	InicioTop10 iniciotop10=new InicioTop10();
	
	JMenuBar barraMenu=new JMenuBar();
	
	JMenu menuAyuda=new JMenu("Ayuda");
	
	JMenuItem mniAyudaVerAyuda=new JMenuItem("Ver Ayuda");
	
	JLabel lblNombre=new JLabel("Nombre:      ");
	JTextField txtNombre=new JTextField(15);
	JButton btnNuevaPart=new JButton("Nueva Partida");
	JButton btnTop10=new JButton("Top 10");
	JButton btnSalir=new JButton("Salir");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public Inicio() {
		setTitle ("Snake" );
		
		menuAyuda.add(mniAyudaVerAyuda);
		
		barraMenu.add(menuAyuda);
		
		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblNombre);
		lblNombre.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtNombre);
		pnlSup.add(pnlSupSup);
		
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(btnNuevaPart);
		pnlSup.add(pnlCent2);
		
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(btnTop10);
		pnlSup.add(pnlCent3);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnSalir);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		addWindowListener(this);
		setJMenuBar(barraMenu);
		setLocationRelativeTo(null);
		setLocation(480, 200);
		setSize(350,250);
		
		mniAyudaVerAyuda.addActionListener((ActionListener) this);
		
		setVisible(true);
		
		btnNuevaPart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnNuevaPart)) {
					String nombre =txtNombre.getText();
					if (nombre.equals("")) {
						inicionombreerror.setVisible(true);
					}else {
						setVisible(false);
						JFrame ventana =new JFrame();
						Snake juego=new Snake();
						
						ventana.setBounds(10,10,905,700);
						ventana.setBackground(Color.DARK_GRAY);
						ventana.setResizable(false);
						ventana.setVisible(true);
						ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						ventana.add(juego);
					}
				}
			}
		});
		btnTop10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnTop10)) {
					iniciotop10.setVisible(true);
				}
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnSalir)) {
					System.exit(0);
				}
			}
		});
	}

	public static void main(String[] args)
	{
		new Inicio();

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object a;
		a=arg0.getSource();
		if(a.equals(mniAyudaVerAyuda))
		{
			verayuda.setVisible(true);
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
	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
		
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
