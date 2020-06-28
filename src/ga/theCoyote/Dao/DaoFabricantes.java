package ga.theCoyote.Dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ga.theCoyote.HibernateUtil;
import ga.theCoyote.model.ModFabricantes;


/**
 * @author flavio
 */
public class DaoFabricantes {
/****************************************************************************************************/
	public ModFabricantes salvarFabricantesDao(ModFabricantes pFabricantes) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pFabricantes);
			transaction.commit();		
		} catch (HibernateException e) {
			sessao.getTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return pFabricantes;
	}
	
/****************************************************************************************************/    
    public List<ModFabricantes> listarFabricantesDao(){
    	
    	List<ModFabricantes> listaFabricantes = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFabricantes> criteriaQuery = builder.createQuery(ModFabricantes.class);
    		Root<ModFabricantes> root = criteriaQuery.from(ModFabricantes.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("fabricante")));
    		listaFabricantes = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
    		e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFabricantes;
    }
	
	
/****************************************************************************************************/    
    public List<ModFabricantes> procurarFabricantesDao(String pFabricantes){
    	
    	List<ModFabricantes> listaFabricantes = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFabricantes> criteriaQuery = builder.createQuery(ModFabricantes.class);
    		Root<ModFabricantes> root = criteriaQuery.from(ModFabricantes.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("fabricantes")));
    		criteriaQuery.where(builder.like(root.get("fabricantes"), "%" + pFabricantes + "%"));
    		listaFabricantes = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFabricantes;
    }
    	
}
