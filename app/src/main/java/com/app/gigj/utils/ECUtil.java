package com.app.gigj.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

/**
 * Created by duanlei on 2017/1/4.
 * 环信 工具类
 */
public class ECUtil {

    // 弹出框
    private ProgressDialog mDialog;

    private Activity mActivity;

    public ECUtil(Activity activity, EcListener ecListener) {
        mActivity = activity;
        mEcListener = ecListener;
    }

    public interface EcListener {
        void onLoginSuccess();
    }

    EcListener mEcListener;

    /**
     * 注册方法
     */
    public void signUp(String username, String password) {
        // 注册是耗时过程，所以要显示一个dialog来提示下用户
        mDialog = new ProgressDialog(mActivity);
        mDialog.setMessage("注册中，请稍后...");
        mDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(username, password);
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!mActivity.isFinishing()) {
                                mDialog.dismiss();
                            }
                            Toast.makeText(mActivity, "注册成功", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (final HyphenateException e) {
                    e.printStackTrace();
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!mActivity.isFinishing()) {
                                mDialog.dismiss();
                            }
                            /**
                             * 关于错误码可以参考官方api详细说明
                             * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1_e_m_error.html
                             */
                            int errorCode = e.getErrorCode();
                            String message = e.getMessage();
                            Log.d("lzan13", String.format("sign up - errorCode:%d, errorMsg:%s", errorCode, e.getMessage()));
                            switch (errorCode) {
                                // 网络错误
                                case EMError.NETWORK_ERROR:
                                    Toast.makeText(mActivity, "网络错误 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                                // 用户已存在
                                case EMError.USER_ALREADY_EXIST:
                                    Toast.makeText(mActivity, "用户已存在 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                                // 参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册
                                case EMError.USER_ILLEGAL_ARGUMENT:
                                    Toast.makeText(mActivity, "参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                                // 服务器未知错误
                                case EMError.SERVER_UNKNOWN_ERROR:
                                    Toast.makeText(mActivity, "服务器未知错误 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                                case EMError.USER_REG_FAILED:
                                    Toast.makeText(mActivity, "账户注册失败 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                                default:
                                    Toast.makeText(mActivity, "ml_sign_up_failed code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 登录方法
     */
    public void signIn(String username, String password) {
        mDialog = new ProgressDialog(mActivity);
        mDialog.setMessage("正在登陆，请稍后...");
        mDialog.show();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(mActivity, "用户名和密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        EMClient.getInstance().login(username, password, new EMCallBack() {
            /**
             * 登陆成功的回调
             */
            @Override
            public void onSuccess() {
                mActivity.runOnUiThread(() -> {
                    mDialog.dismiss();

                    // 加载所有会话到内存
                    EMClient.getInstance().chatManager().loadAllConversations();
                    // 加载所有群组到内存，如果使用了群组的话
                    // EMClient.getInstance().groupManager().loadAllGroups();

                    // 登录成功跳转界面
//                        Intent intent = new Intent(mActivity, ECMainActivity.class);
//                        startActivity(intent);
//                        finish();

                    mEcListener.onLoginSuccess();
                });
            }

            /**
             * 登陆错误的回调
             * @param i
             * @param s
             */
            @Override
            public void onError(final int i, final String s) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDialog.dismiss();
                        Log.d("lzan13", "登录失败 Error code:" + i + ", message:" + s);
                        /**
                         * 关于错误码可以参考官方api详细说明
                         * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1_e_m_error.html
                         */
                        switch (i) {
                            // 网络异常 2
                            case EMError.NETWORK_ERROR:
                                Toast.makeText(mActivity, "网络错误 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 无效的用户名 101
                            case EMError.INVALID_USER_NAME:
                                Toast.makeText(mActivity, "无效的用户名 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 无效的密码 102
                            case EMError.INVALID_PASSWORD:
                                Toast.makeText(mActivity, "无效的密码 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 用户认证失败，用户名或密码错误 202
                            case EMError.USER_AUTHENTICATION_FAILED:
                                Toast.makeText(mActivity, "用户认证失败，用户名或密码错误 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 用户不存在 204
                            case EMError.USER_NOT_FOUND:
                                Toast.makeText(mActivity, "用户不存在 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 无法访问到服务器 300
                            case EMError.SERVER_NOT_REACHABLE:
                                Toast.makeText(mActivity, "无法访问到服务器 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 等待服务器响应超时 301
                            case EMError.SERVER_TIMEOUT:
                                Toast.makeText(mActivity, "等待服务器响应超时 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 服务器繁忙 302
                            case EMError.SERVER_BUSY:
                                Toast.makeText(mActivity, "服务器繁忙 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            // 未知 Server 异常 303 一般断网会出现这个错误
                            case EMError.SERVER_UNKNOWN_ERROR:
                                Toast.makeText(mActivity, "未知的服务器异常 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                            default:
                                Toast.makeText(mActivity, "ml_sign_in_failed code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
