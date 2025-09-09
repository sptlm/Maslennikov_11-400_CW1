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


        System.out.println(httpClient.get("https://webhook.site/...", headers, params));
        System.out.println(httpClient.post("https://webhook.site/...", headers, data));

    }
}
