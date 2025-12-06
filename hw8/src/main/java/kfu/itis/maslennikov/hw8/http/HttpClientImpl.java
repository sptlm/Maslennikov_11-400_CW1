package kfu.itis.maslennikov.hw8.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClientImpl implements HttpClient{


    @Override
    public String get(String url, Map<String, String> headers, Map<String, String> params) {
        if (params != null){
            StringBuilder paramUrl = new StringBuilder(url + "?");
            for (String key : params.keySet()){
                paramUrl.append(URLEncoder.encode(key, StandardCharsets.UTF_8) + "=" + URLEncoder.encode(params.get(key)) + "&");
            }
            url = paramUrl.toString().substring(0,paramUrl.length() - 1);
        }
        HttpURLConnection connection = getConnection(url, "GET");

        setHeaders(connection, headers);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        String response = readResponse(connection);
        connection.disconnect();
        return response;
    }

    @Override
    public String post(String url, Map<String, String> headers, Map<String, String> data) {
        HttpURLConnection connection = getConnection(url, "POST");

        setHeaders(connection, headers);
        sendData(connection, data);
        String response = readResponse(connection);
        connection.disconnect();

        return response;
    }

    @Override
    public String put(String url, Map<String, String> headers, Map<String, String> data) {
        HttpURLConnection connection = getConnection(url, "PUT");

        setHeaders(connection, headers);
        sendData(connection, data);
        String response = readResponse(connection);
        connection.disconnect();

        return response;
    }

    @Override
    public String delete(String url, Map<String, String> headers, Map<String, String> data) {
        HttpURLConnection connection = getConnection(url, "DELETE");

        setHeaders(connection, headers);
        sendData(connection, data);
        String response = readResponse(connection);
        connection.disconnect();

        return response;
    }

    private HttpURLConnection getConnection(String url, String method) {
        try{
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod(method);
            return connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setHeaders(HttpURLConnection connection, Map<String, String> headers) {
        for (String key : headers.keySet()){
            connection.setRequestProperty(key, headers.get(key));
        }
    }

    private void sendData(HttpURLConnection connection, Map<String, String> data) {
        connection.setDoOutput(true);
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))){
            bw.write(new ObjectMapper().writeValueAsString(data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String readResponse(HttpURLConnection connection) {
        if (connection == null) {
            return null;
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
