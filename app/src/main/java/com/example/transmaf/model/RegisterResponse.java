package com.example.transmaf.model;

public class RegisterResponse {

    private boolean status;
    private String message;
    private RegisteredUser data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public RegisteredUser getData() {
        return data;
    }

    public static class RegisteredUser {
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
