import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tes {
    public static Map<String, String> getQueryParams(String extras) {
        Map<String, String> results = new HashMap<String, String>();
        try {
            URI rawExtras = new URI("?" + extras);
            List<NameValuePair> extraList = URLEncodedUtils.parse(rawExtras, "UTF-8");
            for (NameValuePair item : extraList) {
                String name = item.getName();
                int i = 0;
                while (results.containsKey(name)) {
                    name = item.getName() + ++i;
                }
                results.put(name, item.getValue());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return results;
    }
    public static void main(String[] args) {
        System.out.println(getQueryParams("https://www.google.com/search?q=sda&q=sea&oq=sda&aqs=chrome..69i57j0i512l3j46i512j0i67j0i512l3j0i67.1014j0j15&sourceid=chrome&ie=UTF-8"));
    }
}
