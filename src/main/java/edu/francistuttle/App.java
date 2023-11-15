package edu.francistuttle;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        /* 
        Computer comp = new Computer("1111", "bob ross", "1999", "i9");
        Monitor mont = new Monitor("2222", "bill", "1x1");
        comp.addMonitor(mont);
        System.out.println(comp);
        */

        ComputerLab lab = new ComputerLab();
        String pathName = "C:/Users/saran/Documents/GitHub/sncomputerlab/src/main/java/edu/francistuttle/lab.xml";
        ArrayList<Computer> compList = lab.parse(pathName);
        for (int i = 0; i < compList.size(); i++)
        {
            System.out.println(compList.get(i));
        }
    }
}
