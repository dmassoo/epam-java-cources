package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;

/**
 * Read the XML.
 */
public interface Task034 {
    /**
     * Parse XML document with SAX parser.
     * @param handler sax handler
     * @param filepath path to file with xml
     * @return parsed data
     */
    Person readWithSaxParser(DefaultHandler handler, String filepath) throws ParserConfigurationException, SAXException, IOException;

    /**
     * Parse XML document with JAXB parser.
     * @param filepath path to file with xml
     * @return parsed data
     */
    Person readWithJaxbParser(String filepath);

    /**
     * Parse document with StAX parser.
     * @param streamReader stax reader
     * @return parsed data
     */
    Person readWithStaxParser(XMLStreamReader streamReader);
}
