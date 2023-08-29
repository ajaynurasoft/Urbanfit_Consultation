package nurasoftech.urbanfitconsultation.oninit;

import androidx.appcompat.app.AppCompatActivity;

import nurasoftech.urbanfitconsultation.Home.MainHome;
import nurasoftech.urbanfitconsultation.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Login extends AppCompatActivity {

    TextView sign_upTV;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        sign_upTV = findViewById(R.id.sign_up_textView);
        login_button = findViewById(R.id.login_button);

        sign_upTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, MainHome.class));
            }
        });


    }
}