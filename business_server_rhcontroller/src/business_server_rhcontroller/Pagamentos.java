package business_server_rhcontroller;
//import java.util.Calendar;

public class Pagamentos {
	
	private String id_pagamentos;
	private String id_funcionario;
	private String nome;
	private String mes;
	private String ano;
	private String tipo;
	private String valor;
	
	
	public String getId_pagamentos() {
		return id_pagamentos;
	}
	public void setId_pagamentos(String id_pagamentos) {
		this.id_pagamentos = id_pagamentos;
	}
	public String getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
}
