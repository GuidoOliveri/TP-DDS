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
	
    public ParadaColectivo(int id,String nombre, double latitud, double longitud,Set<String> palabras){
		super(nombre,latitud,longitud,palabras);
    	setId(id);
    }
	
    public Boolean calculoDisponibilidad () { 
    		return true;
    	}

	}