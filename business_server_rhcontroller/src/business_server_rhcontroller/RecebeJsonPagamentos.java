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
 * Servlet implementation class RecebeJsonPagamentos
 */
@WebServlet("/RecebeJsonPagamentos")
public class RecebeJsonPagamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("json");
		DAO dao = new DAO();
		Pagamentos pagamentos = new Pagamentos();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try{
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			pagamentos.setId_funcionario((String) jsonObject.get("id_funcionario"));
			pagamentos.setId_pagamentos((String) jsonObject.get("id_pagamento"));
			pagamentos.setMes((String) jsonObject.get("mes"));
			pagamentos.setAno((String) jsonObject.get("ano"));
			pagamentos.setTipo((String) jsonObject.get("tipo"));
			
			
			String json = new Gson().toJson(pagamentos);
			System.out.println("Estamos em business_server_rhcontroller/RecebeJsonPagamentos.java:");
			System.out.println(json);
			dao.adicionaPagamento(pagamentos);
		} catch (org.json.simple.parser.ParseException e1){
			e1.printStackTrace();
		}
		
	}

}
