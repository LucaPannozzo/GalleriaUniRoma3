package galleriaquadri.model;
import java.util.*;

import javax.persistence.*;


@Entity 
@NamedQuery(name = "findAllAutori", query = "SELECT a FROM Autore a ")

public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable=false)
	private String nome;

	@Column (nullable = false)
	private String cognome;

	@Column
	private String nazione;

	//da modificare con util.Date
	@Column
	private Date dataNascita;

	@Column
	private Date dataMorte;

	@Column
	private Date dataInserimento;

	@Column
	@OneToMany(mappedBy="autore", cascade=CascadeType.REMOVE)
	private Collection<Quadro> quadri ;

	public Autore(){

	}
	public Autore(String nome, String cognome, String nazionalità, Date dataNascita, Date dataMorte) {
		// TODO Auto-generated constructor stub

		this.nome=nome;
		this.cognome=cognome;
		this.nazione=nazionalità;
		this.dataNascita=dataNascita;
		this.dataMorte=dataMorte;

	}


	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Collection<Quadro> getQuadri() {
		return quadri;
	}
	public void setQuadri(Collection<Quadro> quadri) {
		this.quadri = quadri;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null)
			this.nome = nome;

	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		if(cognome!=null)
			this.cognome = cognome;

	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazionalità) {
		this.nazione = nazionalità;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date date) {
		this.dataNascita = date;
	}
	public Date getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void addQuadro(Quadro quadro){
		if(quadro!=null)
			this.quadri.add(quadro);
	}
}
