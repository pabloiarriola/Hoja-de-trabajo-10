/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hojadetrabajo10.Floyd;
import hojadetrabajo10.GraphMatrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Sosa
 * @author Pablo Arriola
 */
public class GraphMatrixTest {
    
    public GraphMatrixTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class GraphMatrix.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
       Floyd matriz = new Floyd();
        
        matriz.interfaz.add("Guatemala");
        
    }

    /**
     * Test of addEdge method, of class GraphMatrix.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
         Floyd matriz = new Floyd();
        
        matriz.interfaz.addEdge("Guatemala","Peten","50");
    }
    
    /**
     * Test of get method, of class GraphMatrix.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Floyd matriz = new Floyd();
        
        matriz.interfaz.add("Guatemala");
        matriz.interfaz.add("Peten");
        matriz.interfaz.get(1); 
    }

   
    
}
