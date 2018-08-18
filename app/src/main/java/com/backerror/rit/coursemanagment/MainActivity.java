package com.backerror.rit.coursemanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button studentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        studentBtn=findViewById( R.id.studentBTN );
        studentBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent=new Intent( MainActivity.this, Registration.class );
               // startActivity( intent );
            }
        } );
    }
}
