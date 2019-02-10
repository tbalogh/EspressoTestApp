package com.tbalogh.indigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.navigation.Navigation;

import java.util.Arrays;

public class RegistrationFragment extends Fragment {

    public static final int MIN_PASSWORD_LENGTH = 8;

    EditText emailField;
    EditText passwordField;
    EditText confirmPasswordField;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        emailField = view.findViewById(R.id.emailField);
        passwordField = view.findViewById(R.id.passwordField);
        confirmPasswordField = view.findViewById(R.id.confirmPasswordField);

        view.findViewById(R.id.registerButton).setOnClickListener(v -> {
            register();
        });

        getActivity().setTitle("Registration");

        return view;
    }

    private void register() {
        boolean isValid = validateEmail();
        isValid &= validatePasswords();

        if (isValid) {
            getView().findViewById(R.id.registrationView).setVisibility(View.INVISIBLE);
            getView().findViewById(R.id.registrationSucceededView).setVisibility(View.VISIBLE);
            getView().findViewById(R.id.openLoginButton).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment));
        }
    }

    private boolean validateEmail() {
        if (emailField.getText().toString().isEmpty()) {
            emailField.setError("Must be not empty!");
            return false;
        }
        if (!isValidEmailAddress(emailField.getText().toString())) {
            emailField.setError("Must be a valid email!");
            return false;
        }

        return true;
    }

    private boolean validatePasswords() {
        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            if (password.isEmpty()) {
                passwordField.setError("Must be not empty!");
            }
            if (confirmPassword.isEmpty()) {
                confirmPasswordField.setError("Must be not empty!");
            }
            return false;
        }

        if (!password.equals(confirmPassword)) {
            passwordField.setError("Passwords does not match!");
            confirmPasswordField.setError("Passwords does not match!");
            return false;
        } else {
            if (password.length() < MIN_PASSWORD_LENGTH) {
                passwordField.setError("Password must be at least 8 character!");
                confirmPasswordField.setError("Password must be at least 8 character!");
            }
        }

        return true;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
