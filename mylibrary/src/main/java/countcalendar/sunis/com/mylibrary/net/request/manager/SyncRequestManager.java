package countcalendar.sunis.com.mylibrary.net.request.manager;

import java.util.concurrent.Executors;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

/**
 * Created by Sunis on 2016/3/30.
 */
public class SyncRequestManager extends RequestManager {

    public SyncRequestManager(RequestOptions requestOptions, ResponseOptions responseOptions){
        super(requestOptions,responseOptions);
        executorService = Executors.newSingleThreadExecutor();
    }

}
