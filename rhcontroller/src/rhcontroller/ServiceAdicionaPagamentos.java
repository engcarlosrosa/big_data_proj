package rhcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


import com.google.gson.Gson;


@WebServlet("/ServiceAdicionaPagamentos")
public class ServiceAdicionaPagamentos extends HttpServlet {
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
	throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		Pagamentos pagamentos = new Pagamentos();
		//dadosPessoais.setId_funcionario(Integer.valueOf(request.getParameter("id_funcionario")));
		pagamentos.setId_funcionario(request.getParameter("id_funcionario"));
		pagamentos.setId_pagamentos(request.getParameter("id_pagamento"));
		pagamentos.setValor(request.getParameter("valor"));
		pagamentos.setMes(request.getParameter("mes"));
		pagamentos.setAno(request.getParameter("ano"));
		pagamentos.setTipo(request.getParameter("tipo"));
		
		
		String json = new Gson().toJson(pagamentos);
		System.out.println("Estamos em rhcontroller/ServiceAdicionaPagamentos.java");
		System.out.println(json);
		
		//POST
		HttpClient client = HttpClients.createDefault();
		String url = "http://localhost:8080/business_server_rhcontroller/RecebeJsonPagamentos";
		HttpPost request1 = new HttpPost(url);
		List<NameValuePair>  urlParameters = new ArrayList<NameValuePair>();
 		urlParameters.add(new BasicNameValuePair("json",json));
 		request1.setEntity(new UrlEncodedFormEntity(urlParameters));
 		HttpResponse resp = client.execute(request1);
 		
 		// ***out.println("<html>");
 		// out.println("<body>");
 		// out.println(pagamentos.getNome() + " adicionado com sucesso.");
 		// out.println("Voltar para o ");
 		// out.println("<a href=\"menu.html\">Menu Principal</a>");
 		// out.println(" ou ");
 		// out.println("<a href=\"cria_dados_pessoais.html\"> Adicionar novo funcionário.</a>");
 		// out.println("</a>");
 		// out.println("</body>");
 		// out.println("</html>");
		
	}

}
