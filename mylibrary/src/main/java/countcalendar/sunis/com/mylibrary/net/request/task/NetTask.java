package countcalendar.sunis.com.mylibrary.net.request.task;

import android.util.Log;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.config.BaseNetRequestConfig;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

/**
 * Created by Sunis on 2016/3/30.
 */
public class NetTask extends BaseTask {


    public NetTask(RequestOptions requestOptions, ResponseOptions responseOptions) {
        super(requestOptions, responseOptions);
    }

    @Override
    protected void makeRequest() {

       String result = BaseNetRequestConfig.getInstance().getNetFramework().request(requestOptions);


        Log.e("result", result);




    }




    @Override
    protected void parseResponse() {

    }

    @Override
    protected void saveData() {

    }
}
