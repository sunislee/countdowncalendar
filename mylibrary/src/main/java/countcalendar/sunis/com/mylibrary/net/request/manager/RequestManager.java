package countcalendar.sunis.com.mylibrary.net.request.manager;

import java.util.concurrent.ExecutorService;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.type.BaseRequest;
import countcalendar.sunis.com.mylibrary.net.request.type.DbRequest;
import countcalendar.sunis.com.mylibrary.net.request.type.MemoryRequest;
import countcalendar.sunis.com.mylibrary.net.request.type.NetRequest;
import countcalendar.sunis.com.mylibrary.net.request.type.RequestType;

/**
 * Created by Sunis on 2016/3/30.
 */
public  class RequestManager {

    protected BaseRequest request;
    protected ExecutorService executorService;

    public RequestManager(RequestOptions requestOptions, ResponseOptions responseOptions) {

        createRequest(requestOptions,responseOptions);
    }


    /**
     * 构造请求类型
     *
     * @param requestOptions
     * @return
     */
    private void createRequest(RequestOptions requestOptions, ResponseOptions responseOptions) {
        RequestType requestType = requestOptions.getRequestType();
        int type = requestType.ordinal();
        switch (type) {
            case 0:
                request = new NetRequest(requestOptions,responseOptions);
                //net
                break;
            case 1:
                //memory
                request = new MemoryRequest(requestOptions,responseOptions);
                break;
            case 2:
                //db
                request = new DbRequest(requestOptions,responseOptions);
                break;
        }

    }

    public  void execute(){
        if (executorService!=null) {
            executorService.submit(request);
        }
    }

    public void destory() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
        }

    }
}
