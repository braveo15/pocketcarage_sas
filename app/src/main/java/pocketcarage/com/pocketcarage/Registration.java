package pocketcarage.com.pocketcarage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

public class Registration extends AppCompatActivity {
    private EditText u_name;
    private EditText u_email;

    private EditText u_password;

    private EditText u_cpassword;
    private EditText u_address;
    private EditText u_phone;
    private Button u_create;
    private ImageView back_button;
    final String APP_ID = "gZgoUsyHIaZU4W3YG6OqUcvo5eTAuEkED01Taw3Q";
    final String CLIENT_KEY = "TzbDWUIzTENKtpy743758xpLuDOTS0BvGEjblC5S";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //start connection to parse database
        Parse.initialize(this,APP_ID,CLIENT_KEY);
        // connect layout elements
        back_button=(ImageView) findViewById(R.id.backButton);
        u_create= (Button)findViewById(R.id.createtheaccount);
       u_name = (EditText)findViewById(R.id.name_input);
        u_email = (EditText)findViewById(R.id.email_input);
        u_password = (EditText)findViewById(R.id.password_input);
        u_cpassword = (EditText)findViewById(R.id.confirm_input);
        u_address = (EditText)findViewById(R.id.address_input);
        u_phone = (EditText)findViewById(R.id.phone_input);
        u_create = (Button)findViewById(R.id.createtheaccount);

}

    @Override
    protected void onStart() {
        super.onStart();
        u_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = u_name.getText().toString();
                final String userName = u_phone.getText().toString();
                String email = u_email.getText().toString();
                final String password  = u_password.getText().toString();
                String cpassword = u_cpassword.getText().toString();
                String phone = u_phone.getText().toString();
                String address = u_address.getText().toString();
        if(validate()){
                ParseUser user  = new ParseUser();
                user.setUsername(userName);
                user.setEmail(email);
                user.setPassword(password);
                user.put("Phone",phone);
                user.put("Name",name);
                user.put("Address",address);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_LONG).show();
                            logUserIn(userName,password);

                        }else{
                            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });}
            }
        });

    back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    public boolean validate(){
        boolean temp = true;
        String pass=u_password.getText().toString();
        String cpass=u_cpassword.getText().toString();
        if(!pass.equals(cpass)){
            Toast.makeText(Registration.this,"Password Not matching",Toast.LENGTH_LONG).show();
            temp=false;
        }
        return temp;


    }
    private void logUserIn(String userName, String password) {
        if(!userName.equals("")||!password.equals("")){
            ParseUser.logInInBackground(userName, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    startActivity(new Intent(Registration.this,Services.class));

                }
            });
        }
    }
    }





