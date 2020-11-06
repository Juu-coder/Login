package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText mTextCnfPassword;
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(context: this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_login);
        mTextViewLogin = (TextView)findViewById(R.id.textview_register);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent( packageContext:RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
        }

            mButtonRegister.setOnClickListener(new_View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    String user = mTextUsername.getText().toString().trim();
                    String pwd = mTextPassword.getText().toString().trim();
                    String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                    if(pwd.equals(cnf_pwd)){
                       long val = db.addUser(user,pwd);
                  if(val > 0){
                        Toast.makeText( context: RegisterActivity.this, text: "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent( packageContext:RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText( context: RegisterActivity.this, text: "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }
            };
    }
}