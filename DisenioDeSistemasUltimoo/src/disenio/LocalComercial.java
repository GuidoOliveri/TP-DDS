package disenio;

import java.util.Set;

public class LocalComercial extends POI {
    public LocalComercial () {
    		super();
        } 
    public LocalComercial(String nombre, double latitud, double longitud,Set<String> palabras)
    {
    	super(nombre, latitud, longitud,palabras);
    }
	
}