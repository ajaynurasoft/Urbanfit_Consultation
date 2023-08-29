package nurasoftech.urbanfitconsultation.ScheduleAppointment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import nurasoftech.urbanfitconsultation.R;
import nurasoftech.urbanfitconsultation.utils.CalendarUtils;

import static nurasoftech.urbanfitconsultation.utils.CalendarUtils.daysInWeekArray;
import static nurasoftech.urbanfitconsultation.utils.CalendarUtils.monthYearFromDate;

public class counsellor_1 extends AppCompatActivity {

    TextView monthYearText;
    RecyclerView calendarRecyclerView;
    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counseller1);

        Objects.requireNonNull(getSupportActionBar()).hide();

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        next_button = findViewById(R.id.next_button);
        setWeekView();

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(counsellor_1.this, counsellor_2.class));
            }
        });

    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter1 calendarAdapter = new CalendarAdapter1(this, days, new CalendarAdapter1.OnItemListener() {
            @Override
            public void onItemClick(int position, LocalDate date) {
                CalendarUtils.selectedDate = date;
                setWeekView();
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    public void previousWeekAction(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }


    public static class CalendarAdapter1 extends RecyclerView.Adapter<CalendarAdapter1.ViewHolder>{

        ArrayList<LocalDate> days;
        Context context;
        OnItemListener onItemListener;

        public interface OnItemListener
        {
            void onItemClick(int position, LocalDate date);
        }

        public CalendarAdapter1(Context context, ArrayList<LocalDate> days, OnItemListener onItemListener) {
            this.context = context;
            this.days = days;
            this.onItemListener = onItemListener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.calendar_cell, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            LocalDate date = days.get(position);
            if(date == null)
                holder.cellDayText.setText("");
            else
            {
                holder.cellDayText.setText(String.valueOf(date.getDayOfMonth()));
                if(date.equals(CalendarUtils.selectedDate)){
                    holder.cellDayText.setBackground(context.getDrawable(R.drawable.calendar_orange_background));
                }
            }
        }

        @Override
        public int getItemCount() {
            return days.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ConstraintLayout parentView;
            TextView cellDayText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                parentView = itemView.findViewById(R.id.parentView);
                cellDayText = itemView.findViewById(R.id.cellDayText);
            }
        }
    }



}