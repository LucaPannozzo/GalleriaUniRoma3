package galleriaquadri.view;

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
import galleriaquadri.model.Utente;
import galleriaquadri.service.Service;


/**
 * Servlet implementation class VisualizzaGalleria
 */
@WebServlet("/visualizzaGalleria")
public class VisualizzaGalleria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizzaGalleria() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		String nextPage="/gallery.jsp";
		Service service=new Service();
		
		if(utente!=null && utente.getRole()=="admin")
			nextPage="/admin/adminGallery.jsp";
		
		
	 
		//metto gli autori nella sessione
		String criterioAutore = request.getParameter("ordineAutori");
		List<Autore> autori;
		if(request.getParameter("ordineAutori")!=null)
			autori= service.getAutoriBy(criterioAutore);
		else{
			autori=service.getAutoriBy("cognome");
			session.setAttribute("ordineAutori", "cognome");
		}
		session.setAttribute("autori", autori);
		
		//metto i quadri nella sessione 
		String criterioQuadro=request.getParameter("ordineQuadri");
		List<Quadro> quadri;
		if(request.getParameter("ordineQuadri")!=null)
			quadri=service.getQuadriBy(criterioQuadro);
		else  
			quadri=service.getQuadriBy("titolo"); 
		//quadri=service.getAllQuadri();
		
		session.setAttribute("quadri", quadri);
		
		ServletContext application = request.getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
