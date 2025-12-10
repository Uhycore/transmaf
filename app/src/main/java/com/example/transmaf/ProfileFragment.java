package com.example.transmaf;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.transmaf.auth.LoginActivity;
import com.example.transmaf.auth.SessionManager;

public class ProfileFragment extends Fragment {

    private TextView tvName, tvEmail;
    private Button btnEditProfile;
    private LinearLayout btnLogout;

    private SessionManager sessionManager;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName  = view.findViewById(R.id.tvName);
        tvEmail = view.findViewById(R.id.tvEmail);

        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnLogout      = view.findViewById(R.id.btnLogout);

        loadUserData();
        setupActions();

        return view;
    }

    private void loadUserData() {
        SessionManager.UserSession user = sessionManager.getUser();

        if (user != null) {
            tvName.setText(user.getName());
            tvEmail.setText(user.getEmail());
        } else {
            tvName.setText("Guest");
            tvEmail.setText("-");
        }
    }

    private void setupActions() {
        btnEditProfile.setOnClickListener(v -> {
        });

        btnLogout.setOnClickListener(v -> {
            sessionManager.logout();

            Intent intent = new Intent(requireContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            requireActivity().finish();
        });
    }
}
