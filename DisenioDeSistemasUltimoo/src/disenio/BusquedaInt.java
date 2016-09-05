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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;



public class BusquedaInt extends JFrame {
	private JTable table;
	private JList list;
	private JTextField textField;
	private DefaultListModel listModel;
	private DefaultTableModel modelo; 
	private JTable tabla;
	
	public BusquedaInt() {
		getContentPane().setLayout(null);
		
		JLabel lblCriterioDeBusqueda = new JLabel("Criterio de Busqueda");
		lblCriterioDeBusqueda.setBounds(32, 11, 128, 23);
		getContentPane().add(lblCriterioDeBusqueda);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 58, 46, 14);
		getContentPane().add(lblNombre);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(156, 54, 89, 23);
		getContentPane().add(btnAgregar);
		
	   AgregarBusq busq= new AgregarBusq();
		
		btnAgregar.addActionListener(busq);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(287, 54, 89, 23);
		getContentPane().add(btnBuscar);
		AgregarATabla tab = new AgregarATabla();
		btnBuscar.addActionListener(tab);
		
		/*table = new JTable();
		table.setBounds(32, 250, 340, -63);
		getContentPane().add(table);*/
		
	/*	 list = new JList(listModel);
		list.setBounds(32, 78, 59, 98);
		getContentPane().add(list);*/
		
		textField = new JTextField();
		textField.setBounds(193, 100, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		listModel = new DefaultListModel();
		modelo = new DefaultTableModel();
	}
	
	
	private class AgregarBusq implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	     listModel.addElement(textField.getText());
	     list = new JList(listModel);
			list.setBounds(32, 78, 59, 98);
			getContentPane().add(list);
		 
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
