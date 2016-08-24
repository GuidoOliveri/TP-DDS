package disenio;

public class DentroDeRadio implements Cercania{
	public Boolean calculoDeCercania(double latitud, double longitud,POI unPoi){
		return (unPoi.aCuantoEstoyDe(latitud, longitud)<=unPoi.getRadioLimite());
	}
	
	public Boolean calculoDeCercania(int comuna,POI unPoi){
		return true;
	}
	
}
                            