package com.tbalogh.indigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.navigation.Navigation;

import java.util.Objects;

import static com.tbalogh.indigo.RegistrationFragment.isValidEmailAddress;

public class LoginFragment extends Fragment {

    EditText emailField;
    EditText passwordField;

    public static final String VALID_EMAIL = "test@logmein.com";
    public static final String VALID_PASSWORD = "password";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        view.findViewById(R.id.openRegistrationButton)
                .setOnClickListener(
                        Navigation.createNavigateOnClickListener(R.id.registrationFragment, null));

        view.findViewById(R.id.loginButton).setOnClickListener(v ->
                    authenticate());

        emailField = view.findViewById(R.id.emailField);
        passwordField = view.findViewById(R.id.passwordField);

        getActivity().setTitle("Login");

        return view;
    }

    private void authenticate() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if (VALID_EMAIL.equals(email) && VALID_PASSWORD.equals(password)) {
            Navigation.findNavController(Objects.requireNonNull(getView()))
                    .navigate(R.id.mainFragment);
        } else {
            validateEmail();
            validatePassword();
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
        if (!VALID_EMAIL.equals(emailField.getText().toString())) {
            emailField.setError("Invalid credentials!");
            return false;
        }

        return true;
    }

    private boolean validatePassword() {
        if (passwordField.getText().toString().isEmpty()) {
            passwordField.setError("Must be not empty!");
            return false;
        }
        if (!VALID_PASSWORD.equals(passwordField.getText().toString())) {
            passwordField.setError("Invalid credentials!");
            return false;
        }

        return true;
    }
}
