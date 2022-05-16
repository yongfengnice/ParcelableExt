package com.suyf.parecelext.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 注意：
 * 1.使用上只需要将自己的类实现ParcelableExt接口即可，其他什么都不用动，
 * 记得不要重写writeToParcel方法哦（历史改造时要特别注意）
 * <p>
 * 2.实现类必须有空的构造函数，因为会反射创建（别扯什么反射效率低,
 * Serializable大把反射还会有IO操作还不是用了？如果不想使用反射，
 * 可以自己引入注解器自动生成反射创建类那块代码，个人觉得没必要，
 * 这点反射真的可以忽略不计,从纳秒角度去比较的话确实增加了一点点耗时，
 * 毕竟也对每个filed做了一点点逻辑判断，也可以自己改一下不做任何判断）
 * <p>
 * 3.默认会对除了static、final、@Transient之外的所有属性操作
 * <p>
 * 4.同时支持java对象，kotlin对象(data class每个字段都要赋值，这样才会重载出无参构造函数)，再次提醒：对象一定要提供无参构造函数！！！
 */
public interface ParcelableExt extends Parcelable {
    String TAG = "Suyf";

    @Override
    default void writeToParcel(Parcel dest, int flags) {
        long currentTimeMillis = System.nanoTime();
        try {
            Class<? extends ParcelableExt> aClass = getClass();
            dest.writeString(aClass.getName());
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isTransient(mod)) {
                    //Log.d("Suyf", "writeToParcel: -Exclude:" + field.getName());
                } else {
                    field.setAccessible(true);
                    dest.writeValue(field.get(this));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "writeToParcel出错了: " + e.getMessage());
        }
        Log.d(TAG, "writeToParcel耗时ns: " + (System.nanoTime() - currentTimeMillis));
    }

    @Override
    default int describeContents() {
        return 0;
    }

    Creator<Object> CREATOR = new Creator<Object>() {

        private Object createInst(Parcel parcelIn) {
            long currentTimeMillis = System.nanoTime();
            try {
                String clazzName = parcelIn.readString();
                Class<?> clazz = Class.forName(clazzName);
                Object object = clazz.newInstance();
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field field : declaredFields) {
                    int mod = field.getModifiers();
                    if (Modifier.isStatic(mod) || Modifier.isTransient(mod)) {
                        //Log.d("Suyf", "readParcel: -Exclude:" + field.getName());
                    } else {
                        field.setAccessible(true);
                        field.set(object, parcelIn.readValue(clazz.getClassLoader()));
                    }
                }
                Log.d(TAG, "readParcel耗时ns: " + (System.nanoTime() - currentTimeMillis));
                return object;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "readParcel出错了:" + e.getMessage());
                return null;
            }
        }

        @Override
        public Object createFromParcel(Parcel in) {
            return createInst(in);
        }

        @Override
        public Object[] newArray(int size) {
            return null;
        }
    };

}
