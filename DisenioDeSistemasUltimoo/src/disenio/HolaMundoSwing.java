package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame; // todo lo de adentro de la ventana
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	
/*	private JLabel texto1, texto2;
	
	/*public HolaMundoSwing() {
	setLayout(null);
	texto1=new JLabel("�Hola Mundo!");
	texto2=new JLabel("www.geekytheory.com");
	texto1.setBounds(100,100,200,40);
	texto2.setBounds(70,140,200,40);
	add(texto1);
	add(texto2);
	}
	public HolaMundoSwing() {
		super("Titulo de ventana");
		 setSize(400, 300);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container cp = getContentPane();
		 cp.setLayout(new FlowLayout());
		 JLabel etiqueta = new JLabel("Nombre: ");
		 JTextField texto = new JTextField(20);
		 JButton boton = new JButton("Saludar");
		 cp.add(etiqueta);
		 cp.add(texto);
		 cp.add(boton);
	}

	
	
	public static void main(String[] args) {
	HolaMundoSwing ventana=new HolaMundoSwing();
	ventana.setBounds(500,250,300,250);
	ventana.setVisible(true);
	ventana.setResizable(false);
	}*/
	
	/**
	 * Clase Ventana
	 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
	 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
	 * accion de mostrar el texto en la caja por una ventana de mensaje.
	 * @author Daniel Alvarez (a3dany)
	 */
	public class HolaMundoSwing extends JFrame implements ActionListener {
        
		private JPanel panel;
	    private JLabel texto ,texto2;           // etiqueta o texto no editable
	    private JTextField caja , caja2;        // caja de texto, para insertar datos
	    private JButton boton , boton2;          // boton con una determinada accion

	    public HolaMundoSwing() {
	        super();                    // usamos el contructor de la clase padre JFrame
	        configurarVentana();        // configuramos la ventana
	        inicializarComponentes();   // inicializamos los atributos o componentes
	    }

	    private void configurarVentana() {
	        this.setTitle("Login");                   // colocamos titulo a la ventana
	        this.setSize(400, 300);                                 // colocamos tamanio a la ventana (ancho, alto)
	        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
	        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
	        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
	    }

	    private void inicializarComponentes() {
	        // creamos los componentes
	        texto = new JLabel();
	        texto2 = new JLabel();
	        caja = new JTextField();
	        caja2 = new JTextField();
	        boton = new JButton();
	        boton2 = new JButton();
	        // configuramos los componentes
	        texto.setText("Usuario");    // colocamos un texto a la etiqueta
	        texto.setBounds(150, 25, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
	        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
	        texto2.setText("Contrase�a");    // colocamos un texto a la etiqueta
	        texto2.setBounds(150, 75,100, 25); 
	        caja2.setBounds(150, 100, 100, 25);
	        
	        boton.setText("Ok");   // colocamos un texto al boton
	        boton.setBounds(100, 150, 75, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
	        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
	        boton2.setText("Cancelar");
	        boton2.setBounds(250, 150, 120, 30); 
	        boton2.addActionListener(this);
	        // adicionamos los componentes a la ventana
	        this.add(texto);
	        this.add(texto2);
	        this.add(caja);
	        this.add(caja2);
	        this.add(boton);
	        this.add(boton2);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String usuario = caja.getText();   // obtenemos el contenido de la caja de texto
	        String contra = caja2.getText();
	       // if(usuarioExiste(usuario , contra)){}
	       // JOptionPane.showMessageDialog(this, "Hola " + usuario + ".");    // mostramos un mensaje (frame, mensaje)
	        //Ventacciones VentLoguin = new Ventacciones();      // creamos una ventana
	        //VentLoguin.setVisible(true);
	      //  vent.setVisible(true);
	    }

	    public static void main(String[] args) {
	        HolaMundoSwing V = new HolaMundoSwing();      // creamos una ventana
	        V.setVisible(true);             // hacemos visible la ventana creada
	    	//VentAcciones Acciones = new VentAcciones();      // creamos una ventana
	        //Acciones.setVisible(true);  
	    }
	}
	


