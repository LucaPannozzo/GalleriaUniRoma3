package galleriaquadri.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllQuadri", query = "SELECT q FROM Quadro q ")
public class Quadro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quadroId;


	@Column (nullable=false)
	private String titolo;

	//anno può essere sconosciuto
	@Column
	private int anno;

	@Column(nullable=false)
	private String tecnica;

	@Column(nullable=false)
	private String dimensione;


	@ManyToOne
	private Autore autore;
	
	private Date dataInserimento;
	
	public Long getQuadroId() {
		return quadroId;
	}

	public void setQuadroId(Long quadroId) {
		this.quadroId = quadroId;
	}
	
	public Quadro(){
		
	}
	
	public Date getDataInserimento() {
		return dataInserimento;
	}

	
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Quadro(String titolo, int anno, String tecnica, String dimensione, Autore autore){
		this.titolo=titolo;
		this.anno=anno;
		this.autore=autore;
		this.dimensione=dimensione;
		this.tecnica=tecnica;
	}

	
	public Quadro(String titolo2, String dimensioni2, String tecnica2, int anno2) {
		// TODO Auto-generated constructor stub
		this.titolo=titolo2;
		this.dimensione=dimensioni2;
		this.tecnica=tecnica2;
		this.anno=anno2;

	}

	public Long getId() {
		return quadroId;
	}
	public void setId(Long id) {
		this.quadroId = id;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String dimensioni) {
		this.dimensione = dimensioni;
	}


}
