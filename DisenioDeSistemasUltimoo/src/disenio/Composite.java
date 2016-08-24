package disenio;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Composite implements Componente {

	private ArrayList<Componente> procesos;
	
	public  void agregarProceso (Componente unProceso){
		procesos.add(unProceso);
	}
	
	 public void remover( Componente unProceso )  {
		 procesos.remove(unProceso);   
		 } 
	
	 
	 public void ejecutar(){
		for (int i =0 ; i<(procesos.size())-1 ; i++) {
			
			procesos.get(i).ejecutar();
			
		}
	 }
}