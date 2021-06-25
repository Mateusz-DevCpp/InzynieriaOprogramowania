package io.model.repozytorium;

import io.model.system.Wynagrodzenie;
import java.util.ArrayList;
import java.util.List;

public class RepozytoriumWynagrodzen implements Repozytorium<Wynagrodzenie>
{
    private List<Wynagrodzenie> objects;
    
    public RepozytoriumWynagrodzen()
    {
        objects = new ArrayList<Wynagrodzenie>();
    }
    
    @Override
    public Wynagrodzenie get(int id) 
    {        
        if(id < 0 || id >= objects.size())
            return null;
        
        return objects.get(id);
    }

    @Override
    public boolean add(Wynagrodzenie newObject) 
    {
        if(newObject == null)
            return false;
        
        return objects.add(newObject);
    }

    @Override
    public boolean remove(Wynagrodzenie object)
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