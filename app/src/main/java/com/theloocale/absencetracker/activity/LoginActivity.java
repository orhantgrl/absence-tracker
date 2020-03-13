package com.theloocale.absencetracker.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.theloocale.absencetracker.R;
import com.theloocale.absencetracker.databinding.ActivityLoginBinding;

import java.util.Objects;

/**
 * @author orhangrl
 * created on 3/12/2020.
 */

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.LoginTheme);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginLetsGoButton.setOnClickListener((v) -> {
            String loginInput = Objects.requireNonNull(binding.loginNameInput.getText())
                    .toString()
                    .trim();

            if (loginInput.isEmpty() || loginInput.length() < 3) {
                binding.loginNameInputLayout.setError(getResources().getString(
                        R.string.login_error_content));
            } else {
                SharedPreferences.Editor editor = getSharedPreferences(
                        getString(R.string.global_preferences_name), MODE_PRIVATE).edit();

                editor.putString("userName", loginInput);
                editor.putBoolean("isLogged", true);
                editor.apply();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        binding.loginNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 2 && binding.loginNameInputLayout.isErrorEnabled()) {
                    binding.loginNameInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
