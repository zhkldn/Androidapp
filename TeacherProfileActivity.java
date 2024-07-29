package com.example.ektuarticles;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class TeacherProfileActivity extends AppCompatActivity {
    public static final String EXTRA_TEACHER = "com.example.ektuarticles.EXTRA_TEACHER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        Intent intent = getIntent();
        Teacher teacher = intent.getParcelableExtra(EXTRA_TEACHER);
        if (teacher == null) {
            // Обработка случая, когда данные не переданы
            finish();
            return;
        }

        setTitle(teacher.getName());

        BarChart barChart = findViewById(R.id.chart);
        setupBarChart(barChart, teacher.getBarEntries());
    }

    private void setupBarChart(BarChart barChart, ArrayList<Entry> entries) {
        BarDataSet dataSet = new BarDataSet(convertToBarEntries(entries), "Articles per Year");
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

    private ArrayList<BarEntry> convertToBarEntries(ArrayList<Entry> entries) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (Entry entry : entries) {
            barEntries.add(new BarEntry(entry.getX(), entry.getY()));
        }
        return barEntries;
    }
}








