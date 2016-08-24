package disenio;

import java.util.HashSet;
import java.util.Set;

//hoja del composite
public class BajaDePoi implements Componente {
	

	public void agregarProceso(Componente unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	public void remover(Componente unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	
	public void ejecutar(){
		
	}
	
	
}