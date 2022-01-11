package com.epam.xml.validator;

import com.epam.xml.entity.GemsJaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnmarshaller {

    private String filePath = "gemsJaxb.xml";

        GemsJaxb unmarshGem = fromXmlToObject(filePath);
        if (GemsJaxb != null) {
            System.out.println(unmarshGem.toString());
        }

    private static GemsJaxb fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(GemsJaxb.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (GemsJaxb) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
