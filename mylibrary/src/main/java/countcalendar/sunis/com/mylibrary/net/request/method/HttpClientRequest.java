package countcalendar.sunis.com.mylibrary.net.request.method;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

/**
 * Created by Sunis on 2016/4/20.
 */
public class HttpClientRequest extends BaseNetFramework {
    @Override
    protected String get(RequestOptions requestOptions) {
        String result = "";
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(requestOptions.getRequestUrl());

        try {
            HttpResponse response = httpClient.execute(httpGet);
            result = response.getEntity().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected String post(RequestOptions requestOptions, String params, List<NameValuePair> params2) {
        String result = "";

        HttpPost httpPost = new HttpPost(requestOptions.getRequestUrl());


        try {
            HttpEntity entity;
            entity = new UrlEncodedFormEntity(params2, "utf-8");
            httpPost.setEntity(entity);
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = null;
            try {
                response = httpClient.execute(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = response.getEntity().toString();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected String upload(RequestOptions requestOptions) {
        return null;
    }
}
