package disenio;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;




public class AccionesAnteLaBusqInt extends JFrame {
	
	private JList list;
	private DefaultListModel listModel;
	private DefaultTableModel modelo; 
	private JComboBox comboBox ;
	String[] acciones = { "GenerarLog", "PorFecha", "PorUsuario" };
	
	
	public AccionesAnteLaBusqInt() {
		getContentPane().setLayout(null);
		
		 comboBox = new JComboBox(acciones);
		comboBox.setBounds(22, 23, 210, 26);
		getContentPane().add(comboBox);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(286, 25, 89, 23);
		getContentPane().add(btnAgregar);
		AgregarBusq bus = new AgregarBusq();
		btnAgregar.addActionListener(bus);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(286, 117, 89, 23);
		getContentPane().add(btnEliminar);
		EliminarBusq elim = new EliminarBusq();
		btnEliminar.addActionListener(elim);
		
		
		JList list = new JList();
		list.setBounds(22, 76, 210, 151);
		getContentPane().add(list);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(242, 205, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(345, 205, 89, 23);
		getContentPane().add(btnCancelar);
		Cancelar canc = new Cancelar();
		btnCancelar.addActionListener(canc);
		
		
		listModel = new DefaultListModel();
	}
	
	
	private class AgregarBusq implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	   if(listModel.contains(comboBox.getSelectedItem())){
	   }else {  listModel.addElement(comboBox.getSelectedItem());}
	     list = new JList(listModel);
			list.setBounds(32, 78, 59, 98);
			getContentPane().add(list);
		 
		}
	}
	
	private class Cancelar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	
    }
	
	private class EliminarBusq implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
         listModel.removeAllElements();
         list = new JList(listModel);
         list.setBounds(32, 78, 59, 98);
			getContentPane().add(list);
         
	
        }
	}
	
	
	
}