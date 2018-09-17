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
	
	public void alteraColaborador(DadosPessoais dadospessoais){
		String sql = "UPDATE dados_pessoais SET " +
				"(NOME, NASCIMENTO, RG,ORGAO,CPF, NASCIONALIDADE,ENDERECO,CONTATO, NOME_PAI , NOME_MAE , DADOS_BANCARIOS ) values (?,?,?,?,?,?,?,?,?,?,?) WHERE usuario_id=?";
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
			
			public List<DadosPessoais> getListaUsuarios_id(int id_funcionario){

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
	

	public void removeColaborador(String id){
		PreparedStatement stmt;
		try {

			stmt = connection.prepareStatement("DELETE FROM dados_pessoais WHERE usuario_id=?");
			stmt.setString(1, id);
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