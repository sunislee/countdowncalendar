package countcalendar.sunis.com.mylibrary.net.request.method;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.type.NetRequestType;
import countcalendar.sunis.com.mylibrary.net.utils.NetUtils;

/**
 * Created by Sunis on 2016/4/19.
 */
public abstract class BaseNetFramework {


    protected abstract String get(RequestOptions requestOptions);

    protected abstract String post(RequestOptions requestOptions, String params, List<NameValuePair> params2);

    protected abstract String upload(RequestOptions requestOptions);

    public String request(RequestOptions requestOptions) {
        String requestUrl = "";
        String resultString = "";

        requestUrl = makeRequestUrl(requestOptions);
        requestOptions.setRequestUrl(requestUrl);

        NetRequestType type = requestOptions.getNetRequestType();
        if (type == NetRequestType.GET) {
            resultString = get(requestOptions);

        } else if (type == NetRequestType.POST) {
            String params = makeRequestParams(requestOptions);
            List<NameValuePair> params2 = makeRequestParamsPair(requestOptions);
            resultString = post(requestOptions, params, params2);

        } else if (type == NetRequestType.UPLOAD) {
        }

        return resultString;
    }

    protected List<NameValuePair> makeRequestParamsPair(RequestOptions requestOptions) {
        List<NameValuePair> params = new ArrayList<>();
        LinkedHashMap<String, Object> listMap = NetUtils.getRequestParams(requestOptions.getRequestModel());
        for (String key : listMap.keySet()) {
            try {
                params.add(new BasicNameValuePair(key, URLDecoder.decode(String.valueOf(listMap.get(key)), "UTF-8")));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return params;
    }


    protected String makeRequestUrl(RequestOptions requestOptions) {
        String url;
        NetRequestType type = requestOptions.getNetRequestType();
        if (type == NetRequestType.GET) {
            url = requestOptions.getRequestUrl() + "?" + makeRequestParams(requestOptions);
        } else {
            url = requestOptions.getRequestUrl();

        }

        return url;
    }


    protected String makeRequestParams(RequestOptions requestOptions) {
        String params = "";
        LinkedHashMap<String, Object> listMap = NetUtils.getRequestParams(requestOptions.getRequestModel());
        for (String key : listMap.keySet()) {
            try {
                params = params + key + "=" + URLDecoder.decode(String.valueOf(listMap.get(key)), "UTF-8") + "&";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return params;
    }

}
