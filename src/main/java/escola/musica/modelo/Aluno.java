package escola.musica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message = "Preencha o nome do aluno.")
	private String nome;
	@NotNull(message = "Informe a data de nascimento do aluno.")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	@Past(message = "Informe uma data menor que a data atual.")
	private Date dataNasciemento;
	@CPF(message = "CPF inválido.")
	private String cpf;
	@Email(message = "Email inválido.")
	private String email;
	private boolean ativo = true;
	private String telefone;
	@Embedded
	private Endereco endereco = new Endereco();

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public Date getDataNasciemento() {
		return dataNasciemento;
	}

	public void setDataNasciemento(Date dataNasciemento) {
		this.dataNasciemento = dataNasciemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
