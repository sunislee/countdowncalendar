package countcalendar.sunis.com.mylibrary;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Sunis on 2016/3/29.
 */
public class GlobalEnviroment {

    private Handler mHandler = new Handler();
    private Application mContext;

    public void start(Application application){
        this.mContext = application;

    }

    public Context getContext(){
        return mContext;
    }


    public void runOnUIThread(Runnable r){

        mHandler.post(r);

    }
}
