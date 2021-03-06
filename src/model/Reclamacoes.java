package model;

public class Reclamacoes {
	private int id;
	private String titulo;
	private String dataHora;
	private String idCidadao;
	private String descricao;
	private double latitude;
	private double longitude;
	private Secretarias secretaria;
	private int idAvaliador;
	private String resposta;
	private boolean aprovado;
	
	public Reclamacoes(int id,String titulo, String dataHora, String idCidadao, String descricao, double latitude,
			double longitude, Secretarias secretaria, int idAvaliador, String resposta, boolean aprovado){
		this.id = id;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.idCidadao = idCidadao;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.secretaria = secretaria;
		this.idAvaliador = idAvaliador;
		this.resposta = resposta;
		this.aprovado = aprovado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getIdCidadao() {
		return idCidadao;
	}

	public void setIdCidadao(String idCidadao) {
		this.idCidadao = idCidadao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Secretarias getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretarias secretaria) {
		this.secretaria = secretaria;
	}

	public int getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(int idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		return "Reclamacoes [id=" + getId() + ", titulo=" + getTitulo() + ", dataHora=" 
				+ getDataHora() + ", idCidadao=" + getIdCidadao()
				+ ", descricao=" + getDescricao() + ", latitude=" + getLatitude()
				+ ", longitude=" + getLongitude() + ", secretaria="
				+ getSecretaria() + ", idAvaliador=" + getIdAvaliador() + 
				", resposta=" + getResposta() + ", aprovado=" + aprovado
				+ "]";
	}
}
