package nurasoftech.urbanfitconsultation.chat;

import androidx.appcompat.app.AppCompatActivity;
import nurasoftech.urbanfitconsultation.R;
import android.os.Bundle;

public class Chat_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_details);
        getSupportActionBar().hide();
    }
}