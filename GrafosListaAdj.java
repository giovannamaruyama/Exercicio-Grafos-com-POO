//Giovanna Maruyama - 16869489
//Giovanni Torres Bullo - 16869833

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoListaAdjacencia extends Grafo {
    //mapeia o nome do vértice para a sua lista de vizinhos
    private Map<String, List<String>> adjacencias;

    public GrafoListaAdjacencia() {
        super(); //Inicializa a lista de vértice do grafo
        this.adjacencias = new HashMap<>();
    }

    
    public void adicionarVertice(String vertice) {
        //Se o vértice ainda não existe, adiciona na classe base e na estrutura interna
        if (!existeVertice(vertice)) {
            this.vertices.add(vertice);
            this.adjacencias.put(vertice, new ArrayList<>());
        }
    }


    public void removerVertice(String vertice) {
        if (!existeVertice(vertice)) {
            return;
        }

        //Remove todas as arestas incidentes 
        for (List<String> vizinhos : adjacencias.values()) {
            vizinhos.remove(vertice);
        }

        //Remove o vértice da estrutura de adjacências
        this.adjacencias.remove(vertice);

        //Remove da lista global de vértices (classe base)
        this.vertices.remove(vertice);
    }

    public void adicionarAresta(String origem, String destino) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        //grafo nn direcionado, adiciona nos dois sentidos
        if (!adjacencias.get(origem).contains(destino)) {
            this.adjacencias.get(origem).add(destino);
        }
        if (!adjacencias.get(destino).contains(origem)) {
            this.adjacencias.get(destino).add(origem);
        }
    }

    public void removerAresta(String origem, String destino) {
        if (existeAresta(origem, destino)) {
            this.adjacencias.get(origem).remove(destino);
            this.adjacencias.get(destino).remove(origem);
        }
    }

    public boolean existeAresta(String origem, String destino) {
        if (existeVertice(origem) && existeVertice(destino)) {
            return this.adjacencias.get(origem).contains(destino);
        }
        return false;
    }

    public int grau(String vertice) {
        if (existeVertice(vertice)) {
            return this.adjacencias.get(vertice).size();
        }
        return 0;
    }

    public int tamanho() {
        int totalArestas = 0;
        for (List<String> vizinhos : adjacencias.values()) {
            totalArestas += vizinhos.size();
        }
        //divide por 2 para obter o tamanho real do grafo, pois a cada dupla de vertices há uma dupla de arestas em dois sentidos
        return totalArestas / 2;
    }

 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph {\n");

        //Lista para armazenar as linhas das arestas e formata
        List<String> linhasArestas = new ArrayList<>();

        // Percorre todos os vértices para coletar as arestas
        for (String origem : this.vertices) {
            List<String> vizinhos = this.adjacencias.get(origem);
            for (String destino : vizinhos) {
                if (origem.compareTo(destino) < 0) {
                    linhasArestas.add("  \"" + origem + "\" -- \"" + destino + "\";");
                }
            }
        }

        Collections.sort(linhasArestas);

        for (String linha : linhasArestas) {
            sb.append(linha).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
