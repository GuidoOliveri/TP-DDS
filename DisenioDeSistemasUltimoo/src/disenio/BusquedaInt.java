package disenio;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;



import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;



public class BusquedaInt extends JFrame {
	private JTable table;
	private JList list;
	private DefaultListModel listModel;
	private DefaultTableModel modelo; 
	private JTable tabla;
	private JTextField tlnombre;
	private JTextField tlnombre2;
	private JTable table_1;
	
	public BusquedaInt() {
		setTitle("Busqueda específica");
		getContentPane().setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar POI\r\n");
		btnAgregar.setBounds(225, 85, 106, 23);
		getContentPane().add(btnAgregar);
		
	   AgregarBusq busq= new AgregarBusq();
		
		btnAgregar.addActionListener(busq);
		
		JButton btnBuscar = new JButton("Buscar POI\r\n");
		btnBuscar.setBounds(225, 117, 106, 23);
		getContentPane().add(btnBuscar);
		AgregarATabla tab = new AgregarATabla();
		btnBuscar.addActionListener(tab);
		
		JLabel lblCriterioDeBsqueda = new JLabel("Criterio de búsqueda a seleccionar:\r\n");
		lblCriterioDeBsqueda.setFont(new Font("Arial", Font.BOLD, 15));
		lblCriterioDeBsqueda.setBounds(97, 11, 289, 32);
		getContentPane().add(lblCriterioDeBsqueda);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del POI a buscar", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(21, 73, 174, 102);
		getContentPane().add(panel);
		
		tlnombre2 = new JTextField();
		panel.add(tlnombre2);
		tlnombre2.setColumns(10);
		
		tlnombre = new JTextField();
		tlnombre.setBackground(new Color(255, 255, 255));
		panel.add(tlnombre);
		tlnombre.setColumns(10);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Arial", Font.BOLD, 11));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Nombre", "Direccion"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.setBorder(new LineBorder(new Color(0, 204, 51)));
		table_1.setBounds(31, 217, 393, 48);
		getContentPane().add(table_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(94, 196, 74, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccin.setForeground(Color.BLUE);
		lblDireccin.setBounds(284, 196, 80, 14);
		getContentPane().add(lblDireccin);
		
		listModel = new DefaultListModel();
		modelo = new DefaultTableModel();
	}
	
	
	private class AgregarBusq implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 
			boolean log=false;
			ZLoguinAdmin mimarco =new ZLoguinAdmin();
			mimarco.setTitle("Inicio Sesion");
			mimarco.setBounds(700,300,500,300);
	mimarco.setVisible(true);
	mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			
	      if(log){
	     listModel.addElement(tlnombre.getText());
	     list = new JList(listModel);
			list.setBounds(32, 78, 59, 98);
			getContentPane().add(list);
			}else{
				 ContraseniaIncorrecta marco5= new ContraseniaIncorrecta();
				  marco5.setTitle("Error de logueo");
				  marco5.setBounds(300,200,300,200);
				  marco5.setVisible(true);
			}
			
		}
	}
	
	
	public class AgregarATabla implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//agarra la lista y busca los pois q cumplan con ese criterio
			//y los agrega a la tabla
			
			//  FALTA HACER -> modelo.addRow(arg0);
			
			//una vez q guardo todos los resultados en el modelo , lo pasa a la tabla
			tabla= new JTable(modelo);
			
		}
	}
}

class ContraseniaIncorrecta extends JFrame{
	
	 public ContraseniaIncorrecta(){
     JLabel contraincorrecta = new JLabel("Vuelva a intentarlo");
     LaminaContra milamina =new LaminaContra();
	 add(milamina);
	
	 }
	 }

class LaminaContra extends JPanel{
	
public LaminaContra(){

	JButton botonOK= new JButton("VOLVER A INTENTARLO"); 
	JButton botonsalir= new JButton("SALIR");
	EventoVolverAtras eventovolveratras=new EventoVolverAtras();	
	EventoSalir eventosalir=new EventoSalir();
	botonsalir.addActionListener(eventosalir);
	botonOK.addActionListener(eventovolveratras);
	add(botonOK);
	add(botonsalir);
        }

private class EventoVolverAtras implements ActionListener{
	public void actionPerformed(ActionEvent e) {
//no hace falta volver ATRAS, sino con cerrar el frame contra incorrecta bastaria
		
	}
	}

private class EventoSalir implements ActionListener{
	public void actionPerformed(ActionEvent e) {
	 
			 System.exit( -1); 
			 
	}
	}
}