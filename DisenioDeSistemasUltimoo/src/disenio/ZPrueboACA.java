package disenio;

public class ZPrueboACA {
	private Terminal sistema;
	
	public ZPrueboACA(Terminal sistema){
		this.sistema = sistema;
	}
	
	public void ejecutar(){
		ZMenuPrincipal milogueo = new ZMenuPrincipal(sistema);
		milogueo.setVisible(true);
	}

	public Terminal getSistema() {
		return sistema;
	}

	public void setSistema(Terminal sistema) {
		this.sistema = sistema;
	}
}
