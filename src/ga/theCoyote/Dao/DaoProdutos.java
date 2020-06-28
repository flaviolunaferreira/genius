
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
import ga.theCoyote.model.ModProdutos;

/**
 * @author flavio
 */

public class DaoProdutos {

	public ModProdutos salvarProdutosDao(ModProdutos pProdutos) {
		Session sessao = null;
		SessionFactory sessionFactoy = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactoy.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pProdutos);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo de produtos");
			sessao.beginTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return pProdutos;
	}
	
	public boolean atualizarProdutosDao(ModProdutos pProdutos) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pProdutos);
			transaction.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar Produto!");
			sessao.beginTransaction().rollback();
			return false;
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return true;
	}
	
	public boolean deletarProdutoDao(ModProdutos pProdutos) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.remove(pProdutos);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo de Produtos");
			sessao.beginTransaction().rollback();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return true;
	}
	
	public List<ModProdutos> listarProdutosDao(){
		List<ModProdutos> pListaProdutos = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModProdutos> criteriaQuery = builder.createQuery(ModProdutos.class);
    		Root<ModProdutos> root = criteriaQuery.from(ModProdutos.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("descricao")));
    		pListaProdutos = sessao.createQuery(criteriaQuery).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao listar produtos");
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return pListaProdutos;
	}
	
	public List<ModProdutos> procurarCodigoProdutoDao(String pProduto){
		List<ModProdutos> pListaProdutos = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModProdutos> criteriaQuery = builder.createQuery(ModProdutos.class);
    		Root<ModProdutos> root = criteriaQuery.from(ModProdutos.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("descricao")));
    		criteriaQuery.where(builder.equal(root.get("idProduto"), pProduto));
    		pListaProdutos = sessao.createQuery(criteriaQuery).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao listar esse produtos");
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}	
		return pListaProdutos;
	}
	
	public List<ModProdutos> procurarNomeProdutoDao(String pProduto){
		List<ModProdutos> pListaProdutos = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
    		CriteriaQuery<ModProdutos> criteriaQuery = builder.createQuery(ModProdutos.class);
    		Root<ModProdutos> root = criteriaQuery.from(ModProdutos.class);
    		criteriaQuery.select(root);
    		criteriaQuery.orderBy(builder.asc(root.get("descricao")));
    		criteriaQuery.where(builder.like(root.get("descricao"), "%" + pProduto + "%" ));
    		pListaProdutos = sessao.createQuery(criteriaQuery).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao listar esse produtos");
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}		
		
		return pListaProdutos;
	}
}
