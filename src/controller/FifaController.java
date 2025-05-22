package controller;

import model.Pilha;
import model.Lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FifaController implements lFifaController {

    @Override
    public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
        Pilha<String> pilha = new Pilha<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho + nome));
        String linha = br.readLine(); // cabeçalho
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados[NationalityIndex()].equalsIgnoreCase("Brazil")) {
                pilha.push(linha);
            }
        }
        br.close();
        return pilha;
    }

    @Override
    public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
        while (!pilha.isEmpty()) {
            String jogador = pilha.pop();
            String[] dados = jogador.split(",");
            String nome = dados[NameIndex()];
            int overall = Integer.parseInt(dados[OverallIndex()]);
            if (overall > 80) {
                System.out.println(nome + " - Overall: " + overall);
            }
        }
    }

    @Override
    public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
        Lista<String> lista = new Lista<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho + nome));
        String linha = br.readLine(); // cabeçalho
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            int idade = Integer.parseInt(dados[AgeIndex()]);
            if (idade <= 20) {
                lista.add(linha);
            }
        }
        br.close();
        return lista;
    }

    @Override
    public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
        var elementos = lista.getElementos();
        for (int i = elementos.size() - 1; i >= 0; i--) {
            String jogador = elementos.get(i);
            String[] dados = jogador.split(",");
            int idade = Integer.parseInt(dados[AgeIndex()]);
            int overall = Integer.parseInt(dados[OverallIndex()]);
            if (overall > 80 && idade <= 20) {
                System.out.println(dados[NameIndex()] + " - Idade: " + idade + ", Overall: " + overall);
            }
        }
    }

    // Métodos auxiliares para definir índices corretos das colunas
    private int NationalityIndex() { return 5; } // ajustar conforme csv
    private int NameIndex() { return 1; } // ajustar conforme csv
    private int OverallIndex() { return 7; } // ajustar conforme csv
    private int AgeIndex() { return 3; } // ajustar conforme csv
}
