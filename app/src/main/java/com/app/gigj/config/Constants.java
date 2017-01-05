package com.app.gigj.config;

/**
 * Created by duanlei on 2016/12/28.
 */

public class Constants {


    public static String BASE_URL = "http://www.glgj.com.cn:5080/AppWs/";

    public static String USER_ID = "10000004";
    public static String PASSWORD = "111";
    /**
     * 列表每页显示数据
     */
    public static final int PAGE_SIZE = 20;

    public static final int ROLE_INNER_INDEX = 1;
    public static final int ROLE_DRIVER_INDEX = 2;
    public static final int ROLE_SHIPPER_INDEX = 3;
    public static final int ROLE_CAROWER_INDEX = 4;
//    默认 普通用户为1000000000
//    标志位：1000000000
//    第一位为普通注册用户
//    第二位为1表示内部员工，内部员工又有角色区分，只有当这个为1的时候，使用内部app就需要获取角色，进行权限管理
//    第三位为1表示成员司机
//    第四位为1表示货主身份
//    第五位为1表示车主身份
//    后面的位数继续扩展，暂时保留
//    注意：一个人可以有多个身份，比如注册为司机时，就有可能是货主，同时也是车主身份

}
