package mvc.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import mvc.model.Tarefa;
import mvc.model.TarefasDAO;


@Controller
public class TarefasController {
	 @RequestMapping("/")
	 public String execute() {
		 return "info";
	 }
	 
	 @RequestMapping("getSpotify")
	 public String toGet() {
		 return "/toSpotify";
	 }
	 
	 
	 @RequestMapping(value = "alteraTarefa", method = RequestMethod.POST)
	 public String editar(@RequestParam("tarefa") String descricao,
			 @RequestParam("id") Long id,
			 HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException{
		 System.out.println("POST");
	      
	      Tarefa tarefa = new Tarefa();
	      
	      Calendar dataFinal = Calendar.getInstance(); 
	      System.out.println(dataFinal); 
	      
	      tarefa.setDataFinalizacao(dataFinal);
	      tarefa.setFinalizado(true);
	      tarefa.setId(id);
	      
	      TarefasDAO dao = new TarefasDAO();    
	      
	      tarefa.setDescricao(descricao);
	      System.out.println(tarefa.getDataFinalizacao());
	      System.out.println(tarefa.getId());
	      
	      dao.altera(tarefa);
	      
	      return "redirect:info";
	 }
	 
	 
	 @RequestMapping(value = "criaTarefa", method = RequestMethod.POST)
	 public String postar(@RequestParam("tarefa") String descricao, HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException{
		 System.out.println("POST");
	      
	      Tarefa tarefa = new Tarefa();
	      tarefa.setDescricao(descricao);
	      
	      Calendar dataFinal = Calendar.getInstance(); 
	      System.out.println(dataFinal); 
	      
	      tarefa.setDataFinalizacao(dataFinal);
	      tarefa.setFinalizado(true);
	      
	      TarefasDAO dao = new TarefasDAO();
	      dao.adiciona(tarefa);
	      
	      return "redirect:info";
	 }
	 
	 @RequestMapping(value="deletaTarefa", method = RequestMethod.POST)
	 public String removeTarefa(Tarefa tarefa) {
		 TarefasDAO dao = new TarefasDAO();
		 dao.remove(tarefa);
		 return "redirect:info";
	 }
	 
	 
	 @RequestMapping(value="toSpotify", method = RequestMethod.POST)
	 public String postTrack(@RequestParam("tarefa") String descricao,
			 HttpServletResponse response,HttpServletRequest request, HttpSession session) throws ServletException, IOException{		 
	     Gson gson = new Gson();
	     String json = gson.toJson("Track: " + descricao);
	     System.out.println(json);
	     
	     session.setAttribute("musica", descricao);
	     String client_id = "2ef7b7e48e3349bc9eb2b9f6cf4186d9";
	     String response_type = "code";
	     String redirect_uri = "http://localhost:8080/HandoutSpring/info";
	     
	     String url = "https:accounts.spotify.com/authorize?client_id="+client_id+"&response_type="+response_type+"&redirect_uri="+redirect_uri;
	     
		 return "redirect:"+url;
	 }
	 
	 @RequestMapping(value="/info",
			 params = {"code"},
			 method = RequestMethod.GET)
	 public String getTrack(@RequestParam("code") String access_token,
			 HttpServletResponse response,HttpServletRequest request, HttpSession session) throws ServletException, IOException{		
		 
	     Gson gson = new Gson();
	     String json = gson.toJson("Bearer " + access_token);
	     System.out.println(json);
	     session.setAttribute("acces_token", json);
	     response.setHeader("Authorization", access_token);

	     
	     
	     String q =  (String) session.getAttribute("musica"); 
	     String type = "track";
	    
		 return "redirect:https://api.spotify.com/v1/search?q="+q+"&type="+type;
	 }
	 
}

