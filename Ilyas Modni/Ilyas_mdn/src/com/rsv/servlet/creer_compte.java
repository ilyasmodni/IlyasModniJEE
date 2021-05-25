package com.rsv.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsv.beans.compte;

/**
 * Servlet implementation class creer_compte
 */
@WebServlet("/creer_compte")
public class creer_compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creer_compte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cne=request.getParameter("cne");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		
		
		String message;
		
		if(cne.trim().isEmpty() ||nom.trim().isEmpty() ||prenom.trim().isEmpty()  )
		{
			message="SVP REMPLISSEZ TOUS LES CHAMPS !!!";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		}
		else
		{
			message="INSCRIPTION AVEC SUCCES";
			request.setAttribute("message", message);
			compte c1= new compte();
			
			c1.setCne(cne);
			c1.setNom(nom);
			c1.setPrenom(prenom);
			
			request.setAttribute("compte", c1);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/infos_compte.jsp").forward(request, response);
			
		}
		
		
	}

}
