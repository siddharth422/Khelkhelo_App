package com.example.siddharth.khelkhelo.Modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Siddharth on 23-Apr-18.
 */

public class Model_For_Team {

    @SerializedName("image_desc")
    @Expose
    private String image_desc;
    @SerializedName("image_url")
    @Expose
    private String image_url;

    public String getImage_desc() {
        return image_desc;
    }

    public void setImage_desc(String image_desc) {
        this.image_desc = image_desc;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Model_For_Team(String image_desc, String image_url) {
        this.image_desc = image_desc;
        this.image_url = image_url;

    }

}
