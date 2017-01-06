package com.app.gigj.views.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.admin.AboutUsActivity;
import com.app.gigj.views.activities.admin.FeedbackActivity;
import com.app.gigj.views.activities.admin.HelpCenterActivity;
import com.app.gigj.views.activities.admin.IssueActivity;
import com.app.gigj.views.activities.admin.ServiceRuleActivity;
import com.app.gigj.views.activities.admin.VersionActivity;
import com.app.gigj.views.fragments.core.BaseFragment;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by duanlei on 2016/12/29.
 *
 * 关于
 */

public class AboutFragment extends BaseFragment {

    @BindView(R.id.lv_menu)
    ListView mLvMenu;

    @Override
    protected void initUI(View view) {
        initMenu();
    }

    private void initMenu() {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("关于我们");
        titles.add("帮助中心");
        titles.add("服务规则");
        titles.add("意见反馈");
        titles.add("常见问题");
        titles.add("检查更新");
        titles.add("清空缓存");

        CommonAdapter adapter = new CommonAdapter<String>(getActivity(),
                titles, R.layout.item_about_us, mLvMenu) {
            @Override
            public void convert(MyViewHolder holder, String s) {
                holder.setText(R.id.tv_title, s);
            }
        };

        adapter.setOnItemClickListener((data, position) -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(getActivity(), AboutUsActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(getActivity(), HelpCenterActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(getActivity(), ServiceRuleActivity.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(getActivity(), FeedbackActivity.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(getActivity(), IssueActivity.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(getActivity(), VersionActivity.class);
                    startActivity(intent);
                    break;
                case 6:
                    //TODO  清空缓存


                    break;

            }
        });

        mLvMenu.setAdapter(adapter);

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {

    }

    @Override
    protected void initPresenter() {

    }
}
