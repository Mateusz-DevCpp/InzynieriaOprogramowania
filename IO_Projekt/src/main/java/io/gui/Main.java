package io.gui;

import io.model.NewClass;

public class Main 
{
    static public void main(String[] args)
    {
        NewClass nc = new NewClass(0);
        System.err.println(nc.model());
        Window.main(args);
    }
}
