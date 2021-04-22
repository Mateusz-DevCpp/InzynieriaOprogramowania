package io.model.logowanie;

public class Uzytkownik 
{
    private int id;
    private String login;
    private String haslo;
    
    boolean zaloguj() 
    {
        return true;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getHaslo() 
    {
        return haslo;
    }

    public void setHaslo(String haslo) 
    {
        this.haslo = haslo;
    }
    
}
