package com.hansung.android.teamproject2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Calendar;

public class weekCalendarAdapter extends FragmentStateAdapter {
    public weekCalendarAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }
    int year = MonthViewFragment.YEAR;
    int month = MonthViewFragment.MONTH;
    int day = Calendar.DATE;
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int count = (position + month - 1) / 12;

        return weekCalendarFragment.newInstance(year+count, position + month - (count * 12));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
