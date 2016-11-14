package disenio;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

public class ActualizarComercios extends Command {


	public String nombreFantasia;
	//mi lista nueva de palabras, primero no tiene nada
	public Set<String> palabrasClavesActualizar;
	public Terminal sistema;
	
	public ActualizarComercios(Terminal sistema)
	{
		palabrasClavesActualizar = new HashSet<String>();
		this.sistema = sistema;
	}
	
	public Terminal getTerminal(){
		return sistema;
	}
	
	public void setTerminal(Terminal terminal){
		this.sistema = terminal;
	}
	
	public void agregarProceso(Command unProceso){
		
		JOptionPane.showMessageDialog(null, "No se puede agregar un proceso\n");
	}
	
	public void remover(Command unProceso){
		
		JOptionPane.showMessageDialog(null,"No se puede remover un proceso\n");
	}

	public void ejecutar(){
		this.leerArchivo("archivo.txt");
	}
	
	public void deshacer(){
		JOptionPane.showMessageDialog(null,"Nada para deshacer");
	}
	
	private Set<PalabraClave> obtenerArrayPalabrasClave(String palabrasClave){
		Set<PalabraClave> setPalabras = new HashSet<PalabraClave>();
		String[] palabras = palabrasClave.split(" ");
		 for(int i=0; i< palabras.length; i++){
			 setPalabras.add(new PalabraClave(palabras[i]));
		 }
		return setPalabras;
	}
		
		public void actualizarLocal(String linea){
		
		try {
		
		boolean existe = false;
		String nombreFantasia = linea.split(";")[0];
		String palabrasClave = linea.split(";")[1];
		
		for (POI poi:sistema.getPois()){ // esta es la lista de pois
			if(poi.getNombre().equals(nombreFantasia)){
				//las palabras que actualizo son las que me vienen en el txt
				
				 poi.setPalabrasClave(obtenerArrayPalabrasClave(palabrasClave)); 
				 String s = new String();
				 for(PalabraClave palabra : poi.getPalabrasClave()){
				 	s += palabra.getFrase();
				 	s += " ";
				 }
				 JOptionPane.showMessageDialog(null,"\nPalabras claves actualizadas:"+s);
				 existe = true;
			}
		}
		if(!existe){
		LocalComercial local= new LocalComercial();
		 
		 local.setNombre(nombreFantasia);
		 local.setPalabrasClave(obtenerArrayPalabrasClave(palabrasClave));
		 sistema.agregarPOI(local);
		 String agrega = new String();
			 for(PalabraClave palabra : local.getPalabrasClave()){
			 	agrega += palabra.getFrase();
			 	agrega += " ";
			 }
			 JOptionPane.showMessageDialog(null,"Palabras claves incorporadas a "+local.getNombre()+":"+agrega+"\n");
		 }
						
	
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ha sucedido un error"+e);
		}
		
	
		}

	public void leerArchivo(String nombreArchivo){
		File archivo;
		FileReader fr;
		BufferedReader br;
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null){
				actualizarLocal(linea);
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "hubo un error"+e);
		}
	}
		
}
