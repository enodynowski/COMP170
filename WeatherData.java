//using the library json.simple which provides for easier maniuplation of the JSON data from the AccuWeather API
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
public class WeatherData {
    public static void main (String [] args)throws FileNotFoundException{
        //to obfuscate the API key, i've stored the URL locally in a .txt file and created a scanner class that just reads from it. 
        Scanner input = new Scanner(new File ( "/Users/enodynowski/Desktop/URL.txt" ));
            
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a zip code: ");
        final String ZIP_CODE = userInput.next();
        getLocationCode(input, ZIP_CODE);
        userInput.close();




    }
    public  static String getLocationCode(Scanner input, String zipCode) {
        //I put it all in a try/catch just in case it throws any exceptions
        


        try{
            String locationURLString = "http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W &q=" + zipCode + "&language=en-us&details=false";
           
            URL locationURL = new URL (locationURLString);
            HttpURLConnection connect = (HttpURLConnection) locationURL.openConnection();
            connect.connect();

            int responseCode2 = connect.getResponseCode();

            if (responseCode2 != 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode2);

            } else {
                String inline = "";
                //creating a scanner object that will read from the URL in the same way that scanner would read from a file
                Scanner scanner = new Scanner(locationURL.openStream());

                //turning the JSON data from the URL into a string
                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                scanner.close();

                JSONParser parse = new JSONParser();
                JSONArray array = (JSONArray) parse.parse(inline);
                JSONObject arrayZero = (JSONObject) array.get(0);
                JSONObject parentCity = (JSONObject) arrayZero.get("ParentCity");
                String locationKey = (String) parentCity.get("Key");

                getForecastData(input,zipCode ,locationKey);


             

                return locationKey;


            }

            
        } catch (Exception e){
             
            e.printStackTrace();
            String n = "TEST";
            return n;
            
        }
    }
        
     
     
    public static void getForecastData (Scanner input, String zipCode, String locationCode){ 
        try{
            
            //I used the AccuWeather API that provides lots of 5 day forecast weather data 
            //initializing the URL of the API, opening a connection, and sending the HTTP GET request
            String weatherURLString = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationCode + "?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W&language=en-us&details=false&metric=false";
            System.out.println(weatherURLString);
            
            URL weatherUrl = new URL (weatherURLString);
            HttpURLConnection conn = (HttpURLConnection) weatherUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            //throwing a runtime exception if the response code from the HTTP webpage is anything other than 200
            if (responseCode != 200){
                throw new RuntimeException ("HttpResponseCode: " + responseCode);
            } else {
                String inline = "";
                //creating a scanner object that will read from the URL in the same way that scanner would read from a file
                Scanner scanner = new Scanner(weatherUrl.openStream());

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
