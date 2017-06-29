package escola.musica.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

//Oque pode ser vinculável com outra calsse
@Embeddable
public class Endereco {

	@NotEmpty(message = "Informe o logradouro.")
	private String logradouro;
	@NotNull(message = "Informe o número.")
	private Long numero;
	@NotEmpty(message = "Informe o CEP.")
	private String cep;
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	@NotNull(message="Selecione uma cidade.")
	private Cidade cidade = new Cidade();

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
