package disenio;

public class Horario {
	
	private int horaApertura,horaCierre,diaApertura,diaCierre;
	
	public Horario(int horaA,int horaC,int diaA,int diaC){
		horaApertura=horaA;
		horaCierre=horaC;
		diaApertura=diaA;
		diaCierre=diaC;
	}

	public int getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(int horaApertura) {
		this.horaApertura = horaApertura;
	}

	public int getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}

	public int getDiaApertura() {
		return diaApertura;
	}

	public void setDiaApertura(int diaApertura) {
		this.diaApertura = diaApertura;
	}

	public int getDiaCierre() {
		return diaCierre;
	}

	public void setDiaCierre(int diaCierre) {
		this.diaCierre = diaCierre;
	}
	

}