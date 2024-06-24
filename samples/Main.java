package samples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    /**
     * @param args
     */
    private static String ordersURL =
            "http://example.com:50001/cics/services/orderFile/feed";


    public static void main(String[] args) {

        // Create the order processor object
        OrderProcessor worker = new OrderProcessor();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        NodeList nodesInOrder = null;
        try {
            db = dbf.newDocumentBuilder();
            // Make an XML doc for the ATOM XML for the Orders feed
            Document doc = db.parse(new URL(ordersURL).openStream());

            // Get a list of all entries - each one representing a new order
            NodeList list = doc.getElementsByTagName("entry");
            System.out.println("We have " + list.getLength() + " new orders\n");

            // List of fields we want from the XML order entry
            String order_number = "";     // 注文番号
            String item_id = "";          // 注文品目ID
            String description = "";      // 詳細？...あ、品目名だ
            String quantity = "";         // 数量
            String price = "";            // 価格
            String fulfilled = "";        // fulfilled?
            NodeList detailList = null;   // ...


            for (int i = 0; i < list.getLength(); i++) {
                nodesInOrder = list.item(i).getChildNodes();



                for (int p = 0; p < nodesInOrder.getLength(); p++) {
                    Node orderFields = nodesInOrder.item(p);

                    // Get the content XML node
                    if (orderFields.getNodeName().equals("content")) {

                        // Get the OrdStruc XML node
                        Node OrdStruc = orderFields.getFirstChild();

                        // Get the order_details XML node
                        Node details = OrdStruc.getFirstChild();

                        // Get all nodes in the order_details node
                        detailList = details.getChildNodes();


                        for (int n = 0; n < detailList.getLength(); n++) {

                            Node detailItem = detailList.item(n);

                            String nodeName = detailItem.getNodeName();

                            // if we have the order_number
                            if (nodeName.equals("order_number")) {
                                order_number = detailItem.getTextContent();
                                continue;
                            }

                            // if we have the item_id
                            if (nodeName.equals("item_id")) {
                                item_id = detailItem.getTextContent();
                                continue;
                            }

                            // if we have the item_desc
                            if (nodeName.equals("item_desc")) {
                                description = detailItem.getTextContent();
                                continue;
                            }

                            // if we have the item_quant
                            if (nodeName.equals("item_quant")) {
                                quantity = detailItem.getTextContent();
                                continue;
                            }

                            // if we have the item_price
                            if (nodeName.equals("item_price")) {
                                price = detailItem.getTextContent();
                                continue;
                            }

                            // if we have the fulfilled
                            if (nodeName.equals("fulfilled")) {
                                fulfilled = detailItem.getTextContent();
                                continue;
                            }

                            // There is some unrecognised XML nodes...
                            System.out
                                    .println("Unrecognised segment of XML:");
                            System.out.println(nodeName
                                    + " and the content is :"
                                    + detailItem.getTextContent());

                        }

                    }
                }

            }

            System.out.println("Order Number:" + order_number);
            System.out.println("Item ID:" + item_id);
            System.out.println("Description:" + description);
            System.out.println("Quantity:" + quantity);
            System.out.println("Item Price:" + price);
            System.out.println("Fulfilled:" + fulfilled);
            System.out.println("\n\n");


            worker.processOrder(order_number, item_id, description, Integer.valueOf(quantity),
                    price,Boolean.getBoolean(fulfilled),nodesInOrder);

        }
        catch(Exception e){

        }

    }

}
