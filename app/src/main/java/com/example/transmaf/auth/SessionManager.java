package com.example.transmaf.auth;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.transmaf.model.LoginResponse;

public class SessionManager {

    private static final String PREF_NAME = "APP_PREF";

    private static final String KEY_TOKEN     = "TOKEN";
    private static final String KEY_LOGGED_IN = "LOGGED_IN";
    private static final String KEY_USER_ID   = "USER_ID";
    private static final String KEY_USER_NAME = "USER_NAME";
    private static final String KEY_USER_EMAIL= "USER_EMAIL";
    private static final String KEY_USER_ROLE = "USER_ROLE";

    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveLoginSession(String token, LoginResponse.UserData user) {
        editor.putString(KEY_TOKEN, token);
        editor.putBoolean(KEY_LOGGED_IN, true);
        editor.putInt(KEY_USER_ID, user.getId());
        editor.putString(KEY_USER_NAME, user.getName());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_ROLE, user.getRole());
        editor.apply();
    }

    public String getToken() {
        return prefs.getString(KEY_TOKEN, null);
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_LOGGED_IN, false);
    }

    public UserSession getUser() {
        if (!isLoggedIn()) return null;

        return new UserSession(
                prefs.getInt(KEY_USER_ID, -1),
                prefs.getString(KEY_USER_NAME, "-"),
                prefs.getString(KEY_USER_EMAIL, "-"),
                prefs.getString(KEY_USER_ROLE, "-")
        );
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public static class UserSession {
        private final int id;
        private final String name;
        private final String email;
        private final String role;

        public UserSession(int id, String name, String email, String role) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.role = role;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getRole() { return role; }
    }
}
