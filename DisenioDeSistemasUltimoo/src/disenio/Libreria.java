package disenio;

import java.util.Set;

public class Libreria extends LocalComercial{

    public Libreria (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC);        
    	setRadioLimite(5);
    } 
    public Libreria(int id,String nombre, float latitud, float longitud,Set<PalabraClave> palabras){
    	setId(id);
    	setNombre(nombre);
    	setLatitud(latitud);
    	setLongitud(longitud);
    	setPalabrasClave(palabras);
    	setRadioLimite(5);
    }
	
}
