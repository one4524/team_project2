package com.hansung.android.teamproject2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
    private static final String ARG_PARAM4 = "param4";

    private int mParam1;
    private int mParam2;
    private int mParam3;
    private  ArrayList<String> mParam4;

    int year, month, index;
    ArrayList<String> days;

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
    public static weekCalendarFragment newInstance(int param1, int param2, int param3, ArrayList<String> param4) {
        weekCalendarFragment fragment = new weekCalendarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putStringArrayList(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            ((MainActivity) activity).setActionBarTitle(year+"년 "+month+"월");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getStringArrayList(ARG_PARAM4);
            year = mParam1;
            month = mParam2;
            index = mParam3;
            days = mParam4;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View weekView = inflater.inflate(R.layout.fragment_week_calendar, container, false);

        GridView gridview_week_calendar = weekView.findViewById(R.id.can_calendar);

        ((TextView)weekView.findViewById(R.id.textView1)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView2)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView3)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView4)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView5)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView6)).setText(days.get(index++));
        ((TextView)weekView.findViewById(R.id.textView7)).setText(days.get(index++));

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        };


        weekGridViewAdapter weekGridViewAdapter = new weekGridViewAdapter(getContext(), R.layout.day_cell);
        gridview_week_calendar.setAdapter(weekGridViewAdapter);

        gridview_week_calendar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                int first = gridview_week_calendar.getFirstVisiblePosition();
                int last = gridview_week_calendar.getLastVisiblePosition();

                for(int i=0; i<gridview_week_calendar.getChildCount(); i++){
                    gridview_week_calendar.getChildAt(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                gridview_week_calendar.getChildAt(position).setBackgroundColor(Color.parseColor("#00ffff"));

                Toast.makeText(getContext(),
                        "position="+ position,
                        Toast.LENGTH_SHORT).show();

            }
        });


        // Inflate the layout for this fragment
        return weekView;


    }


}