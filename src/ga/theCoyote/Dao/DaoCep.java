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
import ga.theCoyote.model.ModCep;

/**
 * @author flavio
 */

public class DaoCep {
/****************************************************************************************************/
    public ModCep salvarCep(ModCep pCep){
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		sessao.save(pCep);
    		transaction.commit();            	            
    	}catch(HibernateException e){
    		JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de cep" + e);
    		e.printStackTrace();
    	} finally {
    		if(sessao != null){
    			sessao.close();
    		}
    	}
    	return pCep;
    }

/****************************************************************************************************/    
    public ModCep atualizarCepDao(ModCep pCep) {
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pCep);
			transaction.commit();
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualiza arquivo de cep" + e);
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}  	
    	return pCep;
    }
    
/****************************************************************************************************/    
   public boolean deleteCepDao(int pCep) {
	   Session sessao = null;
	   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	   try {
		   sessao = sessionFactory.openSession();
		   Transaction transaction = sessao.beginTransaction();
		   sessao.delete(pCep);
		   transaction.commit();
	} catch (HibernateException e) {
		JOptionPane.showMessageDialog(null, "Erro ao apagar Cep!!!");
		return false;
	} finally {
		if(sessao != null) {
			sessao.close();
		}
	}
	   return true;
   }
   
/****************************************************************************************************/    
    public List<ModCep> listarCepDao(){
    	
    	List<ModCep> listaCep = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModCep> criteriaQuery = builder.createQuery(ModCep.class);
    		Root<ModCep> root = criteriaQuery.from(ModCep.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("rua")));
    		listaCep = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaCep;
    }	
	
	
/****************************************************************************************************/	
	public List<ModCep> procurarCepDao(String pCep){
	
		List<ModCep> listaCep = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModCep> criteriaQuery = builder.createQuery(ModCep.class);
			Root<ModCep> root = criteriaQuery.from(ModCep.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.like(root.get("cep"), "%" + pCep + "%"));
			criteriaQuery.orderBy(builder.asc(root.get("rua")));
			listaCep = sessao.createQuery(criteriaQuery).getResultList();
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
	return listaCep;	
	}

/****************************************************************************************************/
	public List<ModCep> procurarEnderecoDao(String pEndereco){
		
		List<ModCep> listaCep = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModCep> criteriaQuery = builder.createQuery(ModCep.class);
			Root<ModCep> root = criteriaQuery.from(ModCep.class);
			criteriaQuery.select(root);
			criteriaQuery.where(builder.like(root.get("rua"), "%" + pEndereco + "%"));
			criteriaQuery.orderBy(builder.asc(root.get("rua")));
			listaCep = sessao.createQuery(criteriaQuery).getResultList();
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
	return listaCep;	
	}
	
	public List<ModCep> verSeExisteEnderecoDao(String pRua, String pCep){
		
		List<ModCep> listaCep = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModCep> criteriaQuery = builder.createQuery(ModCep.class);
			Root<ModCep> root = criteriaQuery.from(ModCep.class);
			criteriaQuery.select(root);
			
			criteriaQuery.where(builder.equal(root.get("rua"), pRua), builder.equal(root.get("cep"), pCep));
			listaCep = sessao.createQuery(criteriaQuery).getResultList();
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
	return listaCep;	
	}
	
}
