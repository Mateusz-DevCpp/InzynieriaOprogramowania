package io.model.system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracownikTest {
    
    public PracownikTest() {
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
    public void testGetId() {
        System.out.println("getId");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        int expResult = 0;
        int result = instance.getId();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetImie() {
        System.out.println("getImie");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        String expResult = "imie";
        String result = instance.getImie();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        String expResult = "nazwisko";
        String result = instance.getNazwisko();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAdres() {
        System.out.println("getAdres");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        Adres expResult = adres;
        Adres result = instance.getAdres();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetKontakt_prywatny() {
        System.out.println("getKontakt_prywatny");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        Kontakt expResult = kontakt_prywatny;
        Kontakt result = instance.getKontaktPrywatny();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetKontakt_sluzbowy() {
        System.out.println("getKontakt_sluzbowy");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        Kontakt expResult = kontakt_sluzbowy;
        Kontakt result = instance.getKontaktSluzbowy();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetKarta() {
        System.out.println("getKarta");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        int expResult = 0;
        int result = instance.getKarta();
        
        assertEquals(expResult, result);
    }
        
    @Test
    public void testSetGetStanowisko() {
        System.out.println("set_get_Stanowisko");
        
        Adres adres = new Adres("miasto", "ulica", "mieszkanie", "kod_pocztowy");
        Kontakt kontakt_prywatny = new Kontakt("email.priv", "nr_telefonu_priv");
        Kontakt kontakt_sluzbowy = new Kontakt("email.pub", "nr_telefonu_pub");
        Pracownik instance = new Pracownik(0, "imie", "nazwisko", adres, kontakt_prywatny, kontakt_sluzbowy, 0);
        
        Stanowisko stanowisko = new Stanowisko(0, "Informatyk", 5000.25f);
        instance.setStanowisko(stanowisko);
        
        assertEquals(stanowisko, instance.getStanowisko());
    }
}
