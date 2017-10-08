package info.trongdat.practicexmljson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static info.trongdat.practicexmljson.Constants.XML_DATA;

public class XMLActivity extends AppCompatActivity {
    ArrayList<Product> products;
    ArrayAdapter<Product> adapter;
    ListView lstProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        init();
        loadData();
    }

    public void init() {
        products = new ArrayList<>();
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);
        lstProduct = (ListView) findViewById(R.id.lstProduct);
        lstProduct.setAdapter(adapter);
    }

    public void loadData() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            File dataFile = new File("file:///android_asset/" + XML_DATA);
            InputStream inputStream=getAssets().open(XML_DATA);

//            FileInputStream stream = new FileInputStream();
            Document doc = documentBuilder.parse(inputStream);

            Element element = doc.getDocumentElement();
            NodeList list = element.getChildNodes();

            Log.d("datt", "loadData: "+doc);
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element product = (Element) node;
                    NodeList names = product.getElementsByTagName("Name");
                    String name = names.item(0).getTextContent();
                    NodeList ids = product.getElementsByTagName("Id");
                    int id = Integer.parseInt(ids.item(0).getTextContent());
                    NodeList prices = product.getElementsByTagName("Price");
                    float price = Float.parseFloat(prices.item(0).getTextContent());
                    products.add(new Product(id, name, price));
                    adapter.notifyDataSetChanged();
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
