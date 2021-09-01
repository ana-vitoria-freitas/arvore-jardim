package arvoreJardim;
import java.util.ArrayList;

public class Plantacao {
	private ArrayList<ArrayList<Especie>> matrizJardim = new ArrayList<ArrayList<Especie>>();
	private int quantidadeEspeciesPlantadas;
	
	public Plantacao(int quantidadeSubdivisoes) {
		for(int i = 0; i < quantidadeSubdivisoes; i++) {
			matrizJardim.add(new ArrayList<>());
		}
		
		this.quantidadeEspeciesPlantadas = 0;
	}
	
	private boolean plantacaoCheia(Area area, int idSubdivisao) {
		if(matrizJardim.get(idSubdivisao).isEmpty()) {
			return false;
		}else if(area.getAlturaEmMetros() < matrizJardim.get(idSubdivisao).size()) {
			return true;
		}
		
		return false;
	}

	
	public void imprimePlantacoes() {	
		if(quantidadeEspeciesPlantadas == 0) {
			System.out.println("Não há nada plantado no seu jardim. Que tal plantar alguma espécie?");
		}else {
			System.out.println("================================");
			for(int i = 0; i < matrizJardim.size(); i++) {
				for(int j = 0; j < matrizJardim.get(i).size(); j++) {
					System.out.println("Nome espécie: " + matrizJardim.get(i).get(j).getNomeEspecie());
					System.out.println("Posição na Largura: " + matrizJardim.get(i).get(j).getIdEspecieLargura());
					System.out.println("Posição na Altura: " + matrizJardim.get(i).get(j).getIdEspecieAltura());
					System.out.println();
				}
			}
			System.out.println("================================");
			
		}
	}
	
	private int buscaPlantacaoVazia(Area area, int idSubdivisao) {
		boolean encontrouVazia = false;
		
		while(!encontrouVazia) {
			idSubdivisao++;
			encontrouVazia = true;
			
			if(plantacaoCheia(area, idSubdivisao % matrizJardim.size())) {
				encontrouVazia = false;
			}
		}
		
		return idSubdivisao;
	}
	
	
	public boolean plantarEspecie(Area area, Especie especie, int idSubdivisao) {
		if(idSubdivisao < area.getLarguraEmMetros()) {
			if(especie.getIdEspecieAltura() > area.getAlturaEmMetros()){ //verifica se a altura do jardim foi passada
				int novoIdSubdivisao = buscaPlantacaoVazia(area, idSubdivisao);
				matrizJardim.get(novoIdSubdivisao).add(especie);
				especie.setIdEspecieLargura(novoIdSubdivisao);
				especie.setIdEspecieAltura(matrizJardim.get(novoIdSubdivisao).indexOf(especie));
				quantidadeEspeciesPlantadas++;
			}
			else if((especie.getIdEspecieAltura() < matrizJardim.get(idSubdivisao).size()) && !plantacaoCheia(area, idSubdivisao)) { //verifica se já existe especie na posicao
				especie.setIdEspecieAltura(matrizJardim.get(idSubdivisao).size());
				matrizJardim.get(idSubdivisao).add(especie);	
				quantidadeEspeciesPlantadas++;
			}else if(!plantacaoCheia(area, idSubdivisao)){ //se a plantacao nao esta cheia, basta colocar na posicao escolhida
				matrizJardim.get(idSubdivisao).add(especie);
				quantidadeEspeciesPlantadas++;
				return true;
			}else { //se estiver cheia, a especie sera plantada na proxima posicao vazia
				int novoIdSubdivisao = buscaPlantacaoVazia(area, idSubdivisao);
				matrizJardim.get(novoIdSubdivisao).add(especie);
				quantidadeEspeciesPlantadas++;
				return true;
			}
			
		}
		
		
		
		return false;
	}
	
	public int getQuantidadeEspeciesPlantadas() {
		return this.quantidadeEspeciesPlantadas;
	}
}
