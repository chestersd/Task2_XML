package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import org.junit.Assert;
import org.junit.Test;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class JaxbMarshallerTest {
    private static final String XML_FILE_PATH = "fundsTestSax.xml";

    @Test
    public void testParseShouldReturnObjectGemWhenXmlIsValid() throws JAXBException, FileNotFoundException, ParserCustomException {
        //given
        Gem testGem = new Gem(22, "Russia", "testBrilliant", "precious", "natural");
        List<Gem> expectedGem = Arrays.asList(testGem);
        JaxbMarshaller parser = new JaxbMarshaller();
        //when
        List<Gem> actualGem = parser.parse(XML_FILE_PATH);
        //then
        Assert.assertEquals(expectedGem, actualGem);
    }

}
