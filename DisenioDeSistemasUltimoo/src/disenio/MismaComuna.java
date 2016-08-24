package disenio;

public class MismaComuna implements Cercania{
	public Boolean calculoDeCercania(int comuna,POI unPoi){
		return (unPoi.getComuna()==comuna);
	}
	
	public Boolean calculoDeCercania(double longitud, double latitud,POI unPoi){
		return true;
	}
	
}