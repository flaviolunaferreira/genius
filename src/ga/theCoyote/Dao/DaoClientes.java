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
import ga.theCoyote.model.ModClientes;

/**
 * @author flavio
 */


/****************************************************************************************************/
public class DaoClientes {
	public ModClientes salvarCliente(ModClientes pClientes){
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();        
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pClientes);
			transaction.commit();            
		}catch(HibernateException e){
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de clientes" + e);
			e.printStackTrace();
		} finally {
			if(sessao != null){
				sessao.close();
			}
		}
		return pClientes;
	}
/****************************************************************************************************/    
    public List<ModClientes> listarClientesDao(){
    	
    	List<ModClientes> listaClientes = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessaoFactory.openSession();
    		
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModClientes> criteriaQuery = builder.createQuery(ModClientes.class);
    		Root<ModClientes> root = criteriaQuery.from(ModClientes.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		listaClientes = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaClientes;
    }

/****************************************************************************************************/    
    public List<ModClientes> procurarContemNomeClientesDao(String pCliente){
    	
    	List<ModClientes> listaClientes = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModClientes> criteriaQuery = builder.createQuery(ModClientes.class);
    		Root<ModClientes> root = criteriaQuery.from(ModClientes.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		criteriaQuery.where(builder.like(root.get("nome"), "%" + pCliente + "%"));
    		listaClientes = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaClientes;
    }

/****************************************************************************************************/
    public List<ModClientes> procurarNomeClientesDao(String pCliente){
    	
    	List<ModClientes> listaClientes = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModClientes> criteriaQuery = builder.createQuery(ModClientes.class);
    		Root<ModClientes> root = criteriaQuery.from(ModClientes.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("nome")));
    		criteriaQuery.where(builder.equal(root.get("nome"), pCliente));
    		listaClientes = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaClientes;
    }
 
/****************************************************************************************************/
    public List<ModClientes> procurarCpfCgcClientesDao(String pCliente){
    	
    	List<ModClientes> listaClientes = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModClientes> criteriaQuery = builder.createQuery(ModClientes.class);
    		Root<ModClientes> root = criteriaQuery.from(ModClientes.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("cpfcgc")));
    		criteriaQuery.where(builder.equal(root.get("cpfcgc"), pCliente));
    		listaClientes = sessao.createQuery(criteriaQuery).getResultList();
 
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaClientes;
    }

    
/****************************************************************************************************/       
    public boolean deleteClienteDao(int pCliente) {
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		ModClientes modClientes = sessao.get(ModClientes.class, pCliente);
    		sessao.remove(modClientes);
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
    
    public ModClientes procurarIdClienteDao(int idCliente) {
    	ModClientes modClientes = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {		
    		sessao = sessaoFactory.openSession();
    		Transaction transaction = sessao.beginTransaction();
    		modClientes = (ModClientes) sessao.get(ModClientes.class, idCliente);
    		transaction.commit();
    		
    	} catch (HibernateException e){
    		e.printStackTrace();

    	} finally {
    		if(sessao != null) {
    			sessao.close();
    		} 
    	}
    	return modClientes;    	
    }

    public boolean atualizarClienteDao(ModClientes pClientes){
        Session sessao = null;
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	        
	        try {
	            sessao = sessionFactory.openSession();
	            Transaction transaction = sessao.beginTransaction();
	            sessao.update(pClientes);
	            transaction.commit();            
	            
	        }catch(HibernateException e){
	                JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de clientes" + e);
	                e.printStackTrace();
	                return false;
	        } finally {
	            if(sessao != null){
	                sessao.close();
	            }
	        }
	    return true;
	    }
    
	public List<ModClientes> verSeExisteClienteDao(String pNome, String pCpfCgc){
		
		List<ModClientes> listaClientes = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModClientes> criteriaQuery = builder.createQuery(ModClientes.class);
			Root<ModClientes> root = criteriaQuery.from(ModClientes.class);
			criteriaQuery.select(root);
			
			criteriaQuery.where(builder.equal(root.get("nome"), pNome), builder.equal(root.get("cpfcgc"), pCpfCgc));
			listaClientes = sessao.createQuery(criteriaQuery).getResultList();
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
	return listaClientes;	
	}
    
}

