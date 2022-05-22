package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import reflection.ReflectionHelper;

import java.util.logging.Logger;

public class SaxHandler extends DefaultHandler {
    private static final Logger LOG = Logger.getLogger(SaxHandler.class.getName());
    private static final String CLASS_NAME = "class";
    private String element = null;
    private Object object = null;

    @Override
    public void startDocument() throws SAXException {
        LOG.info("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        LOG.info("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (!qName.equals(CLASS_NAME)) {
            element = qName;
        } else {
            String className = attributes.getValue(0);
            LOG.info("Class name: " + className);
            object = ReflectionHelper.createInstance(className);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element != null) {
            String value = new String(ch, start, length);
            LOG.info(element + " = " + value);
            ReflectionHelper.setFieldValue(object, element, value);
        }
    }

    public Object getObject() {
        return object;
    }
}
