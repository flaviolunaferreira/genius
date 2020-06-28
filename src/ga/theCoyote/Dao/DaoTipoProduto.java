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
import ga.theCoyote.model.ModTipoProduto;

public class DaoTipoProduto {
/****************************************************************************************************/	
	public ModTipoProduto salvarTipoProdutoDao(ModTipoProduto pTipoProduto) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pTipoProduto);
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
		return pTipoProduto;
	}

/****************************************************************************************************/
	public boolean atualizarTipoProdutoDao(ModTipoProduto pTipoProduto) {	
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pTipoProduto);
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
	public boolean deletarTipoProdutoDao(int pTipoProtudo) {
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
    public List<ModTipoProduto> listarTipoProdutoDao(){
    	
    	List<ModTipoProduto> listaTipoProduto = null;
    	Session sessao = null;
    	SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModTipoProduto> criteriaQuery = builder.createQuery(ModTipoProduto.class);
    		Root<ModTipoProduto> root = criteriaQuery.from(ModTipoProduto.class);
    		criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
    		criteriaQuery.orderBy(builder.asc(root.get("tipoProduto")));
    		listaTipoProduto = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaTipoProduto;
    }

/****************************************************************************************************/    
    public List<ModTipoProduto> procurarContemNomeTipoProdutoDao(String pTipoProduto){
    	
    	List<ModTipoProduto> listaTipoProduto = null;
    	Session sessao = null;
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	try {
    		sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModTipoProduto> criteriaQuery = builder.createQuery(ModTipoProduto.class);
    		Root<ModTipoProduto> root = criteriaQuery.from(ModTipoProduto.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("descricao")));
    		criteriaQuery.where(builder.like(root.get("descricao"), "%" + pTipoProduto + "%"));
    		listaTipoProduto = sessao.createQuery(criteriaQuery).getResultList();
    	}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
    	return listaTipoProduto;
    }

}
