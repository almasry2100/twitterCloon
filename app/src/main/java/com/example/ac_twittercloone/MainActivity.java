package com.example.ac_twittercloone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmailId,edtSignUpUserName,edtSignUpPassWord;
    private Button btnSignUp,btnLogin;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();


        edtEmailId=findViewById( R.id.edtEmailId );
        edtSignUpUserName=findViewById( R.id.edtSignUpUserName );
        edtSignUpPassWord=findViewById( R.id.edtSignUpPassWord );

        btnSignUp=findViewById( R.id.btnSignUp );
        btnLogin=findViewById( R.id.btnLogin );

        btnSignUp.setOnClickListener( this );

        btnLogin.setOnClickListener( this );

        

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignUp:
                ParseUser userApp = new ParseUser();
                userApp.setEmail( edtEmailId.getText().toString() );
                userApp.setUsername( edtSignUpUserName.getText().toString() );
                userApp.setPassword( edtSignUpPassWord.getText().toString() );
                userApp.signUpInBackground( new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(MainActivity.this," is Signed Up",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                            Intent intent=new Intent( MainActivity.this,TwitterUsers.class );
                            startActivity( intent );
                        }else {
                            FancyToast.makeText(MainActivity.this," error",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();

                        }
                    }
                } );

                break;
            case R.id.btnLogin:
                Intent intent =new Intent( MainActivity.this,LoginActivity.class );
                startActivity( intent );




                break;
        }

    }
}
