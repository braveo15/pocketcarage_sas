package pocketcarage.com.pocketcarage;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class welcome extends AppCompatActivity {
   private static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home_activity = new Intent(welcome.this,home.class);
                startActivity(home_activity);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
