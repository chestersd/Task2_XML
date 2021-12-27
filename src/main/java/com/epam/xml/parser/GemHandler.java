package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.epam.xml.entity.Gem;
import com.epam.xml.parser.Sax;

import java.util.ArrayList;
import java.util.List;

public class GemHandler extends DefaultHandler {

    public static final String TAG_ID_MAIN = "id";
    public static final String TAG_NAME_MAIN = "name";
    public static final String TAG_NAME_ORIGIN = "origin";
    public static final String TAG_NAME_PRECIOUSNESS = "preciousness";
    public static final String TAG_NAME_SYNTHESIZED = "synthesized";

    private String name;
    private int id;

    Gem gem = new Gem();
    List<Gem> gemList = new ArrayList<>();
    private String currentTagName;
    private boolean isGem = false;
    private boolean isElement = false;

    public Gem getGem(){
        return gem;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        gem.setGem(gemList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        currentTagName = qName;
        if (currentTagName.equals(TAG_NAME_MAIN)) {
            isGem = true;
        } else if (currentTagName.equals(TAG_NAME_MAIN)) {
            isElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (currentTagName != null) {
            if (currentTagName.equals(TAG_NAME_MAIN))
            isGem = false;
        } else  if (currentTagName.equals(TAG_ID_MAIN)){
            isElement = false;

            Gem gem = new Gem(name, id);
            gemList.add(gem);
        }

            currentTagName = null;
    }
    @Override
    public void characters(char[] chars, int start, int length) throws SAXException{
        if (currentTagName == null){
            return;
        }

        if (!isGem && currentTagName.equals(TAG_NAME_MAIN)){
            gem.setName(new String(chars, start, length));
        }

        if (isGem && isElement) {

            if (currentTagName.equals(TAG_NAME_MAIN)) {
                name = new String(chars, start, length);

            } else if (currentTagName.equals(TAG_ID_MAIN)) {
                id = Integer.valueOf(new String(chars, start, length));
            }
        }
    }
}
