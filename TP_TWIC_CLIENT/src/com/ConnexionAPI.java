package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class ConnexionAPI
 */
@WebServlet("/ConnexionAPI")
public class ConnexionAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpResponse<JsonNode> reponse;
		ArrayList<Ville> villes = new ArrayList<>();
		try {
			reponse = Unirest.get("http://192.168.56.1:8082/ville").asJson();
			JsonArray jArray = JsonParser.parseString(reponse.getBody().toString()).getAsJsonArray();
			villes = this.jsonToArrayList(jArray);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		session.setAttribute("villes", villes);
		RequestDispatcher req = request.getRequestDispatcher("ChoixVilles.jsp");
		req.forward(request, response);
	}
	
	private ArrayList<Ville> jsonToArrayList(JsonArray tab) {
		final Gson gson = new GsonBuilder().create();
		ArrayList<Ville> villes = new ArrayList<>();

		for (JsonElement element : tab) {
			villes.add(gson.fromJson(element, Ville.class));
			System.out.println(element.toString());
		}
		return villes;
	}

}
