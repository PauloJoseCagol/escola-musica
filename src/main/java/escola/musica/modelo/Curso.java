package escola.musica.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author paulo
 *
 */
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message = "O campo nome deve ser informado.")
	@Length(min = 4, max = 20, message = "Campo nome deve ter entre 3 e 20 caracteres.")
	private String nome;
	@NotEmpty(message = "O campo descrição deve ser informado.")
	@Length(max = 255, message = "Máximo 255 caracteres.")
	private String descricao;
	@Max(value = 10)
	@Min(value = 1)
	private Double duracao = 1.0;
	@NotNull(message = "Selecione uma opção de curso.")
	private TipoCurso tipo;
	@NotNull(message = "Data de criação deve ser informada.")
	private Date dataCriacao;

	public String getImagem(){
		return nome.toLowerCase()
				.replaceAll("ã", "a")
				.replaceAll("é", "e")
				.replaceAll(" ", "_")
				.concat(".png");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", duracao=" + duracao + ", tipo="
				+ tipo + ", dataCriacao=" + dataCriacao + "]";
	}
}
