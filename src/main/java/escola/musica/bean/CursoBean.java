package escola.musica.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

@ManagedBean
@SessionScoped
public class CursoBean {

	private Curso curso;
	private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Curso> cursosAccordion = new ArrayList<Curso>();
	private Curso cursoExclusao;


	public Curso getCursoExclusao() {
		return cursoExclusao;
	}

	public void setCursoExclusao(Curso cursoExclusao) {
		this.cursoExclusao = cursoExclusao;
		System.out.println(this.cursoExclusao);
	}

	public void init() {
		cursos = new CursoDAO().getCursos();
		cursosAccordion = new CursoDAO().getCursosAccordion();
	}

	public void newCurso() {
		curso = new Curso();
	}

	public void salvar() {
		new CursoDAO().salvar(curso);
		// Adicionando na lista o nome curso.
		cursos = new CursoDAO().getCursos();
		// Limapando o curso depois de adicionar.
		curso = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
	}

	public void voltar() {
		curso = null;
	}

	public void editar(Curso curso) {
		this.curso = curso;
		System.out.println(curso);
	}

	public void excluir() {
		//System.out.println(cursoExclusao);
		new CursoDAO().exlcuir(cursoExclusao);
		// Adicionando na lista o nome curso.
		cursos = new CursoDAO().getCursos();
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso " + curso.getNome() + " excluido!"));
	}

	public String getDateNow() {
		return new SimpleDateFormat().format(new Date());
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TipoCurso> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoCurso> tipos) {
		this.tipos = tipos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}

	public void setCursosAccordion(List<Curso> cursosAccordion) {
		this.cursosAccordion = cursosAccordion;
	}

}
