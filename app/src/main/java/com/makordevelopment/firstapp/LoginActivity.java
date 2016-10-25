package com.makordevelopment.firstapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String VALID_LOGIN = "a";
    private static final String VALID_PASSWORD = "a";

    private EditText editLogin;
    private EditText editPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        setupLoginButton();
    }

    private void findViews() {
        editLogin = (EditText) findViewById(R.id.edit_login);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
    }

    private void setupLoginButton() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextScreenIfValidPassword();
            }
        });
    }

    private void goToNextScreenIfValidPassword() {
        if (isLoginAndPasswordValid()) {
            showMainScreen();
        } else {
            showLoginErrorDialog();
        }
    }

    private boolean isLoginAndPasswordValid() {
        return editLogin.getText().toString().equals(VALID_LOGIN) &&
                editPassword.getText().toString().equals(VALID_PASSWORD);
    }

    private void showMainScreen() {
        startActivity(MainActivity.getStartingIntent(this, editLogin.getText().toString()));
    }

    private void showLoginErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_login_error_title)
                .setMessage(R.string.dialog_login_error_message)
                .setPositiveButton(R.string.ok, null)
                .create()
                .show();
    }
}
