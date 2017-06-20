package galleriaquadri.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import galleriaquadri.model.Autore;

public class AutoreValidator {
	HttpServletRequest request;

	public AutoreValidator(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.request=request;
	}
	public boolean convalida(){
		boolean risultato=true;
		Autore autore=(Autore)request.getAttribute("autore");
		autore.setDataInserimento(new Date());
		String nome=request.getParameter("nomeT");
		String cognome=request.getParameter("cognomeT");
		String nazione=request.getParameter("nazioneT");
		String dataNascita=request.getParameter("dataNascitaT");
		String dataMorte=request.getParameter("dataMorteT");
		DateFormat df=new SimpleDateFormat("yyyy-mm-dd");


		//controllo che sia stato inserito un nome 
		if(request.getParameter("nomeT")==null || request.getParameter("nomeT")==""){
			request.setAttribute("errName", "Campo obbligatorio");
			risultato= false;
		}
		else
			autore.setNome(nome);
		//controllo che sia stato inserito un cognome 
		if(request.getParameter("cognomeT")==null || request.getParameter("cognomeT")==""){
			request.setAttribute("errCognome", "Campo obbligatorio");
			risultato=false;
		}
		else
			autore.setCognome(cognome);

		//se la nazione e nota la inserisco (un autore può essere sconosciuto )
		if(request.getParameter("nazioneT")!=null || request.getParameter("nazioneT")!="")
			autore.setNazione(nazione);

		if(dataNascita == null || dataNascita.equals("")) {
			request.setAttribute("errDate1", "Campo obbligatorio");
			risultato= false;
		} 
		else {


			try {

				//verifico che la data di nascita sia precedente alla data odierna
				if(df.parse(dataNascita).compareTo(new Date()) >0) {
					request.setAttribute("errDate1", "Deve essere precedente alla data di oggi!");
					risultato = false;
				}
				else
					autore.setDataNascita(df.parse(dataNascita));
			} 
			catch (ParseException e) {
				//la data deve essere valida 
				request.setAttribute("errDate1", "la data di nascita essere una data valida!"+request.getAttribute("dataMorteT"));
				risultato = false;
			}


		}

		//se è stata inserita una data di morte faccio le dovute verifiche
		if(dataMorte==null || dataMorte.equals("")){
			request.setAttribute("errDate", "puoi non inserire la data di morte!");
			
		}
		else{
			try {
				//controllo che la data di morte sia precedente alla data di oggi 
				if(df.parse(dataMorte).compareTo(new Date())>0){
					request.setAttribute("errDate", "la data di morte è successiva alla data odierna!");
					risultato=false;
				}
				else {
					try {
						//se la data di morte è precendete alla data odierna verifico che sia successiva alla data di nascita
						if(df.parse(dataMorte).compareTo(df.parse(dataNascita))<0){
							request.setAttribute("errDate", "la data di morte è successiva alla data di nascita!");
							risultato=false;
						}
						else
							//passate le verifiche setto la data di morte dell autore 
							autore.setDataMorte(df.parse(dataMorte));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						request.setAttribute("errDate", "la data di morte essere una data valida!");
						risultato=false;
					}
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				request.setAttribute("errDate", "la data di morte essere una data valida!");
				risultato=false;
			}

		}
		
		
		
		
			
		return risultato;

	}
}

