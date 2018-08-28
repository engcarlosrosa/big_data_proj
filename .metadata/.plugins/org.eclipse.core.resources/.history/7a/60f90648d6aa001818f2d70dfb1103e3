package rhcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/ServiceAdicionaDadosPessoais")
public class ServiceAdicionaDadosPessoais extends HttpServlet {
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
	throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		DadosPessoais dadosPessoais = new DadosPessoais();
		
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
		
	}

}
