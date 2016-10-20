package model;

public class Secretarias {
	private int id;
	private String nome;
	private boolean ativa;
	
	public Secretarias(int id, String nome, boolean ativa){
		this.id = id;
		this.nome = nome;
		this.ativa = ativa;
	}

	public Secretarias() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean getAtiva(){
		return ativa;
	}
	public void setAtiva(boolean ativa){
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		return "Secretarias [id=" + id + ", nome=" + nome + ", ativa=" + ativa + "]";
	}

}
