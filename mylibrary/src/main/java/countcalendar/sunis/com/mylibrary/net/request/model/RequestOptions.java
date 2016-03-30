package countcalendar.sunis.com.mylibrary.net.request.model;

import java.util.Map;

import countcalendar.sunis.com.mylibrary.net.request.type.NetRequestType;
import countcalendar.sunis.com.mylibrary.net.request.type.RequestType;

/**
 * Created by Sunis on 2016/3/30.
 */
public class RequestOptions {

    private boolean syncTaks;
    private RequestModel requestModel;
    private String requestUrl;
    private NetRequestType netRequestType;
    private RequestType requestType;
    private Map<String, String> headers;

    public RequestType getRequestType() {
        if (requestType == null) {
            requestType = RequestType.NET;
        }
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public boolean isSyncTaks() {
        return syncTaks;
    }

    public void setSyncTaks(boolean syncTaks) {
        this.syncTaks = syncTaks;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public NetRequestType getNetRequestType() {
        return netRequestType;
    }

    public void setNetRequestType(NetRequestType netRequestType) {
        this.netRequestType = netRequestType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public RequestModel getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(RequestModel requestModel) {
        this.requestModel = requestModel;
    }
}
