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
import ga.theCoyote.model.ModSituacaoCliente;

/**
 * @author flavio
 */
public class DaoSituacaoCliente {
/****************************************************************************************************/
	public ModSituacaoCliente salvarSituacaoCliente(ModSituacaoCliente pSituacaoCliente) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pSituacaoCliente);
			transaction.commit();
		} catch (HibernateException e) {
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao salvar o aquivo de tipo de clientes E.:" + e);
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		
		return pSituacaoCliente;
	}
	
/****************************************************************************************************/
	public List<ModSituacaoCliente> listaTodasSituacoesClientes(){
		List<ModSituacaoCliente> listaSituacaoCliente = null;
		Session sessao = null;
		SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModSituacaoCliente> criteriaQuery = builder.createQuery(ModSituacaoCliente.class);
			Root<ModSituacaoCliente> root = criteriaQuery.from(ModSituacaoCliente.class);
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get("situacaoCliente")));
			listaSituacaoCliente = sessao.createQuery(criteriaQuery).getResultList();
		} catch (HibernateException e) {
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar a lista de Situação de Clientes");
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				sessao.close();
			}			
		}
		return listaSituacaoCliente;
	}
	
/****************************************************************************************************/
	public List<ModSituacaoCliente> procurarSituacaoCliente(String pSituacaoCliente){
		
		List<ModSituacaoCliente> listaSituacaoCliente = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModSituacaoCliente> criteriaQuery = builder.createQuery(ModSituacaoCliente.class);
			Root<ModSituacaoCliente> root = criteriaQuery.from(ModSituacaoCliente.class);
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get("situacaoCliente")));
			criteriaQuery.where(builder.like(root.get("situacaoCliente"), pSituacaoCliente + "%"));
			listaSituacaoCliente = sessao.createQuery(criteriaQuery).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return listaSituacaoCliente;
	}
}
