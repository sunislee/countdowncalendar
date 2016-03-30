package countcalendar.sunis.com.mylibrary.net.request.task;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

/**
 * Created by Sunis on 2016/3/30.
 */
public abstract class BaseTask implements ITask {
    protected RequestOptions requestOptions;
    protected ResponseOptions responseOptions;

    public BaseTask(RequestOptions requestOptions, ResponseOptions responseOptions){
        this.requestOptions = requestOptions;
        this.responseOptions = responseOptions;
    }

    public void execute() {
        makeRequest();
        parseResponse();
        saveData();
    }

    protected abstract void makeRequest();

    protected abstract void parseResponse();

    protected abstract void saveData();
}
