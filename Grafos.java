//Giovanna Maruyama - 16869489
//Giovanni Torres Bullo - 16869833

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo{
    protected List<String> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    //contagem de vertices
    public int ordem() {
        return this.vertices.size();
    }

    // verifica se o vértice existe na lista
    public boolean existeVertice(String vertice) {
        return this.vertices.contains(vertice);
    }

    // Métodos abstratos
    public abstract void adicionarVertice(String vertice);
    
    public abstract void removerVertice(String vertice);
    
    public abstract void adicionarAresta(String origem, String destino);
    
    public abstract void removerAresta(String origem, String destino);
    
    public abstract boolean existeAresta(String origem, String destino);
    
    public abstract int grau(String vertice);
    
    public abstract int tamanho();
    
    public abstract String toString();
}
}