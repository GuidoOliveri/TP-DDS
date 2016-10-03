package disenio;


public class ZDatosUsuario  {
	public ZDatosUsuario() {
		
	}
	String usuario1 =  "";
	String pass1=  "";
	
	public int registrarUsu(){
		
		Terminal sistema = new Terminal();
		
		Usuario unUsuario1=new Usuario(sistema,"nacho","123");
		Usuario unUsuario2=new Usuario(sistema,"pepe","456");
		Usuario unUsuario3=new Usuario(sistema,"juan","789");
		
		sistema.agregarUsuario(unUsuario1);
		sistema.agregarUsuario(unUsuario2);
		sistema.agregarUsuario(unUsuario3);
		
		usuario1 = ZRegistrarse.txt_usuario.getText();
		pass1 = ZRegistrarse.pss_contraseña.getText();
		
       
		
		if((sistema.agregarUsuario(new Usuario(sistema,usuario1,pass1))!=false)){
			return 1;
		}
		else {
			return 0;
		}
		
		
	}
	
	public int probarPass(){
	
		Terminal sistema = new Terminal();
		
		Usuario unUsuario1=new Usuario(sistema,"nacho","123");
		Usuario unUsuario2=new Usuario(sistema,"pepe","456");
		Usuario unUsuario3=new Usuario(sistema,"juan","789");
		
		sistema.agregarUsuario(unUsuario1);
		sistema.agregarUsuario(unUsuario2);
		sistema.agregarUsuario(unUsuario3);

		usuario1 = ZLoguinUsuario.txt_usuario.getText();
		pass1 = ZLoguinUsuario.pss_contraseña.getText();
		
		Usuario yo;
		
		if(null!=(yo = (Usuario)(sistema.logueo(usuario1,pass1)))){
			return 1;
		}
		else {
			return 0;
		}
	}

}
