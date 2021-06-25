package io.model.system;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UprawnieniaTest {
    
    public UprawnieniaTest() {
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
    public void testGetPoziomDostepu() {
        System.out.println("getPoziomDostepu");
        
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        String expResult = "ACC";
        String result = instance.getPoziomDostepu();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPoziomDostepu() {
        System.out.println("setPoziomDostepu");
        
        String uprawnienia_oznaczenia = "NEW";
        
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        instance.setPoziomDostepu(uprawnienia_oznaczenia);
        
        assertEquals(instance.getPoziomDostepu(), uprawnienia_oznaczenia);
    }

    @Test
    public void testGetGodzinaRozpoczecia() {
        System.out.println("getGodzinaRozpoczecia");
        
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        LocalTime expResult = LocalTime.parse("08:20");
        LocalTime result = instance.getGodzinaRozpoczecia();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGodzinaRozpoczecia() {
        System.out.println("setGodzinaRozpoczecia");
        
        String od_godziny = "08:00";
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        instance.setGodzinaRozpoczecia(od_godziny);
        
        assertEquals(instance.getGodzinaRozpoczecia(), LocalTime.parse(od_godziny));
    }


    @Test
    public void testGetGodzinaZakonczenia() {
        System.out.println("getGodzinaZakonczenia");
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        LocalTime expResult = LocalTime.parse("10:20");
        LocalTime result = instance.getGodzinaZakonczenia();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGodzinaZakonczenia() {
        System.out.println("setGodzinaZakonczenia");
        
        String do_godziny = "21:00";
        Uprawnienia instance = new Uprawnienia("ACC", "08:20", "10:20");
        
        instance.setGodzinaZakonczenia(do_godziny);
        
        assertEquals(instance.getGodzinaZakonczenia(), LocalTime.parse(do_godziny));
    }
    
}
