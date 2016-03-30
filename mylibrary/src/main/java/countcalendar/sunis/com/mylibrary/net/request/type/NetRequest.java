package countcalendar.sunis.com.mylibrary.net.request.type;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.task.NetTask;

/**
 * Created by Sunis on 2016/3/30.
 */
public class NetRequest extends BaseRequest {


    public NetRequest(RequestOptions requestOptions, ResponseOptions responseOptions) {
        super(requestOptions, responseOptions);
    }

    @Override
    protected void initTask(RequestOptions requestOptions, ResponseOptions responseOptions) {
        task = new NetTask(requestOptions,responseOptions);
    }



}
