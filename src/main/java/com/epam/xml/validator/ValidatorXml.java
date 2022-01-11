package com.epam.xml.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ValidatorXml {
    private static final Logger LOGGER = LogManager.getLogger(ValidatorXml.class);
    private static final String RESOURCE_XSD = "gems.xsd";
    public static boolean validate(InputStream xml) {
        try {
            ClassLoader classLoader = Thread.currentThread ().getContextClassLoader ();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File (Objects.requireNonNull (classLoader.getResource (RESOURCE_XSD)).getFile ()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource (xml));
        } catch (IOException | SAXException e){
            LOGGER.error("Validator xml error", e);
            return false;
        }
        return true;
    }
}
