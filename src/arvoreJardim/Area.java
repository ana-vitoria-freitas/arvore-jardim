package arvoreJardim;

public class Area {
	private double larguraEmMetros;
	private double alturaEmMetros;
	private int quantidadeSubdivisoes;
	
	
	public Area(double largura, double altura, int quantidadeSubdivisoes) {
		this.larguraEmMetros = largura;
		this.alturaEmMetros = altura;
		this.quantidadeSubdivisoes = quantidadeSubdivisoes;
	}
	
	
	
	public double calculaAreaTotal() {
		return larguraEmMetros * alturaEmMetros;
	}
	
	public double calculaAreaSubdivisoes() {
		if(quantidadeSubdivisoes != 0) {
			return (larguraEmMetros * alturaEmMetros) / quantidadeSubdivisoes;			
		}
		
		return 0;
	}


	public double getLarguraEmMetros() {
		return larguraEmMetros;
	}
	

	public int getQuantidadeSubdivisoes() {
		return this.quantidadeSubdivisoes;
	}

	public double getAlturaEmMetros() {
		return alturaEmMetros;
	}

	
	
	
}
