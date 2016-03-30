package sunis.com.countdowncalendar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import countcalendar.sunis.com.mylibrary.net.request.manager.SyncRequestManager;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestModel;
import countcalendar.sunis.com.mylibrary.net.request.model.RequestOptions;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyRequestModel model = new MyRequestModel();
        model.setName("MyName");
        model.setRight(true);
        model.setAge(30);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setRequestModel(model);

        SyncRequestManager manager = new SyncRequestManager(requestOptions,null);
        manager.execute();
    }

    class MyRequestModel extends RequestModel {

        private String name;
        private boolean right;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isRight() {
            return right;
        }

        public void setRight(boolean right) {
            this.right = right;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
