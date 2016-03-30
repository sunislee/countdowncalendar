package countcalendar.sunis.com.mylibrary.net.callback;

/**
 * Created by Sunis on 2016/3/30.
 */
public class ResponseOptions {

    private IDataRequestCallback callback;
    private boolean runOnUIThread = true;

    public IDataRequestCallback getCallback() {
        return callback;
    }

    public void setCallback(IDataRequestCallback callback) {
        this.callback = callback;
    }

    public boolean isRunOnUIThread() {
        return runOnUIThread;
    }

    public void setRunOnUIThread(boolean runOnUIThread) {
        this.runOnUIThread = runOnUIThread;
    }
}
