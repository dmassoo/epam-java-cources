package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task034Impl implements Task034 {
    /**
     * Parse XML document with SAX parser.
     *
     * @param handler  sax handler
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse("src/main/resources/" + filepath);
        return ((SaxHandlerImpl) handler).getPerson();
    }

    /**
     * Parse XML document with JAXB parser.
     *
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithJaxbParser(String filepath) {
        PersonImpl person = null;
        File file = new File("src/main/resources/" + filepath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(PersonImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            person = (PersonImpl) jaxbUnmarshaller.unmarshal(file);
            return person;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return person;
    }

    /**
     * Parse document with StAX parser.
     *
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = null;
        try {
            eventReader = factory.createXMLEventReader(streamReader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        Person person = null;
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        try {
            if (eventReader != null) {
                while (eventReader.hasNext()) {
                    XMLEvent xmlEvent = eventReader.nextEvent();
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();

                        if ("person".equalsIgnoreCase(startElement.getName().getLocalPart())) {
                            person = new PersonImpl();
                        }

                        Iterator<Attribute> iterator = startElement.getAttributes();

                        while (iterator.hasNext()) {
                            Attribute attribute = iterator.next();
                            QName name = attribute.getName();
                            if ("id".equalsIgnoreCase(name.getLocalPart())) {
                                assert person != null;
                                person.setId(Integer.parseInt(attribute.getValue()));
                            }
                        }

                        switch (startElement.getName().getLocalPart()) {
                            case "first-name": {
                                Characters firstNameDataEvent =
                                        (Characters) eventReader.nextEvent();
                                assert person != null;
                                person.setFirstName(firstNameDataEvent.getData());
                                break;
                            }
                            case "last-name": {
                                Characters lastNameDataEvent = (Characters) eventReader.nextEvent();
                                assert person != null;
                                person.setLastName(lastNameDataEvent.getData());
                                break;
                            }
                            case "person-phone": {
                                PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                                Characters phoneNumberDataEvent =
                                        (Characters) eventReader.nextEvent();
                                phoneNumber.setPhoneNumber(phoneNumberDataEvent.getData());
                                phoneNumbers.add(phoneNumber);
                                break;
                            }
                            default: {
                                break;
                            }
                        }

                        if (xmlEvent.isEndElement()) {
                            EndElement endElement = xmlEvent.asEndElement();
                            if ("person".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                                assert person != null;
                                person.setPhoneNumbers(phoneNumbers);
                            }
                        }
                    }

                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        assert person != null;
        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
