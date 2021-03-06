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
 * Servlet implementation class RecebeJsonFaltas
 */
@WebServlet("/RecebeJsonFaltas")
public class RecebeJsonFaltas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("json");
		Faltas falta = new Faltas();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try{
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			//dadosPessoais.setId_funcionario(Integer.valueOf(jsonObject.get("id_funcionario").toString()));
			falta.setId_funcionario((String) jsonObject.get("id_funcionario"));
			falta.setId_falta((String) jsonObject.get("id_falta"));

			JSONObject object = (JSONObject) jsonObject.get("dia");

	        int year = Integer.valueOf(object.get("year").toString());
	        int month = Integer.valueOf(object.get("month").toString());
	        int dayOfMonth = Integer.valueOf(object.get("dayOfMonth").toString());
	        int hourOfDay = Integer.valueOf(object.get("hourOfDay").toString());
	        int minute = Integer.valueOf(object.get("minute").toString());
	        int second = Integer.valueOf(object.get("second").toString());

	        Calendar nasc = Calendar.getInstance();
	        nasc.set(year, month, dayOfMonth, hourOfDay, minute, second);


			falta.setMotivo((String) jsonObject.get("motivo"));
			falta.setAbono((String) jsonObject.get("abono"));
			
			
			String json = new Gson().toJson(falta);
			System.out.println("Estamos em business_server_rhcontroller/RecebeJsonDadosPessoais.java:");
			System.out.println(json);
		} catch (org.json.simple.parser.ParseException e1){
			e1.printStackTrace();
		}
		
	}

}
