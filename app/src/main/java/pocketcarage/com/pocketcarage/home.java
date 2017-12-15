package pocketcarage.com.pocketcarage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseInstallation;

public class home extends AppCompatActivity implements View.OnClickListener {
    private TextView createAccount;
    private Button logIN;
    private EditText user_name;
    private EditText user_password;
    private TextView resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseObject test = new ParseObject("testing");
        logIN = (Button)findViewById(R.id.logn_button);
        createAccount = (TextView)findViewById(R.id.to_registration_link);
        logIN.setOnClickListener(this);
        resetPassword = (TextView) findViewById(R.id.passwordrecovery);
        createAccount.setOnClickListener(this);
        user_name = (EditText)findViewById(R.id.username_input_log);
        user_password = (EditText)findViewById(R.id.Password);
        resetPassword=(TextView)findViewById(R.id.passwordrecovery);
        
        resetPassword.setOnClickListener(this);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(home.this,Services.class));

        } else {
            Toast.makeText(getApplicationContext(),"Login or Sign Up",Toast.LENGTH_LONG).show();

        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        createAccount.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent to_registration = new Intent(home.this,Registration.class);
                to_registration.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(to_registration);
                return false;
            }
        });
   resetPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent to_recovery = new Intent(home.this,reset_password.class);
                to_recovery.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(to_recovery);
                return false;
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logn_button:
                String userNameForLogin = user_name.getText().toString();
                String userPasswordForLogin = user_password.getText().toString();
                if (!userNameForLogin.equals("") || !userPasswordForLogin.equals("")) {
                    ParseUser.logInInBackground(userNameForLogin, userPasswordForLogin, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (e == null) {
                                startActivity(new Intent(home.this, Services.class));
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "please enter user name(Phone Number) and password", Toast.LENGTH_LONG).show();

                }
                break;

        }
    }}
