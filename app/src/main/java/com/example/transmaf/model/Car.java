package com.example.transmaf.model;

import com.google.gson.annotations.SerializedName;

public class Car {

    private int id;

    private String nup;

    private String name;

    @SerializedName("plate_number")
    private String plateNumber;

    @SerializedName("image_url")
    private String imageUrl;

    private String status;

    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    // Getter & Setter

    public int getId() {
        return id;
    }

    public String getNup() {
        return nup;
    }

    public String getName() {
        return name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
