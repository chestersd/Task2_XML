package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Director {
    public static void main(String[] args) throws IOException, SAXException {
        Sax parser = new Sax();
        Gem gem = parser.parse();
        System.out.println(gem.toString());

    }
}
