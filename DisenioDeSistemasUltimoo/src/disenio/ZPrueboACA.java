package disenio;

public class ZPrueboACA {
	public Terminal sistema;
	
	public ZPrueboACA(Terminal sistema){
		this.sistema = sistema;
	}
	
	public static void main (String[] args){
		
		Terminal sistema = new Terminal();
		
		Administrador unAdmin1=new Administrador("pepe","argento",sistema);
		Administrador unAdmin2=new Administrador("lionel","messi",sistema);
		Administrador unAdmin3=new Administrador("caruso","lombardi",sistema);
		
		sistema.agregarAdmin(unAdmin1);
		sistema.agregarAdmin(unAdmin2);
		sistema.agregarAdmin(unAdmin3);
		
		ZMenuPrincipal milogueo = new ZMenuPrincipal(sistema);
		milogueo.setVisible(true);
	}
}
