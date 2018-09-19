package business_server_rhcontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.Calendar;

public class DAO {

	private Connection connection = null;
	
	public DAO() throws IOException{
		Properties config = new Properties();
		config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

		String url = config.getProperty("url");
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		
		System.out.println(username);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public void adicionaColaborador(DadosPessoais dadospessoais){
		String sql = "INSERT INTO dados_pessoais" +
	"(NOME, NASCIMENTO, RG, ORGAO,CPF, NACIONALIDADE, ENDERECO, CONTATO, NOME_PAI , NOME_MAE , DADOS_BANCARIOS) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			System.out.println(connection.prepareStatement(sql));
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,dadospessoais.getNome());
			stmt.setDate(2, new Date(dadospessoais.getNascimento().getTimeInMillis()));
			stmt.setString(3, dadospessoais.getRg());
			stmt.setString(4, dadospessoais.getOrgao());
			stmt.setString(5, dadospessoais.getCpf());
			stmt.setString(6, dadospessoais.getNacionalidade());
			stmt.setString(7, dadospessoais.getEndereco());
			stmt.setString(8, dadospessoais.getContato());
			stmt.setString(9, dadospessoais.getNome_pai());
			stmt.setString(10, dadospessoais.getNome_mae());
			stmt.setString(11, dadospessoais.getDados_bancarios());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionaPagamento(Pagamentos pagamento){
		String sql = "INSERT INTO pagamentos" +
	"(id_pagamento, id_funcionario, mes, ano, tipo) values (?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			System.out.println(connection.prepareStatement(sql));
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,pagamento.getId_pagamentos());
			stmt.setString(2, pagamento.getId_funcionario());
			stmt.setString(3, pagamento.getMes());
			stmt.setString(4, pagamento.getAno());
			stmt.setString(5, pagamento.getTipo());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alteraColaborador(DadosPessoais dadospessoais){
		String sql = "UPDATE dados_pessoais SET " +
				"NOME=?, NASCIMENTO=?, RG=?,ORGAO=?,CPF=?, NACIONALIDADE=?, ENDERECO=?, CONTATO=?, NOME_PAI=?, NOME_MAE=?, DADOS_BANCARIOS=? WHERE id_funcionario=?";
		PreparedStatement stmt;
		try {

			stmt = connection.prepareStatement(sql);

			stmt.setString(1,dadospessoais.getNome());
			stmt.setDate(2, new Date(dadospessoais.getNascimento().getTimeInMillis()));
			stmt.setString(3, dadospessoais.getRg());
			stmt.setString(4, dadospessoais.getOrgao());
			stmt.setString(5, dadospessoais.getCpf());
			stmt.setString(6, dadospessoais.getNacionalidade());
			stmt.setString(7, dadospessoais.getEndereco());
			stmt.setString(8, dadospessoais.getContato());
			stmt.setString(9, dadospessoais.getNome_pai());
			stmt.setString(10, dadospessoais.getNome_mae());
			stmt.setString(11, dadospessoais.getDados_bancarios());
			stmt.setLong(12, dadospessoais.getId_funcionario());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DadosPessoais> getListaUsuarios(){

		List<DadosPessoais> usuarios = new ArrayList<DadosPessoais>();
		
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("SELECT * FROM dados_pessoais");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){

				DadosPessoais usuario = new DadosPessoais();
				
				usuario.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				usuario.setNascimento(data);
				usuario.setRg(rs.getString("rg"));
				usuario.setOrgao(rs.getString("orgao"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setNacionalidade(rs.getString("nascionalidade"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setContato(rs.getString("contato"));
				usuario.setNome_pai(rs.getString("nome_pai"));
				usuario.setNome_mae(rs.getString("nome_mae"));
				usuario.setDados_bancarios(rs.getString("dados_bancarios"));
				usuarios.add(usuario);
			}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usuarios;		
		}
			public List<DadosPessoais> getListaUsuarios_id(){

				List<DadosPessoais> usuarios = new ArrayList<DadosPessoais>();
				
				PreparedStatement stmt;

				try {
					stmt = connection.prepareStatement("SELECT * FROM dados_pessoais ORDER BY NOME");
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){

						DadosPessoais usuario = new DadosPessoais();
						
						usuario.setNome(rs.getString("nome"));
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate("nascimento"));
						usuario.setNascimento(data);
						usuario.setRg(rs.getString("rg"));
						usuario.setOrgao(rs.getString("orgao"));
						usuario.setCpf(rs.getString("cpf"));
						usuario.setNacionalidade(rs.getString("nacionalidade"));
						usuario.setEndereco(rs.getString("endereco"));
						usuario.setContato(rs.getString("contato"));
						usuario.setNome_pai(rs.getString("nome_pai"));
						usuario.setNome_mae(rs.getString("nome_mae"));
						usuario.setDados_bancarios(rs.getString("dados_bancarios"));
						usuarios.add(usuario);
					}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;		
	}
	
			public List<Pagamentos> getListaFuncionarioPagamentos_id(int id_funcionario){

				List<Pagamentos> pagamentos = new ArrayList<Pagamentos>();
				
				
				PreparedStatement stmt;
				System.out.println(id_funcionario);
				try {
					stmt = connection.prepareStatement("SELECT d.nome, p.tipo, p.valor, p.mes, p.ano  FROM dados_pessoais d, pagamentos p where d.id_funcionario = p.id_funcionario AND d.id_funcionario = ?");
		
					stmt.setInt(1, id_funcionario);
					//stmt.execute();
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){

						Pagamentos pagamento = new Pagamentos();
						
						pagamento.setNome(rs.getString("nome"));
						pagamento.setTipo(rs.getString("tipo"));
						pagamento.setValor(rs.getString("valor"));
						pagamento.setMes(rs.getString("mes"));
						pagamento.setAno(rs.getString("ano"));
						pagamentos.add(pagamento);
					}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagamentos;		
	}
	public void removeColaborador(DadosPessoais dadospessoais){
		PreparedStatement stmt;
		try {

			stmt = connection.prepareStatement("DELETE  FROM dados_pessoais WHERE id_funcionario=?");
			//System.out.println(dadospessoais.getId_funcionario());
			stmt.setInt(1, dadospessoais.getId_funcionario());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}