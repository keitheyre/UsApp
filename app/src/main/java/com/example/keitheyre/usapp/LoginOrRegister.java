package com.example.keitheyre.usapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginOrRegister extends AppCompatActivity implements View.OnClickListener {

    private Button login_button, register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        init();


    }

    private void init() {
        login_button = (Button) findViewById(R.id.login_button);
        register_button = (Button) findViewById(R.id.register_button);


        setOnClickListeners();
    }

    private void setOnClickListeners() {
        login_button.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                finish();
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;

            case R.id.register_button:
                finish();
                startActivity(new Intent(getApplicationContext(), Register.class));
                break;

            default:
                break;
        }
    }
}
