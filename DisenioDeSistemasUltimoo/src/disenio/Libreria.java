package disenio;

import java.util.Set;

public class Libreria extends LocalComercial{

    public Libreria (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC);        
    	setRadioLimite(5);
    } 
    public Libreria(int id,String nombre, double latitud, double longitud,Set<String> palabras){
		super(nombre,latitud,longitud,palabras);
    	setId(id);
    	setRadioLimite(5);
    }
	
}
