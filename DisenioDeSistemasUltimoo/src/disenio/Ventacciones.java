package disenio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventacciones extends JFrame implements ActionListener {
	
	private JPanel panel;
    private JLabel texto ,texto2;           // etiqueta o texto no editable
    private JTextField caja , caja2;        // caja de texto, para insertar datos
    private JButton botonok , botoncanc , botonagr;          // boton con una determinada accion

    public Ventacciones() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("acciones");                   // colocamos titulo a la ventana
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
        botonok = new JButton();
        botoncanc = new JButton();
        // configuramos los componentes
        texto.setText("Usuario");    // colocamos un texto a la etiqueta
        texto.setBounds(150, 25, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        texto2.setText("Contraseña");    // colocamos un texto a la etiqueta
        texto2.setBounds(150, 75,100, 25); 
        caja2.setBounds(150, 100, 100, 25);
        
        botonok.setText("Ok");   // colocamos un texto al boton
        botonok.setBounds(100, 150, 75, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonok.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        botoncanc.setText("Cancelar");
        botoncanc.setBounds(250, 150, 120, 30); 
        botoncanc.addActionListener(this);
        // adicionamos los componentes a la ventana
        this.add(texto);
        this.add(texto2);
        this.add(caja);
        this.add(caja2);
        this.add(botonok);
        this.add(botoncanc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = caja.getText();   // obtenemos el contenido de la caja de texto
        String contra = caja2.getText();
       // if(usuarioExiste(usuario , contra)){}
       // JOptionPane.showMessageDialog(this, "Hola " + usuario + ".");    // mostramos un mensaje (frame, mensaje)
        HolaMundoSwing vent = new HolaMundoSwing();
        vent.setVisible(true);
    }

    public static void main(String[] args) {
        Loguin VentLoguin = new Loguin();      // creamos una ventana
        VentLoguin.setVisible(true);             // hacemos visible la ventana creada
    }
}






