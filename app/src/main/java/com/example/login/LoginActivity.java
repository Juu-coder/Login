package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvForgot;
    Database db;

    private String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(context: this);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgot = findViewById(R.id.tvForgot);

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent registerIntent = new Intent( packageContext:LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        }

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                email =etEmail.getText().toString().trim;
                password = etPassword.getText().toString().trim;

                validate()
                Boolean res = db.checkUser(user, pwd);
                if (res == true)
                {
                   Intent HomePage = new intent( packageContext: LoginActivity.this,HomeActivity.class);
                   startActivity(HomePage);
                }
                else
                    {
                        Toast.makeText( context: LoginActivity.this, text: "Login Error", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }

    private void validate() {
        if (email.isEmpty()) {
            etEmail.setError("email cannot be empty");
         else if (password.isEmpty() || password.length() < 4) {
             etPassword.setError("password cannot be empty or less than 4");
            }else{
                Toast.makeText( getApplicationContext(), text: "Login Error", Toast.LENGTH_LONG).show();
            }
        }
    }
}