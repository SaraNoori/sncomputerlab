package edu.francistuttle;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class ComputerLab 
{

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


    public ArrayList<Computer> parse(String pathName) throws Exception
    {
        ArrayList<Computer> result = new ArrayList<Computer>();

        Document doc = readXMLFromFile(pathName);

        NodeList nList = doc.getElementsByTagName("computer");

        // for each computer in the list:
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

                        // fill monitors and add to computer
                        Monitor monit = new Monitor();
                        monit.setId(monitElement.getAttribute("id"));
                        monit.setManufacturer(monitElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                        monit.setResolution(monitElement.getElementsByTagName("resolution").item(0).getTextContent());

                        comp.addMonitor(monit);
                    }
                }
                result.add(comp);
            }
        }

        return result;
    }
    
}
