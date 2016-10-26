package model;

public class Usuarios{
	private String id;
	private String senha;
	private String nome;
	private String telefone;
	private String celular;
	private String endereco;
	private String email;
	private String cargo;
	private int secretaria;
	private long cpf;
	private int matricula;
	
	public Usuarios(String id, String senha, String nome, String telefone, String celular, String endereco, int matricula, String email, long cpf, String cargo, int secretaria){
		this.setId(id);
		this.setSenha(senha);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setEndereco(endereco);
		this.setMatricula(matricula);
		this.setEmail(email);
		this.setCpf(cpf);
		this.setCargo(cargo);
		this.setSecretaria(secretaria);
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

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(int secretaria) {
		this.secretaria = secretaria;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if (cargo.equals("Superior"))
			this.cargo = cargo;
		else if (cargo.equals("Avaliador"))
			this.cargo = cargo;
		else if (cargo.equals("SysAdmin"))
			this.cargo = cargo;
		else
			this.cargo = "Cidadao";
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", celular="
				+ celular + ", endereco=" + endereco + ", email=" + email + ", cpf=" + cpf + ", matricula=" + matricula
				+ "]";
	}

	
}