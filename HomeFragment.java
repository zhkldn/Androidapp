package com.example.ektuarticles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        TextView welcomeText = rootView.findViewById(R.id.welcome_text);
        TextView newsText = rootView.findViewById(R.id.news_text);

        welcomeText.setText("EKTUARTICLES басты бетіне қош келдіңіз\nМұнда сіз оқытушылар туралы ақпаратты және университет жаңалықтарын таба аласыз.");
        newsText.setText("Университет жаңалықтары\n1. ШҚТУ-да жаңа зертхананың ашылуы\n2. Техника және технология бойынша халықаралық конференция\n3. Жаңа курстар мен оқу бағдарламалары");

        return rootView;
    }
}
