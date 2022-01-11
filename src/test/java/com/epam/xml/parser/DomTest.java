package com.epam.xml.parser;

import com.epam.xml.exception.ParserCustomException;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class DomTest {
    @Test
    public void testParseShouldReturnListOfGemsWhenXmlIsValid() throws JAXBException, FileNotFoundException, ParserCustomException {
        //given
        SyntheticGem syntheticGem = new SyntheticGem("id1", "Synthetic Diamond", Preciousness.PRECIOUS, "USA by USA-Diamond Factory Inc.");
        NaturalGem naturalGem = new NaturalGem("id2", "Diamond", Preciousness.PRECIOUS, "South Africa by South Africa-Diamonds Africa LLC");
        List<Gem> expected = Arrays.asList(syntheticGem, naturalGem);
        Parser parser = new DomParserImpl();
        //when
        List<Gem> actual = parser.parse(XML_FILE_PATH);
        //then
        Assert.assertEquals(expected, actual);
    }
}
