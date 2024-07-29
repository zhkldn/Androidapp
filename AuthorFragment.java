package com.example.ektuarticles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class AuthorFragment extends Fragment {
    private RecyclerView recyclerView;
    private TeacherAdapter adapter;
    private List<Teacher> teachers;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Создание списка преподавателей с данными
        teachers = new ArrayList<>();
        teachers.add(new Teacher("Erdybaeva Nazgul", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Grigoryeva Svetlana", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Guryanov Georgiy", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Kozhakhmetov Yernat", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Kulenova Natalya", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Kumargazhanova Saule", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Kuzmina Oxana", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Mizernaya Marina", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Nurekenova Elvira", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Oitseva Tatiana", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Plotnikov Sergey", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Rakhmetullina Saule", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Sadenova Marzhan", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Uvaliyeva Indira", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Vavulin Mikhail", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Vodyasov Evgeny", getBarEntriesForTeacher()));
        teachers.add(new Teacher("Zaytseva Olga", getBarEntriesForTeacher()));
    }

    private ArrayList<Entry> getBarEntriesForTeacher() {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 45f));
        entries.add(new BarEntry(1, 80f));
        entries.add(new BarEntry(2, 65f));
        entries.add(new BarEntry(3, 38f));
        return entries;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author, container, false);
        recyclerView = view.findViewById(R.id.teacher_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TeacherAdapter(getActivity(), teachers);
        recyclerView.setAdapter(adapter);
        return view;
    }
}











