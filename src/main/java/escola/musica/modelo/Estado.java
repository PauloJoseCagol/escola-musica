package escola.musica.modelo;

public enum Estado {

	SP("São Paulo"), RJ("Rio de Janeiro"), PR("Paraná"), SC("Santa Catarina"), MG("Mina Gerais");

	private Estado(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
