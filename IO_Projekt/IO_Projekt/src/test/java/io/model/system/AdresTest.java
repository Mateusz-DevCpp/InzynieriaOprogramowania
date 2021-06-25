package io.model.system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdresTest {
    
    public AdresTest() {
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
    public void testGetMiasto() {
        System.out.println("getMiasto");
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        String expResult = "Lodz";
        assertEquals(instance.getMiasto(), expResult);
    }

    @Test
    public void testGetUlica() {
        System.out.println("getUlica");
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        String expResult = "Nowa";
        assertEquals(instance.getUlica(), expResult);
    }

    @Test
    public void testGetMieszkanie() {
        System.out.println("getMieszkanie");
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        String expResult = "21";
        assertEquals(instance.getMieszkanie(), expResult);
    }

    @Test
    public void testGetKodPocztowy() {
        System.out.println("getKodPocztowy");
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        String expResult = "90-900";
        assertEquals(instance.getKodPocztowy(), expResult);
    }

    @Test
    public void testSetMiasto() {
        System.out.println("setMiasto");
        String miasto = "Inne";
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        instance.setMiasto(miasto);
        assertEquals(instance.getMiasto(), miasto);
    }

    @Test
    public void testSetUlica() {
        System.out.println("setUlica");
        String ulica = "Inna";
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        instance.setUlica(ulica);
        assertEquals(instance.getUlica(), ulica);
    }

    @Test
    public void testSetMieszkanie() {
        System.out.println("setMieszkanie");
        String mieszkanie = "Inne";
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        instance.setMieszkanie(mieszkanie);
        assertEquals(instance.getMieszkanie(), mieszkanie);
    }

    @Test
    public void testSetKodPocztowy() {
        System.out.println("setKodPocztowy");
        String kod_pocztowy = "Inny";
        Adres instance = new Adres("Lodz", "Nowa", "21", "90-900");
        instance.setKodPocztowy(kod_pocztowy);
        assertEquals(instance.getKodPocztowy(), kod_pocztowy);
    }
}
