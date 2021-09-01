package arvoreJardim;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bem vindo ao seu jardim virtual!");
		System.out.println("================================");
		
		Area areaJardim = new Area(15, 15, 3);
		Plantacao plantacao = new Plantacao(3);
		
		System.out.println("Por enquanto seu jardim de " + areaJardim.calculaAreaTotal() + " metros quadrados está assim: ");
		plantacao.imprimePlantacoes();
		
		
		plantacao.plantarEspecie(areaJardim, new Especie("Flor do deserto", 0, 0), 0);
		
		plantacao.plantarEspecie(areaJardim, new Especie("Sakura", 0, 1), 0);
		
		plantacao.plantarEspecie(areaJardim, new Especie("Orquídea", 0, 0), 0);
		
		plantacao.plantarEspecie(areaJardim, new Especie("Laranjeira", 0, 0), 0);
		
		plantacao.plantarEspecie(areaJardim, new Especie("Ipê Amarelo", 0, 20), 0);
		
		plantacao.imprimePlantacoes();
		
		System.out.println("Total de espécies plantadas: " + plantacao.getQuantidadeEspeciesPlantadas());
	}
}
