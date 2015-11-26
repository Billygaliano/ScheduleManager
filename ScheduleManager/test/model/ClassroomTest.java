/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aitorpagan
 */
public class ClassroomTest {
   
    
    public ClassroomTest() {
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
     * Test of toString method, of class Classroom.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Classroom instance = new Classroom();
        String expResult = "Aula{" + "id_classroom=" + 0 + ", name=" + null + ", type=" + null + ", capacity=" + 0 + ", building=" + null + ", schedules=" + null + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId_classroom method, of class Classroom.
     */
    @Test
    public void testGetId_classroom() {
        System.out.println("getId_classroom");
        Classroom instance = new Classroom();
        int expResult = 0;
        int result = instance.getId_classroom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_classroom method, of class Classroom.
     */
    @Test
    public void testSetId_classroom() {
        System.out.println("setId_classroom");
        int id_classroom = 0;
        Classroom instance = new Classroom();
        instance.setId_classroom(id_classroom);
        int expResult = instance.getId_classroom();
        assertEquals(expResult,id_classroom);
        
    }

    /**
     * Test of getName method, of class Classroom.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Classroom instance = new Classroom();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Classroom.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Classroom instance = new Classroom();
        instance.setName(name);
        String expResult = instance.getName();
        assertEquals(expResult,name);
    }

    /**
     * Test of getType method, of class Classroom.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Classroom instance = new Classroom();
        String expResult = null;
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Classroom.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Classroom instance = new Classroom();
        instance.setType(type);
        String expResult = instance.getType();
        assertEquals(expResult, type);
    }

    /**
     * Test of getCapacity method, of class Classroom.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Classroom instance = new Classroom();
        int expResult = 0;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacity method, of class Classroom.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 0;
        Classroom instance = new Classroom();
        instance.setCapacity(capacity);
        int expResult = instance.getCapacity();
        assertEquals(expResult, capacity);
        
    }

    /**
     * Test of getBuilding method, of class Classroom.
     */
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        Classroom instance = new Classroom();
        String expResult = null;
        String result = instance.getBuilding();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBuilding method, of class Classroom.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        String building = "";
        Classroom instance = new Classroom();
        instance.setBuilding(building);
        String expResult = instance.getBuilding();
        assertEquals(expResult,building);
    }

    /**
     * Test of getSchedules method, of class Classroom.
     */
    @Test
    public void testGetSchedules() {
        System.out.println("getSchedules");
        Classroom instance = new Classroom();
        List<Schedule> expResult = null;
        List<Schedule> result = instance.getSchedules();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSchedules method, of class Classroom.
     */
    @Test
    public void testSetSchedules() {
        System.out.println("setSchedules");
        Schedule sch = new Schedule();
        ArrayList<Schedule> schedules = new ArrayList();
        System.out.println("Aquí estoy");
        schedules.add(sch);
        Classroom instance = new Classroom();
        instance.setSchedules(schedules);
        List<Schedule> expResult = instance.getSchedules();
        System.out.println(expResult);
        System.out.println(schedules);
        assertTrue(expResult.equals(schedules));
    }

    /**
     * Test of equals method, of class Classroom.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Classroom clas = null;
        Classroom instance = new Classroom();
        boolean expResult = false;
        boolean result = instance.equals(clas);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnClassroomById method, of class Classroom.
     */
    @Test
    public void testReturnClassroomById() {
        System.out.println("returnClassroomById");
        int idClassroom = 0;
        Classroom instance = new Classroom();
        Classroom expResult = null;
        Classroom result = instance.returnClassroomById(idClassroom);
        assertFalse(result.equals(expResult));
    }
    
}
