package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Transient;

import escola.musica.modelo.Curso;

public class CursoDAO {

	EntityManager entityManager;

	public CursoDAO() {
		// TODO Auto-generated constructor stub
		entityManager = JPAUtil.getEntityManager();
	}

	public void salvar(Curso curso) {

		entityManager.getTransaction().begin();
		entityManager.merge(curso);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public Curso findCurso(Curso curso) {
		return entityManager.find(Curso.class, curso.getId());
	}

	public void exlcuir(Curso curso) {
		entityManager.getTransaction().begin();
		curso = findCurso(curso);
		entityManager.remove(curso);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> getCursos() {
		return entityManager.createQuery("from Curso order by nome").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> getCursosAccordion() {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery("from Curso where nome in ('Violino', "
						+ "'Bateria', 'Clarinete', 'Flauta', 'Guitarra', 'Violão', 'Oboé') order by nome")
				.getResultList();
	}
}
