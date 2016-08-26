package disenio;

import java.util.ArrayList;

public class Command {
	
	public void agregarProceso (Componente unProceso){
		
	};
		
	public void remover( Componente unProceso ){
		
	};  
		   
    public void ejecutarProcesos(ArrayList<Componente> procAEjecutar){
    	
    	for(int i=0 ; i < procAEjecutar.size()-1 ; i++ ){
    		
    		procAEjecutar.get(i).ejecutar();
    	}
    	
    }
		
	
	

}