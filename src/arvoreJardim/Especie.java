package arvoreJardim;

public class Especie {
	private int idEspecieLargura;
	private int idEspecieAltura;
	private String nomeEspecie;
	
	public Especie(String nome, int idEspecieLargura, int idEspecieAltura) {
		this.nomeEspecie = nome;
		this.idEspecieLargura = idEspecieLargura;
		this.idEspecieAltura = idEspecieAltura;
	}

	public int getIdEspecieLargura() {
		return idEspecieLargura;
	}
	
	public int getIdEspecieAltura() {
		return idEspecieAltura;
	}

	public String getNomeEspecie() {
		return nomeEspecie;
	}

	public void setIdEspecieLargura(int idEspecieLargura) {
		this.idEspecieLargura = idEspecieLargura;
	}

	public void setIdEspecieAltura(int idEspecieAltura) {
		this.idEspecieAltura = idEspecieAltura;
	}

	
}
