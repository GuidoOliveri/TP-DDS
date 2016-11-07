package disenio;

public class ZDatosAdmin {
	
	private Terminal sistema;
	private String usuario,contrasenia;
	
	public ZDatosAdmin(Terminal sistema,String usu,String contra) {
		this.sistema=sistema;
		this.usuario=usu;
		this.contrasenia=contra;
	}
	
	public int probarPass(){
	
		Administrador yo;
		
		if(null!=(yo = (Administrador)(sistema.logueo(usuario,(String)contrasenia)))){
			return 1;
		}
		else {
			return 0;
		}
	}
}
