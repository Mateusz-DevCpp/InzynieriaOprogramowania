package io.model.repozytorium;

import io.model.system.Karta;
import java.util.ArrayList;
import java.util.List;

public class RepozytoriumKart implements Repozytorium<Karta>
{
    private List<Karta> objects;
    
    public RepozytoriumKart()
    {
        objects = new ArrayList<Karta>();
    }

    @Override
    public Karta get(int id) 
    {        
        if(id < 0 || id >= objects.size())
            return null;
        
        return objects.get(id);
    }

    @Override
    public boolean add(Karta newObject) 
    {
        if(newObject == null)
            return false;
        
        return objects.add(newObject);
    }

    @Override
    public boolean remove(Karta object) 
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
