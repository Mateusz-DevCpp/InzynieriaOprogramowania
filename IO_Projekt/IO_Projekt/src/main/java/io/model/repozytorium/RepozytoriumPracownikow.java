package io.model.repozytorium;

import io.model.system.Pracownik;
import java.util.ArrayList;
import java.util.List;

public class RepozytoriumPracownikow implements Repozytorium<Pracownik>
{
    private List<Pracownik> objects;
    
    public RepozytoriumPracownikow()
    {
        objects = new ArrayList<Pracownik>();
    }
    
    @Override
    public Pracownik get(int id)
    {        
        if(id < 0 || id >= objects.size())
            return null;
        
        return objects.get(id);
    }

    @Override
    public boolean add(Pracownik newObject)
    {
        if(newObject == null)
            return false;
        
        return objects.add(newObject);
    }

    @Override
    public boolean remove(Pracownik object) 
    {
        if(object == null)
            return false;
        
        return objects.remove(object);
    }

    @Override
    public String report()  
    {
        String result = "";
        for(int i=0; i<objects.size(); i++)
        {
            result += objects.get(i).toString() + "\n";
        }
        return result;
    }

    @Override
    public int size()
    {
        return objects.size();
    }
    
}
