
package samples;

// https://www.ibm.com/docs/ja/cics-ts/5.6?topic=solution-creating-order-processing-application

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/*
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
*/
import org.w3c.dom.NodeList;


public class OrderProcessor {

    private URL successUrl;
    private URL deleteOrderEntry;
    private URL failUrl;


    public OrderProcessor() {
    }

    private void writeToSuccessFile(
            String order_number,
            String item_id,
            String description,
            int quantity,
            String item_price,
            boolean fulfilled,
            NodeList detailList){
        try{
            URLConnection urlConnection;
            DataOutputStream outStream;
            DataInputStream inStream;

            //  Build request body
            String body =" <?xml version=\"1.0\" ?><entry xmlns=\"http://www.w3.org/2005/Atom \" >";
            body += "<content><OrdStruc xmlns=\"http://www.OrdStruc.com\"><order_details>:";
            body += "<order_number>"+order_number+"</order_number><item_id>"+item_id+"</item_id>";
            body += "<item_desc>"+description+"</item_desc><item_quant>"+quantity+"</item_quant>";
            body += "<item_price>"+item_price+"</item_price><fulfilled>Y</fulfilled></order_details></OrdStruc></content></entry>";

            String bodyLength = new String();
            bodyLength += body.length();
            // Create connection
            successUrl= new URL("http://example.com:50001/cics/services/goodFile/feed");
            urlConnection = successUrl.openConnection();

            ((HttpURLConnection)urlConnection).setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Content-Type", "application/atom+xml;type=entry");
            urlConnection.setRequestProperty("Host", "example.com" );

            // Create I/O streams
            outStream = new DataOutputStream(urlConnection.getOutputStream());
            // Send request
            outStream.writeBytes(body);
            outStream.flush();
            outStream.close();

            inStream = new DataInputStream(urlConnection.getInputStream());

            // Get Response
            // - For debugging purposes only!
            String buffer;
            while((buffer = inStream.readLine()) != null) {
                System.out.println(buffer);
            }

            // Close I/O streams
            inStream.close();
            outStream.close();
        }
        catch(Exception ex) {
            System.out.println("Exception cauught:\n"+ ex.toString());
        }
    }



    public void processOrder(String order_number, String item_id,
                             String description, int quantity, String item_price,
                             boolean fulfilled, NodeList detailList) {

        System.out.println("\n\n===================================");
        System.out.println("Starting to process the order");
        System.out.println("=======================================\n\n");


        //we have enough stock
        if(quantity < 100){
            //add to success file
            //with fulfilled being true
            //remove from orders file
            writeToSuccessFile(order_number,item_id,description,quantity,item_price,fulfilled,detailList);
            deleteFromOrdersFile(order_number);

        }
        //we do not have enough stock - reject the order
        else{
            //add to fail file
            writeToFailFile(order_number,item_id,description,quantity,item_price,fulfilled,detailList);
        }


        System.out.println("\n\n===================================");
        System.out.println("Processed Order");
        System.out.println("=======================================\n\n");


    }

    private void writeToFailFile(String order_number, String item_id,
                                 String description, int quantity, String item_price,
                                 boolean fulfilled, NodeList detailList) {
        // TODO Auto-generated method stub
        try{

            failUrl= new URL("http://example.com:50001/cics/services/failFile/feed");
            URLConnection urlConnection;
            DataOutputStream outStream;
            DataInputStream inStream;

            // Build request body
            String body ="<?xml version=\"1.0\" ?><entry xmlns=\"http://www.w3.org/2005/Atom\">";
            body += "<content><OrdStruc xmlns=\"http://www.OrdStruc.com\"><order_details>:";
            body += "<order_number>"+order_number+"</order_number><item_id>"+item_id+"</item_id>";
            body += "<item_desc>"+description+"</item_desc><item_quant>"+quantity+"</item_quant>";
            body += "<item_price>"+item_price+"</item_price><fulfilled>N</fulfilled></order_details></OrdStruc></content></entry>";

            String bodyLength = new String();
            bodyLength += body.length();
            // Create connection

            urlConnection = successUrl.openConnection();

            ((HttpURLConnection)urlConnection).setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Content-Type", "application/atom+xml;type=entry");
            urlConnection.setRequestProperty("Host", "example.com" );

            // Create I/O streams
            outStream = new DataOutputStream(urlConnection.getOutputStream());


            // Send request
            outStream.writeBytes(body);
            outStream.flush();
            outStream.close();

            inStream = new DataInputStream(urlConnection.getInputStream());

            // Get Response
            // - For debugging purposes only!
            String buffer;
            while((buffer = inStream.readLine()) != null) {
                System.out.println(buffer);
            }

            // Close I/O streams
            inStream.close();
            outStream.close();
        }
        catch(Exception ex) {
            System.out.println("Exception cauught:\n"+ ex.toString());
        }
    }

    private void deleteFromOrdersFile(String order_number) {
        // TODO Auto-generated method stub
        try{
            URLConnection urlConnection;
            DataOutputStream outStream;
            DataInputStream inStream;


            // Create connection
            deleteOrderEntry = new URL("http://example.com:50001/cics/services/orders/entry/"+order_number);
            urlConnection = deleteOrderEntry.openConnection();

            ((HttpURLConnection)urlConnection).setRequestMethod("DELETE");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Host", "example.com" );


            inStream = new DataInputStream(urlConnection.getInputStream());

            String buffer;
            while((buffer = inStream.readLine()) != null) {
                System.out.println(buffer);
            }

            // Close I/O streams
            inStream.close();
        }
        catch(Exception ex) {
            System.out.println("Exception cought:\n"+ ex.toString());
        }

    }
}