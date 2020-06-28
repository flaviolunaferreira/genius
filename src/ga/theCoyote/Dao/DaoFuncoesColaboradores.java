package ga.theCoyote.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ga.theCoyote.HibernateUtil;
import ga.theCoyote.model.ModFuncoesColaboradores;

/**
 * @author flavio
 */
/****************************************************************************************************/
public class DaoFuncoesColaboradores {
	public ModFuncoesColaboradores salvarFuncoesColaboradores(ModFuncoesColaboradores pFuncoesColaboradores){
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();        
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pFuncoesColaboradores);
			transaction.commit();            
		}catch(HibernateException e){
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de funcoesColaboradores" + e);
			e.printStackTrace();
		} finally {
			if(sessao != null){
				sessao.close();
			}
		}
		return pFuncoesColaboradores;
	}
/****************************************************************************************************/    
    public List<ModFuncoesColaboradores> listarFuncoesColaboradoresDao(){
    	
    	List<ModFuncoesColaboradores> listaFuncoesColaboradores = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncoesColaboradores> criteriaQuery = builder.createQuery(ModFuncoesColaboradores.class);
    		Root<ModFuncoesColaboradores> root = criteriaQuery.from(ModFuncoesColaboradores.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("funcaoColaboradores")));
    		listaFuncoesColaboradores = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncoesColaboradores;
    }

/****************************************************************************************************/    
    public List<ModFuncoesColaboradores> procurarContemNomeFuncoesColaboradoresDao(String pFuncaoColaborador){
    	
    	List<ModFuncoesColaboradores> listaFuncoesColaboradores = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncoesColaboradores> criteriaQuery = builder.createQuery(ModFuncoesColaboradores.class);
    		Root<ModFuncoesColaboradores> root = criteriaQuery.from(ModFuncoesColaboradores.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("funcaoColaboradores")));
    		criteriaQuery.where(builder.like(root.get("funcaoColaboradores"), "%" + pFuncaoColaborador + "%"));
    		listaFuncoesColaboradores = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncoesColaboradores;
    }

/****************************************************************************************************/
    public List<ModFuncoesColaboradores> procurarNomeFuncoesColaboradoresDao(String pFuncaoColaborador){
    	
    	List<ModFuncoesColaboradores> listaFuncoesColaboradores = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncoesColaboradores> criteriaQuery = builder.createQuery(ModFuncoesColaboradores.class);
    		Root<ModFuncoesColaboradores> root = criteriaQuery.from(ModFuncoesColaboradores.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("funcaoColaboradores")));
    		criteriaQuery.where(builder.equal(root.get("funcaoColaboradores"), pFuncaoColaborador));
    		listaFuncoesColaboradores = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncoesColaboradores;
    }
 
/****************************************************************************************************/       
    public boolean deleteFuncaoColaboradorDao(int pFuncaoColaborador) {
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		ModFuncoesColaboradores modFuncoesColaboradores = sessao.get(ModFuncoesColaboradores.class, pFuncaoColaborador);
    		sessao.remove(modFuncoesColaboradores);
    		transaction.commit();
    	}catch(HibernateException e) {
    		e.printStackTrace();
    		return false;
    	} finally {
    		if(sessao != null) {
    			sessao.close();
    		}
    	}
    	
    	return true;
    }
   
/****************************************************************************************************/    
    public boolean atualizarFuncaoCalaboradorDao(ModFuncoesColaboradores pFuncoesColaboradores){
        Session sessao = null;
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	        
	        try {
	            sessao = sessionFactory.openSession();
	            Transaction transaction = sessao.beginTransaction();
	            sessao.update(pFuncoesColaboradores);
	            transaction.commit();            
	            
	        }catch(HibernateException e){
	                JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de funcoes dos colaboradores" + e);
	                e.printStackTrace();
	                return false;
	        } finally {
	            if(sessao != null){
	                sessao.close();
	            }
	        }
	    return true;
	    }    
}

