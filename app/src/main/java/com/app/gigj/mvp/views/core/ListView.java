package com.app.gigj.mvp.views.core;

import java.util.ArrayList;

/**
 * Created by duanlei on 17/1/1.
 */

public interface ListView extends View {
    void onLoadMoreSuccess(ArrayList data);
    void onRefreshSuccess(ArrayList data);
    void onNoMore();
}
