package com.app.gigj.views.widget.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.support.picasso.ImageLoad;
import com.app.gigj.views.widget.NoScrollGridView;
import com.app.gigj.views.widget.listView.CommonAdapter;

import butterknife.ButterKnife;

/**
 * Created by duanlei on 16/9/21.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;


    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v);
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public MyViewHolder(View view, Context context) {
        super(view);
        mConvertView = view;
        mContext = context;
        mViews = new SparseArray<>();
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v);
            }
        });
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public MyViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public MyViewHolder setImageUrl(int viewId, String url) {
        ImageView iv = getView(viewId);
        ImageLoad.loadUrl(mContext, iv, url);
        return this;
    }

    public MyViewHolder setRoundImageUrl(int viewId, String url) {
        ImageView iv = getView(viewId);
        ImageLoad.loadUrlRound(mContext, url, iv);
        return this;
    }

    public MyViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public MyViewHolder setOnClickLister(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public MyViewHolder setGridView(int viewId, CommonAdapter<MenuEntity> commonAdapter) {
        NoScrollGridView gridView = getView(viewId);
        gridView.setAdapter(commonAdapter);
        return this;
    }



}
