package edu.francistuttle;

public class Monitor {
    private String id;
    public String getId() { return id; }

    private String manufacturer;
    public String getManufacturer() { return manufacturer; }

    private String resolution;
    public String getResolution() { return resolution; }

    public Monitor()
    {
        id = "null";
        manufacturer = "null";
        resolution = "null";
    }

    public Monitor(String id, String manufacturer, String resolution)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.resolution = resolution;
    }

    public String toString()
    {
        String result = "Monitor " + this.id;
        result += "\n\tManufacturer: " + manufacturer;
        result += "\n\tResolution: " + resolution;
        return result;
    }

}
