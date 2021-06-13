package io.model.system;

import java.util.Date;

public class Wynagrodzenie 
{
    private Pracownik pracownik;
    private double wartosc_wynagrodzenia;
    private double stawka_za_nadgodziny;
    private Date data_otrzymania;
    private int ilosc_nadgodzin;

    public Wynagrodzenie(Pracownik pracownik, double wartosc_wynagrodzenia, double stawka_za_nadgodziny, int ilosc_nadgodzin) 
    {
        this.pracownik = pracownik;
        this.wartosc_wynagrodzenia = wartosc_wynagrodzenia;
        this.stawka_za_nadgodziny = stawka_za_nadgodziny;
        this.ilosc_nadgodzin = ilosc_nadgodzin;
        
        this.data_otrzymania = new Date();
    }

    public Pracownik getPracownik() 
    {
        return pracownik;
    }

    public double getWartoscWynagrodzenia() 
    {
        return wartosc_wynagrodzenia;
    }

    public double getStawkaZaNadgodziny() 
    {
        return stawka_za_nadgodziny;
    }

    public Date getDataOtrzymania() 
    {
        return data_otrzymania;
    }

    public int getIloscNadgodzin() 
    {
        return ilosc_nadgodzin;
    }
    
    public String toString()
    {
        String result = "";
        
        result += pracownik.toString();
        result += " : ";
        result += Double.toString(wartosc_wynagrodzenia);
        
        return result;
    }
}
