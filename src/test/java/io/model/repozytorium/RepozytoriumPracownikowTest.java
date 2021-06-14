package io.model.repozytorium;

import io.model.system.Adres;
import io.model.system.Kontakt;
import io.model.system.Pracownik;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepozytoriumPracownikowTest {
    
    public RepozytoriumPracownikowTest() {
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
    public void testSomeMethod() {
        RepozytoriumPracownikow rp = new RepozytoriumPracownikow();
        
        Pracownik newPracownik = new Pracownik(0, "imie", "nazwisko", 
                new Adres("ASD", "ASD", "ASD", "ASD"), 
                new Kontakt("priv_email@com", "123456789"), 
                new Kontakt("publ_email@com", "123406789"), 0);
        
        rp.add(newPracownik);
        
        assertEquals(rp.size(), 1);
    }
    
}
