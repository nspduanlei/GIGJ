package com.app.gigj.views.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.config.Constants;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.support.picasso.ImageLoad;
import com.app.gigj.utils.MyUtils;
import com.app.gigj.utils.SPUtils;
import com.app.gigj.views.activities.admin.AboutUsActivity;
import com.app.gigj.views.activities.UserInfoActivity;
import com.app.gigj.views.activities.carOwner.AccidentManaActivity;
import com.app.gigj.views.activities.carOwner.BreakRulesActivity;
import com.app.gigj.views.activities.carOwner.CarTeamActivity;
import com.app.gigj.views.activities.carOwner.GasolineManageActivity;
import com.app.gigj.views.activities.carOwner.ServiceStateActivity;
import com.app.gigj.views.activities.shipper.AddressManaActivity;
import com.app.gigj.views.activities.shipper.EvaluateActivity;
import com.app.gigj.views.activities.shipper.MyChitActivity;
import com.app.gigj.views.activities.shipper.MyCustomsActivity;
import com.app.gigj.views.activities.shipper.MyFundActivity;
import com.app.gigj.views.activities.shipper.OrdersActivity;
import com.app.gigj.views.fragments.core.BaseFragment;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 */

public class MeFragment extends BaseFragment {

    @BindView(R.id.lv_menu)
    ListView mLvMenu;

    @BindView(R.id.gv_menu)
    GridView mGvMenu;
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;
    @BindView(R.id.tv_msg)
    TextView mTvMsg;
    @BindView(R.id.tv_msg_1)
    TextView mTvMsg1;
    @BindView(R.id.tv_msg_2)
    TextView mTvMsg2;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    private String mUserId;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initUI(View view) {
        initLv();
        initGv();

        String headImg = (String) SPUtils.get(getActivity(), SPUtils.USER_IMG, "");
        String nickName = (String) SPUtils.get(getActivity(), SPUtils.USER_NAME, "");
        String userRole = (String) SPUtils.get(getActivity(), SPUtils.USER_ROLE, "");
        mUserId = (String) SPUtils.get(getActivity(), SPUtils.USER_NO, "");


        ImageLoad.loadUrlRound(getActivity(), headImg, mIvHead);
        mTvUserName.setText(nickName);

        if (userRole.charAt(Constants.ROLE_DRIVER_INDEX) == '1') {
            mTvMsg1.setVisibility(View.VISIBLE);
        }
        if (userRole.charAt(Constants.ROLE_CAROWER_INDEX) == '1') {
            mTvMsg.setVisibility(View.VISIBLE);
        }
        if (userRole.charAt(Constants.ROLE_SHIPPER_INDEX) == '1') {
            mTvMsg2.setVisibility(View.VISIBLE);
        }
    }

    private void initLv() {
        ArrayList<MenuEntity> titles = new ArrayList<>();
        titles.add(new MenuEntity(R.drawable.icon_me_lv1, "我的发货订单", 2, 0));
        titles.add(new MenuEntity(R.drawable.icon_me_lv2, "是否上班", 3, 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv3, "我的钱包", 1, 2));
        titles.add(new MenuEntity(R.drawable.icon_me_lv4, "我的车队", 1, 3));
        titles.add(new MenuEntity(R.drawable.icon_me_lv5, "我的报关", 1, 4));
        titles.add(new MenuEntity(R.drawable.icon_me_lv6, "地址管理", 1, 5));
        titles.add(new MenuEntity(R.drawable.icon_me_lv7, "评价查看", 1, 6));
        titles.add(new MenuEntity(R.drawable.icon_me_lv8, "关于我们", 1, 7));
        titles.add(new MenuEntity(R.drawable.icon_me_lv9, "退出", 1, 8));

        CommonAdapter adapter = new CommonAdapter<MenuEntity>(getActivity(),
                titles, R.layout.item_me_list, mLvMenu) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());

                switch (menuEntity.getType()) {
                    case 1:
                        holder.setVisibility(R.id.iv_arrow, View.VISIBLE)
                                .setVisibility(R.id.switch_work, View.GONE)
                                .setVisibility(R.id.tv_hint, View.GONE);
                        break;
                    case 2:
                        holder.setVisibility(R.id.iv_arrow, View.VISIBLE)
                                .setVisibility(R.id.switch_work, View.GONE)
                                .setVisibility(R.id.tv_hint, View.VISIBLE);
                        break;
                    case 3:
                        holder.setVisibility(R.id.iv_arrow, View.GONE)
                                .setVisibility(R.id.switch_work, View.VISIBLE)
                                .setVisibility(R.id.tv_hint, View.GONE);
                        break;
                    default:
                        break;
                }
            }
        };

        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener<MenuEntity>() {
            @Override
            public void onItemClick(MenuEntity data, int position) {
                Intent intent;

                switch (data.getId()) {
                    case 0:
                        intent = new Intent(getActivity(), OrdersActivity.class);
                        startActivity(intent);
                        break;
//                    case 1:
//                        break;
                    case 2:
                        intent = new Intent(getActivity(), MyFundActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), CarTeamActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), MyCustomsActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getActivity(), AddressManaActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getActivity(), EvaluateActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getActivity(), AboutUsActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        MyUtils.loginOut(getActivity());
                        break;
                }
            }
        });
        mLvMenu.setAdapter(adapter);
    }

    private void initGv() {
        ArrayList<MenuEntity> titles = new ArrayList<>();
        titles.add(new MenuEntity(R.drawable.icon_me_gv1, "我的配送订单"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv2, "事故处理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv3, "违章信息管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv4, "年检信息"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv5, "车贷管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv6, "加油管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv7, "车辆维修管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv8, "我的保单"));

        CommonAdapter adapter = new CommonAdapter<MenuEntity>(getActivity(),
                titles, R.layout.item_me_button, mGvMenu) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());
            }
        };

        adapter.setOnItemClickListener((data, position) -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(getActivity(), OrdersActivity.class);
                    intent.putExtra(OrdersActivity.ARG_TYPE, 1);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(getActivity(), AccidentManaActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(getActivity(), BreakRulesActivity.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(getActivity(), BreakRulesActivity.class);
                    intent.putExtra(BreakRulesActivity.ARG_TYPE, 1);
                    startActivity(intent);
                    break;
                case 4:

                    break;
                case 5:
                    intent = new Intent(getActivity(), GasolineManageActivity.class);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(getActivity(), ServiceStateActivity.class);
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(getActivity(), MyChitActivity.class);
                    startActivity(intent);
                    break;
            }
        });

        mGvMenu.setAdapter(adapter);


    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.rl_top)
    void onTopClicked(View view) {
        Intent intent = new Intent(getActivity(), UserInfoActivity.class);
        startActivity(intent);
    }
}
