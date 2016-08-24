package disenio;

public interface Command {
	
	public void agregarProceso (Componente unProceso);
		
	public void remover( Componente unProceso );  
		   
    public void ejecutarProcesos();
		
	
	

}