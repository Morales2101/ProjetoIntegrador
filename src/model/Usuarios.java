package model;

public class Usuarios{
	private String id;
	private String senha;
	private String nome;
	private String telefone;
	private String celular;
	private String endereco;
	private String email;
	private int cpf;
	private int matricula;
	
	public Usuarios(String id, String senha, String nome, String telefone, String celular, String endereco, int matricula, String email, int cpf){
		this.id = id;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.matricula = matricula;
		this.email = email;
		this.cpf = cpf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", celular="
				+ celular + ", endereco=" + endereco + ", email=" + email + ", cpf=" + cpf + ", matricula=" + matricula
				+ "]";
	}

	
}