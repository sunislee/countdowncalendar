package countcalendar.sunis.com.mylibrary.net.request.task;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.utils.NetUtils;

/**
 * Created by Sunis on 2016/3/30.
 */
public class NetTask extends BaseTask {


    public NetTask(RequestOptions requestOptions, ResponseOptions responseOptions) {
        super(requestOptions, responseOptions);
    }

    @Override
    protected void makeRequest() {

        HttpURLConnection connection = null;
        try {
            LinkedHashMap listMap = NetUtils.getRequestParams(requestOptions.getRequestModel());
            connection = (HttpURLConnection) new URL(requestOptions.getRequestUrl()).openConnection();
            connection.setRequestMethod(requestOptions.getNetRequestType().name());
            connection.setConnectTimeout(10 * 1000);
            connection.setReadTimeout(10 * 1000);

            addHeaders(connection, requestOptions.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static void addHeaders(HttpURLConnection connection, Map<String, String> headers) {
        if (headers == null || headers.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }


    @Override
    protected void parseResponse() {

    }

    @Override
    protected void saveData() {

    }
}
