public class Main {
    public static void main(String[] args) {
                Grafo grafo = new Grafo(10);
                Nodo n1 = new Nodo("A");
                Nodo n2 = new Nodo("B");
                Nodo n3 = new Nodo("C");
                Nodo n4 = new Nodo("D");
                Nodo n5 = new Nodo("E");

                grafo.anadirNodo(n1);
                grafo.anadirNodo(n2);
                grafo.anadirNodo(n3);
                grafo.anadirNodo(n4);
                grafo.anadirNodo(n5);

                grafo.anadirArista(new Arista(n1, n2, 3));
                grafo.anadirArista(new Arista(n2, n3, 1));
                grafo.anadirArista(new Arista(n3, n4, 5));
                grafo.anadirArista(new Arista(n4, n5, 2));
                grafo.anadirArista(new Arista(n1, n5, 4));

                System.out.println("Nodos con grado entre 1 y 2:");
                grafo.escribirNodos(1, 2);

                System.out.println("\nLimpieza del grafo eliminando aristas con peso menor que 3:");
                Grafo grafoLimpio = grafo.limpiaGrafo(3);

                System.out.println("\nNodos en el grafo despues de limpiar:");
                for (Nodo nodo : grafoLimpio.listaNodos()) {
                    System.out.println(nodo.getNombre());
                }

    }
}