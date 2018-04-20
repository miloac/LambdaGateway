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
import static spark.Spark.*;

public class WebServerSpark {
    public static void main(String[] args) {
        String url = " https://4zj6dp58f8.execute-api.us-west-2.amazonaws.com/init";
        get("/hello", (req, res) -> "Hello World");
    }
}