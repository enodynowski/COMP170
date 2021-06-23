/*
 using the library json.simple which provides for easier maniuplation of the JSON data from the AccuWeather API
 Prior to compiling and running this code make sure that you have added the json-simple-1.1.1.jar to your CLASSPATH
 These libraries can be found here: https://github.com/fangyidong/json-simple
*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//including all other relevant libraries required for this project
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class WeatherData {
    
    public static void main (String [] args)throws FileNotFoundException{
        //initializing the scanner class that will prompt the user for the zip code from which they would like weather data  
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a zip code: ");
        

        
        //the constant that is the zip code that the user enters, and that gets passed into the methods
        final String ZIP_CODE = userInput.next();
        getLocationCode(ZIP_CODE);
        userInput.close();



    }
    //this method will fetch the location code for a provided zip code and return it as a string
    public  static String getLocationCode(String zipCode) {
        //I put it all in a try/catch just in case it throws any exceptions due to response codes
        
        try{
            
            //this is the string for the URL that gets cast to the URL class in java
            String locationURLString = "http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W&q=" + zipCode + "&language=en-us&details=false";
           
            //initializing and connecting to the URL
            URL locationURL = new URL (locationURLString);
            HttpURLConnection connect = (HttpURLConnection) locationURL.openConnection();
            connect.setRequestMethod("GET");
            connect.connect();
            
            
            
            


            //getting the response code back from the GET request, and testing if it is 200. Otherwise throwing a runtime exception
            int responseCode2 = connect.getResponseCode();
            if (responseCode2 != 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode2);

            } else {
                
                /*
                 Beginning the main block of code that fetches the data.
                 Creating a scanner object that will read the JSON data from the URL. This is akin to the way that scanner would read from a file.
                 Additionally, I am turning the JSON data from the URL into a string, such that the JSON parser object from the JSON.simple
                 libraries can cast the data to an array 
                 */
                String inline = "";
                Scanner scanner = new Scanner(locationURL.openStream());

                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                scanner.close();

                //Here I am using the json.simple library to parse the JSON data from the API
                JSONParser parse = new JSONParser();
                //casting the data to a JSON Array
                JSONArray array = (JSONArray) parse.parse(inline);
                //fetching the object that is at index 0 in the array, because this will be the most relevant location that corresponds with the zip code
                JSONObject arrayZero = (JSONObject) array.get(0);
                /*
                 navigating through the nested JSON objects within the array to get to the specific key/value pair that contains the location code
                 that corresponds with the entered zip code 
                */
                JSONObject parentCity = (JSONObject) arrayZero.get("ParentCity");
                //Casting the value of the "Key" key to a string such that it can be returned by the method, and then called again in method below 
                String locationKey = (String) parentCity.get("Key");

                //calling the other method, that takes a parameter of the zip code entered and the location key that was identified above
                getForecastData(zipCode ,locationKey);
                return locationKey;



            }

        //a final catch clause in case the above code throws an exception, as well as a string that can be returned.     
        } catch (Exception e){
             
            e.printStackTrace();
            String n = "Exception";
            return n;
            
        }
    }
        
     
    //this method will use the location code from the above method and use it to fetch the weather data from above 
    public static void getForecastData (String zipCode, String locationKey){ 
 
        try{
            
            //I used the AccuWeather API that provides lots of 5 day forecast weather data 
            //initializing the URL of the API, opening a connection, and sending the HTTP GET request
            String weatherURLString = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationKey + "?apikey=iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W&language=en-us&details=false&metric=false";
            
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
                    
                    //fetching data for precipitation type and intensity
                    JSONObject day = (JSONObject) dayForecast.get("Day");
                    boolean dayPrecip = (boolean) day.get("HasPrecipitation");
                    String dateShort = (String) dayForecast.get("Date");

                    //if there is precipitation, print out the type and intensity 
                    if(dayPrecip){
                        String dayPrecipIntensity = (String) day.get("PrecipitationIntensity");
                        String dayPrecipType = (String) day.get("PrecipitationType");

                        System.out.println(dateShort.substring(0, 10) + ": " + day.get("IconPhrase") + " with a high of " + maximum.get("Value") + " and a low of " + minimum.get("Value"));
                        System.out.println("There will be " + dayPrecipIntensity.toLowerCase() + " " + dayPrecipType.toLowerCase());
                        System.out.println();


                    } else {
                        System.out.println(dateShort.substring(0, 10) + ": " + day.get("IconPhrase") + " with a high of " + maximum.get("Value") + " and a low of " + minimum.get("Value"));
                        System.out.println();

                    }
                }
            }
        }
        
        //this will catch all exceptions that get thrown, and provide a stack trace to where it was thrown
        catch (Exception e){
            e.printStackTrace();
        }

        //this method does not need to return anything

    }        

} 