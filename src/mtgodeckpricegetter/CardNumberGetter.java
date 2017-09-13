


package mtgodeckpricegetter;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.JsonParser;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import java.io.InputStream;
import java.io.InputStreamReader;

        
public class CardNumberGetter {
    
    
    
    
    public static String getNumber(String cardname)
    {
        
        
        
        int resultint = 0;
        String fullres = "";
        String resultset = "";
        String resultnumstr = "";
        String baseURL = "https://api.magicthegathering.io/v1/cards?name=";
        try {
            URL url = new URL (baseURL + cardname);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(50000);
            conn.setConnectTimeout(50000);
            InputStream input = conn.getInputStream();
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(new InputStreamReader(input, "UTF-8"));
            fullres = jsonObject.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
        return fullres;
    }
    
    
}
