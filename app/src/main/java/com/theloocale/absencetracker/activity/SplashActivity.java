package com.theloocale.absencetracker.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.theloocale.absencetracker.R;

/**
 * @author orhangrl
 * created on 3/12/2020.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(
                getString(R.string.global_preferences_name), MODE_PRIVATE);

        if (!sharedPreferences.getBoolean("isLogged", false)) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}
