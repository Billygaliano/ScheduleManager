/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import junit.framework.Assert;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getDni method, of class User.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        User instance = new User();
        String expResult = null;
        String result = instance.getDni();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getPass method, of class User.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        User instance = new User();
        String expResult = null;
        String result = instance.getPass();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSurname method, of class User.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        User instance = new User();
        String expResult = null;
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User();
        String expResult = null;
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthdate method, of class User.
     */
    @Test
    public void testGetBirthdate() {
        System.out.println("getBirthdate");
        User instance = new User();
        Date expResult = null;
        Date result = instance.getBirthdate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class User.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        User instance = new User();
        String expResult = null;
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubjects method, of class User.
     */
    @Test
    public void testGetSubjects() {
        System.out.println("getSubjects");
        User instance = new User();
        List<Subject> expResult = null;
        List<Subject> result = instance.getSubjects();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDni method, of class User.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        User instance = new User();
        instance.setDni(dni);
    }

    /**
     * Test of setPass method, of class User.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "";
        User instance = new User();
        instance.setPass(pass);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);
    }

    /**
     * Test of setSurname method, of class User.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "";
        User instance = new User();
        instance.setSurname(surname);
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        User instance = new User();
        instance.setRole(role);
    }

    /**
     * Test of setBirthdate method, of class User.
     */
    @Test
    public void testSetBirthdate() {
        System.out.println("setBirthdate");
        Date birthdate = null;
        User instance = new User();
        instance.setBirthdate(birthdate);
    }

    /**
     * Test of setAddress method, of class User.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        User instance = new User();
        instance.setAddress(address);
    }

    /**
     * Test of setSubjects method, of class User.
     */
    @Test
    public void testSetSubjects() {
        System.out.println("setSubjects");
        List<Subject> subjects = null;
        User instance = new User();
        instance.setSubjects(subjects);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertFalse(expResult.equals(result));
    }
    
    @Test
    public void testEquals(){
        System.out.println("Equals");
        User instance = new User();
        instance.setDni("");
        //User instance2 = new User();
        assertFalse(instance.equals(this));
    }
    
    @Test
    public void testreturnStartSection(){
        System.out.println("returnStartSection");
        User instance = new User();
        String dni = null;
        String pass = null;
        boolean result = instance.returnStartSession(dni, pass);
        boolean expResult = false;
        assertEquals(result,expResult);
    }
    
    @Test
    public void testreturnUserSection(){
        System.out.println("returnUserSection");
        User instance = new User();
        User expResult = instance.returnUserSession(null, null);
        assertTrue(expResult.equals(instance));
    }
    
    @Test
    public void testreturnUserSectionDAO(){
        System.out.println("JUnit conexion base de datos");
        User instance = new User();
        String expResult = "Aitor";
        instance = instance.returnUserSession("78970910L", "aitor");
        assertEquals(expResult,instance.getName());
    }
    
    
}
