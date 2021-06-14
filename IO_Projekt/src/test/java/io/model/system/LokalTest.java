package io.model.system;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LokalTest {
    
    public LokalTest() {
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
        
        Lokal instance = new Lokal("L1", 0, 0, "L1A");
        String expResult = "L1";
        String result = instance.getNazwa();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        
        Lokal instance = new Lokal("L1", 0, 0, "L1A");
        int expResult = 0;
        int result = instance.getPosX();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        
        Lokal instance = new Lokal("L1", 0, 0, "L1A");
        int expResult = 0;
        int result = instance.getPosY();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWymaganeUprawnienia() {
        System.out.println("getWymaganeUprawnienia");
        
        Lokal instance = new Lokal("L1", 0, 0, "L1A");
        String expResult = "L1A";
        String result = instance.getWymaganeUprawnienia();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testMaDostep() {
        
        System.out.println("maDostep");
        System.out.println("Test ten dziala jedynie w godzinach 8:00 do 22:00");
        
        Karta karta = new Karta(0, new Uprawnienia("L1A", "08:00:00", "22:00:00"), true);
        Lokal l1 = new Lokal("L1", 0, 0, "L1A");
        Lokal l2 = new Lokal("L2", 0, 0, "L2A");
        
        assertEquals(l1.maDostep(karta), true);
        assertEquals(l2.maDostep(karta), false);
        
        karta.getPosiadaneUprawiniena().setGodzinaRozpoczecia("21:59:59");
        assertEquals(l1.maDostep(karta), false);
        
        karta.getPosiadaneUprawiniena().setGodzinaRozpoczecia("08:00:00");
        karta.getPosiadaneUprawiniena().setGodzinaZakonczenia("08:00:01");
        assertEquals(l1.maDostep(karta), false);
        
    }
    
}
