package hojadetrabajo10;

import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego Sosa
 * @author Pablo Arriola
 */
public class Main {

    //private String cadenaD; 
    public static void main(String[] args)
    {
      String cadenaD = "";    
              
        Floyd matriz = new Floyd(); // Almacena la matriz de adyacencia
        matriz.caminoMasCorto(); // Algoritmo de Floyd para encontrar el camino mas corto entre todos los nodos
        int OpIngreso; // Seleccion del usuario para realizar
        int opcion; // Seleccion del usuario para la pregunta 3
        
        Scanner scan = new Scanner(System.in); //Entrada por teclado
       
           
    
        /*Menu de texto que se muestra en pantalla, donde tambien se ingresa 
        la opcion seleccionada por el usuario.
        
        Esta opcion se almacena en la variable OpIngreso. Se utiliza la opciion
        3 (Question)*/
        OpIngreso = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Encontrar la ruta mas corta entre dos ciudades\n"
                + "2. Nombre de la ciudad que esta en el centro del grafo\n"
                + "3. Modificar grafo\n4. Salir del programa",
                "Ingrese una opcion",3));
        
        
      
        
        // Realizar ciclo mientras la respuesta del usuario no sea 4
        while(OpIngreso!=4)
        {
            // Desplegar la matriz
           
            String matriz_de_adyacencia = matriz.interfaz.show2();
            JOptionPane.showMessageDialog(null, matriz_de_adyacencia,"Matriz "
                    + "de adyacencia",1);
            
            // Si la respuesta es 1, preguntar por las ciudades y desplegar resultados
            if(OpIngreso==1)
            {
                matriz.caminoMasCorto(); // Camino mas corto entre todas las ciudades
                String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese la ciudad de salida","",3);
              
                
                
                String ciudad2 = JOptionPane.showInputDialog(null,"Ingrese la ciudad de destino","",3);
            
                // Si las ciudades se encuentran en la matriz, entonces 
                //desplegar la distancia minima y la ruta completa
                if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                {
                    //System.out.println("\nLa distancia minima es: "+matriz.interfaz.getEdge(ciudad1, ciudad2)+".");
                    cadenaD =  "La distancia minima es: "+matriz.interfaz.getEdge(ciudad1, ciudad2)+".";
                    
                    if(matriz.interfaz.getEdge(ciudad1, ciudad2)!=10000)
                    {
                       
                        cadenaD = cadenaD +("\nLa ruta es: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.interfaz.getIndex(ciudad1), matriz.interfaz.getIndex(ciudad2));
                      
                        cadenaD = cadenaD + ", " + ciudad2;
                    }
                    JOptionPane.showMessageDialog(null,cadenaD);
                }
            }
            
            /*Si la respuesta es 2, desplegar la ciudad que esta en 
             * el centro de grafo*/
            else if(OpIngreso==2)
            {
                matriz.centroGrafo();
            }
            
            /*Si la respuesta es 3, preguntar cual es el cambio  realizar y 
            * ejecutarlo*/
            else if(OpIngreso==3)
            {
               
               opcion = Integer.parseInt(JOptionPane.showInputDialog(
                       "1. Hay interrupcion de trafico entre un par de ciudades\n"
                     + "2. Establecer nueva conexion"));
                /*Si la respuesta es 1, preguntar por el nombre de las ciudades
                 *y colocar un numero muy grande en la matriz de adyacencia
                 *para indicar que no hay conexion*/
                if(opcion==1)
                {
                  
                    String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese "
                            + "el nombre de la ciudad de salida",
                            "Ciudad de salida",3);
                    
                    
                    String ciudad2 = JOptionPane.showInputDialog(null,
                            "Ingrese el nombre de la ciudad de destino",
                            "Ciudad de destino",3);
                    if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                    {
                        matriz.interfaz.addEdge(ciudad1, ciudad2, 10000);
                    }
                }
                // Si la respuesta es 2, preguntar por el nombre de las ciudades y agregar nueva distancia.
                else if(opcion==2){
                   
                    String ciudad1 = JOptionPane.showInputDialog(null,"Ingrese "
                            + "el nombre de la ciudad de salida",
                            "Ciudad de salida",3);
                   
                    String ciudad2 = JOptionPane.showInputDialog(null,
                            "Ingrese el nombre de la ciudad de destino",
                            "Ciudad de destino",3);
                
                    int distancia = Integer.parseInt(JOptionPane.showInputDialog
                    (null,"Ingrese la distancia entre las ciudades",3));
                    
                    // Si las ciudades ya existen, cambiar el valor
                    if(matriz.interfaz.contains(ciudad1)&&matriz.interfaz.contains(ciudad2))
                    {
                        matriz.interfaz.addEdge(ciudad1, ciudad2, distancia);
                    }
                    // Si las ciudades no existen, agregarlas archivo la matriz
                    else
                    {
                        matriz.interfaz.add(ciudad1);
                        matriz.interfaz.add(ciudad2);
                        matriz.interfaz.addEdge(ciudad1, ciudad2, distancia);
                    }
                }
                // Recalcular las rutas mas cortas
                matriz.caminoMasCorto();
            }
       
            OpIngreso =  Integer.parseInt(JOptionPane.showInputDialog(null,"1. Buscar ruta mas corta entre "
                    + "dos ciudades\n2. Nombre de la ciudad en el centro "
                    + "del grafo\n3. Modificar grafo\n4. Finalizar programa"));
        }
        
    }
}
