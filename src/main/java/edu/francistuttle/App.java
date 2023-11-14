package edu.francistuttle;

public class App 
{
    public static void main( String[] args )
    {
        Computer comp = new Computer("1111", "bob ross", "1999", "i9");
        Monitor mont = new Monitor("2222", "bill", "1x1");
        comp.addMonitor(mont);
        System.out.println(comp);
    }
}
