package io.gui;

import io.model.logowanie.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewClass 
{
    static public void main(String[] args) throws IOException
    {
        Uzytkownik user;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(name); 
    }
}
