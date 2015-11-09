package hojadetrabajo10;


import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.*;

/**
 * Esta clase se utiliza para ejecutar el algoritmo de Floyd
 * @author Diego Sosa
 * @author Pablo Arriola
 */
public class Floyd {
    
    BuscarArchivo archivo= new BuscarArchivo();
    public InterfazGrafo interfaz;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;
    String direccion;
    
    /**
     * Nombre: Floyd
     * Descripcion: constructor de la clase
     */
    public Floyd()
    {
        
        try 
        {
            direccion = JOptionPane.showInputDialog("Ingrese la direccion del archivo de texto. Ejemplo: /home/eldonmoi/Desktop/hojadetrabajo10/src/hojadetrabajo10/datos.txt" );
            archivo.obtenerArchivo(direccion);
            archivo.arregloDeNombres(); // Nombre de los nodos
            interfaz = archivo.matrizDeCostos(); // Peso de los arcos entre nodos
            P = new int[25][25]; // Matriz de nodos intermedios
            max = new int[25];
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        for(int n=0;n<archivo.grafo.size();n++)
        {
            for(int m=0;m<archivo.grafo.size();m++)
            {
                P[n][m]=10000;
            }
        }
    }
    
    /**
     * caminoMasCorto
    * Algoritmo de Floyd para encontrar el camino mas corto entre todos los nodos*/
    public void caminoMasCorto()
    {
        for(int k=0;k<interfaz.size();k++)
        {
            for(int i=0;i<interfaz.size();i++)
            {
                for(int j=0;j<interfaz.size();j++)
                {
                    if(interfaz.getEdge(interfaz.get(i),interfaz.get(j))>(interfaz.getEdge(interfaz.get(i), interfaz.get(k))+interfaz.getEdge(interfaz.get(k), interfaz.get(j))))
                    {
                        interfaz.addEdge(interfaz.get(i), interfaz.get(j), (interfaz.getEdge(interfaz.get(i), interfaz.get(k))+interfaz.getEdge(interfaz.get(k), interfaz.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    /**
     * Nombre: centroGrafo
     * Descripcion: encontrar el centro del grafo
     * Pre: matriz de adyacencia con los menores valores entre cada nodo
     * Post: centro del grafo
     * No hay parametros ni valor de retorno
     */
    public void centroGrafo()
    {
        caminoMasCorto();
        int n=0;       
        // Encontrar los maximos de cada columna de la matriz
        for(int i=0;i<interfaz.size();i++)
        {
            for(int j=0;j<interfaz.size()-1;j++)
            {
                int num1=interfaz.getEdge(interfaz.get(j), interfaz.get(i));
                n=j;
                n++;
                int num2=interfaz.getEdge(interfaz.get(n), interfaz.get(i));
                if(num1>num2)
                {
                    max[i]=num1;
                }
                else
                {
                    max[i]=num2;
                }
            }
            n++;
        }
        // Encontrar el minimo de los maximos de cada columna
        for(int i=0;i<interfaz.size();i++)
        {
            int num1=max[i];
            if(num1<minimo)
            {
                centro=i;
                minimo=num1;
            }
        }
        //System.out.println("\nEl centro del grafo es: "+interfaz.get(centro)+"\n");
        JOptionPane.showMessageDialog(null, "La ciudad que esta en el centro "
                + "del grafo es: " +interfaz.get(centro)+"\n");
    }
    
    /**
     * Nombres: mostrarIntermedias
     * Descripcion: desplegar los nodos intermedios
     * Basado en el material de clase
     * Pre: no hay
     * Post: nodos intermedios desplegados
     * No hay valor de retorno
     * @param num1
     * @param num2
     */
    public void mostrarIntermedias(int num1, int num2)
    {
        if(P[num1][num2]!=10000)
        {
            mostrarIntermedias(num1,P[num1][num2]);
            System.out.print(", "+interfaz.get(P[num1][num2]));
            mostrarIntermedias(P[num1][num2],num2);
            return;
        }
        else return;
           
    }
}
