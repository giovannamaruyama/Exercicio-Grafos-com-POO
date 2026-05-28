# Exercicio-Grafos-com-POO

Exercício: Herança com Grafos (Java)
Neste exercício, você deverá implementar uma pequena hierarquia de classes para representar
grafos não direcionados. O objetivo é exercitar o uso de herança, definindo uma classe base com
a interface pública comum a todos os grafos e, em seguida, subclasses que implementam diferentes
formas de armazenamento interno.
Um grafo é uma estrutura formada por um conjunto de vértices e um conjunto de arestas. Neste
exercício, todos os grafos serão não direcionados, isto é, uma aresta entre os vértices A e B
representa uma ligação nos dois sentidos: de A para B e de B para A.
Além disso, serão implementados grafos não ponderados e ponderados. Em grafos não
ponderados, as arestas indicam apenas a existência de uma ligação entre dois vértices. Em grafos
ponderados, cada aresta possui também um valor numérico associado, chamado peso.
A classe base deverá definir a interface pública comum às subclasses. Todas as classes deverão
permitir a manipulação de vértices e arestas, consulta sobre a existência de vértices e arestas,
cálculo do grau de um vértice, obtenção da ordem e do tamanho do grafo e geração de uma
representação textual, conforme explicado no finl deste texto
-----------------------------------------------------------------------------------------------------------------
A interface pública mínima deve conter os seguintes métodos:
public void adicionarVertice(String vertice)
Adiciona um novo vértice ao grafo, caso ele ainda não exista.
public void removerVertice(String vertice)
Remove um vértice do grafo. Ao remover o vértice, todas as arestas incidentes a ele também devem
ser removidas.
public void adicionarAresta(String origem, String destino)
Adiciona uma aresta entre dois vértices. Como o grafo é não direcionado, a ligação deve ser
registrada nos dois sentidos.
public void removerAresta(String origem, String destino)
Remove a aresta entre dois vértices, caso ela exista.
public boolean existeVertice(String vertice)
Verifica se um determinado vértice pertence ao grafo.
public boolean existeAresta(String origem, String destino)
Verifica se existe uma aresta entre dois vértices.
public int grau(String vertice)
Retorna o grau de um vértice, isto é, o número de vértices adjacentes a ele.
public int ordem()
Retorna a ordem do grafo, isto é, o número de vértices.
public int tamanho()
Retorna o tamanho do grafo, isto é, o número de arestas.
public String toString()
Retorna uma representação textual do grafo.
Além desses métodos, a classe de grafo ponderado deverá oferecer também uma versão de
adicionarAresta que recebe o peso da aresta:
public void adicionarAresta(String origem, String destino, int peso)
Esse método deve adicionar uma aresta entre os dois vértices com o peso informado.
-----------------------------------------------------------------------------------------------------------------
Classes que devem ser implementadas
Você deverá implementar obrigatoriamente as seguintes classes:
Grafo
Classe base da hierarquia. Deve conter os elementos comuns a todos os grafos e definir a interface
pública que será usada pelas subclasses. Essa classe deve ser abstrata.
GrafoListaAdjacencia
Subclasse que representa um grafo não direcionado e não ponderado usando lista de adjacências.
Para cada vértice, deve ser mantida uma lista ou conjunto de seus vizinhos.
GrafoMatrizAdjacencia
Subclasse que representa um grafo não direcionado e não ponderado usando matriz de
adjacências. A matriz deve indicar se existe ou não aresta entre cada par de vértices.
GrafoPonderadoMatrizAdjacencia
Subclasse que representa um grafo não direcionado e ponderado usando matriz de adjacências.
Nesse caso, a matriz deve armazenar o peso da aresta entre dois vértices. Deve ser definido um
valor especial para indicar ausência de aresta, por exemplo 0 ou -1.
Em todas as implementações, os grafos devem ser considerados não direcionados. Portanto, ao
adicionar uma aresta entre A e B, a estrutura interna deve registrar a ligação tanto de A para B quanto
de B para A.
Por exemplo, em uma implementação por lista de adjacências, ao adicionar a aresta entre A e B, o
vértice B deve aparecer na lista de vizinhos de A, e o vértice A deve aparecer na lista de vizinhos de
B.
Em uma implementação por matriz de adjacências, ao adicionar uma aresta entre os vértices de
índices i e j, devem ser atualizadas as posições:
matriz[i][j]
matriz[j][i]
Formato do toString
Para facilitar a visualização dos grafos, o método toString() de cada classe deve retornar o
grafo em um formato textual compatível com o Graphviz.
O Graphviz é uma ferramenta que permite descrever grafos em texto e gerar uma imagem a partir
dessa descrição. O formato usado pelo Graphviz é chamado DOT.
Como todos os grafos deste exercício são não direcionados, a saída deve usar a palavra-chave:
graph
e as arestas devem ser representadas com:
--
Por exemplo, um grafo não direcionado com vértices A, B e C, e arestas entre A-B e A-C, pode ser
descrito assim:
graph {
 "A" -- "B";
 "A" -- "C";
}
Cada vértice deve ser escrito entre aspas, para permitir nomes compostos, como "Sao Paulo" ou
"Vertice 1".
Para grafos não ponderados, cada aresta deve aparecer apenas uma vez. Como o grafo é não
direcionado, a aresta entre A e B não deve ser impressa duas vezes. Portanto, a saída correta é:
graph {
 "A" -- "B";
}
e não:
graph {
 "A" -- "B";
 "B" -- "A";
}
Para grafos ponderados, o peso da aresta deve ser exibido como rótulo usando o atributo label:
graph {
 "A" -- "B" [label="10"];
 "A" -- "C" [label="5"];
}
Importante: as linhas devem ser geradas de forma que estejam ordenadas lexicograficamente.
Programa principal
O programa principal deve ser implementado em uma classe Main, responsável por criar os grafos,
ler os comandos da entrada padrão e executar as operações solicitadas em todas as implementações.
O programa deve criar três objetos:
GrafoListaAdjacencia grafoLista = new GrafoListaAdjacencia();
GrafoMatrizAdjacencia grafoMatriz = new GrafoMatrizAdjacencia();
GrafoPonderadoMatrizAdjacencia grafoPonderado = new
GrafoPonderadoMatrizAdjacencia();
Esses três grafos representam o mesmo conjunto de vértices e arestas, mas usam formas diferentes
de armazenamento interno. O primeiro usa lista de adjacências, o segundo usa matriz de adjacências
sem pesos, e o terceiro usa matriz de adjacências com pesos.
O programa deve ler uma sequência de comandos do stdin, um comando por linha, até o final da
entrada. Cada comando indica uma operação a ser executada nos grafos.
O comando de inserção tem o seguinte formato:
i v1 v2 p
Esse comando insere uma aresta entre os vértices v1 e v2. Se os vértices ainda não existirem, eles
devem ser criados automaticamente. Nos grafos não ponderados, o valor p deve ser ignorado, pois a
aresta não possui peso. No grafo ponderado, p deve ser usado como peso da aresta.
Por exemplo:
i A B 10
deve inserir a aresta entre A e B. No grafo ponderado, essa aresta terá peso 10.
O comando de remoção pode ter dois formatos:
d v1 v2
ou
d v1
Quando o comando possui três elementos, ele remove a aresta entre v1 e v2:
d A B
Nesse caso, os vértices A e B continuam existindo, mas a aresta entre eles é removida.
Quando o comando possui apenas dois elementos, ele remove o vértice informado:
d A
Nesse caso, o vértice A deve ser removido do grafo, assim como todas as arestas incidentes a ele.
O comando de impressão tem o seguinte formato:
p
Esse comando deve imprimir no stdout a representação textual dos três grafos, chamando o
método toString() de cada um deles. A saída deve permitir comparar as três implementações.
Uma forma adequada de impressão seria:
Lista de Adjacencia
graph {
 "A" -- "B";
}
Matriz de Adjacencia
graph {
 "A" -- "B";
}
Ponderado - Matriz de Adjacencia
graph {
 "A" -- "B" [label="5"];
}
É importante que o método toString() gere as linhas das arestas em ordem alfabética. Isso
garante que a saída seja sempre a mesma, independentemente da estrutura interna usada pela classe.
Assim, a lista de adjacências, a matriz de adjacências e a matriz ponderada devem produzir uma
saída previsível e comparável.
Por exemplo, se o grafo tiver as arestas A-B, A-C e B-D, a saída deve seguir uma ordem estável,
como:
graph {
 "A" -- "B";
 "A" -- "C";
 "B" -- "D";
}
O programa principal não deve implementar diretamente a lógica interna dos grafos. Sua função é
apenas interpretar os comandos e chamar os métodos públicos das classes. 
