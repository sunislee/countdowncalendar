package countcalendar.sunis.com.mylibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunis on 2016/3/29.
 */
public class GlobalManager {

    private static GlobalManager sInstance;
    private static Map<Class<? extends UIListener>, List<? extends UIListener>> uiListeners;



    private GlobalManager() {
    }

    public static synchronized GlobalManager getInstance() {
        if (sInstance == null) {
            sInstance = new GlobalManager();

        }

        init();

        return sInstance;
    }

    private static void init() {

        uiListeners = new HashMap<>();
    }





    public <T extends UIListener> void addUIListener(T t){
        List<T> list = (List<T>) uiListeners.get(t.getClass());
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(t);
        uiListeners.put(t.getClass(), list);

    }


    public <T extends UIListener> List<T> getUIListener(T t){

        return (List<T>) uiListeners.get(t.getClass());

    }






}
