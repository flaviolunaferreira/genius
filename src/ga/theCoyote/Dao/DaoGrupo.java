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
import ga.theCoyote.model.ModGrupo;

public class DaoGrupo {

	/****************************************************************************************************/	
	public ModGrupo salvarGrupoDao(ModGrupo pGrupo) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pGrupo);
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
		return pGrupo;
	}

/****************************************************************************************************/
	public boolean atualizarGrupoDao(ModGrupo pGrupo) {	
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pGrupo);
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
	public boolean deletarGrupoDao(int pTipoProtudo) {
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
    public List<ModGrupo> listarGrupoDao(){
    	
    	List<ModGrupo> listaGrupo = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModGrupo> criteriaQuery = builder.createQuery(ModGrupo.class);
    		Root<ModGrupo> root = criteriaQuery.from(ModGrupo.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("grupo")));
    		listaGrupo = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaGrupo;
    }

/****************************************************************************************************/    
    public List<ModGrupo> procurarContemNomeGrupoDao(String pGrupo){
    	
    	List<ModGrupo> listaGrupo = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModGrupo> criteriaQuery = builder.createQuery(ModGrupo.class);
    		Root<ModGrupo> root = criteriaQuery.from(ModGrupo.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("grupo")));
    		criteriaQuery.where(builder.like(root.get("grupo"), "%" + pGrupo + "%"));
    		listaGrupo = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaGrupo;
    }

	
}
