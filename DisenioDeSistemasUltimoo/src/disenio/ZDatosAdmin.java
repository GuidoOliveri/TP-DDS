package disenio;

public class ZDatosAdmin {
	public ZDatosAdmin() {
		
	}
	String usuario1 =  "";
	String pass1=  "";
	
	public int probarPass(){
		Administrador yo;
		Terminal sistema = new Terminal();
		
		Administrador unAdmin1=new Administrador("pepe","argento",sistema);
		Administrador unAdmin2=new Administrador("lionel","messi",sistema);
		Administrador unAdmin3=new Administrador("caruso","lombardi",sistema);
		
		sistema.agregarAdmin(unAdmin1);
		sistema.agregarAdmin(unAdmin2);
		sistema.agregarAdmin(unAdmin3);

		usuario1 = ZLoguinAdmin.txt_usuario.getText();
		pass1 = ZLoguinAdmin.pss_contraseña.getText();
		
		if(null!=(yo = (Administrador)(sistema.logueo(usuario1,pass1)))){
			return 1;
		}
		else {
			return 0;
		}
	}
}
