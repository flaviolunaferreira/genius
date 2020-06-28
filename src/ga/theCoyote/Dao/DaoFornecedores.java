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
import ga.theCoyote.model.ModFornecedores;

/**
 * @author flavio
 */


public class DaoFornecedores {

	public ModFornecedores salvarFornecedores(ModFornecedores pFornecedores){
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();        
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.save(pFornecedores);
			transaction.commit();            
		}catch(HibernateException e){
			sessao.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo de fornecedordes" + e);
			e.printStackTrace();
		} finally {
			if(sessao != null){
				sessao.close();
			}
		}
		return pFornecedores;
	}
	/****************************************************************************************************/    
	public List<ModFornecedores> listarFornecedoresDao(){

		List<ModFornecedores> listaFornecedores = null;
		Session sessao = null;
		SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();

		try {

			sessao = sessaoFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFornecedores> criteriaQuery = builder.createQuery(ModFornecedores.class);
			Root<ModFornecedores> root = criteriaQuery.from(ModFornecedores.class);
			criteriaQuery.select(root);																// nao precisaria colocar essa linha, mas eu goostoo!!!!
			criteriaQuery.orderBy(builder.asc(root.get("nome")));
			listaFornecedores = sessao.createQuery(criteriaQuery).getResultList();
		}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return listaFornecedores;
	}

	/****************************************************************************************************/    
	public List<ModFornecedores> procurarContemNomeFornecedoresDao(String pFornecedor){

		List<ModFornecedores> listaFornecedores = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try {

			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFornecedores> criteriaQuery = builder.createQuery(ModFornecedores.class);
			Root<ModFornecedores> root = criteriaQuery.from(ModFornecedores.class);
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get("nome")));
			criteriaQuery.where(builder.like(root.get("nome"), "%" + pFornecedor + "%"));
			listaFornecedores = sessao.createQuery(criteriaQuery).getResultList();

		}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return listaFornecedores;
	}

	/****************************************************************************************************/
	public List<ModFornecedores> procurarNomeFornecedoresDao(String pFornecedor){

		List<ModFornecedores> listaFornecedores = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFornecedores> criteriaQuery = builder.createQuery(ModFornecedores.class);
			Root<ModFornecedores> root = criteriaQuery.from(ModFornecedores.class);
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get("nome")));
			criteriaQuery.where(builder.equal(root.get("nome"), pFornecedor));
			listaFornecedores = sessao.createQuery(criteriaQuery).getResultList();

		}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return listaFornecedores;
	}

	/****************************************************************************************************/
	public List<ModFornecedores> procurarCpfCgcFornecedoresDao(String pFornecedor){

		List<ModFornecedores> listaFornecedores = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try {
			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFornecedores> criteriaQuery = builder.createQuery(ModFornecedores.class);
			Root<ModFornecedores> root = criteriaQuery.from(ModFornecedores.class);
			criteriaQuery.select(root);
			criteriaQuery.orderBy(builder.asc(root.get("cpfcgc")));
			criteriaQuery.where(builder.equal(root.get("cpfcgc"), pFornecedor));
			listaFornecedores = sessao.createQuery(criteriaQuery).getResultList();

		}catch(HibernateException e){	
			e.printStackTrace();
		} finally {
			if(sessao != null) {
				sessao.close();
			}
		}
		return listaFornecedores;
	}


	/****************************************************************************************************/       
	public boolean deleteFornecedorDao(int pFornecedor) {
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			ModFornecedores modFornecedores = sessao.get(ModFornecedores.class, pFornecedor);
			sessao.remove(modFornecedores);
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

	public ModFornecedores procurarIdFornecedorDao(int idFornecedor) {
		ModFornecedores modFornecedores = null;
		Session sessao = null;
		SessionFactory sessaoFactory = HibernateUtil.getSessionFactory();
		try {		
			sessao = sessaoFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			modFornecedores = (ModFornecedores) sessao.get(ModFornecedores.class, idFornecedor);
			transaction.commit();

		} catch (HibernateException e){
			e.printStackTrace();

		} finally {
			if(sessao != null) {
				sessao.close();
			} 
		}
		return modFornecedores;    	
	}

	public boolean atualizarFornecedorDao(ModFornecedores pFornecedores){
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	        
		try {
			sessao = sessionFactory.openSession();
			Transaction transaction = sessao.beginTransaction();
			sessao.update(pFornecedores);
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

	public List<ModFornecedores> verSeExisteFornecedorDao(String pNome, String pCpfCgc){

		List<ModFornecedores> listaFornecedores = null;
		Session sessao = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try {

			sessao = sessionFactory.openSession();
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<ModFornecedores> criteriaQuery = builder.createQuery(ModFornecedores.class);
			Root<ModFornecedores> root = criteriaQuery.from(ModFornecedores.class);
			criteriaQuery.select(root);

			criteriaQuery.where(builder.equal(root.get("nome"), pNome), builder.equal(root.get("cpfcgc"), pCpfCgc));
			listaFornecedores = sessao.createQuery(criteriaQuery).getResultList();

		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			if(sessao != null) {
				sessao.close();
			}
		}

		return listaFornecedores;	
	}

}