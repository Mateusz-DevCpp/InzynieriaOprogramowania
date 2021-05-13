package io.model.system;

public class Adres 
{
    private String miasto;
    private String ulica;
    private String mieszkanie;
    private String kod_pocztowy;
    
    public Adres(String miasto, String ulica, String mieszkanie, String kod_pocztowy)
    {
        this.miasto = miasto;
        this.ulica = ulica;
        this.mieszkanie = mieszkanie;
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() 
    {
        String result = "";
        
        result += "Adres:\n";
        result += "\tkod: " + kod_pocztowy + "\n";
        result += "\tmiasto: " + miasto + "\n";
        result += "\tulica: " + ulica + "\n";
        result += "\tmieszkanie: " + mieszkanie;
        
        return result;
    }

    public String getMiasto() 
    {
        return miasto;
    }

    public String getUlica() 
    {
        return ulica;
    }

    public String getMieszkanie() 
    {
        return mieszkanie;
    }

    public String getKodPocztowy() 
    {
        return kod_pocztowy;
    }

    public void setMiasto(String miasto) 
    {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) 
    {
        this.ulica = ulica;
    }

    public void setMieszkanie(String mieszkanie) 
    {
        this.mieszkanie = mieszkanie;
    }

    public void setKodPocztowy(String kod_pocztowy) 
    {
        this.kod_pocztowy = kod_pocztowy;
    }
}
