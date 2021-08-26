import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;


import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;


public class Main {

    public static Map<String, List<NameValuePair>> getQueryParams(String URL) {
        Map<String, List<NameValuePair>> pathAndParams = new HashMap<>();
        try {
            int i = URL.indexOf("?");
            String path = URL.substring(0, i);
            pathAndParams.put(path, new URIBuilder(URL).getQueryParams());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return pathAndParams;
    }

    public static void main(String[] args) throws URISyntaxException {
        Map<String, String> results = new HashMap<String, String>();
        String URL = "https://www.google.com/search?q=sda&q=sda&oq=sda&aqs=chrome..69i57j0i512l3j46i512j0i67j0i512l3j0i67.1014j0j15&sourceid=chrome&ie=UTF-8";
        URI testURI = new URI("https://www.google.com/search?q=sda&oq=sda&aqs=chrome..69i57j0i512l3j46i512j0i67j0i512l3j0i67.1014j0j15&sourceid=chrome&ie=UTF-8");
        List<NameValuePair> queryParams = new URIBuilder(testURI).getQueryParams();
        URI rawExtras = new URI("?" + URL);
//        System.out.println(rawExtras);
//        System.out.println(queryParams);
        System.out.println(getQueryParams(URL));


    }
}