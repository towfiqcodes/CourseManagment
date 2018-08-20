package com.backerror.rit.coursemanagment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.backerror.rit.coursemanagment.Activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Handler handler=new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent( MainActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        }, 3000 );
    }
}
