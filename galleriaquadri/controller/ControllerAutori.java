package galleriaquadri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import galleriaquadri.model.Autore;
import galleriaquadri.service.Service;
import galleriaquadri.validator.AutoreValidator;

/**
 * Servlet implementation class ControllerAutori
 */
@WebServlet("/admin/ControllerAutori")
public class ControllerAutori extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Service service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public ControllerAutori() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service=new Service();
		HttpSession sessione=request.getSession();
		String criterio = request.getParameter("ordineAutori");
		sessione.setAttribute("ordineAutori", criterio);
		
		if(request.getParameter("ordineAutori")!=null){
			sessione.setAttribute("autori", service.getAutoriBy(criterio));

		}
		else{
			sessione.setAttribute("autori", service.getAutoriBy("cognome"));
			sessione.setAttribute("ordineAutori","cognome");
		}
		
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher("/admin/adminVisualizzaGalleria.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prossimaPagina = "/visualizzaGalleria";


		if(request.getParameter("delete")!=null)
			cancellaAutore(request);


		else if (request.getParameter("deleteAll")!=null)
			cancellaAllAutori(request);

		else if(request.getParameter("insert")!=null) {
			prossimaPagina="/admin/inserimentoAutore.jsp";
			inserisciAutore(request);
		}
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);
	}

	private void cancellaAllAutori(HttpServletRequest request) {
		// TODO Auto-generated method stub
		service=new Service();
		
		if(service.cancellaAllAutori())
			request.setAttribute("cancellatoTutto", "Hai cancellato tutti gli autori");
		request.setAttribute("autori", service.getAutoriBy("cognome"));


	}

	private void cancellaAutore(HttpServletRequest request){
		HttpSession sessione = request.getSession();
		Long idAutore = Long.parseLong(request.getParameter("id"));
		service=new Service();
		service.cancellaAutore(service.getOneAutore(idAutore));
		request.setAttribute("autori", service.getAutoriBy("cognome"));

	}

	private void inserisciAutore(HttpServletRequest request){

		Autore autore= new Autore();
		request.setAttribute("autore", autore);
		AutoreValidator av=new AutoreValidator(request);
		
		if(av.convalida()){

			service=new Service();
			if(!service.containsAutore(autore)){
				service.addAutore(autore);
				request.setAttribute("AutoreInserito", "Autore inserito correttamente!");
			}
			else
				request.setAttribute("AutoreContenuto", "Autore già presente nella Galleria!");

		}

	}
}
