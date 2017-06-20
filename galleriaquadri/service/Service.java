package galleriaquadri.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import galleriaquadri.model.Autore;
import galleriaquadri.model.Quadro;


public class Service {


	//metodi getOne

	public Autore getOneAutore(Long id){
		Autore result=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		List<Autore> autori = em.createNamedQuery("findAllAutori").getResultList();

		for(Autore a : autori){
			if(a.getId()==id)
				result=a;
		}
		tx.commit();
		em.close();
		emf.close();
		return result;
	}

	public Quadro getOneQuadro(Long id ){
		Quadro result=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		List<Quadro> quadri=em.createNamedQuery("findAllQuadri").getResultList();

		for(Quadro quadro : quadri){
			if(quadro.getId()==id)
				result=quadro;
		}
		tx.commit();
		em.close();
		emf.close();
		return result;

	}

	//metodi getAll
	public List<Quadro> getQuadriBy(String criterio){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//Query q = em.createQuery("SELECT * FROM public.quadro ORDER BY anno ASC");
		
		Query q = em.createQuery("SELECT q FROM Quadro q ORDER BY q."+criterio);
		List<Quadro> quadri = q.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return quadri;
	}





	public List<Autore> getAutoriBy(String criterio){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q;
		if(criterio.equals("dataInserimento"))
			q = em.createQuery("SELECT a FROM Autore a ORDER BY a."+criterio+" DESC");
		else
			q = em.createQuery("SELECT a FROM Autore a ORDER BY a."+criterio);
		List<Autore> autori = q.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return autori;
	}






	//metodi add
	public void addAutore(Autore autore){
		if(autore!=null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
			EntityManager em =emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			if(!em.contains(autore)) 
				em.persist(autore);
			tx.commit();
			em.close();
			emf.close();
		}
	}

	public void addQuadro(Quadro quadro){
		if(quadro!=null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
			EntityManager em =emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			if(!em.contains(quadro))
				em.persist(quadro);
			tx.commit();
			em.close();
			emf.close();
		}
	}

	//metodi delete
	public void cancellaAutore(Autore a) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.remove(em.contains(a) ? a : em.merge(a));
		tx.commit();
		em.close();
		emf.close();
	}
	public void cancellaQuadro(Quadro q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.remove(em.contains(q) ? q : em.merge(q));
		tx.commit();
		em.close();
		emf.close();
	}

	//metodi deleteAll
	public boolean cancellaAllAutori() {
		// TODO Auto-generated method stub
		boolean result=false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createQuery("DELETE FROM Autore ").executeUpdate();
		if(this.getAutoriBy("cognome").size()==0)
			result=true;
		tx.commit();
		em.close();
		emf.close();
		return result;
	}

	public boolean cancellaAllQuadri() {
		// TODO Auto-generated method stub
		boolean result=false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createQuery("DELETE FROM Quadro ").executeUpdate();
		if(this.getQuadriBy("titolo").size()==0)
			result=true;
		tx.commit();
		em.close();
		emf.close();
		return result;
	}

	public boolean containsAutore(Autore autore){
		List<Autore> autori=getAutoriBy("cognome");
		for (Autore a : autori){
			if(a.getNome().equals(autore.getNome()) && a.getCognome().equals(autore.getCognome()) && a.getNazione().equals(autore.getNazione()) && a.getDataNascita().compareTo(autore.getDataNascita())==0 && a.getDataMorte().compareTo(autore.getDataMorte())==0)
				return true;
		}
		return false;
	}

}
