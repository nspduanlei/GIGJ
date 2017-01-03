package com.app.gigj.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SPUtils {

    /**
     * =============================key====================================
     **/

    //是否第一次进入app
    public static final String IS_FIRST_LAUNCH = "is_first_launch";

    //是否有新的系统消息
    public static final String HAS_NEW_MESSAGE = "has_new_message";

    //用户选择不更新版本
    public static final String IS_NOT_UPDATE_VERSION = "select_not_update_version";

    //登录成功了未完善资料
    public static final String IS_COMPLETE = "select_not_update_version";

    //手机号
    public static final String PHONE = "user_phone";

    //密码
    public static final String PASSWORD = "user_password";

    //用户名
    public static final String USER_NAME = "user_name";

    //用户编号
    public static final String USER_NO = "user_no";

    //用户登录token
    public static final String TOKEN = "token";

    //用户头像
    public static final String USER_IMG = "user_img";

    //公司id
    public static final String COMPANY_ID = "company_id";


    //角色  货主 司机 车主 员工
    /**
     * 默认 普通用户为1000000000
     标志位：1000000000
     第一位为普通注册用户
     第二位为1表示内部员工，内部员工又有角色区分，只有当这个为1的时候，使用内部app就需要获取角色，进行权限管理
     第三位为1表示成员司机
     第四位为1表示货主身份
     第五位为1表示车主身份
     后面的位数继续扩展，暂时保留
     注意：一个人可以有多个身份，比如注册为司机时，就有可能是货主，同时也是车主身份
     */
    public static final String USER_ROLE = "user_role";



    /**
     * =================================================================
     **/

    public SPUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String key, Object object) {
        if (object == null) {
            return;
        }

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

//    public static void setUserInfo(Context context, User user) {
//        SPUtils.put(context, SPUtils.USER_NAME, user.getRealName());
//        SPUtils.put(context, SPUtils.TOKEN, user.getToken());
//        SPUtils.put(context, SPUtils.USER_NO, user.getUserNo());
//        SPUtils.put(context, SPUtils.POSITION_NAME, user.getPositionName());
//        SPUtils.put(context, SPUtils.DEP_NAME, user.getDepName());
//        SPUtils.put(context, SPUtils.USER_IMG, user.getImg());
//        SPUtils.put(context, SPUtils.POSITION_LEVEL, user.getPositionLevel());
//    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}