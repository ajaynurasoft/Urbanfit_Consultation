package nurasoftech.urbanfitconsultation.Home;

import androidx.appcompat.app.AppCompatActivity;
import nurasoftech.urbanfitconsultation.R;
import nurasoftech.urbanfitconsultation.ScheduleAppointment.counsellor_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Objects;

public class CoachDetails extends AppCompatActivity {

    RelativeLayout schedule_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_details);

        Objects.requireNonNull(getSupportActionBar()).hide();


        schedule_button = findViewById(R.id.schedule_button);

        schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoachDetails.this, counsellor_1.class));
            }
        });

    }
}