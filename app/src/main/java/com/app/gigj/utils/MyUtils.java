package com.app.gigj.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;

import com.app.gigj.R;
import com.app.gigj.config.ErrorCode;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.views.activities.LoginActivity;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.util.ArrayList;

import rx.Subscription;


/**
 * Created by duanlei on 2016/10/13.
 */
public class MyUtils {

    public static void showListDialog(Context context,
                                      ArrayList<MenuEntity> selectContents,
                                      OnItemClickListener itemClickListener) {

        DialogPlus dialogPlus = DialogPlus.newDialog(context)
                .setAdapter(new CommonAdapter<MenuEntity>(context, selectContents,
                        R.layout.select_list_item) {
                    @Override
                    public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                        holder.setText(R.id.tv_content, menuEntity.getName());
                    }
                })
                .setOnItemClickListener(itemClickListener)
                .setGravity(Gravity.BOTTOM)
                .setCancelable(true)
                .create();

        dialogPlus.show();
    }


//    /**
//     * 拨打电话
//     * @param mobile
//     */
//    public static void callPhone(Context context, String mobile) {
//        // 使用系统的电话拨号服务，必须去声明权限，在AndroidManifest.xml中进行声明
//        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
//                + mobile));
//
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
//                != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            return;
//        }
//        context.startActivity(intent);
//    }


    /**
     * 取消订阅，防止内存泄漏
     */
    public static void cancelSubscribe(Subscription... subscriptions) {
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] != null && !subscriptions[i].isUnsubscribed()) {
                subscriptions[i].unsubscribe();
            }
        }
    }

    /**
     * 登录token 过期
     */
    public static void tokenTimeOut(String errorCode, android.app.Activity activity) {
        if (errorCode.equals(ErrorCode.SESSION_OUT)) {
            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    /**
     * 退出登录
     */
    public static void loginOut(Activity context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("退出登录");
        builder.setMessage("确定退出登录？");

        builder.setPositiveButton("确定", (dialog, which) -> {
            dialog.dismiss();

            SPUtils.clear(context);
            SPUtils.put(context, SPUtils.IS_FIRST_LAUNCH, true);

            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            context.finish();
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }
}
