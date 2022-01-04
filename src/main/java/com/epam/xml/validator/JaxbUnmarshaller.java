package com.epam.xml.validator;

import com.epam.xml.entity.GemsJaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnmarshaller {

    private String fileName = "gemsJaxb.xml";
    public static GemsJaxb unmarshJaxb(){
        GemsJaxb unmarshGem = fromXmlToObject(fileName);
        if (unmarshJaxb != null) {
            System.out.println(unmarshJaxb.toString());
        }
    }

    private static Student fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Student) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
