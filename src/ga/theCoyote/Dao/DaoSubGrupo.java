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
import ga.theCoyote.model.ModSubGrupo;

public class DaoSubGrupo {

	/****************************************************************************************************/	
	public ModSubGrupo salvarSubGrupoDao(ModSubGrupo pSubGrupo) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pSubGrupo);
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
		return pSubGrupo;
	}

/****************************************************************************************************/
	public boolean atualizarSubGrupoDao(ModSubGrupo pSubGrupo) {	
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pSubGrupo);
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
	public boolean deletarSubGrupoDao(int pTipoProtudo) {
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
    public List<ModSubGrupo> listarSubGrupoDao(){
    	
    	List<ModSubGrupo> listaSubGrupo = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModSubGrupo> criteriaQuery = builder.createQuery(ModSubGrupo.class);
    		Root<ModSubGrupo> root = criteriaQuery.from(ModSubGrupo.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("subGrupo")));
    		listaSubGrupo = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaSubGrupo;
    }

/****************************************************************************************************/    
    public List<ModSubGrupo> procurarContemNomeSubGrupoDao(String pSubGrupo){
    	
    	List<ModSubGrupo> listaSubGrupo = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModSubGrupo> criteriaQuery = builder.createQuery(ModSubGrupo.class);
    		Root<ModSubGrupo> root = criteriaQuery.from(ModSubGrupo.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("subGrupo")));
    		criteriaQuery.where(builder.like(root.get("subGrupo"), "%" + pSubGrupo + "%"));
    		listaSubGrupo = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaSubGrupo;
    }

	
}
