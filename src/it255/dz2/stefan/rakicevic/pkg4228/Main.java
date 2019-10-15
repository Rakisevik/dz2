package it255.dz2.stefan.rakicevic.pkg4228;


import com.google.gson.Gson;
import static com.google.gson.internal.bind.TypeAdapters.URL;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

    public class Main {
     
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            
            Get();
            GetUser("3");
            Post();
        }
     
        public static void Post(){
                User u = new User();
    u.setEmail("stefan.rakicevic.4228@metropolitan.ac.rs");
    u.setEmailConfirmationCode("123");
    u.setFullName("Stefan Rakicevic");
    u.setPassword("Rakisevik");
    try {       
        URL url = new URL("http://89.216.56.107:8080/restfull/rest/users");         
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();      
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");  
       if (conn.getResponseCode() != 200)  {        
            throw new RuntimeException("Greška : HTTP error: " +conn.getResponseCode());        
        }       
        PrintWriter pw = new PrintWriter(conn.getOutputStream());
        pw.print(new Gson().toJson(u));
        pw.close();
        pw.flush();
                
        BufferedReader br = new BufferedReader(new InputStreamReader(           
        (conn.getInputStream())));          
        String output;                      
        while ((output = br.readLine()) != null) {          
            System.out.println(output);         
        }       
        conn.disconnect();        
    } catch (MalformedURLException e) {         
        e.printStackTrace();      
    } catch (IOException e) {       
        e.printStackTrace();      
    }


        }
        public static void Get(){
                try {       
        URL url = new URL("http://89.216.56.107:8080/restfull/rest/users");         
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();      
        conn.setRequestMethod("GET");       
        conn.setRequestProperty("Accept", "application/json");          
        if (conn.getResponseCode() != 200) {            
            throw new RuntimeException("Failed : HTTP error code : "    
                    + conn.getResponseCode());      
        }       
        
        BufferedReader br = new BufferedReader(new InputStreamReader(           
        (conn.getInputStream())));          
        String output;  
        while ((output = br.readLine()) != null) {          
            System.out.println(output);         
        }       
        conn.disconnect();        
    } catch (MalformedURLException e) {         
        e.printStackTrace();      
    } catch (IOException e) {       
        e.printStackTrace();      
    }


        }
        public static void GetUser(String id){
            try {       
            URL url = new URL("http://89.216.56.107:8080/restfull/rest/users/"+id);         
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();      
            conn.setRequestMethod("GET");       
            conn.setRequestProperty("Accept", "application/json");          
            if (conn.getResponseCode() != 200) {            
                throw new RuntimeException("Failed : HTTP error code : "                    
                        + conn.getResponseCode());      
            }       
            
            BufferedReader br = new BufferedReader(new InputStreamReader(           
            (conn.getInputStream())));          
            String output;      
            System.out.println("Output from Server .... \n");
                    
            while ((output = br.readLine()) != null) {          
                System.out.println(output);         
            }       
            conn.disconnect();        
        } catch (MalformedURLException e) {         
            e.printStackTrace();      
        } catch (IOException e) {       
            e.printStackTrace();      
        }           
        }
    }


