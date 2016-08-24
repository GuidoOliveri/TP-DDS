package disenio;


import java.util.HashSet;
import java.util.Set;

public interface  Componente {
	
	 public void ejecutar();
	
	 public void agregarProceso(Componente unProceso);
	
	 public void remover(Componente unProceso);
	
}