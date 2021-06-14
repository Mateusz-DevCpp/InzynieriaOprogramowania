package io.model.system;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KartaTest {
    
    public KartaTest() {
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
    public void testWyczyscHistorie() {
        System.out.println("wyczyscHistorie");
        
        Karta instance = new Karta(0, new Uprawnienia("L1A", "08:30:00", "22:30:00"), false);
        
        instance.wyczyscHistorie();
        
        assertEquals(instance.getHistoria().size(), 0);
    }


    @Test
    public void testGetId() {
        System.out.println("getId");
        
        Karta instance = new Karta(0, new Uprawnienia("L1A", "08:30:00", "22:30:00"), false);
        
        int expResult = 0;
        int result = instance.getId();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrzypisana() {
        System.out.println("isPrzypisana");
        
        Karta instance = new Karta(0, new Uprawnienia("L1A", "08:30:00", "22:30:00"), false);
        
        boolean expResult = false;
        boolean result = instance.isPrzypisana();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPrzypisana() {
        System.out.println("setPrzypisana");
        
        Karta instance = new Karta(0, new Uprawnienia("L1A", "08:30:00", "22:30:00"), false);
        
        instance.setPrzypisana(true);
        
        assertEquals(instance.isPrzypisana(), true);
    }

    @Test
    public void testGetPosiadaneUprawiniena() {
        System.out.println("getPosiadaneUprawiniena");
        
        Uprawnienia upr = new Uprawnienia("L1A", "08:30:00", "22:30:00");
        Karta instance = new Karta(0, upr, false);
        
        Uprawnienia expResult = upr;
        Uprawnienia result = instance.getPosiadaneUprawiniena();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPosiadaneUprawiniena() {
        System.out.println("setPosiadaneUprawiniena");
        
        Uprawnienia upr = new Uprawnienia("L1A", "08:30:00", "22:30:00");
        Karta instance = new Karta(0, upr, false);

        Uprawnienia upr2 = new Uprawnienia("L1AL2A", "08:30:00", "22:30:00");
        instance.setPosiadaneUprawiniena(upr2);
        
        
        assertEquals(instance.getPosiadaneUprawiniena(), upr2);
    }

}
