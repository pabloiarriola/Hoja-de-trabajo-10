package hojadetrabajo10;


import java.io.*;

/**
 * Esta clase se utiliza para buscar el archivo de texto que se va a utilizar
 * @author Diego Sosa
 * @author Pablo Arriola
 */
public class BuscarArchivo
{
    
    File archivo;
    FileReader filereader;
    BufferedReader bufferedreader;
    InterfazGrafo grafo = new GraphMatrix();

    
    /**
     * Nombre: obtenerArchivo
     * Descripcion: 
     * No hay valor de retorno
     * @param direccion
     * @throws FileNotFoundException
     */
    public void obtenerArchivo(String direccion) throws FileNotFoundException
    {
       archivo=new File(direccion); 
    }  
    
    /**
     * Nombre: arregloDeNombres
     * Descripcion: obtiene los nombres de los nodos para el grafo que se utiliza
     *
     *
     * Este metodo no utiliza ningun parametro de entrada
     * @return Devuelve un grafo
     * @throws IOException 
     */
    public InterfazGrafo arregloDeNombres() throws IOException
    {
        // Lectura del  archivo de texto
        filereader = new FileReader (archivo);
        bufferedreader = new BufferedReader(filereader);
        String linea;
        while((linea=bufferedreader.readLine())!=null)
        {
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo; //Devuelve el grafo
    }
    
    /**
     * Nombre: matrizDeCostos
     * Descripcion: obtiene los pesos de los arcos entre nodos del grafo
     * No tiene parametros
     * @return
     * @throws IOException
     */
    public InterfazGrafo matrizDeCostos() throws IOException
    {
        // Lectura del fichero
        filereader = new FileReader (archivo);
        bufferedreader = new BufferedReader(filereader);
        String linea;
        //SE lee el archivo
        while((linea=bufferedreader.readLine())!=null)
        {
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}