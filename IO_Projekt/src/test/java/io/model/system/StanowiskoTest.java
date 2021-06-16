package io.model.system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StanowiskoTest {
    
    public StanowiskoTest() {
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
    public void testGetNazwa() {
        System.out.println("getNazwa");
        
        Stanowisko instance = new Stanowisko(0, "name", 100);
        
        String expResult = "name";
        String result = instance.getNazwa();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNazwa() {
        System.out.println("setNazwa");
        
        String nazwa = "name^2";
        
        Stanowisko instance = new Stanowisko(0, "name", 100);
        instance.setNazwa(nazwa);
        
        assertEquals(instance.getNazwa(), "name^2");
    }

    @Test
    public void testGetZarobki() {
        System.out.println("getZarobki");
        
        Stanowisko instance = new Stanowisko(0, "name", 100);
        
        float expResult = 100.F;
        float result = instance.getZarobki();
        
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetZarobki() {
        System.out.println("setZarobki");
        
        float zarobki = 0.0F;
        
        Stanowisko instance = new Stanowisko(0, "name", 100);
        instance.setZarobki(zarobki);
        
        assertEquals(instance.getZarobki(), 0.0F);
        
    }
    
}
