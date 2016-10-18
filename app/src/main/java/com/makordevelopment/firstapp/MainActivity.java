package com.makordevelopment.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textLoggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setLoggedUser();
    }

    private void findViews() {
        textLoggedUser = (TextView) findViewById(R.id.text_logged_user);
    }

    private void setLoggedUser() {
        Bundle extras = getIntent().getExtras();
        String loggedUserName = extras.getString("login");
        if (loggedUserName != null) {
            textLoggedUser.setText(loggedUserName);
        }
    }
}
