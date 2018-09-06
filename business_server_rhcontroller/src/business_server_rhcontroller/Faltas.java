package rhcontroller;

import java.util.Calendar;

public class Faltas {
	
	private Integer id_falta;
	private Integer id_funcionario;
	private Calendar dia;
	private String motivo;
	private Integer abono;
	
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public Integer getId_falta() {
		return id_falta;
	}
	public void setId_falta(Integer id_falta) {
		this.id_falta = id_falta;
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
	public Integer getAbono() {
		return abono;
	}
	public void setAbono(Integer abono) {
		this.abono = abono;
	}
	
	
}
