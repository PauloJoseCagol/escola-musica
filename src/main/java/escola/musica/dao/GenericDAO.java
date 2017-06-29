package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		// TODO Auto-generated constructor stub
		this.classe = classe;
	}

	public void salvar(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(T t) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<T> getAll() {
		EntityManager em = JPAUtil.getEntityManager();
		List<T> result = em.createQuery("select c from " + classe.getName() + " c", classe).getResultList();
		em.close();
		return result;
	}

	public T findById(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		T t = em.createQuery("from " + classe.getName() + "where id = :id", classe).setParameter("id", id)
				.getSingleResult();
		em.close();
		return t;
	}

}
