/*
 using the library json.simple which provides for easier maniuplation of the JSON data from the AccuWeather API
 Prior to compiling and running this code make sure that you have added the json-simple-1.1.1.jar to your CLASSPATH
 These libraries can be found here: https://github.com/fangyidong/json-simple
*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


//including all other relevant libraries required for this project
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import java.time.Instant;

import java.util.Scanner;


public class WeatherData {
    
    public static void main (String [] args)throws FileNotFoundException, IOException{
        //initializing the scanner class that will prompt the user for the zip code from which they would like weather data  
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a zip code: ");  
        //the constant that is the zip code that the user enters, and that gets passed into the methods
        final String ZIP_CODE = userInput.next();
        userInput.close();
        mainLogic(ZIP_CODE);



    }

/*
 * Prior to running any of this code, ensure that you have properly adjusted
 * the file paths. They are currently set up for my computer. If they're not
 * adjusted correctly, it will throw exceptions. 
 */
    public static void mainLogic(String zipCode) throws FileNotFoundException, IOException{
        //this is the main logic method that will guide the rest of all the methods
        boolean check = new File("/Users/enodynowski/Desktop/caching", zipCode + ".txt").exists();
        //first check if the file already exists, which would mean a user has already requested weather data for this specific address
        if(check && (getFileAge (zipCode) <= (8.64 * Math.pow(10, 7)))){
            //then check if the file is greater than 24hr old, in which case you would want to pull new data
            System.out.println("Reading data from cache...");
            readFromFile(zipCode);
          //assuming the above statements are false, pull the data from the API. This way I can reduce the total API calls.       
            }else{
            //if the file already exists, and is older than 24hr, delete the file, so tha getForecastData() writes a new one as opposed to writing
            //more onto the one that is too old
            if(check){
                new File("/Users/enodynowski/Desktop/caching", zipCode + ".txt").delete();
                
            }
            getLocationCode(zipCode);
        }
    }

        
    //this method will read the data directly from a file that is written at the bottom of getForecastData, if it's called
    public static void readFromFile(String zipCode) throws FileNotFoundException{
        try{
            Scanner JSONinput = new Scanner(new File ("/Users/enodynowski/Desktop/caching/" + (zipCode  + ".txt")));
            String localJSONinput = "";
            while (JSONinput.hasNext()){
                localJSONinput += JSONinput.next();
            }
            JSONParser parser = new JSONParser();
            JSONObject data_obj = (JSONObject) parser.parse(localJSONinput);
            JSONArray arr = (JSONArray) data_obj.get("DailyForecasts");
            JSONObject dayForecast = null;
                for (int i = 0; i < arr.size(); i++){
                    dayForecast = (JSONObject) arr.get(i);
                    //parsing through the nested JSON objects that are returned from the API to retrieve the Temperature Data
                    JSONObject temp = (JSONObject) dayForecast.get("Temperature");
                    JSONObject maximum = (JSONObject) temp.get("Maximum");
                    JSONObject minimum = (JSONObject) temp.get("Minimum");
                    
                    //fetching data for precipitation type and intensity retrieving the precipitation Data and the date
                    JSONObject day = (JSONObject) dayForecast.get("Day");
                    boolean dayPrecip = (boolean) day.get("HasPrecipitation");

                    //creating strings of the precipitation data and the date
                    String dateShort = (String) dayForecast.get("Date"); 
                    String dayPrecipIntensity = (String) day.get("PrecipitationIntensity");
                    String dayPrecipType = (String) day.get("PrecipitationType");
                    
                    //calling the method that will format and output and format the data
                    outputFormatting(dateShort, dayPrecipIntensity, dayPrecipType, dayPrecip, maximum, minimum, day);
                    

                    }
                    System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    
    //this method will fetch the location code for a provided zip code and return it as a string
    public  static void getLocationCode(String zipCode) {
        //I put it all in a try/catch just in case it throws any exceptions due to response codes
        
        try{
            Scanner URLinput = new Scanner (new File("/Users/enodynowski/Desktop/URL.txt"));
            String apiKey = "";
            while (URLinput.hasNext()){
                apiKey+=URLinput.next();
            }
            //this is the string for the URL that gets cast to the URL class in java
            String locationURLString1 = "http://dataservice.accuweather.com/locations/v1/postalcodes/search?apikey="+ apiKey + "&q=" + zipCode + "&language=en-us&details=false";

            //initializing and connecting to the URL
            URL locationURL = new URL (locationURLString1);
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
                getForecastData(zipCode, locationKey);

            }

        //a final catch clause in case the above code throws an exception, as well as a string that can be returned.     
        } catch (Exception e){
             
            e.printStackTrace();
            
        }
    }
        
   
    
    //this method will use the location code from the above method and use it to fetch the weather data from above 
    public static void getForecastData (String zipCode, String locationKey){ 
 
        try{
            Scanner URLinput = new Scanner (new File("/Users/enodynowski/Desktop/URL.txt"));
            String apiKey = "";
            while (URLinput.hasNext()){
                apiKey+=URLinput.next();
            }
            //I used the AccuWeather API that provides lots of 5 day forecast weather data 
            //initializing the URL of the API, opening a connection, and sending the HTTP GET request
            String weatherURLString = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationKey + "?apikey=" + apiKey + "&language=en-us&details=false&metric=false";
            
            URL weatherUrl = new URL (weatherURLString);
            HttpURLConnection conn = (HttpURLConnection) weatherUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            //throwing a runtime exception if the response code from the HTTP webpage is anything other than 200
            if (responseCode != 200){
                throw new RuntimeException ("HttpResponseCode: " + responseCode);
            } else {
                System.out.println("Fetching Data from API...");
                String inline = "";
                //creating a scanner object that will read from the URL in the same way that scanner would read from a file
                Scanner scanner = new Scanner(weatherUrl.openStream());

                //turning the JSON data from the URL into a string
                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                scanner.close();
                PrintStream cache = new PrintStream(new File ("/Users/enodynowski/Desktop/caching/", (zipCode + ".txt")));
                cache.print(inline);
                readFromFile(zipCode);
            }
                System.out.println();
                
        }   
        
        //this will catch all exceptions that get thrown, and provide a stack trace to where it was thrown
        catch (Exception e){
            e.printStackTrace();
        }


    } 
    

    //this method will format the output such that it looks nice when the user sees it in the console
    public static void outputFormatting(String dateShort, String dayPrecipIntensity, String dayPrecipType, boolean dayPrecip, JSONObject maximum, JSONObject minimum, JSONObject day){
        System.out.print("|          " + dateShort.substring(0,10) + "          |");
        System.out.println();
        System.out.println("  " + day.get("IconPhrase"));

        System.out.println("  High          " + maximum.get("Value") );
        System.out.println("  Low           " + minimum.get("Value"));
        
        //if there will be precipitation, this will print the type and intensity of it. Otherwise prints that there will not be any
        if(dayPrecip){
            
            System.out.println("  Precip        " + dayPrecipIntensity+ " " + dayPrecipType);

        } else {
            System.out.println("  Precip        none");
        }
        System.out.println();

    }
    //this method will determine the age of the file in milliseconds since the epoch date, then determine the current time in milliseconds since the epoch date
    //and return the difference in milliseconds, to be used in the mainLogic() method. 
    public static long getFileAge(String zipCode) throws IOException{
       
        String fileName = "/Users/enodynowski/Desktop/caching/" + zipCode + ".txt";
        Instant currentInstant = Instant.now();
        Path file = Paths.get(fileName);
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        long fileAgeMillis = attr.creationTime().toMillis();
        long currentTimeMillis = currentInstant.toEpochMilli();
        long milliDifference = currentTimeMillis - fileAgeMillis;


        return milliDifference;
            

    }

}