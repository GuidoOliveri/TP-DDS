package disenio;

import java.util.Set;

public class ParadaColectivo extends POI{
	
	public ParadaColectivo (int nuevoNro) {
			super();
			setRadioLimite(1);
		}
	
	public ParadaColectivo () {
		super();
	}
	
    public ParadaColectivo(int id,String nombre, float latitud, float longitud,Set<PalabraClave> palabras){
    	setId(id);
    	setNombre(nombre);
    	setLatitud(latitud);
    	setLongitud(longitud);
    	setPalabrasClave(palabras);
    }
	
    public Boolean calculoDisponibilidad () { 
    		return true;
    	}

	}