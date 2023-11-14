package edu.francistuttle;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class ComputerLab 
{
    private ArrayList<Computer> computerList;

    public ComputerLab()
    {
        computerList = new ArrayList<Computer>();
    }

    public static Document readXMLFromFile(String fileNameWithPath) throws Exception
    {
        // document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // parse file
        Document document = builder.parse(new File(fileNameWithPath));
        
        document.getDocumentElement().normalize();

        return document;
    }

    // --- WIP ----
    public ArrayList parse(String pathName) throws Exception
    {
        ArrayList<Computer> result = new ArrayList<Computer>();

        Document doc = readXMLFromFile(pathName);
        Element root = doc.getDocumentElement();

        NodeList nList = doc.getElementsByTagName("computer");

        for (int index = 0; index < nList.getLength(); index++)
        {
            Node node = nList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element compNode = (Element) node;

                // make new computer and fill it with all data
                Computer comp = new Computer();
                comp.setId(compNode.getAttribute("id"));
                comp.setManufacturer(compNode.getElementsByTagName("manufacturer").item(0).getTextContent());
                comp.setProcessor(compNode.getElementsByTagName("processor").item(0).getTextContent());
                comp.setYear(compNode.getElementsByTagName("year").item(0).getTextContent());
                
                // make monitors and fill it with data
                NodeList monitorNodes = compNode.getElementsByTagName("monitor");
            
                // loop through monitors
                for (int i = 0; i < monitorNodes.getLength(); i++)
                {
                    Node monitNode = monitorNodes.item(i);
                    if (monitNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element monitElement = (Element) monitNode;

                        Monitor monit = new Monitor();
                        // TODO: fill monitors and add to computer
                    }
                }

            }
            // TODO: Add computer to result Array
        }

        return result;
    }
    
}
