//using the library json.simple which provides for easier maniuplation of the JSON data from the AccuWeather API
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class WeatherData {
    public static void main (String [] args){
        
        mainGet();

    }
    public static void mainGet(){
        
        //I put it all in a try/catch just in case it throws any exceptions
        try{
            //I used the AccuWeather API that provides lots of 5 day forecast weather data 
            //initializing the URL of the API, opening a connection, and sending the HTTP GET request
            URL url = new URL ("http://dataservice.accuweather.com/forecasts/v1/daily/5day/348308?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W&language=en-us&details=false&metric=false");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            //throwing a runtime exception if the response code from the HTTP webpage is anything other than 200
            if (responseCode != 200){
                throw new RuntimeException ("HttpResponseCode: " + responseCode);
            } else {
                String inline = "";
                //creating a scanner object that will read from the URL in the same way that scanner would read from a file
                Scanner scanner = new Scanner(url.openStream());

                //turning the JSON data from the URL into a string
                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                scanner.close();

                //using the JSON.simple library to parse the string created above into a JSON object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //creating an array with the JSON data that is within the DailyForescasts JSON key
                JSONArray arr = (JSONArray) data_obj.get("DailyForecasts");

                
                //initializing the dayForecast object, which will be updated in the following cumulative algorithm
                JSONObject dayForecast = null;
                for (int i = 0; i < arr.size(); i++){
                    dayForecast = (JSONObject) arr.get(i);
                    //parsing through the nested JSON objects that are returned from the API
                    JSONObject temp = (JSONObject) dayForecast.get("Temperature");
                    JSONObject maximum = (JSONObject) temp.get("Maximum");
                    JSONObject minimum = (JSONObject) temp.get("Minimum");
                    
                    //creating a string out of the "Date" JSON key/value pair
                    String dateShort = (String) dayForecast.get("Date");
                    
                    //printing the final output
                    System.out.println("The high for " + dateShort.substring(0,10) + " is " + maximum.get("Value"));
                    System.out.println("The low for " + dateShort.substring(0,10) + " is " + minimum.get("Value"));

                }
            }
        }
        
        //this will catch all exceptions that get thrown, and provide a stack trace to where it was thrown
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
