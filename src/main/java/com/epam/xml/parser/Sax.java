package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import org.xml.sax.SAXException;
import com.epam.xml.entity.Gem;
import com.epam.xml.parser.GemHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Sax {

    public Gem parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHandler handler = new SAXParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
//            insert logger
            return  null;
        }
        File file = new File("fund.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return handler.getGem();
    }
}
