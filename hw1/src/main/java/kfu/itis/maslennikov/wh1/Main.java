package kfu.itis.maslennikov.wh1;

import kfu.itis.maslennikov.wh1.http.HttpClientImpl;

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


        System.out.println(httpClient.get("https://webhook.site/384c2fcc-fa2b-4d4b-9ebe-d97af4ac4558", headers, params));
        System.out.println(httpClient.post("https://webhook.site/384c2fcc-fa2b-4d4b-9ebe-d97af4ac4558", headers, data));

    }
}
