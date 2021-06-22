import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class WeatherDataCaching {
   public static void main(String args[]) throws FileNotFoundException{
      //Creating a JSONObject object
      JSONObject cache = new JSONObject();
      //Inserting key-value pairs into the json object
      cache.put("Zip_Code", "locationKey");
      cache.put("Date", "Date");
      cache.put("Maximum", "maximum");
      cache.put("Minimum", "minimum");
      try {
         FileWriter file = new FileWriter("output.json");
         file.write(cache.toJSONString());
         file.close();
      } catch (IOException e) {
         //Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+ cache);
   }
}