package nurasoftech.urbanfitconsultation.ScheduleAppointment;

import androidx.appcompat.app.AppCompatActivity;
import nurasoftech.urbanfitconsultation.R;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class counsellor_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsellor_2);

        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}