package escola.musica.modelo;

public enum TipoCurso {
	CORDAS("Cordas"), MADEIRAS("Madeiras"), METAIS("Metais"), PERCUSSAO("Precurssão");

	private String label;

	private TipoCurso(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
