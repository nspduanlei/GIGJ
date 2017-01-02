package com.app.gigj.mvp.views;

import com.app.gigj.domin.entities.User;
import com.app.gigj.mvp.views.core.View;

/**
 * Created by duanlei on 17/1/2.
 */

public interface LoginView extends View {
    void onLoginSuccess(User user);
}
