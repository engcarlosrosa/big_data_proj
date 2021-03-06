package rhcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServiceListaFuncionarioPagamentos
 */
@WebServlet("/ServiceListaFuncionarioPagamentos")
public class ServiceListaFuncionarioPagamentos extends HttpServlet {
	protected void service(HttpServletRequest request,
            HttpServletResponse response)
throws IOException, ServletException {
PrintWriter out = response.getWriter();

DadosPessoais dadosPessoais = new DadosPessoais();
dadosPessoais.setId_funcionario(Integer.valueOf(request.getParameter("id_funcionario")));

String json = new Gson().toJson(dadosPessoais);
System.out.println(json);

//POST
HttpClient client = HttpClients.createDefault();
String url = "http://localhost:8080/business_server_rhcontroller/RecebeDevolveJsonListaFuncionarioPagamentos";
System.out.println("Estamos em ServiceListaFuncionarioPagamentos");
HttpPost request1 = new HttpPost(url);
List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
urlParameters.add(new BasicNameValuePair("json",json));
request1.setEntity(new UrlEncodedFormEntity(urlParameters));
HttpResponse resp = client.execute(request1);

//Post Response
Gson gson = new Gson();

if(resp.getStatusLine().getStatusCode() == 200) {
	  InputStreamReader stream = new InputStreamReader(resp.getEntity().getContent());
	  BufferedReader br = new BufferedReader(stream);
	  String line;
	  out.println("<html><body><table border='1'>");
	  out.println("<tr><td>Nome</td><td>Contato</td><td>Endere�o</td><td>Dados Banc�rios</td>"/** + 
	              "<td>Org�o</td><td>CPF</td><td>Nacionalidade</td><td>Endere�o</td>"
	              + "<td>Contato</td><td>Nome do Pai</td><td>Nome da M�e</td><td>Dados Banc�rios</td></tr>"**/);
	  
	  //usuario = (Usuarios) gson.fromJson(line, Usuarios.class);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		try {

			JSONArray array = (JSONArray) jsonParser.parse(br.readLine());
			for (int i = 0; i < array.size(); i++) {
			    JSONObject object = (JSONObject) array.get(i);
			    out.println("<tr><td >" + object.get("nome") + "</td>");
			    /**
			    out.println("<td >" + object.get("rg") + "</td>");
			    out.println("<td >" + object.get("orgao") + "</td>");
			    out.println("<td >" + object.get("cpf") + "</td>");
			    JSONObject objectV = (JSONObject) object.get("nascimento");
			    int year = Integer.valueOf(objectV.get("year").toString());
		        int month = Integer.valueOf(objectV.get("month").toString());
		        int dayOfMonth = Integer.valueOf(objectV.get("dayOfMonth").toString());
		        int um = 1;
		        month= month+um;
			    out.println("<td >" + dayOfMonth+"/"+month+"/"+year + "</td>");
			    out.println("<td >" + object.get("nacionalidade") + "</td>");
			    **/
			    out.println("<tr><td >" + object.get("tipo") + "</td>");
			    out.println("<td >" + object.get("valor") + "</td>");
			   
			    out.println("<td >" + object.get("mes") + "</td>");
			    out.println("<td >" + object.get("ano") + "</td>");
			    /**
			    out.println("<td >" + object.get("dados_bancarios") + "</td>");
			    **/
			    out.println("<td><a href=\"http://localhost:8080/rhcontroller/atualiza_pagamento.html#id="+object.get("conta_id")+"&emissor="+object.get("emissor")+"&valor="+object.get("valor")+"&usuario_id="+object.get("usuario_id")+"&status="+object.get("status")+"\">Atualizar</a></td>");
			    out.println("<td><a href=\"http://localhost:8080/rhcontroller/remove_pagamento.html#id="+object.get("conta_id")+"\">Remover</a></td></tr>");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		out.println("Voltar para o ");
		out.println("<a href=\"menu.html\">Menu Principal</a>");
		out.println(".");
		out.println("</table></body></html>");
	  }

	    }
	}

