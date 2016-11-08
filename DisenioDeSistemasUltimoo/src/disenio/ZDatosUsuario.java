package disenio;


public class ZDatosUsuario  {
	
	private Terminal sistema;
	private String usuario, contra;
	private Usuario usu;
	
	public ZDatosUsuario(Terminal sistema,String usu,String con) {
		this.sistema=sistema;
		this.usuario=usu;
		this.contra=con;
	}
	
	public int registrarUsu(){
		
		usu = new Usuario(sistema,usuario,contra,sistema.getPoiActual());
		if((sistema.agregarUsuario(usu)!=false)){
			sistema.persistirUsuario(usu);
			return 1;
		}
		else {
			return 0;
		}
		
		
	}
	
	public int probarPass(){
	
		Usuario yo;
		
		if(null!=(yo = (Usuario)(sistema.logueoUsu(usuario,contra)))){
			return 1;
		}
		else {
			return 0;
		}
	}

	public Terminal getSistema() {
		return sistema;
	}

	public void setSistema(Terminal sistema) {
		this.sistema = sistema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

}
