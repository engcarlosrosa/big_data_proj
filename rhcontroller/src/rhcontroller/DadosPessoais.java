package rhcontroller;

import java.util.Calendar;

public class DadosPessoais {
	
	private Integer id_funcionario;
	private String nome;
	private Calendar nascimento;
	private String rg;
	private String orgao;
	private String cpf;
	private String nacionalidade;
	private String endereco;
	private String contato;
	private String nome_pai;
	private String nome_mae;
	private String dados_bancarios;
	
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getNome_pai() {
		return nome_pai;
	}
	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	public String getNome_mae() {
		return nome_mae;
	}
	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public String getDados_bancarios() {
		return dados_bancarios;
	}
	public void setDados_bancarios(String dados_bancarios) {
		this.dados_bancarios = dados_bancarios;
	}
	
}
