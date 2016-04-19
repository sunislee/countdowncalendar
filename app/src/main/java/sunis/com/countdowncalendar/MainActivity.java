package sunis.com.countdowncalendar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import countcalendar.sunis.com.mylibrary.net.request.manager.SyncRequestManager;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestModel;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;
import countcalendar.sunis.com.mylibrary.net.request.type.NetRequestType;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyRequestModel model = new MyRequestModel();
        model.setAccount("stay4it");
        model.setPassword("123456");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setRequestModel(model);
        requestOptions.setNetRequestType(NetRequestType.POST);
//        requestOptions.setNetRequestType(NetRequestType.GET);
        requestOptions.setRequestUrl("http://api.stay4it.com/v1/public/core/?service=user.login");
//        requestOptions.setRequestUrl("http://imglf0.nosdn.127.net/img/ekpCUHpFWXBtVW5IcWViMzB4bzVGV0IzY0NnUGJUYmxVZk9RVVJYQVQweTFrUkpnK241SlF3PT0.jpg");

        SyncRequestManager manager = new SyncRequestManager(requestOptions,null);
//        AsyncRequestManager manager = new AsyncRequestManager(requestOptions,null);
        manager.execute();
    }

    class MyRequestModel extends RequestModel {

        private String account;
        private String password;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
