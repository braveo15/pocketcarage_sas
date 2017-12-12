package pocketcarage.com.pocketcarage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class reset_password extends AppCompatActivity {
    ImageView back_Button ;
    private EditText reset;
    private Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        back_Button=(ImageView)findViewById(R.id.backButton);
        reset = (EditText) findViewById(R.id.reset_input);
        reset_button = (Button) findViewById(R.id.resett_button);

    }

    @Override
    protected void onStart() {
        super.onStart();

        reset_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                ParseUser.requestPasswordResetInBackground(reset.getText().toString().trim(), new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "an email has been sent to you", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }

        });
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}