package rhcontroller;

import java.util.Calendar;

public class Faltas {
	
	private String id_falta;
	private String id_funcionario;
	private Calendar dia;
	private String motivo;
	private String abono;
	
	public String getId_falta() {
		return id_falta;
	}
	public void setId_falta(String id_falta) {
		this.id_falta = id_falta;
	}
	public String getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public Calendar getDia() {
		return dia;
	}
	public void setDia(Calendar dia) {
		this.dia = dia;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getAbono() {
		return abono;
	}
	public void setAbono(String abono) {
		this.abono = abono;
	}

}
