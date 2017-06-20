package galleriaquadri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import galleriaquadri.model.Utente;

/**
 * Servlet implementation class ControllerLogin
 */
@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prossimaPagina="/login.jsp";
		HttpSession s = request.getSession();
		Utente u = (Utente) s.getAttribute("utente");
		if(u!=null && u.getRole()=="admin")
			prossimaPagina="/admin/indexAdmin.jsp";
		else
			prossimaPagina="index.jsp";
		
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String prossimaPagina="/login.jsp";

		//controllo se e già stato effettuato l'accesso
		HttpSession s = request.getSession();
		Utente u = (Utente) s.getAttribute("utente");
		
		//effettua il logout
		if(request.getParameter("logout")!=null)
			s.removeAttribute("utente");
		//controllo se e gia stato effettuato l'accesso
		else if(u!=null && u.getRole()=="admin")
			prossimaPagina="/admin/indexAdmin.jsp";


		else{	
			//controllo che siano stati inseriti dei dati
			if(request.getParameter("usernameT")==null || request.getParameter("usernameT").equals("") || request.getParameter("passwordT")==null || request.getParameter("passwordT").equals("")){
				request.setAttribute("errInsert", "inserisci username e password!");
			}
			else{
				String username=request.getParameter("usernameT");
				String password=request.getParameter("passwordT");
				Utente utente=new Utente(username);

				if(autorizza(utente,password)){
					s.setAttribute("utente",utente);
					prossimaPagina=("/admin/indexAdmin.jsp");
					s.removeAttribute("errLogin");
					s.removeAttribute("errInsert");
				}
				else{
					request.setAttribute("errLogin", "dati inseriti non admin!");
				}
			}
		}
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);

	}

	public boolean autorizza(Utente utente , String password){
		if(utente!=null && password!=null){
			if(utente.getUsername().equals("mario")&& password.equals("rossi")){
				utente.setRole("admin");
				return true;
			}
			else
				return false;

		}
		else
			return false;
	}

}
