import java.util.ArrayList;
class Grafo {
    private ArrayList<Nodo> nodos;
    private ArrayList<Arista> aristas;
    public Grafo(int numNodos) {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }
    public boolean anadirArista(Arista arista) {
        if (!aristas.contains(arista)) {
            aristas.add(arista);
            return true;
        }else{
            return false;
        }
    }
    public boolean anadirNodo(Nodo nodo) {
        if (!nodos.contains(nodo)){
            nodos.add(nodo);
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarArista(Arista arista) {
        return aristas.remove(arista);
    }
    public boolean eliminarNodo(Nodo nodo) {
        return nodos.remove(nodo);
    }
    private int posicionNodo(Nodo nodo) {
        return nodos.indexOf(nodo);
    }
    public Nodo[] listaNodos() {
        return nodos.toArray(new Nodo[0]);
    }
    public Arista[] listaAristas() {
        return aristas.toArray(new Arista[0]);
    }
    private int numeroDeAristas() {
        return aristas.size();
    }
    private int numeroDeNodos() {
        return nodos.size();
    }

    // Ejercicio 1
    public void escribirNodos(int grado1, int grado2) {
        for (Nodo nodo : listaNodos()) {
            int grado = gradoNodo(nodo);
            if (grado >= grado1 && grado <= grado2) {
                System.out.println(nodo.getNombre());
            }
        }
    }

    private int gradoNodo(Nodo nodo) {
        int grado = 0;
        for (Arista arista : listaAristas()) {
            if (arista.getV1().igual(nodo) || arista.getV2().igual(nodo)) {
                grado++;
            }
        }
        return grado;
    }

    // Ejercicio 2
    public Grafo limpiaGrafo(int valor) {
        Grafo nuevoGrafo = new Grafo(numeroDeNodos());

        for (Nodo nodo : listaNodos()) {
            nuevoGrafo.anadirNodo(nodo);
        }

        for (Arista arista : listaAristas()) {
            if (arista.getPeso() >= valor) {
                nuevoGrafo.anadirArista(arista);
            }
        }

        for (Nodo nodo : listaNodos()) {
            if (nuevoGrafo.gradoNodo(nodo) == 0) {
                nuevoGrafo.eliminarNodo(nodo);
            }
        }

        return nuevoGrafo;
    }
}
