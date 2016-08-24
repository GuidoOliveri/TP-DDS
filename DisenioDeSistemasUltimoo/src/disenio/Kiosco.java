package disenio;

import java.util.Set;

public class Kiosco extends LocalComercial{

    public Kiosco (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC); 
	    setRadioLimite(2);
	}
    public Kiosco () {
    	super();
	}
    
    public Kiosco(int id,String nombre, double latitud, double longitud,Set<String> palabras){
		super(nombre,latitud,longitud,palabras);
    	setId(id);
    }

}