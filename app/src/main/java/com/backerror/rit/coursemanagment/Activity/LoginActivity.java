package com.backerror.rit.coursemanagment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backerror.rit.coursemanagment.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText userName,pass;
    Button login,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_page );
        setTitle( "Login Page" );
        initializationView();
        clickButton();
        }

    public void initializationView(){
        userName=findViewById( R.id.loginNameEt );
        pass=findViewById( R.id.userPassEt );
        login=findViewById( R.id.logingBt );
        reg=findViewById( R.id.regiBt );
    }
    public void clickButton(){
        login.setOnClickListener( this );
        reg.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.logingBt){

            if (checkValidity()){
               // Toast.makeText( this,"Please put the value"+name,Toast.LENGTH_LONG ).show();;
            }else{
                startActivity( new Intent( LoginActivity.this,StudentHomeActivity.class ) );
            }

        }else if(id==R.id.regiBt){
            startActivity( new Intent( LoginActivity.this,RegistrationActivity.class ) );
        }
    }
   public boolean checkValidity(){
        View focusView=null;
        boolean cancel=false;
        String name=userName.getText().toString();
        String password=pass.getText().toString();

        if(TextUtils.isEmpty(name)){
            //focusView=userName;
            cancel=true;
            userName.setError( "Enter your name" );
        }else if(TextUtils.isEmpty(password)) {
          // focusView = pass;
           cancel = true;
           pass.setError( "Enter your password" );
       }
       return cancel;
   }


}
