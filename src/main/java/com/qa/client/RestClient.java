package com.qa.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    //GET Method without headers

    public CloseableHttpResponse Get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }

    //POST Method with headers

    public CloseableHttpResponse put(String url, String entityString, HashMap<String, String> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        httpPut.setEntity(new StringEntity(entityString));
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpPut.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpPut);

        return httpResponse;
    }
}
