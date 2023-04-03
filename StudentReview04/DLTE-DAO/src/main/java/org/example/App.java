package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DAOoperations daOoperations=new DAOoperations();
        System.out.println(daOoperations.authenticate("surya","boss07"));
        System.out.println(daOoperations.fetch());
    }
}
