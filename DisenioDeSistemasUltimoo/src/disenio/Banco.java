package disenio;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
/*import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
*/

public class Banco extends POI{

	private String gerente, sucursal;
	private  Set<String> serviciosC;
	
    public Banco (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC); 
		serviciosC = new HashSet<String>();
    }
    
    public Banco () {
    	super();
    }
    
    public Banco(int id,String nombre, double latitud, double longitud,Set<String> palabras){
		super(nombre,latitud,longitud,palabras);
    	setId(id);
    }
    	
    public String getGerente() {
    	return gerente;
    }
    
	public void setGerente(String gerente) {
    	this.gerente = gerente;
    }

	public String getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Set<String> getserviciosC() {
		return serviciosC;
	}
}