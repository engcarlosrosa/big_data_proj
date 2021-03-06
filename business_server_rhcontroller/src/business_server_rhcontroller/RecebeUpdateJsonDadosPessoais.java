package business_server_rhcontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;



/**
 * Servlet implementation class RecebeUpdateJsonDadosPessoais
 */
@WebServlet("/RecebeUpdateJsonDadosPessoais")
public class RecebeUpdateJsonDadosPessoais extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("json");
		DadosPessoais dadosPessoais = new DadosPessoais();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();

		DAO dao = new DAO();
		
		try{
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));


			dadosPessoais.setId_funcionario(Integer.valueOf(jsonObject.get("id_funcionario").toString()));
			dadosPessoais.setNome((String) jsonObject.get("nome"));
			JSONObject object = (JSONObject) jsonObject.get("nascimento");
	        int year = Integer.valueOf(object.get("year").toString());
	        int month = Integer.valueOf(object.get("month").toString());
	        int dayOfMonth = Integer.valueOf(object.get("dayOfMonth").toString());
	        int hourOfDay = Integer.valueOf(object.get("hourOfDay").toString());
	        int minute = Integer.valueOf(object.get("minute").toString());
	        int second = Integer.valueOf(object.get("second").toString());
	        Calendar nasc = Calendar.getInstance();
	        nasc.set(year, month, dayOfMonth, hourOfDay, minute, second);
			dadosPessoais.setNascimento(nasc);
			dadosPessoais.setRg((String) jsonObject.get("rg"));
			dadosPessoais.setOrgao((String) jsonObject.get("orgao"));
			dadosPessoais.setCpf((String) jsonObject.get("cpf"));
			dadosPessoais.setNacionalidade((String) jsonObject.get("nacionalidade"));
			dadosPessoais.setEndereco((String) jsonObject.get("endereco"));
			dadosPessoais.setContato((String) jsonObject.get("contato"));
			dadosPessoais.setNome_pai((String) jsonObject.get("nome_pai"));
			dadosPessoais.setNome_mae((String) jsonObject.get("nome_mae"));
			dadosPessoais.setDados_bancarios((String) jsonObject.get("dados_bancarios"));


			String json = new Gson().toJson(dadosPessoais);

			dao.alteraColaborador(dadosPessoais);

			System.out.println("Estamos em business_server_rhcontroller/RecebeUpdateJsonDadosPessoais.java:");
			System.out.println(json);
		} catch (org.json.simple.parser.ParseException e1){
			e1.printStackTrace();
		}
		
	}

}
