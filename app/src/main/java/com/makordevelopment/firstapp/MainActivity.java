package com.makordevelopment.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_LOGIN = "EXTRA_LOGIN";
    private TextView textUserLogin;

    public static Intent getStartingIntent(Context context, String login) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_LOGIN, login);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        showUserLogin();
    }

    private void findViews() {
        textUserLogin = (TextView) findViewById(R.id.text_logged_user);
    }

    private void showUserLogin() {
        Bundle extras = getIntent().getExtras();
        String userLogin = extras.getString(EXTRA_LOGIN);
        if (userLogin != null) {
            textUserLogin.setText(userLogin);
        }
    }
}
