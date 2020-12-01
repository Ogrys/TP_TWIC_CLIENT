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

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class SupprimerVille
 */
@WebServlet("/SupprimerVille")
public class SupprimerVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerVille() {
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
		String villeSup = request.getParameter("ville");
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		String codePostal = null;
		String nomCommune = null;
		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(villeSup)) {
				codePostal = ville.getCodePostal();
				nomCommune = ville.getNomCommune();
			}
		}
		String url = "http://192.168.56.1:8082/ville";
		try {
			HttpResponse<JsonNode> reponse = Unirest.delete(url).queryString("codePostal", codePostal).queryString("nomCommune", nomCommune).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		RequestDispatcher req = request.getRequestDispatcher("ModificationAcceptee.jsp");
		req.forward(request, response);
	}

}
