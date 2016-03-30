package countcalendar.sunis.com.mylibrary.net.request.type;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

/**
 * Created by Sunis on 2016/3/30.
 */
public class MemoryRequest extends BaseRequest {

    public MemoryRequest(RequestOptions requestOptions, ResponseOptions responseOptions) {
        super(requestOptions, responseOptions);
    }

    @Override
    protected void initTask(RequestOptions requestOptions, ResponseOptions responseOptions) {

    }

    @Override
    public void run() {


    }
}
