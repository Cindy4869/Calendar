package com.example.calendar;

import static com.example.calendar.CalendarUtils.dateInWeek;
import static com.example.calendar.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity_Weekly_Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener  {
    //ListView mListView;
    // ArrayList<Assignments> arrayList;
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView assingment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_weekly_calendar);
        //mListView = findViewById(R.id.assignment);
        initWidget();
        setWeekView();
    }

    private void initWidget() {
        calendarRecyclerView = findViewById(R.id.days);
        monthYearText = findViewById(R.id.Week);

    }
    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = dateInWeek(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }



    public void previousWeek(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeek(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    /*public void onAssignmentClick(int position) {
        //arrayList.get(position);
        Intent intent = new Intent(this, Assignments.class);
        startActivity(intent);
    }*/

    public void finished(View view) {
    }
    @Override
    public void onItemClick(int position) {

    }
}
