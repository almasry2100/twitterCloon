package com.example.ac_twittercloone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmailId,edtSignUpUserName,edtSignUpPassWord;
    private Button btnSignUp,btnLogin;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();


        edtEmailId.findViewById( R.id.edtEmailId );
        edtSignUpUserName.findViewById( R.id.edtSignUpUserName );
        edtSignUpPassWord.findViewById( R.id.edtSignUpPassWord );

        btnSignUp.findViewById( R.id.btnSignUp );
        btnLogin.findViewById( R.id.btnLogin );

        

    }
}
