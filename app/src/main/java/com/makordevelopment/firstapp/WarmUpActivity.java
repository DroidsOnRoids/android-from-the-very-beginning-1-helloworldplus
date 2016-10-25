package com.makordevelopment.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

public class WarmUpActivity extends AppCompatActivity {

    private TextView textSeekBarValues;
    private SeekBar seekBar;
    private ImageView imageLogo;

    private Button buttonGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmup);

        findViews();
        setupSeekBar();
        setupGoToLoginScreenButton();
        initTextAndImageValues();
    }

    private void findViews() {
        textSeekBarValues = (TextView) findViewById(R.id.text_seekbar_values);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        imageLogo = (ImageView) findViewById(R.id.image_logo);
        buttonGoToLogin = (Button) findViewById(R.id.button_go_to_login);
    }

    private void setupSeekBar() {
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateProgressInViews(progress);
                showGoToLoginButtonIfProgressIs100(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void setupGoToLoginScreenButton() {
        buttonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WarmUpActivity.this, LoginActivity.class));
            }
        });
    }

    private void updateProgressInViews(int progress) {
        textSeekBarValues.setText(convertProgressToText(progress));
        textSeekBarValues.setAlpha(convertProgressToAlpha(progress));
        imageLogo.setAlpha(convertProgressToAlpha(progress));
    }

    private String convertProgressToText(int progress) {
        return String.format(Locale.getDefault(), "%d%%", progress);
    }

    private float convertProgressToAlpha(float progress) {
        return progress / 100.0f;
    }

    private void initTextAndImageValues() {
        updateProgressInViews(seekBar.getProgress());
    }


    private void showGoToLoginButtonIfProgressIs100(int progress) {
        if (progress == 100) {
            buttonGoToLogin.setVisibility(View.VISIBLE);
        }
    }
}
