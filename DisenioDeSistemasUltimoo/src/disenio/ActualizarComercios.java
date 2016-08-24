package disenio;
import java.io.*;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ActualizarComercios implements Componente {

	Terminal sistema=new Terminal();
	String nombreFantasia;
	//mi lista nueva de palabras, primero no tiene nada
	public List<String> palabrasClavesAActualizar;
	
	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}
	
	public String getNombreFantasia(){
		return nombreFantasia;
	}
	
	public void agregarProceso(Componente unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	
	public void remover(Componente unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	
	
	public void ejecutar(){
		ActualizarComercios comerc = new ActualizarComercios();
		comerc.Escribir("archivo.txt");
	}
	
	
		
		public void Escribir(String nombreArchivo){
		
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter wr;
		
		
		try {
			
		f= new File(nombreArchivo);
		w = new FileWriter(f);
		bw = new BufferedWriter(w);
		wr = new PrintWriter(bw);
		

		wr.write("Nombre de fantasia; palabras clave\n");
			
		Scanner capt= new Scanner(System.in);
		String palabraAactualizar;
		Terminal sistema=new Terminal();
		
		for (POI poi:sistema.getPois()){ // esta es la lista de pois
			if(poi.getNombre()==this.getNombreFantasia()){
				//lo que yo voy a actualizar
				System.out.println("Ingrese las palabras a actualizar\n");
				palabraAactualizar=capt.nextLine();
				//cargo la lista con lo que quiero actualizar
				palabrasClavesAActualizar.add(palabraAactualizar);
					for (int i = 0; i <= palabrasClavesAActualizar.size() - 1; i++) {
						palabrasClavesAActualizar.get(i);
					}
					poi.setPalabrasClaves(palabrasClavesAActualizar);
					wr.write(poi.getNombre()+"; "+poi.getPalabrasClaves());
			}else{
				 LocalComercial local= new LocalComercial();
				 local.setNombre(nombreFantasia);
			}
			capt.close();
		}
		
		
		wr.close();
		bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ha sucedido un error"+e);
		}
		
	}
	
	
}
