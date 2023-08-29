package nurasoftech.urbanfitconsultation.oninit;

import androidx.appcompat.app.AppCompatActivity;
import nurasoftech.urbanfitconsultation.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    TextView login_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Objects.requireNonNull(getSupportActionBar()).hide();
        login_textView = findViewById(R.id.login_textView);

        login_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, Login.class));
            }
        });
    }
}