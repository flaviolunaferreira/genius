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
import ga.theCoyote.model.ModTipoCliente;

/**
 * @author flavio
 */
public class DaoTipoCliente {
/****************************************************************************************************/
	public ModTipoCliente salvarTipoClienteDao(ModTipoCliente pTipoCliente) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pTipoCliente);
			transaction.commit();		
		} catch (HibernateException e) {
			sessao.getTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return pTipoCliente;
	}
	
/****************************************************************************************************/    
    public List<ModTipoCliente> listarTipoClienteDao(){
    	
    	List<ModTipoCliente> listaTipoCliente = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModTipoCliente> criteriaQuery = builder.createQuery(ModTipoCliente.class);
    		Root<ModTipoCliente> root = criteriaQuery.from(ModTipoCliente.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("tipoCliente")));
    		listaTipoCliente = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
    		e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaTipoCliente;
    }
	
	
/****************************************************************************************************/    
    public List<ModTipoCliente> procurarTipoClienteDao(String pTipoCliente){
    	
    	List<ModTipoCliente> listaTipoCliente = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   	
    	try { 		
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModTipoCliente> criteriaQuery = builder.createQuery(ModTipoCliente.class);
    		Root<ModTipoCliente> root = criteriaQuery.from(ModTipoCliente.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("tipoCliente")));
    		criteriaQuery.where(builder.like(root.get("tipoCliente"), pTipoCliente + "%"));
    		listaTipoCliente = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaTipoCliente;
    }
    	
}
