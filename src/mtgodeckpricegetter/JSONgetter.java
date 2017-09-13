
package mtgodeckpricegetter;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONgetter {
    
    public static String getPrice(String cardName)
    {
        
        String baseURL = "http://api.mtgowikiprice.com/api/card/M14/";
        String APIkey = "?_ef6bc55ad8f3e8da9f0287406e0e1911";
        String resultString = "";
        try {
            URL url = new URL (baseURL + "1" + APIkey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            InputStream input = conn.getInputStream();
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(new InputStreamReader(input, "UTF-8"));
            int gg = jsonObject.size();
            resultString = gg + jsonObject.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
        return resultString;
    }
    
}
