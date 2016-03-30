package countcalendar.sunis.com.mylibrary.net.request.type;

import countcalendar.sunis.com.mylibrary.net.callback.ResponseOptions;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.task.BaseTask;

/**
 * Created by Sunis on 2016/3/30.
 */
public abstract class BaseRequest implements Runnable{

    public BaseRequest(RequestOptions requestOptions, ResponseOptions responseOptions){
            initTask(requestOptions,responseOptions);
    }

    protected abstract void initTask(RequestOptions requestOptions, ResponseOptions responseOptions);

    protected BaseTask task;

    @Override
    public void run() {

        task.execute();

    }

    public BaseTask getTask() {
        return task;
    }

    public void setTask(BaseTask task) {
        this.task = task;
    }
}
