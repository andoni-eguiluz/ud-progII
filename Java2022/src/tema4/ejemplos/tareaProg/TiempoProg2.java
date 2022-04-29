package tema4.ejemplos.tareaProg;

import java.io.Serializable;
import java.util.Date;

public class TiempoProg2 implements Serializable {
	private Date fechaHora;
	private int minutos;
	public TiempoProg2(Date fechaHora, int minutos) {
		super();
		this.fechaHora = fechaHora;
		this.minutos = minutos;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	@Override
	public String toString() {
		return fechaHora + " : " + minutos;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TiempoProg2) {
			TiempoProg2 tp2 = (TiempoProg2) obj;
			return this.fechaHora.compareTo( tp2.fechaHora )==0 && this.minutos==tp2.minutos;
		} else {
			return false;
		}
	}
	
	public String aLinea() {
		return MainTiempoProg.FORMATO_DMYHM.format( fechaHora ) + "\t" + minutos;
	}
}
