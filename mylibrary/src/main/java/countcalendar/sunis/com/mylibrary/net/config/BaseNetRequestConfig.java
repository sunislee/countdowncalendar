package countcalendar.sunis.com.mylibrary.net.config;

import countcalendar.sunis.com.mylibrary.net.request.method.BaseNetFramework;
import countcalendar.sunis.com.mylibrary.net.request.method.UrlConnectionRequest;

/**
 * Created by Sunis on 2016/4/19.
 */
public class BaseNetRequestConfig {

    private static BaseNetRequestConfig instance;


    private BaseNetRequestConfig() {

    }

    public static synchronized BaseNetRequestConfig getInstance() {
            if (instance == null) {
                instance = new BaseNetRequestConfig();
            }
            return instance;

    }

    private BaseNetFramework netFramework;

    public BaseNetFramework getNetFramework() {
//        if (netFramework == null) {

//            netFramework = new HttpClientRequest();
            netFramework = new UrlConnectionRequest();
//        }
        return netFramework;
    }

    public void setNetFramework(BaseNetFramework netFramework) {
        this.netFramework = netFramework;
    }
}
