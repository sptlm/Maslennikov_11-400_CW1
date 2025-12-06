package kfu.itis.maslennikov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kfu.itis.maslennikov.http.HttpClientImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HttpClientImpl httpClient = new HttpClientImpl();

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");

        HashMap<String, String> params = new HashMap<>();
        params.put("userId","1");

        HashMap<String, String> data = new HashMap<>();
        data.put("userId","1");
        data.put("aboba", "draboba");


        System.out.println("GET: " + httpClient.get("http://127.0.0.1:8080/CW1_war_exploded/hello", headers, params));
        System.out.println("POST: " + httpClient.post("http://localhost:8080/CW1_war_exploded/hello", headers, data));
        System.out.println("PUT: " + httpClient.put("http://localhost:8080/CW1_war_exploded/hello", headers, data));
        System.out.println("DELETE: " + httpClient.delete("http://localhost:8080/CW1_war_exploded/hello", headers, data));

    }
}
