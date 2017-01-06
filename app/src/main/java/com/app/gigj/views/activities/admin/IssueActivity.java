package com.app.gigj.views.activities.admin;

import android.os.Bundle;
import android.widget.ListView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by duanlei on 2017/1/6.
 */

public class IssueActivity extends BaseActivity {

    @BindView(R.id.lv_issue)
    ListView mLvIssue;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_issue, "常见问题");
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        ArrayList<MenuEntity> menuEntities = new ArrayList<>();
        menuEntities.add(new MenuEntity(1, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(2, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(3, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(4, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(5, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(6, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));
        menuEntities.add(new MenuEntity(7, "问题1问题1问题1问题1问题1问题1问题1问题1问题1"));


        CommonAdapter<MenuEntity> commonAdapter = new CommonAdapter<MenuEntity>(this, menuEntities,
                R.layout.item_text_list, mLvIssue) {

            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName());
            }
        };

        commonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener<MenuEntity>() {
            @Override
            public void onItemClick(MenuEntity data, int position) {
                switch (data.getResId()) {
                    case 0:
                        break;

                }
            }
        });


        mLvIssue.setAdapter(commonAdapter);



    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}
