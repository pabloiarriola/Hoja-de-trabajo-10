package hojadetrabajo10;

/**
 *
 * @param <V> 
 * @param <E> 
 * @author Diego Sosa
 * @author Pablo Arriola
 */
public interface InterfazGrafo<V,E> {

    /**
     * Nombre: add
     * Descripcion: agrega nodo al grafo
     * Pre: label no es null
     * Post: nodo con nombre agregado al grafo
     * Si el nodo ya existe, no hay accion
     * No hay valor de retorno
     * @param label
     */
    public void add(V label);

    /**
     * Nombre: addEdge
     * Descripcion: agregar conexion entre nodos
     * Pre: vtx1 y vtx2 son nombres de nodos existentes
     * Post: conexion entre vtx1 y vtx2
     * No hay valor de retorno
     * @param vtx1
     * @param vtx2
     * @param label
     */
    public void addEdge(V vtx1, V vtx2, E label);
    
    /**
     * Nombre: show
     * Descipcion: desplegar el grafo
     * Pre: existe el grafo
     * Post: grafo desplegado
     * No hay parametros ni valor de retorno
     */
    public void show();
    public String show2();
    /**
     * Nombre: getIndex
     * Descripcion: obtiene la posicion de un nodo
     * Pre: label existe en el grafo
     * Post: indice del nodo
     * @param label
     * @return
     */
    public int getIndex(V label);
    
    /**
     * Nombre: get
     * Descipción: obtiene el nodo en la posicion label
     * Pre: no hay
     * Post: regresa el nombre del nodo
     * @param label
     * @return
     */
    public V get(int label);
    
    /**
     * Nombre: getEdge
     * Descipcion: obtiene el peso de la conexion entre dos nodos
     * Pre: no hay
     * Post: regresa el valor actual de la conexion
     * @param label1
     * @param label2
     * @return
     */
    public int getEdge(V label1, V label2);
    
    /**
     * Nombre: contains
     * Descripcion: verifica si el nodo indicado existe en el grafo
     * Pre: no hay
     * Post: regresa true si el vertice existe en el grafo
     * @param label
     * @return
     */
    public boolean contains(V label);
    
    /**
     * Nombre: size
     * Descripcion: indica la cantidad de nodos en el grafo
     * Pre: no hay
     * Post: regresa el numero de nodos en el grafo
     * No hay parametros
     * @return
     */
    public int size();
    
}