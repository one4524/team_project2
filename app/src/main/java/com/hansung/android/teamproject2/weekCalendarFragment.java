package com.hansung.android.teamproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weekCalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weekCalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private int mParam1;
    private int mParam2;
    private int mParam3;

    int year, month, date;

    public weekCalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment weekCalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static weekCalendarFragment newInstance(int param1, int param2, int param3) {
        weekCalendarFragment fragment = new weekCalendarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            year = mParam1;
            month = mParam2;
            date = mParam3;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View weekView = inflater.inflate(R.layout.fragment_week_calendar, container, false);

        GridView gridview_week_calendar = weekView.findViewById(R.id.can_calendar);

        weekGridViewAdapter weekGridViewAdapter = new weekGridViewAdapter(getContext(), R.layout.day_cell);
        gridview_week_calendar.setAdapter(weekGridViewAdapter);

        // Inflate the layout for this fragment
        return weekView;


    }


}