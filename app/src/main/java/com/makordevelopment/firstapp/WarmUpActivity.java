package com.makordevelopment.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class WarmUpActivity extends AppCompatActivity {

    private TextView textSeekbarValues;
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
        textSeekbarValues = (TextView) findViewById(R.id.text_seekbar_values);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        imageLogo = (ImageView) findViewById(R.id.image_logo);

        buttonGoToLogin = (Button) findViewById(R.id.button_go_to_login);
    }

    private void setupSeekBar() {
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateValuesInViews(i);
                changeLayoutIfProgressIs100(i);
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

    private void updateValuesInViews(int i) {
        textSeekbarValues.setText(convertProgressToText(i));
        textSeekbarValues.setAlpha(convertProgressToAlpha(i));
        imageLogo.setAlpha(convertProgressToAlpha(i));
    }

    private String convertProgressToText(int i) {
        return String.format(Locale.getDefault(), "%d%%", i);
    }

    private float convertProgressToAlpha(float i) {
        return i / 100;
    }

    private void initTextAndImageValues() {
        updateValuesInViews(seekBar.getProgress());
    }


    private void changeLayoutIfProgressIs100(int i) {
        if (i == 100) {
            buttonGoToLogin.setVisibility(View.VISIBLE);
            buttonGoToLogin.animate().alpha(1.0f).setDuration(2000);
        }
    }
}
