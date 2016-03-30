package countcalendar.sunis.com.mylibrary.net.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Locale;

/**
 * Created by Sunis on 2016/3/30.
 */
public class NetUtils {

    public static LinkedHashMap<String, Object> getRequestParams(Object model){
        LinkedHashMap requestDataMap = new LinkedHashMap();
        if (model == null) {
            return requestDataMap;
        }

        Field[] fields = model.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            Object value = getGFieldValueByName(name,model);
            if (value != null) {
                requestDataMap.put(name, value);
            }
        }

        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            Object value = getIFieldValueByName(name,model);
            if (value != null) {
                requestDataMap.put(name, value);
            }
        }

        return requestDataMap;

    }

    private static Object getGFieldValueByName(String name,Object o) {

        try {
            String e = name.substring(0, 1).toUpperCase(Locale.getDefault());
            String getter = "get" + e + name.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[0]);
            Object value = method.invoke(o, new Object[0]);
            return value;
        } catch (Exception var6) {
            return null;
        }


    }

    private static Object getIFieldValueByName(String name,Object o) {

        try {
            String e = name.substring(0, 1).toUpperCase(Locale.getDefault());
            String getter = "is" + e + name.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[0]);
            Object value = method.invoke(o, new Object[0]);
            return value;
        } catch (Exception var6) {
            return null;
        }


    }
}
