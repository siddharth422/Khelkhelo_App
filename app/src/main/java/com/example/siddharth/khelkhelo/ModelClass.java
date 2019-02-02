package com.example.siddharth.khelkhelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhinay on 4/3/2018.
 */

public class ModelClass {
@SuppressWarnings("photo")
private String photo;
@SuppressWarnings("name")
private String name;
@SuppressWarnings("description")
private String description;

    public ModelClass(String photo, String name, String description) {
        this.photo = photo;
        this.name = name;
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
