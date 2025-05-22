package view;

import controller.FifaController;
import controller.lFifaController;
import model.Pilha;
import model.Lista;

public class Principal {

    public static void main(String[] args) {
        lFifaController controller = new FifaController();
        String caminho = "C:\\TEMP\\";
        String nome = "data.csv";

        try {
            System.out.println("Empilhando jogadores brasileiros...");
            Pilha<String> pilhaBrasileiros = controller.empilhaBrasileiros(caminho, nome);

            System.out.println("\nDesempilhando bons brasileiros (Overall > 80):");
            controller.desmpilhaBonsBrasileiros(pilhaBrasileiros);

            System.out.println("\nListando revelações (idade <= 20):");
            Lista<String> listaRevelacoes = controller.listaRevelacoes(caminho, nome);

            System.out.println("\nBuscando bons jovens (Overall > 80 e idade <= 20):");
            controller.buscaListaBonsJovens(listaRevelacoes);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
