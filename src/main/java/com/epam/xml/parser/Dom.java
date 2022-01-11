package com.epam.xml.parser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.VisualParameters;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Dom {
    private static final Logger LOGGER = LogManager.getLogger();

    private Set<Gem> gems;
    private DocumentBuilder documentBuilder;
    public void GemsDomBuilder() {
        this.gems = new HashSet<Gem>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Parser config error: " + e);
        }
    }
    public Set<Gem> getGems() {
        return gems;
    }
    public void buildSetGems(String fileName) {
        Document document = null;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList gemsList = root.getElementsByTagName("gem");
            for (int i = 0; i < gemsList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
    private Gem buildGem(Element gemElement) {
        Gem gem = new Gem();
        Integer id = Integer.parseInt(getElementTextContent(gemElement, "id"));
        gem.setId(id);
        gem.setOrigin(gemElement.getAttribute("origin"));
        gem.setName(getElementTextContent(gemElement, "name"));
        gem.setPreciousness(getElementTextContent(gemElement, "preciousness"));
        gem.setSynthesized(getElementTextContent(gemElement, "synthesized"));
        VisualParameters visualParameters= gem.getVisualParameters();
        Element visualParametersElement = (Element) gemElement.getElementsByTagName("visualParameters").item(0);
        visualParameters.setColor(getElementTextContent(visualParametersElement, "color"));
        visualParameters.setOpacity(getElementTextContent(visualParametersElement, "opacity"));
        visualParameters.setFacets(getElementTextContent(visualParametersElement, "facets"));
        visualParameters.setWeight(getElementTextContent(visualParametersElement, "weight"));
        return gem;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
