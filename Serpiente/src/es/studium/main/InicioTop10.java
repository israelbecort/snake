package es.studium.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InicioTop10 extends JFrame implements WindowListener, ActionListener
{
private static final long serialVersionUID = 1L;
	
	List lista=new List(6, false);
	JButton btnAceptar=new JButton ("Aceptar");
	
	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public InicioTop10() {
		addWindowListener(this);
		setTitle ("Consultar Cita");
		setSize(300,250);
		lista.add("Juan 500 Puntos");
		lista.add("Juan 482 Puntos");
		lista.add("Chuki 480 Puntos");
		lista.add("Pedro 442 Puntos");
		lista.add("Nati 418 Puntos");
		lista.add("Billy 417 Puntos");
		lista.add("Adrian 411 Puntos");
		lista.add("Juan 409 Puntos");
		lista.add("Paco 389 Puntos");
		lista.add("Chuki 386 Puntos");
		
		
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
