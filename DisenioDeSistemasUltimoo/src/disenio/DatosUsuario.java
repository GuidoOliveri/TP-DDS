package disenio;

public class DatosUsuario {
	public DatosUsuario() {
		
	}
	String usuario1 =  "";
	String pass1=  "";
	
	public int probarPass(){
		usuario1 = Loguin.txt_usuario.getText();
		pass1 = Loguin.pss_contraseña.getText();
		
		if (usuario1.equals("pepe") && pass1.equals("argento")){
			return 1;
		}
		else {
			return 0;
		}
	}
}
