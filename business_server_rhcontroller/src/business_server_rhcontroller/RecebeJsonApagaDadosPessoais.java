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
 * Servlet implementation class RecebeJsonDadosPessoais
 */
@WebServlet("/RecebeJsonApagaDadosPessoais")
public class RecebeJsonDadosPessoais extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("json");
		DadosPessoais dadosPessoais = new DadosPessoais();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try{
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			dadosPessoais.setId_funcionario(Integer.valueOf(jsonObject.get("id_funcionario").toString()));
	
			
			String json = new Gson().toJson(dadosPessoais);
			System.out.println("Estamos em business_server_rhcontroller/RecebeJsonApagaDadosPessoais.java:");
			System.out.println(json);
		} catch (org.json.simple.parser.ParseException e1){
			e1.printStackTrace();
		}
		
	}

}
