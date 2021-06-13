package io.model.system;

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LokalizacjaTest {
    
    public LokalizacjaTest() {
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
    public void testGetData() {
        System.out.println("getData");
        
        Lokalizacja instance = new Lokalizacja(new Lokal("L1", 0, 0, "L1A"), false);
        Date result = instance.getData();
        
        System.out.println(result.toString());
    }

    @Test
    public void testGetLokal() {
        System.out.println("getLokal");
        
        Lokal L1 = new Lokal("L1", 0, 0, "L1A");
        Lokalizacja instance = new Lokalizacja(L1, false);
        Lokal expResult = L1;
        Lokal result = instance.getLokal();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testIsDostepPrzyznany() {
        System.out.println("isDostepPrzyznany");
        
        Lokal L1 = new Lokal("L1", 0, 0, "L1A");
        Lokalizacja instance = new Lokalizacja(L1, false);
        boolean expResult = false;
        boolean result = instance.isDostepPrzyznany();
        
        assertEquals(expResult, result);
    }
    
}
