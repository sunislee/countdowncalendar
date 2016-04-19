package countcalendar.sunis.com.mylibrary.net.request.method;

import org.apache.http.NameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.type.NetRequestType;

/**
 * Created by Sunis on 2016/4/19.
 */
public class UrlConnectionRequest extends BaseNetFramework {


    @Override
    protected String get(RequestOptions requestOptions) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(requestOptions.getRequestUrl()).openConnection();
            connection.setRequestMethod(NetRequestType.GET.name());
            connection.setConnectTimeout(10 * 1000);
            connection.setReadTimeout(10 * 1000);

//            int status = connection.getResponseCode();
//            if (status == HttpStatus.SC_OK) {
//            if (status == 200) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                InputStream inputStream = connection.getInputStream();
                byte[] buffer = new byte[2048];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                inputStream.close();
                out.flush();
                out.close();

                String result = new String(out.toByteArray());
                return result;

//            }

//            return null;

//            addHeaders(connection,request.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected String post(RequestOptions requestOptions, String params,List<NameValuePair> params2) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(requestOptions.getRequestUrl()).openConnection();
            connection.setRequestMethod(NetRequestType.POST.name());
            connection.setConnectTimeout(10 * 1000);
            connection.setReadTimeout(10 * 1000);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(params.getBytes());

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            inputStream.close();
            out.flush();
            out.close();

            String result = new String(out.toByteArray());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected String upload(RequestOptions requestOptions) {
        return null;
    }
}
