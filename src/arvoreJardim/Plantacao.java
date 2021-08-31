package arvoreJardim;
import java.util.ArrayList;

public class Plantacao {
	private ArrayList<ArrayList<Especie>> matrizJardim = new ArrayList<ArrayList<Especie>>();
	
	
	public boolean plantacaoCheia(Area area, int idSubdivisao) {
		if(area.getAlturaEmMetros() < matrizJardim.get(idSubdivisao).size()) {
			return true;
		}
		
		return false;
	}
	
	public void imprimePlantacoes() {
		for(int i = 0; i < matrizJardim.size(); i++) {
			for(int j = 0; j < matrizJardim.get(i).size(); i++) {
				System.out.println("Nome espécie: " + matrizJardim.get(i).get(j).getNomeEspecie());
				System.out.println("Posição na Largura: " + matrizJardim.get(i).get(j).getIdEspecieLargura());
				System.out.println("Posição na Altura: " + matrizJardim.get(i).get(j).getIdEspecieAltura());
			}
			System.out.println();
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
			if(!plantacaoCheia(area, idSubdivisao)) {
				matrizJardim.get(idSubdivisao).add(especie);
				return true;
			}else {
				int novoIdSubdivisao = buscaPlantacaoVazia(area, idSubdivisao);
				matrizJardim.get(novoIdSubdivisao).add(especie);
			}
			
		}
		
		
		
		return false;
	}
}
