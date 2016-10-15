package model;

public class Anexos {
	private int id;
	private int idReclam;
	private String idCidadao;
	private String anexo;
	private String comentario;
	private String tipo;
	
	public Anexos(int id, int idReclam, String idCidadao, String anexo, String comentario, String tipo){
		this.id = id;
		this.idReclam = idReclam;
		this.anexo = anexo;
		this.comentario = comentario;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdReclam() {
		return idReclam;
	}

	public void setIdReclam(int idReclam) {
		this.idReclam = idReclam;
	}

	public String getIdCidadao() {
		return idCidadao;
	}

	public void setIdCidadao(String idCidadao) {
		this.idCidadao = idCidadao;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Anexos [id=" + id + ", idReclam=" + idReclam + ", idCidadao=" + idCidadao + ", anexo=" + anexo
				+ ", comentario=" + comentario + ", tipo=" + tipo + "]";
	}
}
