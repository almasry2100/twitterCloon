package com.example.ac_twittercloone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLoginID,edtLoginPassWord;
    private Button btnLogin,btnLoginSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        edtLoginID =findViewById( R.id.edtLoginID );
        edtLoginPassWord=findViewById( R.id.edtLoginPassWord );
        btnLogin=findViewById( R.id.btnLogin );
        btnLoginSignUp=findViewById( R.id.btnLoginSignUp );

        btnLogin.setOnClickListener(this  );
        btnLoginSignUp.setOnClickListener( this );



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                if (edtLoginID.getText().toString().equals( "" )|| edtLoginPassWord.getText().toString().equals( "" )){

                    Toast.makeText( this,"user name of password missing  ",Toast.LENGTH_SHORT ).show();

                }else {
                    ParseUser.logInInBackground( edtLoginID.getText().toString(), edtLoginPassWord.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user !=null & e==null){
                                FancyToast.makeText( LoginActivity.this,user.getUsername()+"  login ", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true ).show();
                                Intent intent =new Intent( LoginActivity.this,TwitterUsers.class );
                                startActivity( intent );

                            }else {
                                Toast.makeText( LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG ).show();

                            }

                        }
                    } );


                }

        }
    }
}