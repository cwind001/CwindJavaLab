package ch12.xml;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * This program demonstrates how to use a SAX parser. The
 * program prints all hyperlinks links of an XHTML web page.
 * Usage: java SAXTest url
 *
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/3
 * Email: billchen01@163.com
 */
public class SAXTest {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String url;
        if(args.length==0){
            url = "http://www.w3c.org";
            System.out.println("Using: "+url);
        }else {
            url = args[0];
        }

        DefaultHandler handler = new DefaultHandler(){
            public void startElement(String namespaceURI, String lname, String qname, Attributes attrs){
                if(lname.equalsIgnoreCase("a")&&attrs!=null){
                    for(int i=0; i<attrs.getLength(); i++){
                        String aname = attrs.getLocalName(i);
                        if(aname.equalsIgnoreCase("href")){
                            System.out.println(attrs.getValue(i));
                        }
                    }
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser saxParser = factory.newSAXParser();
        InputStream in = new URL(url).openStream();
        saxParser.parse(in, handler);

    }
}
