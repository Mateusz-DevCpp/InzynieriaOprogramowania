package io.model.system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KontaktTest {
    
    public KontaktTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Kontakt instance = new Kontakt("email@pl.pl", "123");
        String expResult = "email@pl.pl";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNrTelefonu() {
        System.out.println("getNrTelefonu");
        Kontakt instance = new Kontakt("email@pl.pl", "123");
        String expResult = "123";
        String result = instance.getNrTelefonu();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNrTelefonu() {
        System.out.println("setNrTelefonu");
        String nr_telefonu = "321";
        Kontakt instance = new Kontakt("email@pl.pl", "123");
        instance.setNrTelefonu(nr_telefonu);
        String expResult = "321";
        String result = instance.getNrTelefonu();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email.com";
        Kontakt instance = new Kontakt("email@pl.pl", "123");
        instance.setEmail(email);
        String expResult = "email.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }
    
}
