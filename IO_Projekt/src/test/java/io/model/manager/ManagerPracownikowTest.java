/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.model.manager;

import io.model.system.Adres;
import io.model.system.Kontakt;
import io.model.system.Pracownik;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mateusz
 */
public class ManagerPracownikowTest {
    
    public ManagerPracownikowTest() {
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

    /*@Test
    public void testSomeMethod() {
        ManagerPracownikow rp = new ManagerPracownikow();
        
        Pracownik newPracownik = new Pracownik(0, "imie", "nazwisko", 
                new Adres("ASD", "ASD", "ASD", "ASD"), 
                new Kontakt("priv_email@com", "123456789"), 
                new Kontakt("publ_email@com", "123406789"), 0);
        
        rp.register(newPracownik);
        
        assertEquals(rp.count(), 1);
        assertEquals(rp.get(0), newPracownik);
    }*/
    
}
