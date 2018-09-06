package rhcontroller;

//import java.util.Calendar;

public class Pagamentos {
	
	private Integer id_pagamentos;
	private Integer id_funcionario;
	private Integer mes;
	private Integer ano;
	private String tipo;
	
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public Integer getId_pagamentos() {
		return id_pagamentos;
	}
	public void setId_pagamentos(Integer id_pagamentos) {
		this.id_pagamentos = id_pagamentos;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.nascimento = nascimento;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
