package com.app.gigj.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.func.TabEntity;
import com.app.gigj.support.eventBus.RxBus;
import com.app.gigj.utils.MyUtils;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.fragments.HomeFragment;
import com.app.gigj.views.fragments.MeFragment;
import com.app.gigj.views.fragments.MessageFragment;
import com.app.gigj.views.fragments.AboutFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import rx.Subscription;

/**
 * Created by duanlei on 2016/12/29.
 */

public class MainCommonActivity extends BaseActivity {
    @BindView(R.id.tl_main)
    CommonTabLayout mTlMain;

    private String[] mTitles = {"首页", "关于", "沟通", "我的"};
    private int[] mIconUnSelectIds = {
            R.mipmap.icon_home,
            R.mipmap.icon_order,
            R.mipmap.icon_message,
            R.mipmap.icon_me};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_sel,
            R.mipmap.icon_order_sel,
            R.mipmap.icon_message_sel,
            R.mipmap.icon_me_sel};

    HomeFragment mHomeFragment;
    MessageFragment mMessageFragment;
    AboutFragment mAboutFragment;
    MeFragment mMeFragment;

    Subscription mRxSubscription;
    public static final int ACTION_UPDATE_CUSTOMS = 1;
    public static final int ACTION_UPDATE_USER = 2;
    public static final int ACTION_MY_COUNT = 3;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_main_common, R.string.title_home, MODE_HOME);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        initTabBar();
        initSubscription();
    }

    private void initSubscription() {
        mRxSubscription = RxBus.getDefault().toObservable(Integer.class)
                .subscribe(this::updateData, this::manageError);
    }

    private void manageError(Throwable throwable) {

    }

    private void updateData(Integer integer) {
//        switch (integer) {
//            case ACTION_UPDATE_CUSTOMS:
//                mCustomFragment.updateCustomList();
//                break;
//            case ACTION_UPDATE_USER:
//                mProfileFragment.updateUser();
//                break;
//            case ACTION_MY_COUNT:
//                mWorkPlaceFragment.updateData();
//                break;
//        }
    }

    private void initTabBar() {

        mHomeFragment = new HomeFragment();
        mMessageFragment = new MessageFragment();
        mAboutFragment = new AboutFragment();
        mMeFragment = new MeFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mAboutFragment);
        mFragments.add(mMessageFragment);
        mFragments.add(mMeFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i],
                    mIconUnSelectIds[i]));
        }

        mTlMain.setTabData(mTabEntities, this, R.id.fl_content, mFragments);

        mTlMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                switch (position) {
                    case 0:  //首页
                        setUpTitle(R.string.title_home);
                        setMenuText("设置", v -> {

                        });
                        break;
                    case 1: //关于
                        setUpTitle(R.string.title_about);

                        break;
                    case 2: //消息
                        setUpTitle(R.string.title_msg);

                        break;

                    case 3: //我的
                        setUpTitle(R.string.title_me);

                        break;
                }
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyUtils.cancelSubscribe(mRxSubscription);
    }
}
