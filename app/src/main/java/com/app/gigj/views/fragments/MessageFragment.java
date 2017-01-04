package com.app.gigj.views.fragments;

import android.support.v4.app.Fragment;
import android.view.View;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.fragments.core.BaseTabFragment;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.ui.EaseConversationListFragment;

import java.util.ArrayList;

/**
 * Created by duanlei on 2016/12/29.
 */

public class MessageFragment extends BaseTabFragment {


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "消息", "通讯录", "发现"
    };

    @Override
    protected void initUI(View view) {


        EaseChatFragment chatFragment = new EaseChatFragment();
        // 将参数传递给聊天界面
        chatFragment.setArguments(getActivity().getIntent().getExtras());

        mFragments.add(new EaseConversationListFragment());
        mFragments.add(new EaseContactListFragment());
        mFragments.add(new MsgFindFragment());
        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}
