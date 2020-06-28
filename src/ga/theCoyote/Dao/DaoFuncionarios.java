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
import ga.theCoyote.model.ModFuncionarios;

/**
 * @author flavio
 */


/****************************************************************************************************/
public class DaoFuncionarios {
	public ModFuncionarios salvarFuncionario(ModFuncionarios pFuncionarios){
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();        
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pFuncionarios);
			transaction.commit();            
		}catch(HibernateException e){
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de funcionarios" + e);
			e.printStackTrace();
		} finally {
			if(sessao != null){
				sessao.close();
			}
		}
		return pFuncionarios;
	}
/****************************************************************************************************/    
    public List<ModFuncionarios> listarFuncionariosDao(){
    	
    	List<ModFuncionarios> listaFuncionarios = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncionarios> criteriaQuery = builder.createQuery(ModFuncionarios.class);
    		Root<ModFuncionarios> root = criteriaQuery.from(ModFuncionarios.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		listaFuncionarios = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncionarios;
    }

/****************************************************************************************************/    
    public List<ModFuncionarios> procurarContemNomeFuncionariosDao(String pFuncionario){
    	
    	List<ModFuncionarios> listaFuncionarios = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncionarios> criteriaQuery = builder.createQuery(ModFuncionarios.class);
    		Root<ModFuncionarios> root = criteriaQuery.from(ModFuncionarios.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		criteriaQuery.where(builder.like(root.get("nome"), "%" + pFuncionario + "%"));
    		listaFuncionarios = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncionarios;
    }

/****************************************************************************************************/
    public List<ModFuncionarios> procurarNomeFuncionariosDao(String pFuncionario){
    	
    	List<ModFuncionarios> listaFuncionarios = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncionarios> criteriaQuery = builder.createQuery(ModFuncionarios.class);
    		Root<ModFuncionarios> root = criteriaQuery.from(ModFuncionarios.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		criteriaQuery.where(builder.equal(root.get("nome"), pFuncionario));
    		listaFuncionarios = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncionarios;
    }
 
/****************************************************************************************************/
    public List<ModFuncionarios> procurarCpfCgcFuncionariosDao(String pFuncionario){
    	
    	List<ModFuncionarios> listaFuncionarios = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFuncionarios> criteriaQuery = builder.createQuery(ModFuncionarios.class);
    		Root<ModFuncionarios> root = criteriaQuery.from(ModFuncionarios.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("cpfcgc")));
    		criteriaQuery.where(builder.equal(root.get("cpfcgc"), pFuncionario));
    		listaFuncionarios = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFuncionarios;
    }

    
/****************************************************************************************************/       
    public boolean deleteFuncionarioDao(int pFuncionario) {
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		ModFuncionarios modFuncionarios = sessao.get(ModFuncionarios.class, pFuncionario);
    		sessao.remove(modFuncionarios);
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
    
    public ModFuncionarios procurarIdFuncionarioDao(int idFuncionario) {
    	ModFuncionarios modFuncionarios = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {		
    		sessao = sessaoFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		modFuncionarios = (ModFuncionarios) sessao.get(ModFuncionarios.class, idFuncionario);
    		transaction.commit();
    		
    	} catch (HibernateException e){
    		e.printStackTrace();

    	} finally {
    		if(sessao != null) {
    			sessao.close();
    		} 
    	}
    	return modFuncionarios;    	
    }

    public boolean atualizarFuncionarioDao(ModFuncionarios pFuncionarios){
        Session sessao = null;
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	        
	        try {
	            sessao = sessionFactory.openSession();
	            Transaction transaction = sessao.beginTransaction();
	            sessao.update(pFuncionarios);
	            transaction.commit();            
	            
	        }catch(HibernateException e){
	                JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de funcionarios" + e);
	                e.printStackTrace();
	                return false;
	        } finally {
	            if(sessao != null){
	                sessao.close();
	            }
	        }
	    return true;
	    }
    
	public List<ModFuncionarios> verSeExisteFuncionarioDao(String pNome, String pCpfCgc){
		
		List<ModFuncionarios> listaFuncionarios = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFuncionarios> criteriaQuery = builder.createQuery(ModFuncionarios.class);
			Root<ModFuncionarios> root = criteriaQuery.from(ModFuncionarios.class);
			criteriaQuery.select(root);
			
			criteriaQuery.where(builder.equal(root.get("nome"), pNome), builder.equal(root.get("cpfCgc"), pCpfCgc));
			listaFuncionarios = sessao.createQuery(criteriaQuery).getResultList();
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
	return listaFuncionarios;	
	}

}

