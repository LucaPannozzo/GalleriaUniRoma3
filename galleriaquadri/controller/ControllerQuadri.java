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
import galleriaquadri.model.Quadro;
import galleriaquadri.service.Service;
import galleriaquadri.validator.QuadroValidator;

/**
 * Servlet implementation class ControllerQuadri
 */
@WebServlet("/admin/ControllerQuadri")
public class ControllerQuadri extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerQuadri() {

		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String prossimaPagina="/admin/inserimentoQuadro.jsp";


		//metto gli autori 
		service=new Service();
		List<Autore> autori=service.getAutoriBy("cognome");
		session.setAttribute("autori", autori);

		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prossimaPagina="/admin/inserimentoQuadro.jsp";

		if(request.getParameter("insert")!=null){
			if(inserisciQuadro(request))
				request.setAttribute("QuadroInserito", "Quadro inserito correttamente nella Galleria!");

		}
		if(request.getParameter("CommandDelete")!=null){
			prossimaPagina="/adminVisualizzaGalleria.jsp";
			cancellaQuadro(request);

		}
		if(request.getParameter("deleteAll")!=null){
			prossimaPagina="/adminVisualizzaGalleria.jsp";
			cancellaAllQuadri(request);
		}

		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);
	}
	private void cancellaAllQuadri(HttpServletRequest request) {
		// TODO Auto-generated method stub
		service=new Service();

		if(service.cancellaAllQuadri())
			request.setAttribute("cancellatoTuttiQuadri", "Hai cancellato tutti i quadri");
		request.setAttribute("autori", service.getQuadriBy("titolo"));

	}

	private void cancellaQuadro(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Long idQuadro = Long.parseLong(request.getParameter("id"));
		service=new Service();
		service.cancellaQuadro(service.getOneQuadro(idQuadro));
		request.setAttribute("autori", service.getAutoriBy("cognome"));

	}

	private boolean inserisciQuadro(HttpServletRequest request){
		Quadro quadro=new Quadro();
		request.setAttribute("quadro", quadro);
		QuadroValidator qv= new QuadroValidator(request);
		boolean result=false;
		if(qv.convalida()){
			Service service= new Service();
			service.addQuadro(quadro);
			result=true;
		}
		return result;
	}
}
