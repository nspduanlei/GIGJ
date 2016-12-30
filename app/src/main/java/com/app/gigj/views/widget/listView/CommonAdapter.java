package com.app.gigj.views.widget.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Author: duanlei
 * Date: 2015-08-05
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener<T> {
        void onItemClick(T data, int position);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public CommonAdapter(Context context, List<T> datas, int layoutId, AbsListView listView) {
        mContext = context;
        mData = datas;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(mData.get(position), position);
            }
        });
    }

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mData = datas;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder = MyViewHolder.get(mContext, convertView, parent,
                mLayoutId, position);

        convert(holder, getItem(position));


        return holder.getConvertView();
    }

    public abstract void convert(MyViewHolder holder, T t);

    public void clear() {
        mData.clear();
    }

    public void addAll(List<T> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }




}
