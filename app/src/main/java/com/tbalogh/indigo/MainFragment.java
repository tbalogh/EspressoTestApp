package com.tbalogh.indigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button registerButton = view.findViewById(R.id.openRegistrationButton);
        if (registerButton != null) {
            registerButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.registrationFragment, null));
        }

        getActivity().setTitle("App");

        return view;
    }
}
