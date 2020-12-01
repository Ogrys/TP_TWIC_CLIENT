package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;


/**
 * Servlet implementation class EnvoiVilleModifiee
 */
@WebServlet("/envoiVilleModifiee")
public class EnvoiVilleModifiee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnvoiVilleModifiee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String codeCommune = (String) request.getParameter("codeCommune");
		String nomCommune = (String) request.getParameter("nomCommune");
		String codePostal = (String) request.getParameter("codePostal");
		String libelleAcheminement = (String) request.getParameter("libelleAcheminement");
		String ligne = (String) request.getParameter("ligne");
		String longitude = (String) request.getParameter("longitude");
		String latitude = (String) request.getParameter("latitude");

		System.out.println("http://127.0.0.1:8082/ville?codePostal="+codePostal+"&codeCommune="+codeCommune+"&nomCommune="+nomCommune+"&libelleAcheminement="+libelleAcheminement+"&ligne="+ligne+"&latitude="+latitude+"&longitude="+longitude+"");
		//Unirest.put("http://127.0.0.1:8082/ville?codePostal="+codePostal+"&codeCommune="+codeCommune+"&nomCommune="+nomCommune+"&libelleAcheminement="+libelleAcheminement+"&ligne="+ligne+"&latitude="+latitude+"&longitude="+longitude+"");
		
		String url = "http://192.168.56.1:8082/ville";
		try {
			HttpResponse<JsonNode> reponse = Unirest.put(url).queryString("codePostal", codePostal)
					.queryString("codeCommune", codeCommune)
					.queryString("nomCommune", nomCommune)
					.queryString("libelleAcheminement", libelleAcheminement)
					.queryString("ligne", ligne)
					.queryString("latitude", latitude)
					.queryString("longitude", longitude).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher req = request.getRequestDispatcher("ModificationAcceptee.jsp");
		req.forward(request, response);
	}

}
