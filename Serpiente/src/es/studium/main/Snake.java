package es.studium.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Snake extends JPanel implements KeyListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	private int[] serpienteXLongitud=new int[750];
	private int[] serpienteYLongitud=new int[750];
	
	private boolean izquierda = false;
	private boolean derecha = false;
	private boolean arriba = false;
	private boolean abajo = false;
	
	private ImageIcon bocaDerecha;
	private ImageIcon bocaIzquierda;
	private ImageIcon bocaArriba;
	private ImageIcon bocaAbajo;
	
	private int cuerpoSerpiente=3;
	
	private Timer tiempo;
	private int retraso=100;
	private ImageIcon imagenSerpiente;
	
	private int[] posicionXPunto= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,
									625,650,675,700,725,750,775,800,825,850};
	private int[] posicionYPunto={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon imagenPunto;
	
	private Random random=new Random();
	
	private int posX=random.nextInt(34);
	private int posY=random.nextInt(23);
	
	private int puntuacion=0;
	
	private int mover=0;
	
	private ImageIcon imagenTitulo;

	public Snake() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		tiempo = new Timer(retraso, this);
		tiempo.start();
		
	}
	public void paint(Graphics g) {
		
		if(mover==0) {
			
			serpienteXLongitud[2]=50;
			serpienteXLongitud[1]=75;
			serpienteXLongitud[0]=100;
			
			serpienteYLongitud[2]=100;
			serpienteYLongitud[1]=100;
			serpienteYLongitud[0]=100;
		}
		
		//Título borde imagen
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//dibujo imagen titulo
		imagenTitulo=new ImageIcon("snaketitle.jpg");
		imagenTitulo.paintIcon(this, g, 25, 11);
		
		//borde juego
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//fondo juego
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		//Puntuacion
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Puntuación: "+puntuacion,765,30);
		
		//puntos longitud de la serpiente
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Longitud: "+cuerpoSerpiente,780,50);
		
		bocaDerecha =new ImageIcon("bocaDerecha.png");
		bocaDerecha.paintIcon(this, g, serpienteXLongitud[0], serpienteYLongitud[0]);
		
		for(int i=0;i<cuerpoSerpiente; i++) {
			
			if(i==0&&derecha) {
				bocaDerecha =new ImageIcon("bocaDerecha.png");
				bocaDerecha.paintIcon(this, g, serpienteXLongitud[i], serpienteYLongitud[i]);
			}
			if(i==0&&izquierda) {
				bocaIzquierda =new ImageIcon("bocaIzquierda.png");
				bocaIzquierda.paintIcon(this, g, serpienteXLongitud[i], serpienteYLongitud[i]);
			}
			if(i==0&&abajo) {
				bocaAbajo =new ImageIcon("bocaAbajo.png");
				bocaAbajo.paintIcon(this, g, serpienteXLongitud[i], serpienteYLongitud[i]);
			}
			if(i==0&&arriba) {
				bocaArriba =new ImageIcon("bocaArriba.png");
				bocaArriba.paintIcon(this, g, serpienteXLongitud[i], serpienteYLongitud[i]);
			}
			if(i!=0) {
				imagenSerpiente =new ImageIcon("cuerpo.png");
				imagenSerpiente.paintIcon(this, g, serpienteXLongitud[i], serpienteYLongitud[i]);
			}
		}
		
		imagenPunto=new ImageIcon("punto.png");
		
		if((posicionXPunto[posX]==serpienteXLongitud[0]&&posicionYPunto[posY]==serpienteYLongitud[0])) {
			puntuacion+=25;
			cuerpoSerpiente++;
			posX=random.nextInt(34);
			posY=random.nextInt(23);
		}
		
		imagenPunto.paintIcon(this, g, posicionXPunto[posX], posicionYPunto[posY]);
		
		for(int b=1;b<cuerpoSerpiente;b++) {
			if(serpienteXLongitud[b]==serpienteXLongitud[0] && serpienteYLongitud[b]==serpienteYLongitud[0]) {
				derecha=false;
				izquierda=false;
				arriba=false;
				abajo=false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD,50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD,20));
				g.drawString("Espacio para reiniciar", 335, 340);
			}
		}
		
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		tiempo.start();
		if(derecha) {
			for(int d=cuerpoSerpiente-1;d>=0;d--) {
				serpienteYLongitud[d+1]=serpienteYLongitud[d];
			}
			for(int d=cuerpoSerpiente;d>=0;d--) {
				if(d==0) {
					serpienteXLongitud[d]=serpienteXLongitud[d]+25;
				}else {
					serpienteXLongitud[d]=serpienteXLongitud[d-1];
				}
				if(serpienteXLongitud[d]>850) {
					serpienteXLongitud[d]=25;
				}
			}
			repaint();
		}
		if(izquierda) {
			for(int d=cuerpoSerpiente-1;d>=0;d--) {
				serpienteYLongitud[d+1]=serpienteYLongitud[d];
			}
			for(int d=cuerpoSerpiente;d>=0;d--) {
				if(d==0) {
					serpienteXLongitud[d]=serpienteXLongitud[d]-25;
				}else {
					serpienteXLongitud[d]=serpienteXLongitud[d-1];
				}
				if(serpienteXLongitud[d]<25) {
					serpienteXLongitud[d]=850;
				}
			}
			repaint();
		}
		if(arriba) {
			for(int d=cuerpoSerpiente-1;d>=0;d--) {
				serpienteXLongitud[d+1]=serpienteXLongitud[d];
			}
			for(int d=cuerpoSerpiente;d>=0;d--) {
				if(d==0) {
					serpienteYLongitud[d]=serpienteYLongitud[d]-25;
				}else {
					serpienteYLongitud[d]=serpienteYLongitud[d-1];
				}
				if(serpienteYLongitud[d]<75) {
					serpienteYLongitud[d]=625;
				}
			}
			repaint();
		}
		if(abajo) {
			for(int d=cuerpoSerpiente-1;d>=0;d--) {
				serpienteXLongitud[d+1]=serpienteXLongitud[d];
			}
			for(int d=cuerpoSerpiente;d>=0;d--) {
				if(d==0) {
					serpienteYLongitud[d]=serpienteYLongitud[d]+25;
				}else {
					serpienteYLongitud[d]=serpienteYLongitud[d-1];
				}
				if(serpienteYLongitud[d]>625) {
					serpienteYLongitud[d]=75;
				}
			}
			repaint();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			mover=0;
			puntuacion=0;
			cuerpoSerpiente=3;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			mover++;
			derecha=true;
			if(!izquierda) {
				derecha=true;
			}else {
				derecha=false;
				izquierda=true;
			}
			arriba=false;
			abajo=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			
			mover++;
			izquierda=true;
			if(!derecha) {
				izquierda=true;
			}else {
				izquierda=false;
				derecha=true;
			}
			arriba=false;
			abajo=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			mover++;
			arriba=true;
			if(!abajo) {
				arriba=true;
			}else {
				arriba=false;
				abajo=true;
			}
			izquierda=false;
			derecha=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			
			mover++;
			abajo=true;
			if(!arriba) {
				abajo=true;
			}else {
				abajo=false;
				arriba=true;
			}
			izquierda=false;
			derecha=false;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
