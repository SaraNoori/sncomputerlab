package edu.francistuttle;
import java.util.ArrayList;

public class Computer {
    private String id;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    private String manufacturer;
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    private String year;
    public String getYear() { return year; }
    public void setYear(String year) {this.year = year; }

    private String processor;
    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    private ArrayList<Monitor> monitorList;

    public Computer()
    {
        id = "null";
        manufacturer = "null";
        year = "null";
        processor = "null";
        monitorList = new ArrayList<Monitor>();
    }

    public Computer(String id, String manufacturer, String year, String processor)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.year = year;
        this.processor = processor;
        monitorList = new ArrayList<Monitor>();
    }

    public void addMonitor(Monitor monitor)
    {
        monitorList.add(monitor);
    }

    public String toString()
    {
        String result = "Computer " + this.id;
        result += "\n\tManufacturer: " + manufacturer;
        result += "\n\tYear: " + year;
        result += "\n\tProcessor: " + processor;

        if (monitorList.size() != 0)
        {
            // i would call the toString for monitor, but I wrote it to also be standalone and I didn't want to change the
            // original toString to have double indents and stuff.
            for (int i = 0; i < monitorList.size(); i++)
            {
                result += "\n\tMonitor " + monitorList.get(i).getId();
                result += "\n\t\tManufacturer: " + monitorList.get(i).getManufacturer();
                result += "\n\t\tResolution: " + monitorList.get(i).getResolution();
            }
        }

        return result;
    }

    

}
