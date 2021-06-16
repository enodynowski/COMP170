import org.json.simple.JSONArray;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class WeatherData {
    public static void main (String [] args){

    }
    public static void mainGet(){
        try{
            //identifying the URL, opening a connection, and sending the GET request
            URL url = new URL ("http://dataservice.accuweather.com/forecasts/v1/daily/5day/348308?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W&language=en-us&details=false&metric=false HTTP/1.1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            //throwing a runtime exception if the response code is anything other than 200
            if (responseCode != 200){
                throw new RuntimeException ("HttpResponseCode: " + responseCode);
            } else {
                String inline = "";
                //this creates a scanner object that will read from the URL in the same way that scanner would read from a file
                Scanner scanner = new Scanner(url.openStream());

                //turning the JSON data from the URL into a string
                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                scanner.close();

                //this will use the JSON.simple library to parse the string created above into a JSON object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);


                JSONArray arr = (JSONArray) data_obj.get("DailyForecasts");

                for (int i = 0; i <= arr.size(); i++){
                    JSONObject new_obj = (JSONObject) arr.get(i);

                    if (new_obj.get("EpochDate").equals("1623758400")){
                        System.out.println("test" + new_obj.get("Value"));

                    }       
                    }
                }                    
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
