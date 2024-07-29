package com.example.ektuarticles;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;
import java.util.List;

public class TeacherProfileFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_ENTRIES = "entries";

    private String teacherName;
    private List<BarEntry> barEntries;

    public static TeacherProfileFragment newInstance(String name, ArrayList<BarEntry> entries) {
        TeacherProfileFragment fragment = new TeacherProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putParcelableArrayList(ARG_ENTRIES, entries);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            teacherName = getArguments().getString(ARG_NAME);
            barEntries = getArguments().getParcelableArrayList(ARG_ENTRIES);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_profile, container, false);

        BarChart barChart = view.findViewById(R.id.chart);
        setupBarChart(barChart);

        return view;
    }

    private void setupBarChart(BarChart barChart) {
        BarDataSet dataSet = new BarDataSet(barEntries, "Articles per Year");
        dataSet.setColor(Color.BLUE);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);
        barChart.invalidate();

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "Year " + (int) value;
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);

        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisLineWidth(2f);
        yAxis.setAxisLineColor(Color.BLACK);
        yAxis.setLabelCount(10);

        barChart.getAxisRight().setDrawLabels(false);
    }
}


