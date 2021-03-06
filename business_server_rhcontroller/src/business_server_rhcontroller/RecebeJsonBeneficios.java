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
@WebServlet("/RecebeJsonBeneficios")
public class RecebeJsonBeneficios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("json");
		Beneficios beneficios = new Beneficios();
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		try{
			jsonObject = (JSONObject) parser.parse(request.getParameter("json"));
			beneficios.setId_funcionario((String) jsonObject.get("id_funcionario"));
			beneficios.setId_beneficio((String) jsonObject.get("id_pagamento"));
			beneficios.setValor((String) jsonObject.get("valor"));

			
			
			String json = new Gson().toJson(beneficios);
			System.out.println("Estamos em business_server_rhcontroller/RecebeJsonBeneficios.java:");
			System.out.println(json);
		} catch (org.json.simple.parser.ParseException e1){
			e1.printStackTrace();
		}
		
	}

}
