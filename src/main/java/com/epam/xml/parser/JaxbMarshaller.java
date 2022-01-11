package com.epam.xml.parser;

import com.epam.xml.entity.GemsJaxb;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbMarshaller {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void generateXml(){
        String fileName = "gemsJaxb.xml";

        GemsJaxb brilliant = new GemsJaxb(021, "Africa", "brilliant", "yes", "no");

        convertObjectToXml(brilliant, fileName);
    }

    private static void convertObjectToXml(GemsJaxb brilliant, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(JaxbMarshaller.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(brilliant, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
