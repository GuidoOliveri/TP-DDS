package disenio;

import java.util.Set;

public class LocalComercial extends POI {
    public LocalComercial () {
    		super();
        } 
    public LocalComercial(String nombre, float latitud, float longitud,Set<PalabraClave> palabras)
    {
    	setNombre(nombre);
    	setLatitud(latitud);
    	setLongitud(longitud);
    	setPalabrasClave(palabras);
    }
	
}