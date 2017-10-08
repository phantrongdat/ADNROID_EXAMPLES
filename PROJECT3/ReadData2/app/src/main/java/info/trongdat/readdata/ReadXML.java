package info.trongdat.readdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXML extends AppCompatActivity {

    DocumentBuilder documentBuilder;
    DocumentBuilderFactory builderFactory;

    XmlPullParser xmlPullParser;
    XmlPullParserFactory parserFactory;

    Button btnDom, btnSAX, btnPull;
    TextView txtData;
    final String URL = "http://ptdcloud.com/xmlproducts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_xml);
        btnDom = (Button) findViewById(R.id.btnDom);
        btnSAX = (Button) findViewById(R.id.btnSAX);
        btnPull = (Button) findViewById(R.id.btnPull);
        txtData = (TextView) findViewById(R.id.txtData);
        btnDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                domParse();
            }
        });

        btnSAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saxParse();
            }
        });

        btnPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pullParse();
            }
        });
    }

    public void domParse() {
        String data = "";
        try {
            builderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = builderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(URL);

            Element element = doc.getDocumentElement();
            NodeList list = element.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element product = (Element) node;
                    NodeList names = product.getElementsByTagName("Name");
                    String name = names.item(0).getTextContent();
                    NodeList ids = product.getElementsByTagName("Name");
                    String id = ids.item(0).getTextContent();
                    NodeList prices = product.getElementsByTagName("Name");
                    String price = prices.item(0).getTextContent();

                    data += id + "\n" + name + "\n" + price + "\n";
                }
            }
            txtData.setText("DOM\n" + data);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saxParse() {
        String data = "";

    }

    public void pullParse() {
        String data = "";

        try {
            parserFactory = XmlPullParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            xmlPullParser = parserFactory.newPullParser();


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
