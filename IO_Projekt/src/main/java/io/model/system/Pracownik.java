package io.model.system;

public class Pracownik 
{
    
    private int id;
    private String imie;
    private String nazwisko;
    private Adres adres;
    private Kontakt kontakt_prywatny;
    private Kontakt kontakt_sluzbowy;
    private int id_karty;

    public Pracownik(String imie, String nazwisko, Adres adres, Kontakt kontakt_prywatny, Kontakt kontakt_sluzbowy, int id_karty) 
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.kontakt_prywatny = kontakt_prywatny;
        this.kontakt_sluzbowy = kontakt_sluzbowy;
        this.id_karty = id_karty;
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

    public Kontakt getKontakt_prywatny() 
    {
        return kontakt_prywatny;
    }

    public Kontakt getKontakt_sluzbowy() 
    {
        return kontakt_sluzbowy;
    }

    public int getKarta() 
    {
        return id_karty;
    }
    
    
    
    /// static
    static private int id_counter = 0;
    static public void init()
    {
        // pobranie z bazy danych max id dla pracownika i przypisanie tej wartosci do id_counter;
    }
}
