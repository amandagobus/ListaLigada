/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testelista;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Gobus
 */
public class ListaLigadaDuplamenteTest {

    public ListaLigadaDuplamenteTest() {
    }

//    /**
//     * Test of getLast method, of class ListaLigadaDuplamente.
//     */
//    @Test
//    public void testGetLast() {
//        System.out.println("getLast");
//        ListaLigadaDuplamente instance = new ListaLigadaDuplamente();
//        Object expResult = null;
//        Object result = instance.getLast();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of add method, of class ListaLigadaDuplamente.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        String e = "a";
       // String a = "1";
        List<String> instance = new ListaLigadaDuplamente();
        boolean expResult = true;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        
        System.out.println("Amanda");
         e = "amanda";
       //  a = "amandah";
        expResult = true;
        result = instance.add(e);
        assertEquals(expResult, result);

        System.out.println("hahasdfasdflkjhglkjgpoiuertoiumnzxcnvbbvcnxzmzcnzxczx");
         e = "hahasdfasdflkjhglkjgpoiuertoiumnzxcnvbbvcnxzmzcnzxczx";
       //  a = "amandah";
        expResult = true;
        result = instance.add(e);
        assertEquals(expResult, result);
        
         System.out.println("123456789");
         e = "123456789";
       //  a = "amandah";
        expResult = true;
        result = instance.add(e);
        assertEquals(expResult, result);
        
         System.out.println("1a2b3c4d5e");
         e = "1a2b3c4d5e";
       //  a = "amandah";
        expResult = true;
        result = instance.add(e);
        assertEquals(expResult, result);
        
         System.out.println(" ");
         e = " ";
         //  a = "amandah";
        expResult = false;
        result = instance.add(e);
        assertEquals(expResult, result);
        
        
        


        
        

        
    }

    /**
     * Test of remove method, of class ListaLigadaDuplamente.
     */
    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        Object o = null;
        ListaLigadaDuplamente instance = new ListaLigadaDuplamente();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        
        
         System.out.println("remove");
         o = "BomDiaAmanda";
         expResult = true;
         result = instance.remove(o);
         assertEquals(expResult, result);

    }

    
    
}
