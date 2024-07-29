package com.example.ektuarticles;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {
    private Context context;
    private List<Teacher> teachers;

    public TeacherAdapter(Context context, List<Teacher> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teacher_list_item, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        Teacher teacher = teachers.get(position);
        holder.nameTextView.setText(teacher.getName());
        holder.setupBarChart(teacher.getBarEntries());
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    static class TeacherViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        BarChart barChart;

        TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.teacher_name);
            barChart = itemView.findViewById(R.id.chart);
        }

        void setupBarChart(ArrayList<BarEntry> entries) {
            BarDataSet dataSet = new BarDataSet(entries, "Articles per Year");
            dataSet.setColor(Color.BLUE);

            BarData barData = new BarData(dataSet);
            barChart.setData(barData);

            // Дополнительные настройки графика (например, подписи осей, стиль и т. д.)
            // ...

            // Обязательно вызовите invalidate(), чтобы обновить график
            barChart.invalidate();
        }
    }
}











