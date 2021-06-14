package io.model.system;

import io.gui.Main;

public class Pracownik 
{
    private int id;
    private String imie;
    private String nazwisko;
    private Adres adres;
    private Kontakt kontakt_prywatny;
    private Kontakt kontakt_sluzbowy;
    private int id_karty;
    private Stanowisko stanowisko;

    public Pracownik(int id, String imie, String nazwisko, Adres adres, Kontakt kontakt_prywatny, Kontakt kontakt_sluzbowy, int id_karty) 
    {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.kontakt_prywatny = kontakt_prywatny;
        this.kontakt_sluzbowy = kontakt_sluzbowy;
        this.id_karty = id_karty;
        
        stanowisko = null;
    }
    
    public boolean update(Pracownik nowy)
    {
        this.imie = nowy.getImie();
        this.nazwisko = nowy.getNazwisko();
        this.adres = nowy.getAdres();
        this.kontakt_prywatny = nowy.getKontaktPrywatny();
        this.kontakt_sluzbowy = nowy.getKontaktSluzbowy();
        
        return true;
    }

    public void setStanowisko(Stanowisko stanowisko)
    {
        this.stanowisko = stanowisko;
    }
    
    public Stanowisko getStanowisko()
    {
        return this.stanowisko;
    }
    
    public int getId() 
    {
        return id;
    }

    public String getImie() 
    {
        return imie;
    }

    public String getNazwisko() 
    {
        return nazwisko;
    }

    public Adres getAdres() 
    {
        return adres;
    }

    public Kontakt getKontaktPrywatny() 
    {
        return kontakt_prywatny;
    }

    public Kontakt getKontaktSluzbowy() 
    {
        return kontakt_sluzbowy;
    }

    public int getKarta() 
    {
        return id_karty;
    }

    public void setKarta(int karta) 
    {
         id_karty = karta;
    }
    
    public String toString()
    {
        String result = "";
        
        result += imie + " " + nazwisko;
        
        return result;
    }
    
    
    /// static
    static private int id_counter = 0;
    static public void init()
    {
        id_counter = Main.manager_pracownikow.getMaxID() + 1;
    }
}
