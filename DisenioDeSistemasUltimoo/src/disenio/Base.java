package disenio;

public class Base extends Command{
	private Terminal sistema;
	public Base(Terminal sistema)
	{
		this.sistema=sistema;
	}

	public void agregarProceso(Command unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	public void removerProcesos(){
		
		System.out.println("No se puede remover procesos\n");
	}

	public void ejecutar(){
		
		System.out.println("Nada para ejecutar\n");
		
	}
	
}
