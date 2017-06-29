package escola.musica.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.CidadeDAO;
import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;
import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;

	public void init() {
		alunos = new GenericDAO<Aluno>(Aluno.class).getAll();
		estados = Arrays.asList(Estado.values());
	}

	public void newAluno() {
		aluno = new Aluno();
	}

	public void voltar() {
		this.aluno = null;
	}

	public String getDateAluno() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat().format(calendar.getTime());
	}

	public void salvar() {
		new GenericDAO<Aluno>(Aluno.class).salvar(aluno);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		alunos = new GenericDAO<Aluno>(Aluno.class).getAll();
		aluno = null;
	}

	public List<Cidade> getCidadeEstado() {
		return CidadeDAO.getCidadesEstado(aluno.getEndereco().getCidade().getEstado());
	}

	public void editar(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
