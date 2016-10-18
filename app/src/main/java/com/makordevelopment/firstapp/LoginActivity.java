package com.makordevelopment.firstapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

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
        return editLogin.getText().toString().equals("a") &&
                editPassword.getText().toString().equals("a");
    }

    private void showMainScreen() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("login", editLogin.getText().toString());
        startActivity(intent);
    }

    private void showLoginErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Błąd")
                .setMessage("Podany login lub hasło są niepoprawne.")
                .setPositiveButton("OK", null)
                .create()
                .show();
    }
}
