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
import ga.theCoyote.model.ModFamiliaTributaria;

public class DaoFamiliaTributaria {

	/****************************************************************************************************/	
	public ModFamiliaTributaria salvarFamiliaTributariaDao(ModFamiliaTributaria pFamiliaTributaria) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pFamiliaTributaria);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar o tipo de produto");
			sessao.getTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return pFamiliaTributaria;
	}

/****************************************************************************************************/
	public boolean atualizarFamiliaTributariaDao(ModFamiliaTributaria pFamiliaTributaria) {	
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pFamiliaTributaria);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro do tipo de produto.");
			sessao.getTransaction().rollback();
			return false;
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return true;
	}

/****************************************************************************************************/
	public boolean deletarFamiliaTributariaDao(int pTipoProtudo) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.remove(pTipoProtudo);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao apagar cadastro de tipo de produto");
			sessao.getTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return true;
	}
	
/****************************************************************************************************/  
    public List<ModFamiliaTributaria> listarFamiliaTributariaDao(){
    	
    	List<ModFamiliaTributaria> listaFamiliaTributaria = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFamiliaTributaria> criteriaQuery = builder.createQuery(ModFamiliaTributaria.class);
    		Root<ModFamiliaTributaria> root = criteriaQuery.from(ModFamiliaTributaria.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("familiaTributaria")));
    		listaFamiliaTributaria = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFamiliaTributaria;
    }

/****************************************************************************************************/    
    public List<ModFamiliaTributaria> procurarContemNomeFamiliaTributariaDao(String pFamiliaTributaria){
    	
    	List<ModFamiliaTributaria> listaFamiliaTributaria = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModFamiliaTributaria> criteriaQuery = builder.createQuery(ModFamiliaTributaria.class);
    		Root<ModFamiliaTributaria> root = criteriaQuery.from(ModFamiliaTributaria.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("familiaTributaria")));
    		criteriaQuery.where(builder.like(root.get("familiaTributaria"), "%" + pFamiliaTributaria + "%"));
    		listaFamiliaTributaria = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaFamiliaTributaria;
    }

	
}
