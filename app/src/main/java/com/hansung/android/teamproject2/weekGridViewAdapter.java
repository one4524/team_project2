package com.hansung.android.teamproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class weekGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private LayoutInflater mLiInflater;
    ArrayList<String> can; //날짜 리스트 생성


    public weekGridViewAdapter(Context context, int textResource, ArrayList<String> can) {

        this.mContext = context;
        this.mResource = textResource;
        this.can = can;
        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return can.size();
    }

    @Override
    public Object getItem(int position) {
        return can.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MonthGridViewAdapter.DayViewHolde dayViewHolder;

        if(convertView == null)
        {
            convertView = mLiInflater.inflate(mResource, null);

            dayViewHolder = new MonthGridViewAdapter.DayViewHolde();

            dayViewHolder.llBackground = (LinearLayout)convertView.findViewById(R.id.day_cell_ll_background);
            dayViewHolder.tvDay = (TextView) convertView.findViewById(R.id.day_cell_tv_day);

            convertView.setTag(dayViewHolder);
        }
        else
        {
            dayViewHolder = (MonthGridViewAdapter.DayViewHolde) convertView.getTag();
        }


        int height = mContext.getResources().getDisplayMetrics().heightPixels - 245;


        dayViewHolder.tvDay.setText(can.get(position));
        dayViewHolder.tvDay.setHeight(height/6 - 5);


        return convertView;
    }


}


