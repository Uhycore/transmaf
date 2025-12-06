package com.example.transmaf.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private boolean status;
    private String message;
    private String token;
    private UserData user;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public UserData getUser() {
        return user;
    }

    public static class UserData {
        private int id;
        private String name;
        private String email;
        private String role;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }
    }
}
