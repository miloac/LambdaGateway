/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arem.lambagateway;

/**
 *
 * @author Milo
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import static spark.Spark.*;

public class WebServerSpark {
    public static void main(String[] args) {
        staticFileLocation("/static");
        init();
        String url = "https://4zj6dp58f8.execute-api.us-west-2.amazonaws.com/init/cuadra2?valor=";
        get("/hello", (req, res) -> {
            String resp ="";
            Integer num = Integer.parseInt(req.params("valor"));
            System.out.println(num);
            try{
            URL pagURL = new URL(url+num);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pagURL.openStream()))) {
                String inputLine = "";
                while ((inputLine = reader.readLine()) != null) {
                    resp += inputLine;
                }
                
            }catch (IOException x) {
                System.err.println(x);
            }
            }
            catch (MalformedURLException e){
                System.out.println("Error, URL mal formado");
            }
            return resp;
        });
        
    }
}