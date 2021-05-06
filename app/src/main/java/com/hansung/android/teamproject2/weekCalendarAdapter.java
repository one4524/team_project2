package com.hansung.android.teamproject2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Calendar;

public class weekCalendarAdapter extends FragmentStateAdapter {
    private static int NUM_ITEMS=100;
    public weekCalendarAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    int year = weekViewFragment.YEAR;
    int month = weekViewFragment.MONTH;
    int date = weekViewFragment.DATE;

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int count = (position + month - 1) / 12;

        return weekCalendarFragment.newInstance(year+count, position + month - (count * 12), date);
    }




    @Override
    public int getItemCount () {
        return NUM_ITEMS;
    }

}