package com.app.gigj.views.activities.carOwner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.carOwner.AccidentCourseFragment;
import com.app.gigj.views.fragments.carOwner.AccidentManaFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/5.
 * 事故处理
 */

public class AccidentManaActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "事故处理记录", "事故处理教程"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("事故处理");
        setMenuText("添加", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccidentManaActivity.this, AddAccidentActivity.class);
                startActivity(intent);
            }
        });

        mFragments.add(new AccidentManaFragment());
        mFragments.add(new AccidentCourseFragment());

        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected OnTabSelectListener getTabSelectListener() {
        return new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switch (position) {
                    case 0:
                        setMenuText("添加", v -> {
                            Intent intent = new Intent(AccidentManaActivity.this, AddAccidentActivity.class);
                            startActivity(intent);
                        });
                        break;
                    case 1:
                        setMenuText("法律服务", v -> {
                            Intent intent = new Intent(AccidentManaActivity.this, LawServiceActivity.class);
                            startActivity(intent);
                        });

                        break;
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        };
    }
}
