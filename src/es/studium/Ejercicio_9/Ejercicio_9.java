package es.studium.Ejercicio_9;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ejercicio_9 extends Frame implements WindowListener, ActionListener,TextListener
{
	//creacion de los distintos componentes
	//barra de menus
	MenuBar barra = new MenuBar();
	//menus
	Menu archivo = new Menu ("Archivo");
	Menu separador1 = new Menu ("|");
	Menu ayuda = new Menu ("Ayuda");
	//item a los menus
	MenuItem archivoNueva = new MenuItem("Nueva partida");
	MenuItem archivoSalir = new MenuItem("Salir");
	MenuItem ayudaAcerca = new MenuItem("Acerca de...");
	//paneles
	Panel tablero = new Panel(new GridLayout(3,3,5,5));
	Panel opciones = new Panel(new GridLayout(5,1));
	Panel opcionesJugar = new Panel(new FlowLayout(FlowLayout.CENTER,20,20));
	Panel opcionesTurno = new Panel(new FlowLayout(FlowLayout.CENTER,20,20));
	Panel opcionesJugador1 = new Panel(new FlowLayout(FlowLayout.CENTER,20,20));
	Panel opcionesJugador2 = new Panel(new FlowLayout(FlowLayout.CENTER,20,20));
	Panel opcionesGanador = new Panel(new FlowLayout(FlowLayout.CENTER,20,20));
	//label
	Label j1 = new Label ("  Jugador 1");
	Label j2 = new Label ("  Jugador 2");
	Label jganador = new Label ("Ganador");
	Label turno = new Label ("TURNO:");
	//cuadro de textos
	TextField jt1 = new TextField ("",15);
	TextField jt2 = new TextField ("",15);
	TextField jtGanador = new TextField (15);
	TextField textoTurno = new TextField (15);
	//botones
	Button bJugar = new Button ("JUGAR");
	Button b1=new Button();
	Button b2=new Button();
	Button b3=new Button();
	Button b4=new Button();
	Button b5=new Button();
	Button b6=new Button();
	Button b7=new Button();
	Button b8=new Button();
	Button b9=new Button();
	//variables
	String jugador1, jugador2;
	boolean controlJugador;
	boolean controlComienzo=false;
	int controlNoGanador;
	int [][] tabla = new int [3][3];
	
	public Ejercicio_9()
	{
		setTitle("TRES EN RAYA");
		setVisible(true);
		setSize(600,360);
		setResizable(false);
		setMenuBar(barra);
		barra.add(archivo);
		barra.add(separador1);
		barra.add(ayuda);
		archivo.add(archivoNueva);
		archivo.add(archivoSalir);
		ayuda.add(ayudaAcerca);	
		setLayout (new GridLayout(1,2));
		add(opciones);
		add(tablero);
		opciones.add(opcionesJugar);
		opciones.add(opcionesTurno);
		opciones.add(opcionesJugador1);
		opciones.add(opcionesJugador2);
		opciones.add(opcionesGanador);
		opcionesJugar.add(bJugar);
		opcionesTurno.add(turno);
		opcionesTurno.add(textoTurno);
		textoTurno .setEditable(false);
		opcionesJugador1.add(j1);
		j1.setBackground(Color.blue);
		j1.setForeground(Color.white);
		opcionesJugador1.add(jt1);
		jt1.setEditable(false);
		opcionesJugador2.add(j2);
		j2.setBackground(Color.red);
		j2.setForeground(Color.white);
		opcionesJugador2.add(jt2);
		jt2.setEditable(false);
		opcionesGanador.add(jganador);
		opcionesGanador.add(jtGanador);
		jtGanador.setEditable(false);
		tablero.add(b1);
		tablero.add(b2);
		tablero.add(b3);
		tablero.add(b4);
		tablero.add(b5);
		tablero.add(b6);
		tablero.add(b7);
		tablero.add(b8);
		tablero.add(b9);
		addWindowListener(this);
		archivoSalir.addActionListener(this);
		archivoNueva.addActionListener(this);
		ayudaAcerca.addActionListener(this);
		bJugar.addActionListener(this);
		bJugar.setBackground(Color.lightGray);
		jt1.addTextListener(this);
		jt2.addTextListener(this);
	}
	//metodo para el control de turnos
	public void turno()
	{
		if ((textoTurno.getText()).equals(jt1.getText()))
		{
			textoTurno.setText(jt2.getText());
		}
		else
		{
			textoTurno.setText(jt1.getText());
		}
	}
	//metodo para anular los listener de los botones una vez que haya ganador
	public void anularListener()
	{
		b1.removeActionListener(this);
		b2.removeActionListener(this);
		b3.removeActionListener(this);
		b4.removeActionListener(this);
		b5.removeActionListener(this);
		b6.removeActionListener(this);
		b7.removeActionListener(this);
		b8.removeActionListener(this);
		b9.removeActionListener(this);
		jt1.setEditable(false);
		jt2.setEditable(false);
		jtGanador.setEditable(false);
	}
	//metodo comprobar si hay ganador
	public void ganador ()
	{
		if ( (tabla[0][0]==1)&&(tabla[0][1]==1)&&(tabla[0][2]==1)) 
		{
			jtGanador.setText(jt1.getText());
			b1.setBackground(Color.green);
			b2.setBackground(Color.green);
			b3.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if  ( (tabla[0][0]==2)&&(tabla[0][1]==2)&&(tabla[0][2]==2)) 
		{
			jtGanador.setText(jt2.getText());
			b1.setBackground(Color.green);
			b2.setBackground(Color.green);
			b3.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[1][0]==1)&&(tabla[1][1]==1)&&(tabla[1][2]==1))
		{
			jtGanador.setText(jt1.getText());
			b4.setBackground(Color.green);
			b5.setBackground(Color.green);
			b6.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[1][0]==2)&&(tabla[1][1]==2)&&(tabla[1][2]==2))
		{
			jtGanador.setText(jt2.getText());
			b4.setBackground(Color.green);
			b5.setBackground(Color.green);
			b6.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[2][0]==1)&&(tabla[2][1]==1)&&(tabla[2][2]==1))
		{
			jtGanador.setText(jt1.getText());
			b7.setBackground(Color.green);
			b8.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[2][0]==2)&&(tabla[2][1]==2)&&(tabla[2][2]==2))
		{
			jtGanador.setText(jt2.getText());
			b7.setBackground(Color.green);
			b8.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][0]==1)&&(tabla[1][0]==1)&&(tabla[2][0]==1))
		{
			jtGanador.setText(jt1.getText());
			b1.setBackground(Color.green);
			b4.setBackground(Color.green);
			b7.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][0]==2)&&(tabla[1][0]==2)&&(tabla[2][0]==2))
		{
			jtGanador.setText(jt2.getText());
			b1.setBackground(Color.green);
			b4.setBackground(Color.green);
			b7.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][1]==1)&&(tabla[1][1]==1)&&(tabla[2][1]==1))
		{
			jtGanador.setText(jt1.getText());
			b2.setBackground(Color.green);
			b5.setBackground(Color.green);
			b8.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][1]==2)&&(tabla[1][1]==2)&&(tabla[2][1]==2))
		{
			jtGanador.setText(jt2.getText());
			b2.setBackground(Color.green);
			b5.setBackground(Color.green);
			b8.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();	
		}
		else if ( (tabla[0][2]==1)&&(tabla[1][2]==1)&&(tabla[2][2]==1))
		{
			jtGanador.setText(jt1.getText());
			b3.setBackground(Color.green);
			b6.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][2]==2)&&(tabla[1][2]==2)&&(tabla[2][2]==2))
		{
			jtGanador.setText(jt2.getText());
			b3.setBackground(Color.green);
			b6.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			b1.removeActionListener(this);
			b2.removeActionListener(this);
			b3.removeActionListener(this);
			b4.removeActionListener(this);
			b5.removeActionListener(this);
			b6.removeActionListener(this);
			b7.removeActionListener(this);
			b8.removeActionListener(this);
			b9.removeActionListener(this);
		}
		else if ( (tabla[0][0]==1)&&(tabla[1][1]==1)&&(tabla[2][2]==1))
		{
			jtGanador.setText(jt1.getText());
			b1.setBackground(Color.green);
			b5.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][0]==2)&&(tabla[1][1]==2)&&(tabla[2][2]==2))
		{
			jtGanador.setText(jt2.getText());
			b1.setBackground(Color.green);
			b5.setBackground(Color.green);
			b9.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][2]==1)&&(tabla[1][1]==1)&&(tabla[2][0]==1))
		{
			jtGanador.setText(jt1.getText());
			b3.setBackground(Color.green);
			b5.setBackground(Color.green);
			b7.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
		else if ( (tabla[0][2]==2)&&(tabla[1][1]==2)&&(tabla[2][0]==2))
		{
			jtGanador.setText(jt2.getText());
			b3.setBackground(Color.green);
			b5.setBackground(Color.green);
			b7.setBackground(Color.green);
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			anularListener();
		}
	}
	//implementacion de  metodos listener
	public void windowActivated(WindowEvent arg0)
	{
		
	}
	public void windowClosed(WindowEvent arg0)
	{
		
	}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);//cierra el frame pulsando el simbolo de cierre del frame
	}
	public void windowDeactivated(WindowEvent arg0)
	{
		
	}
	public void windowDeiconified(WindowEvent arg0) 
	{
		
	}
	public void windowIconified(WindowEvent arg0)
	{
		
	}
	public void windowOpened(WindowEvent arg0) 
	{
		
	}
	public void textValueChanged(TextEvent tvcg)
	{
		jugador1=jt1.getText();//almacena el texto introducido en sus respectivas variables
		jugador2=jt2.getText();
		textoTurno.setText(""+(jt1.getText()));
	}
	public void actionPerformed(ActionEvent ae)
	{	
		if (archivoSalir.equals(ae.getSource()))
		{
			System.exit(0);//cierra el frame pulsando el simbolo de cierre del frame
		}
		if ((bJugar.equals(ae.getSource()))||(archivoNueva.equals(ae.getSource())))//Pulsar boton comenzar a jugar
		{
			jt1.setEditable(true);
			jt2.setEditable(true);
			controlComienzo=true;
			for (int i=0;i<3;i++)//pone todos los valores de la matriz a 0
			{
				for (int j=0;j<3;j++)
				{
					tabla [i][j]=0;
				}
			}
			bJugar.setBackground(Color.green);
			b1.setBackground(Color.lightGray);
			b2.setBackground(Color.lightGray);
			b3.setBackground(Color.lightGray);
			b4.setBackground(Color.lightGray);
			b5.setBackground(Color.lightGray);
			b6.setBackground(Color.lightGray);
			b7.setBackground(Color.lightGray);
			b8.setBackground(Color.lightGray);
			b9.setBackground(Color.lightGray);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			b7.addActionListener(this);
			b8.addActionListener(this);
			b9.addActionListener(this);
			controlNoGanador=0;
			controlJugador=false;
			jt1.setText("");
			jt2.setText("");
			jtGanador.setText("");
		}
		
		if (controlComienzo==true)//hasta que no se pulsa comenzar a jugar, no entra este if
		{
			if (b1.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b1.setBackground(Color.blue);
					controlJugador=true;
					b1.removeActionListener(this);
					tabla[0][0]=1;// el jugador 1 juega con color azul y el numero 1 para la matriz
					
				}
				else
				{
					b1.setBackground(Color.red);
					controlJugador=false;
					b1.removeActionListener(this);
					tabla[0][0]=2;
				}
				ganador();
				controlNoGanador++;
				turno();				
			}
			if (b2.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b2.setBackground(Color.blue);
					controlJugador=true;
					b2.removeActionListener(this);
					tabla[0][1]=1;
				}
				else
				{
					b2.setBackground(Color.red);
					controlJugador=false;
					b2.removeActionListener(this);
					tabla[0][1]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b3.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b3.setBackground(Color.blue);
					controlJugador=true;
					b3.removeActionListener(this);
					tabla[0][2]=1;
				}
				else
				{
					b3.setBackground(Color.red);
					controlJugador=false;
					b3.removeActionListener(this);
					tabla[0][2]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b4.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b4.setBackground(Color.blue);
					controlJugador=true;
					b4.removeActionListener(this);
					tabla[1][0]=1;
				}
				else
				{
					b4.setBackground(Color.red);
					controlJugador=false;
					b4.removeActionListener(this);
					tabla[1][0]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b5.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b5.setBackground(Color.blue);
					controlJugador=true;
					b5.removeActionListener(this);
					tabla[1][1]=1;
				}
				else
				{
					b5.setBackground(Color.red);
					controlJugador=false;
					b5.removeActionListener(this);
					tabla[1][1]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b6.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b6.setBackground(Color.blue);
					controlJugador=true;
					b6.removeActionListener(this);
					tabla[1][2]=1;
				}
				else
				{
					b6.setBackground(Color.red);
					controlJugador=false;
					b6.removeActionListener(this);
					tabla[1][2]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b7.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b7.setBackground(Color.blue);
					controlJugador=true;
					b7.removeActionListener(this);
					tabla[2][0]=1;
				}
				else
				{
					b7.setBackground(Color.red);
					controlJugador=false;
					b7.removeActionListener(this);
					tabla[2][0]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			if (b8.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b8.setBackground(Color.blue);
					controlJugador=true;
					b8.removeActionListener(this);
					tabla[2][1]=1;
				}
				else
				{
					b8.setBackground(Color.red);
					controlJugador=false;
					b8.removeActionListener(this);
					tabla[2][1]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
			
			
			if (b9.equals(ae.getSource()))
			{
				if (controlJugador==false)
				{
					b9.setBackground(Color.blue);
					controlJugador=true;
					b9.removeActionListener(this);
					tabla[2][2]=1;
				}
				else
				{
					b9.setBackground(Color.red);
					controlJugador=false;
					b9.removeActionListener(this);
					tabla[2][2]=2;
				}
				ganador();
				controlNoGanador++;
				turno();	
			}
		}
		if ((controlNoGanador==9)&&((b1.getBackground())!=Color.green)&&((b2.getBackground())!=Color.green)&&((b3.getBackground())!=Color.green)&&((b4.getBackground())!=Color.green)&&((b5.getBackground())!=Color.green)&&((b6.getBackground())!=Color.green)&&((b7.getBackground())!=Color.green)&&((b8.getBackground())!=Color.green)&&((b9.getBackground())!=Color.green))  
		{
			jtGanador.setText("No hay ganador");
			controlComienzo=false;
			bJugar.setBackground(Color.lightGray);
			controlNoGanador=0;
		}
	}	
	public static void main(String[] args)
	{
		new Ejercicio_9();
	}
}

