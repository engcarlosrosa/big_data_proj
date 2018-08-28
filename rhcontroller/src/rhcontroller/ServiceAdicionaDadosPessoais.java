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


@WebServlet("/ServiceAdicionaDadosPessoais")
public class ServiceAdicionaDadosPessoais extends HttpServlet {
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
	throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		DadosPessoais dadosPessoais = new DadosPessoais();
		//dadosPessoais.setId_funcionario(Integer.valueOf(request.getParameter("id_funcionario")));
		dadosPessoais.setNome(request.getParameter("nome"));
		String nascimento = request.getParameter("nascimento");
		Date data;
		try{
			data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			dadosPessoais.setNascimento(dataNascimento);			
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		dadosPessoais.setRg(request.getParameter("rg"));
		dadosPessoais.setOrgao(request.getParameter("orgao"));
		dadosPessoais.setCpf(request.getParameter("cpf"));
		dadosPessoais.setNacionalidade(request.getParameter("nacionalidade"));
		dadosPessoais.setEndereco(request.getParameter("endereco"));
		dadosPessoais.setContato(request.getParameter("contato"));
		dadosPessoais.setNome_pai(request.getParameter("nome_pai"));
		dadosPessoais.setNome_mae(request.getParameter("nome_mae"));
		dadosPessoais.setDados_bancarios(request.getParameter("dados_bancarios"));
		
		String json = new Gson().toJson(dadosPessoais);
		System.out.println("Estamos em rhcontroller/ServiceAdicionaDadosPessoais.java");
		System.out.println(json);
		
		//POST
		HttpClient client = HttpClients.createDefault();
		String url = "http://localhost:8080/business_server_rhcontroller/RecebeJsonDadosPessoais";
		HttpPost request1 = new HttpPost(url);
		List<NameValuePair>  urlParameters = new ArrayList<NameValuePair>();
 		urlParameters.add(new BasicNameValuePair("json",json));
 		request1.setEntity(new UrlEncodedFormEntity(urlParameters));
 		HttpResponse resp = client.execute(request1);
 		
 		out.println("<html>");
 		out.println("<body>");
 		out.println(dadosPessoais.getNome() + " adicionado com sucesso.");
 		out.println("Voltar para o ");
 		out.println("<a href=\"menu.html\">Menu Principal</a>");
 		out.println(" ou ");
 		out.println("<a href=\"cria_dados_pessoais.html\"> Adicionar novo funcionário.</a>");
 		out.println("</a>");
 		out.println("</body>");
 		out.println("</html>");
		
	}

}
