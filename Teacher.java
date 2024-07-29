package com.example.ektuarticles;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class Teacher implements Parcelable {
    private String name;
    private final ArrayList<Entry> barEntries;

    public Teacher(String name, ArrayList<Entry> barEntries) {
        this.name = name;
        this.barEntries = barEntries;
        }
    protected Teacher(Parcel in) {
        name = in.readString();
        barEntries = in.createTypedArrayList(Entry.CREATOR);
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    public String getName() {
        return name;
    }

    public ArrayList<BarEntry> getBarEntries() {
        return barEntries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(barEntries);
    }
}





