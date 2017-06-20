package galleriaquadri.validator;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import galleriaquadri.model.Autore;
import galleriaquadri.model.Quadro;
import galleriaquadri.service.Service;



public class QuadroValidator {
	HttpServletRequest request;
	int annoCorrente;

	@SuppressWarnings("deprecation")
	public QuadroValidator(HttpServletRequest request){
		this.annoCorrente=new Date().getYear()+1900;
		this.request=request;
	}

	public boolean convalida(){
		Quadro quadro=(Quadro)request.getAttribute("quadro");
		boolean risultato=true;
		quadro.setDataInserimento(new Date());
		String titolo=request.getParameter("titoloT");
		String dimensione=request.getParameter("dimensioneT");
		String tecnica=request.getParameter("tecnicaT");
		String anno=request.getParameter("annoT");
		
		//titolo obbigatorio
		if(titolo==null ||titolo==""){
			request.setAttribute("errTitolo", "Campo obbligatorio");
			risultato= false;
		}
		else
			quadro.setTitolo(titolo);
		
		//dimensione obblig
		if(dimensione==null || dimensione==""){
			request.setAttribute("errDimensione", "Campo obbligatorio");
			risultato=false;
		}
		else
			quadro.setDimensione(dimensione);

		//tecnica obblig
		if(tecnica==null || tecnica==""){
			request.setAttribute("errTecnica", "Campo obbligatorio");
			risultato=false;
		}
		else 
			quadro.setTecnica(tecnica);

		//se l anno e noto salvalo e controlle che sia corretto
		if(request.getParameter("annoT")!="") {
			if(Integer.parseInt(request.getParameter("annoT"))>this.annoCorrente) {

				request.setAttribute("errAnno", "Deve essere un anno valido!");
				risultato = false;
			}
			else
				quadro.setAnno(Integer.parseInt(anno));
		}
		
		
		if(!request.getParameter("autoreQuadro").equals("n/a")){
			Service service=new Service();
			Long autoreId=Long.parseLong(request.getParameter("autoreQuadro"));
			Autore autore=service.getOneAutore(autoreId);
			quadro.setAutore(autore);
			autore.addQuadro(quadro);
		}
				
		

		return risultato;
	}
}
