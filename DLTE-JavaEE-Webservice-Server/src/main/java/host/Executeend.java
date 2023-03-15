package host;



import javax.xml.ws.Endpoint;

public class Executeend {
    private static String url="http://localhost:8082/crudl";
    public static void main(String[] args) {
        Operations listofcards=new Operations();
        System.out.println("Webservice is running on "+url);
        Endpoint.publish(url,listofcards);
    }
}
